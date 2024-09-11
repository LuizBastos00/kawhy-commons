package br.com.actionsys.kawhycommons.infra.license;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Arrays;

@Slf4j
@Component
public class DecryptService {

    @Value("classpath:graPublic.key")
    public Resource publicKeyResource;

    public String decrypt(byte[] key) {
        try (InputStream isPublicKey = publicKeyResource.getInputStream()) {
            //Chave AES criptografada via RSA
            byte[] aesKeyCrypted = Arrays.copyOfRange(key, 0, 512);

            //Mensagem Criptografada via AES
            byte[] aesMessageCrypted = Arrays.copyOfRange(key, 512, key.length);

            PublicKey publicKey = readPublicKeyFromFile(isPublicKey.readAllBytes());

            Cipher decryptCipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            decryptCipher.init(Cipher.DECRYPT_MODE, publicKey);
            byte[] aesKeyDecrypted = decryptCipher.doFinal(aesKeyCrypted);

            //Chave AES descriptografada
            SecretKey aesKey = new SecretKeySpec(aesKeyDecrypted, "AES");
            byte[] aesMessageDecrypted = decryptAES(aesMessageCrypted, aesKey);

            return new String(aesMessageDecrypted);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler chave pública. ", e);
        }
    }

    private byte[] decryptAES(byte[] message, SecretKey secretKey) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return cipher.doFinal(message);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao ler chave AES.");
        }
    }

    private PublicKey readPublicKeyFromFile(byte[] key) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        EncodedKeySpec publicKeySpec = new X509EncodedKeySpec((key));
        return keyFactory.generatePublic(publicKeySpec);
    }


}
