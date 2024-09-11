package br.com.actionsys.kawhycommons.infra.license;

import br.com.actionsys.kawhycommons.infra.exception.IgnoreFileException;
import br.com.actionsys.kawhycommons.infra.exception.StopExecutionException;
import br.com.actionsys.kawhycommons.infra.license.types.CnpjLicense;
import br.com.actionsys.kawhycommons.infra.license.types.License;
import br.com.actionsys.kawhycommons.types.KawhyType;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Getter
@Slf4j
@Component
public class LicenseService {

    @Value("${file.license}")
    private String licenseFile;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private DecryptService decryptService;

    public Boolean validateLicenseModule(KawhyType kawhyType) {
        List<CnpjLicense> cnpjLicenses = getLicense().getCnpjLicenseList();

        if (cnpjLicenses == null || cnpjLicenses.isEmpty()) {
            log.warn("Nenhuma licença encontrada.");
            return false;
        }

        if (KawhyType.KAWHY_UPDATE_SEFAZ_CERTIFICATE.equals(kawhyType)) {
            return true;
        }

        for (CnpjLicense cnpjLicense : cnpjLicenses) {
            boolean licenseHasPermission;

            switch (kawhyType) {
                case KAWHY_NFE:
                    licenseHasPermission = cnpjLicense.isKawhyNfe();
                    break;
                case KAWHY_CTE:
                    licenseHasPermission = cnpjLicense.isKawhyCte();
                    break;
                case KAWHY_NFSE:
                    licenseHasPermission = cnpjLicense.isKawhyNfse();
                    break;
                case KAWHY_EMAIL:
                    licenseHasPermission = cnpjLicense.isKawhyEmail();
                    break;
                case KAWHY_CONSULTA_NFE:
                    licenseHasPermission = cnpjLicense.isConsultaNfe();
                    break;
                case KAWHY_CONSULTA_CTE:
                    licenseHasPermission = cnpjLicense.isConsultaCte();
                    break;
                case KAWHY_DISTRIBUICAO_NFE:
                    licenseHasPermission = cnpjLicense.isDistribuicaoNfe();
                    break;
                case KAWHY_DISTRIBUICAO_CTE:
                    licenseHasPermission = cnpjLicense.isDistribuicaoCte();
                    break;
                case KAWHY_REGISTRA_EVENTOS:
                    licenseHasPermission = cnpjLicense.isKawhyRegistraEventos();
                    break;
                default:
                    throw new RuntimeException("Tipo de serviço desconhecido: " + kawhyType);

            }

            if (licenseHasPermission) {
                return true;
            }
        }

        log.warn("Nenhuma licença possui permissão para o serviço: " + kawhyType);
        return false;
    }

    public Boolean validateLicenseModuleInstall(KawhyType kawhyType) {
        List<CnpjLicense> cnpjLicenses = getLicenseExist(searchLicense()).getCnpjLicenseList();

        if (cnpjLicenses == null || cnpjLicenses.isEmpty()) {
            log.warn("Nenhuma licença encontrada.");
            return false;
        }

        if (KawhyType.KAWHY_UPDATE_SEFAZ_CERTIFICATE.equals(kawhyType)) {
            return true;
        }

        for (CnpjLicense cnpjLicense : cnpjLicenses) {
            boolean licenseHasPermission;

            switch (kawhyType) {
                case KAWHY_NFE:
                    licenseHasPermission = cnpjLicense.isKawhyNfe();
                    break;
                case KAWHY_CTE:
                    licenseHasPermission = cnpjLicense.isKawhyCte();
                    break;
                case KAWHY_NFSE:
                    licenseHasPermission = cnpjLicense.isKawhyNfse();
                    break;
                case KAWHY_EMAIL:
                    licenseHasPermission = cnpjLicense.isKawhyEmail();
                    break;
                case KAWHY_CONSULTA_NFE:
                    licenseHasPermission = cnpjLicense.isConsultaNfe();
                    break;
                case KAWHY_CONSULTA_CTE:
                    licenseHasPermission = cnpjLicense.isConsultaCte();
                    break;
                case KAWHY_DISTRIBUICAO_NFE:
                    licenseHasPermission = cnpjLicense.isDistribuicaoNfe();
                    break;
                case KAWHY_DISTRIBUICAO_CTE:
                    licenseHasPermission = cnpjLicense.isDistribuicaoCte();
                    break;
                case KAWHY_REGISTRA_EVENTOS:
                    licenseHasPermission = cnpjLicense.isKawhyRegistraEventos();
                    break;
                default:
                    throw new RuntimeException("Tipo de serviço desconhecido: " + kawhyType);

            }

            if (licenseHasPermission) {
                return true;
            }
        }

        log.warn("Nenhuma licença possui permissão para o serviço: " + kawhyType);
        return false;
    }

    public List<String> getCnpjs() {
        License license = getLicense();
        List<String> cnpjs = new ArrayList<>();
        for (CnpjLicense cnpjLicense : license.getCnpjLicenseList()) {
            cnpjs.add(cnpjLicense.getCnpj());
        }

        return cnpjs;
    }

    public License getLicense() {
        String file = "";
        try {
            file = getLicenseFile();
            return getLicenseExist(resourceLoader.getResource(file).getFile());
        } catch (Exception e) {
            throw new StopExecutionException("Erro ao ler ou descriptografar o arquivo de licença : " + file, e);
        }
    }

    public File searchLicense() {
        String directoryPath = System.getProperty("GRA_HOME") + "/ActionSys/KaWhys/Config/";

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".key");
            }
        };

        File[] files = directory.listFiles(filter);

        if (files != null && files.length > 0) {
            return files[0];
        } else {
            return null;
        }
    }

    public License getLicenseExist(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            String content = decryptService.decrypt(bytes);

            ObjectMapper objectMapper = new ObjectMapper();
            License license = objectMapper.readValue(content, License.class);

            return license;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public boolean validateLicense(File file) {
        try {
            if (!file.isFile() && !file.exists()) {
                return false;
            }

            byte[] bytes = Files.readAllBytes(file.toPath());
            String content = decryptService.decrypt(bytes);

            ObjectMapper objectMapper = new ObjectMapper();
            License license = objectMapper.readValue(content, License.class);
            return license != null;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Consultar se isKawhyNfseProcessarOutrosDocumentos é true
    public boolean checkKawhyNfseProcessarOutrosDocumentos(String cnpj) {
        License license = getLicense();

        for (CnpjLicense cnpjLicense : license.getCnpjLicenseList()) {
            if (cnpjLicense.getCnpj().equals(cnpj)) {
                return cnpjLicense.isKawhyNfseProcessarOutrosDocumentos();
            }
        }

        throw new RuntimeException("CNPJ não encontrado.");
    }

    //Valida se alguns dos Cnpjs são válidos.
    public boolean validateCnpjs(List<String> cnpjs) {
        try {
            List<String> list = getCnpjs();
            if (list == null) {
                return true;
            }

            for (String cnpj : list) {
                for (String c : cnpjs) {
                    if (c.substring(0, 8).trim().equals(cnpj.substring(0, 8).trim())) {
                        return true;
                    }
                }
            }
            return false;

        } catch (StopExecutionException e) {
            throw e;
        } catch (Exception e) {
            throw new IgnoreFileException("Erro ao validar cnpjs : " + cnpjs, e);
        }
    }

    public boolean hasDevolucao(String cnpj) {
        License license = getLicense();

        for (CnpjLicense cnpjLicense : license.getCnpjLicenseList()) {
            if (cnpjLicense.getCnpj().substring(0, 8).trim().equals(cnpj.substring(0, 8).trim())) {
                return cnpjLicense.isNfeDevolucao();
            }
        }
        return false;
    }

    //Valida se a raiz do Cnpj tem licença.
    public boolean validateCnpj(String cnpj) {

        try {
            if (cnpj == null || "".equals(cnpj)) {
                return false;
            }

            List<String> cnpjs = getCnpjs();
            for (String c : cnpjs) {
                if (c.substring(0, 8).trim().equals(cnpj.substring(0, 8).trim())) {
                    return true;
                }
            }
            return false;
        } catch (StopExecutionException e) {
            throw e;
        } catch (Exception e) {
            String m = "Erro ao validar cnpjs : " + cnpj;
            log.error(m, e);
            throw new IgnoreFileException(m, e);
        }

    }

    public CnpjLicense find(String cnpj) {
        License license = getLicense();
        for (CnpjLicense cnpjLicense : license.getCnpjLicenseList()) {
            if (cnpj.equals(cnpjLicense.getCnpj())) {
                return cnpjLicense;
            }
        }

        return null;
    }

    private String getLicenseFile() {
        if (StringUtils.isBlank(licenseFile)) {
            String graHome = System.getenv("GRA_HOME");
            if (graHome == null || StringUtils.isBlank(graHome)) {
                licenseFile = "file:/" + Path.of(System.getProperty("GRA_HOME"), "ActionSys/KaWhys/Config/gra-license.key");
            } else {
                licenseFile = "file:/" + Path.of(graHome, "ActionSys/KaWhys/Config/gra-license.key");
            }
        }
        return licenseFile;
    }
}
