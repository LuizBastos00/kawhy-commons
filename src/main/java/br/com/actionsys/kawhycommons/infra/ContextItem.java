package br.com.actionsys.kawhycommons.infra;

import br.com.actionsys.kawhycommons.infra.util.APathUtil;
import lombok.Data;
import org.w3c.dom.Document;

@Data
public class ContextItem {

    protected Document document;

    public String aPath(String aPath) {
        return APathUtil.executeOrNull(document, aPath);
    }
}
