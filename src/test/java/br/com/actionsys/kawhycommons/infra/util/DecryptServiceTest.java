package br.com.actionsys.kawhycommons.infra.util;

import br.com.actionsys.kawhycommons.infra.license.DecryptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = DecryptService.class)
@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class DecryptServiceTest {

    @Autowired
    public DecryptService decryptService;

    @Value("classpath:/chave.key")
    public Resource licenseAction;

    @Test
    public void decryptMessageTest() throws Exception {
        byte[] file = FilesUtil.readToBytes(licenseAction.getFile());

        String decrypted = decryptService.decrypt(file);

        assertEquals("{\"dateGenerated\":1724877638615,\"cnpjLicenseList\":[{\"cnpj\":\"11111111111111\",\"kawhyNfe\":true,\"distribuicaoNfe\":true,\"nfeDevolucao\":true,\"consultaNfe\":true,\"kawhyCte\":true,\"distribuicaoCte\":true,\"consultaCte\":true,\"kawhyNfse\":false,\"kawhyNfseProcessarOutrosDocumentos\":false,\"kawhyEmail\":false,\"kawhyRegistraEventos\":false,\"estado\":\"AM\"},{\"cnpj\":\"22222222222222\",\"kawhyNfe\":true,\"distribuicaoNfe\":true,\"nfeDevolucao\":false,\"consultaNfe\":true,\"kawhyCte\":true,\"distribuicaoCte\":true,\"consultaCte\":true,\"kawhyNfse\":false,\"kawhyNfseProcessarOutrosDocumentos\":false,\"kawhyEmail\":false,\"kawhyRegistraEventos\":false,\"estado\":\"PA\"}]}", decrypted);
    }

}
