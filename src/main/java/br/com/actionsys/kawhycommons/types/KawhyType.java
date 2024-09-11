package br.com.actionsys.kawhycommons.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum KawhyType {

    KAWHY_NFE("NFe", "KaWhyNFe", "KwNFe", DocumentType.NFE),
    KAWHY_CTE("CTe", "KaWhyCTe", "KwCTe", DocumentType.CTE),
    KAWHY_NFSE("NFSe", "KaWhyNFSe", "KwNFSe", DocumentType.NFSE),
    KAWHY_EMAIL("Email", "KaWhyEmail", "KwEmail", null),
    KAWHY_CONSULTA_NFE("Consulta NFe", "KaWhyConsultaNFe", "KwConsNFe", DocumentType.NFE),
    KAWHY_CONSULTA_CTE("Consulta CTe", "KaWhyConsultaCTe", "KwConsCTe", DocumentType.CTE),
    KAWHY_DISTRIBUICAO_NFE("Distribuição NFe", "KaWhyDistribuicaoNFe", "KwDistNFe", DocumentType.NFE),
    KAWHY_DISTRIBUICAO_CTE("Distribuição CTe", "KaWhyDistribuicaoCTe", "KwDistCTe", DocumentType.CTE),
    KAWHY_REGISTRA_EVENTOS("Registra Eventos", "KaWhyRegistraEventos", "KwRegEvNFe", DocumentType.NFE),
    KAWHY_UPDATE_SEFAZ_CERTIFICATE("Certificado Sefaz", "KaWhyUpdateSefazCertificate", "KwSefazCer", DocumentType.NFE);

    private String label;
    private String serviceName;
    private String auditName; //Máximo 20 caracteres. 10 caracteres no caso do registra evento.

    private DocumentType documentType;

}
