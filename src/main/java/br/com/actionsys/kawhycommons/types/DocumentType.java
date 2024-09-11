package br.com.actionsys.kawhycommons.types;

import lombok.Getter;

@Getter
public enum DocumentType {
  NFE("NFe", "1", "EM", "CA"),
  CTE("CTe", "2", "CT", "TC"),

  // FIXME - Verificar com o Fernando o que precisa ser feito, pois no legado não salvavamos o xml de cancelamento NFSE no banco de dados.
  NFSE("NFSe", "3", "NFSE", "SC");

  DocumentType(String prefix, String actionCode, String issueType, String cancelType) {
    this.prefix = prefix;
    this.actionCode = actionCode;
    this.issueType = issueType;
    this.cancelType = cancelType;
  }

  private String prefix;
  private String actionCode;
  private String issueType;
  private String cancelType;
}
