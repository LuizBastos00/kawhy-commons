package br.com.actionsys.kawhycommons.integration.metadata;

import lombok.Data;

@Data
public class FieldMetadata {

    private String tableId;
    private String table;
    private String variable;
    private String column;
    private String aPath;
    private String type;
    private String whereComplement;
    private String regex;
}
