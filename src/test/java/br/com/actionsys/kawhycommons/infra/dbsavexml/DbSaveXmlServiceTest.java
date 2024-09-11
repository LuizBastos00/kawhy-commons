package br.com.actionsys.kawhycommons.infra.dbsavexml;

import br.com.actionsys.kawhycommons.infra.util.FilesUtil;
import br.com.actionsys.kawhycommons.integration.IntegrationContext;
import br.com.actionsys.kawhycommons.types.KawhyType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.File;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "br.com.actionsys")
public class DbSaveXmlServiceTest {

    @Autowired
    private DbSaveXmlService dbSaveXmlService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("/xml/procNFe_v4.00_completo.xml")
    private Resource xmlResource;

    public void clearDB() {
        jdbcTemplate.execute("delete from fq72319");
    }

    public void before() throws Exception {
        clearDB();
        File resource = xmlResource.getFile();

        IntegrationContext item = new IntegrationContext(resource);
        item.setId("NFe35230856493877000116550010002073651002155823");

        dbSaveXmlService.process(item, KawhyType.KAWHY_NFE.getAuditName(), "EM");
    }

    @Test
    public void success() throws Exception {
        before();

        List<Map<String, Object>> result = jdbcTemplate.queryForList
                ("select * from fq72319 where nxq720652 like '%NFe35230856493877000116550010002073651002155823%' ORDER BY nxq720653");//kwnfe_xml

        StringBuilder xml = new StringBuilder();
        for (Map<String, Object> row : result) {
            xml.append(row.get("nxq720839"));
        }

        Assertions.assertEquals(FilesUtil.readToString(xmlResource.getFile()), xml.toString().trim());
    }

    @Test
    public void exception_process() throws Exception {
        clearDB();

        File resource = xmlResource.getFile();

        //Irá tentar inserir o xml, mas sem o ID.
        IntegrationContext item = new IntegrationContext(resource);

        Assertions.assertDoesNotThrow(() ->
                dbSaveXmlService.process(item, KawhyType.KAWHY_NFE.getAuditName(), "EM"));

        Integer count = jdbcTemplate.queryForObject("select count(*) from fq72319", Integer.class);
        assertEquals(0, count);
    }

}
