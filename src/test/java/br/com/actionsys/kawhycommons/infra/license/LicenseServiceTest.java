package br.com.actionsys.kawhycommons.infra.license;

import br.com.actionsys.kawhycommons.infra.license.types.License;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = {LicenseService.class, DecryptService.class})
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class LicenseServiceTest {

    @Autowired
    private LicenseService licenseService;

    @Test
    public void getLicenseTest() {
        License result = licenseService.getLicense();
        Assertions.assertEquals(1724877638615l, result.getDateGenerated().getTime());
        Assertions.assertEquals("11111111111111", result.getCnpjLicenseList().get(0).getCnpj());
        Assertions.assertEquals("22222222222222", result.getCnpjLicenseList().get(1).getCnpj());
    }

    @Test
    public void getCnpjsTest() {
        List<String> result = licenseService.getCnpjs();
        Assertions.assertEquals("11111111111111", result.get(0));
        Assertions.assertEquals("22222222222222", result.get(1));
    }

    @Test
    public void hasDevolucaoTrueTest() {
        String cnpj = "11111111111111"; // Primeiro CNPJ da licença
        boolean hasDevolucao1 = licenseService.hasDevolucao(cnpj);
        assertTrue(hasDevolucao1, "A licença para devolução deve estar ativa para o CNPJ: " + cnpj);
    }

    @Test
    public void hasDevolucaoFalseTest() {
        String cnpj = "22222222222222"; // Primeiro CNPJ da licença
        boolean hasDevolucao1 = licenseService.hasDevolucao(cnpj);
        assertFalse(hasDevolucao1, "A licença para devolução deve estar ativa para o CNPJ: " + cnpj);
    }

}
