package br.com.actionsys.kawhycommons.integration;

import br.com.actionsys.kawhycommons.Constants;
import br.com.actionsys.kawhycommons.infra.dbsavexml.DbSaveXmlService;
import br.com.actionsys.kawhycommons.infra.exception.DuplicateFileException;
import br.com.actionsys.kawhycommons.infra.exception.IgnoreFileException;
import br.com.actionsys.kawhycommons.infra.exception.OtherFileException;
import br.com.actionsys.kawhycommons.infra.exception.StopExecutionException;
import br.com.actionsys.kawhycommons.infra.license.LicenseService;
import br.com.actionsys.kawhycommons.infra.util.DateUtil;
import br.com.actionsys.kawhycommons.infra.util.FilesUtil;
import br.com.actionsys.kawhycommons.infra.util.XmlUtil;
import br.com.actionsys.kawhycommons.types.KawhyType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public abstract class IntegrationOrchestrator {

    @Value("${dir.entrada:#{null}}")
    public String dirEntrada;
    @Value("${dir.saida:#{null}}")
    public String dirSaida;
    @Value("${dir.erro:#{null}}")
    public String dirErro;
    @Value("${dir.outros:#{null}}")
    public String dirOutros;
    @Value("${dir.duplicados:#{null}}")
    public String dirDuplicados;

    @Value("${NFE_XML:#{null}}")
    public String gravarXml;

    @Autowired
    protected LicenseService licenseService;

    @Autowired
    private DbSaveXmlService dbSaveXmlService;

    public abstract void processDocumentFile(IntegrationContext item) throws Exception;
    public abstract void processCancelFile(IntegrationContext item) throws Exception;
    public abstract boolean isCancel(IntegrationContext item) throws Exception;
    public abstract boolean isDocument(IntegrationContext item) throws Exception;
    public abstract KawhyType getKawhyType();

    public void validateXmlFile(IntegrationContext item) throws Exception {
        FilesUtil.isXmlFile(item.getFile());
    }

    public List<IntegrationContext> getFiles() {
        File pastaEntrada = new File(dirEntrada);
        File[] files = pastaEntrada.listFiles();
        log.info("Quantidade de arquivos na pasta de entrada : " + files.length);
        return Arrays.asList(files).stream().map(i -> IntegrationContext.builder().file(i).build()).collect(Collectors.toList());
    }


    public void process() {
        KawhyType kawhyType = getKawhyType();
        if (!licenseService.validateLicenseModule(kawhyType)) {
            log.warn("Licença não encontrada para o serviço {}. Interrompendo a execução.", kawhyType);
            return;
        }

        List<IntegrationContext> itens = getFiles();
        if (itens.isEmpty()) {
            return;
        }

        Iterator<IntegrationContext> iterator = itens.iterator();
        while (iterator.hasNext()) {
            IntegrationContext item = iterator.next();
            try {
                processItem(item);

                writeSaidaFile(item);
            } catch (OtherFileException e) {
                writeOtherFile(item, e);
            } catch (IgnoreFileException e) {
                ignoreFile(item, e);
            } catch (DuplicateFileException e) {
                writeDuplicateFile(item, e);
            } catch (StopExecutionException e) {
                log.error("Execução interrompida.", e);
                break;
            } catch (Exception e) {
                writeErrorFile(item, e);
            } finally {
                iterator.remove();
            }
        }
    }

    @Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    public void processItem(IntegrationContext item) throws Exception {
        //Caso arquivo está inválido, ocorre lança uma Exception.
        validateXmlFile(item);
        item.setBytes(FilesUtil.readToBytes(item.getFile()));
        item.setDocument(XmlUtil.buildDocument(item.getBytes()));

        String documentType;
        if (isDocument(item)) {
            processDocumentFile(item);
            documentType = getKawhyType().getDocumentType().getIssueType();

        } else if (isCancel(item)) {
            processCancelFile(item);
            documentType = getKawhyType().getDocumentType().getCancelType();
        } else {
            throw new Exception("Documento não suportado.");
        }


        //Gravar xml na tabela fq72319 (kawhy_xml)
        if (Constants.S.equals(gravarXml)) {
            dbSaveXmlService.process(item, getKawhyType().getAuditName(), documentType);
        }

    }

    private void ignoreFile(IntegrationContext item, IgnoreFileException e) {
        log.warn("Arquivo ignorado : " + item.getFile().getAbsolutePath() + " - " + e.getMessage());
    }

    void writeSaidaFile(IntegrationContext item) {
        FilesUtil.move(item.getFile(), dirSaida + item.getFileName());
        log.info("Arquivo processado com sucesso : " + item.getFile().getAbsolutePath());
    }


    public void writeErrorFile(IntegrationContext item, Exception exception) {
        String dirDest = dirErro + item.getFileName();
        FilesUtil.move(item.getFile(), dirDest);

        // Criar arquivo .log com a mensagem de erro
        String stackTrace = DateUtil.formatDateTimeToLabel(new Date()) + " - " + ExceptionUtils.getStackTrace(exception);
        FilesUtil.write(dirDest + ".log", stackTrace);

        log.error("Erro ao processar arquivo : " + item.getFile().getAbsolutePath() + " to " + dirDest, exception);
    }

    public void writeOtherFile(IntegrationContext item, OtherFileException e) {
        FilesUtil.move(item.getFile(), dirOutros + item.getFile().getName());
        if (e.getMessage() != null) {
            log.warn(e.getMessage());
        } else {
            log.warn("Arquivo movido para pasta 'Outros' : " + item.getFile().getAbsolutePath());
        }
    }

    public void writeDuplicateFile(IntegrationContext item, DuplicateFileException e) {
        FilesUtil.move(item.getFile(), dirDuplicados + item.getFile().getName());
        if (e.getMessage() != null) {
            log.warn(e.getMessage());
        } else {
            log.warn("Arquivo movido para pasta 'Duplicados' : " + item.getFile().getAbsolutePath());
        }
    }
}
