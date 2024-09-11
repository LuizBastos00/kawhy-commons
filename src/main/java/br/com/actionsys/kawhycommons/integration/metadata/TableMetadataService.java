package br.com.actionsys.kawhycommons.integration.metadata;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TableMetadataService {

    @Autowired
    private FieldMetadataService fieldMetadataService;

    /**
     * Gera a lista contendo todos os metadados de um diretorio separados por linhas de uma tabela, no caso de possuí complemento where para serapara grupos de registro em uma mesma tabela, por exemplo, na tabela de endereço temos os diferentes grupos  'emi', 'rem'.
     *
     * @param directory diretorio para busca de meta dados
     * @return lista de TableMetadata
     */
    public List<TableMetadata> readAll(Path directory) {
        List<FieldMetadata> allFields = fieldMetadataService.readAll(directory);

        // separar campos por tabela
        return allFields.stream()
                .collect(Collectors.groupingBy(FieldMetadata::getTableId))
                .values().stream().map(this::build)
                .collect(Collectors.toList());
    }

    private TableMetadata build(List<FieldMetadata> tableFields) {
        String tableId = tableFields.stream().findFirst().get().getTableId();

        return TableMetadata.builder()
                .idField(getIdField(tableFields, tableId))
                .sequenceField(getSequenceField(tableFields))
                .fields(tableFields)
                .build();
    }

    private FieldMetadata getIdField(List<FieldMetadata> tableFields, String tableId) {
        return tableFields.stream()
                .filter(field -> "id".equalsIgnoreCase(field.getVariable()))
                .findFirst().orElseThrow(() -> new RuntimeException("Metadado id da tabela " + tableId + " não encontrado"));
    }

    private FieldMetadata getSequenceField(List<FieldMetadata> tableFields) {
        return tableFields.stream()
                .filter(field -> "nSequencia".equalsIgnoreCase(field.getVariable()))
                .findFirst().orElse(null);
    }

}
