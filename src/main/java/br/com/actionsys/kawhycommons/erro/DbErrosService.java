package br.com.actionsys.kawhycommons.erro;

import br.com.actionsys.kawhycommons.Constants;
import br.com.actionsys.kawhycommons.infra.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class DbErrosService {
//  tabela crpdta.fq72367  kwfun_erros
//  ejq720652 AS nfe_id 50
//	ejq721147 AS aplicativo 20
//	ejq721148 AS erro 500
//	ejq720881 AS audit_date 20
//	ejq720874 AS audit_time 20
//  PK
//  EJQ720652
//  EJQ721147
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveApp(String module, String erro) {
        save(Constants.ERROR_APP, module, erro);
    }

    //Mantém um registro para cada documento dentro do módulo.
    public void save(String documentId, String module, String erro) {
        try {
            String moduleSql = StringUtils.rightPad(module, 20);
            String documentIdSql = StringUtils.rightPad(documentId, 50);

            Integer count = jdbcTemplate.queryForObject("select count(*) from fq72367 where ejq720652 = ? and ejq721147 = ?", Integer.class, documentIdSql, moduleSql);

            String sql;
            if (count > 0) {
                sql = "update fq72367 set ejq720881 = ?, ejq720874 = ?, ejq721148 = ? where ejq720652 = ? and ejq721147 = ?";
            } else {
                sql = "insert into fq72367 (ejq720881, ejq720874, ejq721148, ejq720652, ejq721147) values (?, ?, ?, ?, ?)";
            }

            Date now = new Date();
            String data = DateUtil.formatDateToDb(now); //2023-08-26
            String hora = DateUtil.formatTimeToDb(now); // 23:30:47.450361814

            jdbcTemplate.update(sql, data, hora, StringUtils.substring(erro, 0, 500), documentIdSql, moduleSql);
        } catch (Exception e) {
            log.error("Erro ao salvar registro na tabela fq72367 (Kwfun_erros)", e);
        }
    }
//    public void save(String documentId, String module, Exception exception) {
//        String erro = ExceptionUtils.getStackTrace(exception);
//        log.info("--------------------------------------------\n" + erro);
//        save(documentId, module, erro);
//    }
}
