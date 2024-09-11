package br.com.actionsys.kawhycommons.infra.license;

import br.com.actionsys.kawhycommons.types.KawhyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {LicenseService.class, DecryptService.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LicenseService_validateLicenseModuleTest {

    @Autowired
    private LicenseService licenseService;

    @Test
    public void success() {

        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_NFE));
        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_CONSULTA_CTE));
        Assertions.assertFalse(licenseService.validateLicenseModule(KawhyType.KAWHY_EMAIL));
        Assertions.assertFalse(licenseService.validateLicenseModule(KawhyType.KAWHY_NFSE));
        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_CTE));
        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_CONSULTA_NFE));
        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_CONSULTA_CTE));
        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_DISTRIBUICAO_CTE));
        Assertions.assertTrue(licenseService.validateLicenseModule(KawhyType.KAWHY_DISTRIBUICAO_NFE));
        Assertions.assertFalse(licenseService.validateLicenseModule(KawhyType.KAWHY_REGISTRA_EVENTOS));

    }

}
