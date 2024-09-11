package br.com.actionsys.kawhycommons.integration.metadata;

import br.com.actionsys.kawhycommons.infra.util.FilesUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldMetadataService {

    /**
     * Gera a lista contendo todos os metadados em um diretorio
     *
     * @param directory diretorio para busca de meta dados
     * @return lista de meta dados
     */
    public List<FieldMetadata> readAll(Path directory) {

        try {
            return FilesUtil.readLinesFromDirectory(directory)
                    .stream().map(this::build)
                    .filter(field -> !isIncomplete(field))
                    .collect(Collectors.toList());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private FieldMetadata build(String csvLine) {

        String[] columns = csvLine.split(",");

        FieldMetadata field = new FieldMetadata();
        field.setTable(getColumnValue(columns, 0));
        field.setColumn(getColumnValue(columns, 1));
        field.setVariable(getColumnValue(columns, 2));
        field.setAPath(getColumnValue(columns, 3));
        field.setType(getColumnValue(columns, 4));
        if (columns.length > 5) {
            field.setWhereComplement(getColumnValue(columns, 5));

            if(columns.length > 6) {
                field.setRegex(getColumnValue(columns, 6));
            }
        }

        field.setTableId(field.getTable() + "_" + field.getWhereComplement());

        return field;
    }

    private boolean isIncomplete(FieldMetadata field) {

        return field.getAPath() == null
                || "-".equals(field.getAPath())
                || field.getTable() == null
                || field.getColumn() == null;
    }

    private String getColumnValue(String[] columns, int columnIndex) {
        String value = columns[columnIndex].trim();
        return StringUtils.isBlank(value) ? null : value;
    }
}
