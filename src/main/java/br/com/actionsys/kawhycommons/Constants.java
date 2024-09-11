package br.com.actionsys.kawhycommons;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Constants {
	public static final String KAWHY = "KAWHY";


	//	###### DB ######
	public static final String DB_URL_KEY = "db.url";
	public static final String DB_DRIVER_KEY = "db.driver";
    public static final String DB_DIALETO_KEY = "db.dialect";
	public static final String DB_BIBLIOTECA_KEY = "db.schema";
	public static final String DB_USUARIO_KEY = "db.user";
	public static final String DB_SENHA_KEY = "db.password";

	//	###### ÚTIL ######
	public static DateTimeFormatter SEFAZ_DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");
	public static ZoneId TIME_ZONE = ZoneId.of("America/Sao_Paulo");
	public static final String XML_EXTENSION = ".xml";
	public static final String SPACE = " ";
	public static final String ZERO = "0";
	public static final String NO = "N";
	public static final String YES = "Y";
	public static final String S = "S";
	public static final String DESCRIPTION_CANCEL_DOCUMENT = "Cancelada";
	public static final String XML = "XML";

	public static final String SEFAZ_AMBIENTE_NACIONAL = "91";

	public static final String CSTATUS_SEFAZ_APROVADO = "100";
	public static final String CSTATUS_SEFAZ_CACELAMENTO = "101";

	//	###### DELIVERY ######
	public static final String DELIVERY_SEFAZ_RETORNO_COM_ITENS_HA_PROCESSAR = "138";
	public static final String DELIVERY_SEFAZ_RETORNO_CONSUMO_INDEVIDO = "656";
	public static final String DELIVERY_SEFAZ_EVENTO_TP_CARTA_CORRECAO = "110110";
	public static final String DELIVERY_KWDISTDFE = "KWDISTDFE";
	public static final String DELIVERY_ORIGEM_DOCUMENTO = "D";

	//		### NFE ###
	public static final String NFE_DELIVERY_DOCUMENT_TYPE = "NF";
	public static final String NFE_DEVOLUCAO = "4";
	public static final String NFE_SEFAZ_EVENTO_TP_CANCELAMENTO = "110111";
	public static final String NFE_DELIVERY_SEFAZ_EVENTO_PREFIX_EVENTO = "procEventoNFe";
	public static final String NFE_DELIVERY_SEFAZ_EVENTO_PREFIX_RESUMO_NOTA = "resNFe";
	public static final String NFE_DELIVERY_SEFAZ_EVENTO_PREFIX_RESUMO_EVENTO = "resEvento";
	public static final Integer NFE_REG_EVENTO_ID_LOTE = 0;
	public static final Integer NFE_REG_EVENTO_SEQUENCE = 1;

	//Tag usada no layout 2.0 da sefaz.
	public static final String NFE_DELIVERY_SEFAZ_ITEMZIP_PREFIX_DUCUMENTO_2 = "procNFe";
	public static final String NFE_DELIVERY_SEFAZ_EVENTO_PREFIX_DUCUMENTO_3 = "nfeProc";

	//		### CTE ###
	public static final String CTE_DELIVERY_SEFAZ_EVENTO_TP_CANCELAMENTO = "110111";
	public static final String CTE_XMOTIVO = "Cancelamento Homologado";
	public static final String CTE_EVCTE_XJUST = "Cancelar";
	//Tag usada no layout 2.0 da sefaz.
	public static final String CTE_DELIVERY_SEFAZ_EVENTO_PREFIX_DUCUMENTO_2 = "procCTe";
	public static final String CTE_DELIVERY_SEFAZ_EVENTO_PREFIX_DUCUMENTO_3 = "cteProc";
	public static final String CTE_DELIVERY_SEFAZ_EVENTO_PREFIX_EVENTO = "procEventoCTe";
	public static final String CTE_PREFIX_FILE_NAME_EVENT = "ProcEvento_";

	// 		## NFSE ###
	public static final String NFSE_CANCELADA = "NOTA CANCELADA";
	//	###### QUERY ######

	public static final String CERTIFICATE = "Certificado";
	public static final String CERTIFICATE_DEFAULT = "PADRAO";


	//	###### ERRO ######
	//Constant utilizada para marcar erros relacionados a aplicação e não apenas para um único documento.
	public static final String ERROR_APP = "APP";
	public static final String ERROR_NSU = "NSU";

}
