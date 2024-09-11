package br.com.actionsys.kawhycommons.infra.function;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
@SpringBootTest(classes = {NumeroNfseFunction.class})
public class NumeroNfseFunction_generateNfseNumberTeste {

    @Autowired
    private NumeroNfseFunction numeroNfseFunction;

    @Test
    public void test1() {
        String numero = "00020172394";
        String data = "2024-06-05T00:00:00";
        String result = numeroNfseFunction.generateNfseNumber(numero, data);
        assertEquals("240172394", result);
        log.info("numero {}, result {}", numero, result);
    }

    @Test
    public void test2() {
        String numero = "000008725912051";
        String data = "2024-06-05T00:00:00";
        String result = numeroNfseFunction.generateNfseNumber(numero, data);

        assertEquals("245912051", result);
    }

    @Test
    public void test3() {
        String numero = "2024000008725912051";
        String data = "2024-06-05T00:00:00";
        String result = numeroNfseFunction.generateNfseNumber(numero, data);

        assertEquals("245912051", result);
    }
}