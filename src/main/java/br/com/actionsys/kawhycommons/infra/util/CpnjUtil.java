package br.com.actionsys.kawhycommons.infra.util;

import org.apache.commons.lang3.StringUtils;

public class CpnjUtil {

    public static String formatCNPJ(String cnpj) {
        return cnpj.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
    }

}
