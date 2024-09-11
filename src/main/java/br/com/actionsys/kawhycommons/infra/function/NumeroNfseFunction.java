package br.com.actionsys.kawhycommons.infra.function;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class NumeroNfseFunction {

    public String generateNfseNumber(String nnf, String dtEmissao) {
        Integer nnfMaxSize = 7;

        //Considerando que o ano vem no formato YYYY
        String year = dtEmissao.substring(2, 4);

        if (nnf.length() > nnfMaxSize) {
            String lastDigits = nnf.substring(nnf.length() - 7);
            return year + lastDigits;
        } else {
            String digits = StringUtils.leftPad(nnf, nnfMaxSize, "0");
            return year + digits;
        }
    }
}
