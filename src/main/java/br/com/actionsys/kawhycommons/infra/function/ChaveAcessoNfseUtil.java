package br.com.actionsys.kawhycommons.infra.function;

import br.com.actionsys.kawhycommons.types.KawhyType;
import org.apache.commons.lang3.StringUtils;

public class ChaveAcessoNfseUtil {

    //dtEmissao - Data de Emmissao - Formato 20171230 (AAAAMMDD)
    public static String generateNfseId(String dtEmissao, String cpfCnpjPrestador, String numeroNf) {
        /* CPF/CNPJ do Prestador - 14 posicoes completando com zeros a esquerda */
        cpfCnpjPrestador = StringUtils.leftPad(cpfCnpjPrestador, 14, "0");

        /* Numero na Nota Fiscal - 20 posicoes completando com zeros a esquerda */
        numeroNf = StringUtils.leftPad(numeroNf, 20, "0");
        String nfeId = KawhyType.KAWHY_NFSE.getLabel().toUpperCase() + dtEmissao + cpfCnpjPrestador + numeroNf;
        return nfeId;
    }

}
