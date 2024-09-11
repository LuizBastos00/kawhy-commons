package br.com.actionsys.kawhycommons.integration.metadata;

import br.com.actionsys.kawhycommons.infra.util.APathUtil;
import br.com.actionsys.kawhycommons.infra.function.ChaveAcessoNfseUtil;
import br.com.actionsys.kawhycommons.infra.function.NumeroNfseFunction;
import br.com.actionsys.kawhycommons.infra.util.FilesUtil;
import br.com.actionsys.kawhycommons.infra.util.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;

import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class MetadataService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private TableMetadataService tableMetadataService;
    @Autowired
    private NumeroNfseFunction numeroNfseFunction;

    private final static String GENERATE_ID_NFSE = "${generateNfseId}";
    private final static String GENERATE_NUMBER_NFSE = "${generateNfseNumber}";

    public void validateFiles(Path metadataDirectory, Path xmlDirectory) {
        List<TableMetadata> tables = tableMetadataService.readAll(metadataDirectory);

        try (Stream<Path> files = Files.walk(xmlDirectory, 99).filter(Files::isRegularFile)) {
            files.forEach(file -> validateFile(file, tables));
        } catch (IOException e) {
            throw new RuntimeException("Erro ao listar arquivos", e);
        }
    }

    public void validateFile(Path file, List<TableMetadata> tables) {
        log.info("Validando arquivo {}", file.getFileName());

        try {
            Document document = XmlUtil.buildDocument(FilesUtil.readToBytes(file.toFile()));
            tables.forEach(table -> validateTable(table, document));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar arquivo " + file.getFileName(), e);
        }
    }

    private void validateTable(TableMetadata table, Document document) {
        table.getFields().forEach(field -> validateField(table, field, document));
    }

    private void validateField(TableMetadata table, FieldMetadata field, Document document) {
        try {

            List<?> xmlValue = getXmlValue(field, document)
                    .stream().filter(Objects::nonNull).collect(Collectors.toList());

            List<?> databaseValue = getDatabaseValue(table, field, document)
                    .stream().filter(Objects::nonNull).collect(Collectors.toList());

            // parar o metodo caso nao tenha gravado registro para a linha
            // valida se o id existe no banco de dados
            if (field.getVariable().equalsIgnoreCase(table.getIdField().getVariable()) && databaseValue.isEmpty()) {
                log.debug("Nao foi gravado registro para o campo: " + field);
                return;
            }

            // validar em caso de sequenceLine
            FieldMetadata sequenceField = table.getSequenceField();
            if (sequenceField != null && sequenceField.getVariable().equals(field.getVariable())) {
                log.debug("Validando tamanho da lista pois o campo é a sequencia {}", field);

                if (xmlValue.size() != databaseValue.size()) {
                    log.error("Listas com tamanhos diferentes na validacao do campo nSequencia {}", field);
                    log.error("xmlValue: " + xmlValue);
                    log.error("databaseValue: " + databaseValue);
                    throw new RuntimeException("Listas com tamanhos diferentes na validacao do campo nSequencia");
                }
                // teste passou com sucesso
                return;
            }

            // validar caso nao seja sequencia
            if (!xmlValue.equals(databaseValue)) {

                if (xmlValue.isEmpty()
                        && StringUtils.equalsAnyIgnoreCase(databaseValue.get(0).toString(), "0.0", "0")
                        && StringUtils.equalsAnyIgnoreCase(field.getType(), "Integer", "Decimal")) {
                    log.debug("Foi inserido zero no banco e nao foi encontrado valor do XML {}", field);
                } else {
                    log.error("Linha com valores diferentes {}", field);
                    log.error("xmlValue: " + xmlValue);
                    log.error("databaseValue: " + databaseValue);
                    throw new RuntimeException("Linha com valores diferentes");
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar linha: " + field, e);
        }
    }

    private List<?> getXmlValue(FieldMetadata field, Document document) throws XPathExpressionException {
        //Processa função de gerar nfseID.
        if (GENERATE_ID_NFSE.equals(field.getAPath())) {
            String cnpjPrest = APathUtil.execute(document, "IntegracaoMidas/DadosPrestador/Cnpj");
            String dtEmissao = APathUtil.execute(document, "IntegracaoMidas/DtEmissao");
            String data = StringUtils.substring(RegExUtils.removeAll(dtEmissao, "-"), 0, 8);
            String numNf = APathUtil.execute(document, "IntegracaoMidas/Numero");

            return Collections.singletonList(ChaveAcessoNfseUtil.generateNfseId(data, cnpjPrest, numeroNfseFunction.generateNfseNumber(numNf, dtEmissao)));
        } else if (GENERATE_NUMBER_NFSE.equals(field.getAPath())) {
            //Quando receber o NNF é feita a validação e alteração do número conforme regra no método generateNfseNumber
            String numNf = APathUtil.execute(document, "IntegracaoMidas/Numero");
            String data = APathUtil.execute(document, "IntegracaoMidas/DtEmissao");

            return Collections.singletonList(new BigInteger(numeroNfseFunction.generateNfseNumber(numNf, data)));
        }

        List<String> valueXmlStr = APathUtil.executeList(document, field.getAPath());
        return valueXmlStr.stream().map(value -> {

            value = StringUtils.trim(value);

            if (value == null || value.trim().isEmpty()) {
                return null;

            } else if (field.getType().equals("Date")) {
                return value.substring(0, 10);

            } else if (field.getType().equals("Time")) {
                return value.substring(11, 19);

            } else if (field.getType().equals("Decimal")) {
                return BigDecimal.valueOf(Double.parseDouble(value));

            } else if (field.getType().equals("Integer")) {
                return new BigInteger(value);

            } else {
                if (field.getRegex() != null) {
                    return value.trim().replaceAll(field.getRegex(), "");
                }

                return value;
            }
        }).collect(Collectors.toList());
    }

    private List<?> getDatabaseValue(TableMetadata table, FieldMetadata field, Document document) throws XPathExpressionException {

        if (GENERATE_ID_NFSE.equals(field.getAPath())) {
            return Collections.emptyList();
        }

        FieldMetadata idField = table.getIdField();

        StringBuilder query = new StringBuilder("select ")
                .append(idField.getVariable().equalsIgnoreCase(field.getVariable()) ? "distinct " : "")
                .append(field.getColumn())
                .append(" from ")
                .append(field.getTable())
                .append(" where ")
                .append(idField.getColumn())
                .append(" like ?");

        List<?> args = Collections.singletonList(getXmlValue(idField, document).get(0) + "%");

        if (field.getWhereComplement() != null) {
            query.append(" and ")
                    .append(field.getWhereComplement());
        }

        if (table.getSequenceField() != null && !idField.equals(field)) {
            query.append(" order by ")
                    .append(table.getSequenceField().getColumn());
        }

        List<?> listValuesDb = jdbcTemplate.queryForList(query.toString(), Object.class, args.toArray());
        if (StringUtils.containsAnyIgnoreCase(field.getType(), "String", "Date", "Time")) {

            return listValuesDb.stream().map(value -> {
                if (value == null) {
                    return null;
                }
                if (field.getRegex() != null) {
                    return value.toString().trim().replaceAll(field.getRegex(), "");
                }
                return value.toString().trim();
            }).collect(Collectors.toList());

        } else if (StringUtils.containsAnyIgnoreCase(field.getType(), "Decimal")) {
            return listValuesDb.stream()
                    .map(o -> o == null ? null : BigDecimal.valueOf(Double.parseDouble(o.toString().trim())))
                    .collect(Collectors.toList());
        } else if (StringUtils.containsAnyIgnoreCase(field.getType(), "Integer")) {
            return listValuesDb.stream()
                    .map(o -> o == null ? null : new BigInteger(o.toString().trim()))
                    .collect(Collectors.toList());
        }else if (StringUtils.containsAnyIgnoreCase(field.getType(), "Blob")) {
            return listValuesDb.stream().map(value -> {
                if (value == null) {
                    return null;
                }
                return new String((byte[]) value);
            }).collect(Collectors.toList());
        }
        return listValuesDb;
    }

}
