package br.com.actionsys.kawhycommons.infra.dbsavexml;

import br.com.actionsys.kawhycommons.infra.util.DateUtil;
import br.com.actionsys.kawhycommons.integration.IntegrationContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DbSaveXmlService {

//   tabela fq72319 - kwnfe_xml
//   nxq720652 AS nfe_id
//	 nxq720897 AS xml_tipo
//	 nxq720653 AS xml_seq
//	 nxq720839 AS xml_nfe
//	 nxuser    AS xml_user
//	 nxq72172  AS xml_date
//	 nxtime    AS xml_time
//	 nxq72173  AS xml_jobn
//   PK
//   nxq720652
//   nxq720897
//   nxq720653

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void process(IntegrationContext item, String module, String documentType) throws Exception {
        try {
            List<String> xmlDbInsertLines = substringXml(item);
            String sql = "insert into fq72319 (nxq720652, nxq720897, nxq720653, nxuser, nxq72172, nxtime, nxq72173, nxq720839) values (?, ?, ?, ?, ?, ?, ?, ?)";

            Date now = new Date();
            String data = DateUtil.formatDateToDb(now); //2023-08-26
            String hora = DateUtil.formatTimeToDb(now); // 23:30:47.450361814

            String jobn = InetAddress.getLocalHost().getHostAddress();

            int count = 1;
            for (String line : xmlDbInsertLines) {
                jdbcTemplate.update(sql, item.getId(), documentType, count, module, data, hora, jobn, line);
                count ++;
            }

        } catch (Exception e) {
            log.error("Erro ao salvar XML na tabela fq72319 (kwnfe_xml/kwnfse_xml): " + item.getFile().getAbsolutePath(), e);
        }
    }

    private List<String> substringXml(IntegrationContext item) throws Exception {
        List<String> xmlStringList = new ArrayList<String>();

        String xml = new String(item.getBytes());
        String dbLine = "";

        boolean flag = false;
        while (!flag) {
            if (xml.length() <= 4000) {
                dbLine = xml;
                dbLine = String.format("%-3999s", dbLine);
                flag = true;
            } else {
                dbLine = xml.substring(0, 4000 - 1);
                xml = xml.substring(4000 - 1);
            }
            xmlStringList.add(dbLine);
        }
        return xmlStringList;
    }


}
