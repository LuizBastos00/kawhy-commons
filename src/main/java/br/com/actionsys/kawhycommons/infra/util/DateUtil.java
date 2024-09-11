package br.com.actionsys.kawhycommons.infra.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String formatDate(Date date, String mask) {
		if (date == null) {
			return null;
		}

		SimpleDateFormat s = new SimpleDateFormat(mask);
		return s.format(date);
    }

    public static String formatDateTimeToLabel(Date date) {
		return formatDate(date, "dd/MM/yyyy HH:mm:ss");
    }

    public static String formatDateToLabel(Date date) {
        return formatDate(date, "dd/MM/yyyy");
	}

	public static String formatTimeToDb(Date date) { return formatDate(date, "HH:mm:ss"); }

	public static String formatDateToDb(Date date) { return formatDate(date, "yyyy-MM-dd"); }
	public static String formatTimeToHHmmss(Date date) { return formatDate(date, "HHmmss"); }

	public static String formatDateToJulian(Date date) {
		String dataJulian = formatDateToJulian(formatDateToDb(date));
		return dataJulian;
	}

	public static String formatDateToJulian(String dataStr) {

		int meses[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int somaDias = 0, mesN, diaN, anoN, secN;
		String dia, mes, ano, sec, dataJulian = "";
		ano = dataStr.substring(0, 4);
		anoN = Integer.parseInt(ano);
		mes = dataStr.substring(5, 7);
		mesN = Integer.parseInt(mes);
		dia = dataStr.substring(8, 10);
		diaN = Integer.parseInt(dia);
		sec = dataStr.substring(1, 2);
		secN = Integer.parseInt(sec);

		//Verificar se é ano bissesto
		if (anoN % 4 == 0) {
			if (anoN % 100 == 0) {
				if (anoN % 400 == 0) {
					meses[2] = 29;
				}
			} else {
				meses[2] = 29;
			}
		}

		somaDias = somaDias + diaN;
		for (int i = mesN - 1; i > 0; i--) {
			somaDias = somaDias + meses[i];
		}
		ano = dataStr.substring(2, 4);
		secN = secN + 1;

		if (somaDias < 100) {
			if (somaDias < 10) {
				dataJulian = "00";
			} else {
				dataJulian = "0";
			}
		}

		dataJulian = secN + ano + dataJulian + somaDias;
		return dataJulian;
	}

	public static String formatDateSefazToDb(String date) {
		return date.substring(0, date.indexOf("T"));
	}

	public static String formatTimeSefazToDb(String date) {
		return date.substring(date.indexOf("T") + 1, date.indexOf("T") + 9);
	}

}
