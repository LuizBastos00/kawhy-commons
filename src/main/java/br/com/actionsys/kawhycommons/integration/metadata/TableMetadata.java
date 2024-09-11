package br.com.actionsys.kawhycommons.integration.metadata;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TableMetadata {
    private FieldMetadata idField;
    private FieldMetadata sequenceField;
    private List<FieldMetadata> fields;
}
