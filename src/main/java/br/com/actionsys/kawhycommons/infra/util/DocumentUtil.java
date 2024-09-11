package br.com.actionsys.kawhycommons.infra.util;

import br.com.actionsys.kawhycommons.types.DocumentType;
import org.w3c.dom.Document;

public class DocumentUtil {

    public static boolean isNfe(Document document) {
        return APathUtil.hasTag(document, "nfeProc/NFe/infNFe");
    }

    public static boolean isCte(Document document) {
        return APathUtil.hasTag(document, "cteProc/CTe/infCte/@Id");
    }

    public static boolean isNfse(Document document) {
        return APathUtil.hasTag(document, "IntegracaoMidas");
    }

    public static boolean isNfseAuxiliar(Document document) {
        return APathUtil.hasTag(document, "DocumentoAuxiliarIntegracao");
    }


    public static DocumentType getDocumentType(byte[] bytes) {
        Document document;
        try {
            document = XmlUtil.buildDocument(bytes);
        } catch (Exception ex) {
            return null;
        }

        if (DocumentUtil.isNfe(document)) {
            return DocumentType.NFE;
        } else if (DocumentUtil.isCte(document)) {
            return DocumentType.CTE;
        } else if (DocumentUtil.isNfse(document) || DocumentUtil.isNfseAuxiliar(document)) {
            return DocumentType.NFSE;
        }
        return null;
    }

}
