package br.com.actionsys.kawhycommons.integration;

import br.com.actionsys.kawhycommons.Constants;
import br.com.actionsys.kawhycommons.infra.ContextItem;
import br.com.actionsys.kawhycommons.infra.util.FilesUtil;
import br.com.actionsys.kawhycommons.infra.util.XmlUtil;
import lombok.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IntegrationContext extends ContextItem {

    public IntegrationContext(File file) throws Exception {
        this.file = file;
        this.bytes = FilesUtil.readToBytes(file);
        this.document = XmlUtil.buildDocument(this.bytes);
    }

    private String id;
    private File file;
    protected byte[] bytes;
    private Map<String, String> tempVariables;
    private String customFileName;

    public void setId(String id) {
        this.id = id != null ? id.trim() : null;
    }

    public String getFileName() {
        String fileName = file.getName();
        if (id != null) {
            fileName = id + Constants.XML_EXTENSION;
        }

        if (customFileName != null) {
            fileName = customFileName;
        }
        return fileName;
    }

    public Map<String, String> getTempVariables() {
        if (tempVariables == null) {
            tempVariables = new HashMap<>();
        }
        return tempVariables;
    }
}
