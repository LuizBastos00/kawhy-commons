package br.com.actionsys.kawhycommons.db.erro;

import br.com.actionsys.kawhycommons.erro.DbErrosService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@SpringBootApplication(scanBasePackages = "br.com.actionsys")
public class DbErrosService_saveTest {

    @Autowired
    private DbErrosService dbErrosService;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void clearDB() {
        jdbcTemplate.execute("delete from fq72367");
    }

    //Testa salvar dois erros para o mesmo documento, o registro dever ser atualizado com o segundo erro.
    @Test
    public void success() {
        clearDB();
        //Verifica se salvou corretamente no banco de dados.
        assertDoesNotThrow(() -> dbErrosService.save("id", "module", "Error"));

        String erroValue = jdbcTemplate.queryForObject("select ejq721148 from fq72367 where ejq720652 = ? and ejq721147 = ?", String.class, "id                                                ", "module              ");

        assertEquals("Error", erroValue);

        assertDoesNotThrow(() -> dbErrosService.save("id", "module", "Error 2"));
        String erroValue2 = jdbcTemplate.queryForObject("select ejq721148 from fq72367 where ejq720652 = ? and ejq721147 = ?", String.class, "id                                                ", "module              ");

        assertEquals("Error 2", erroValue2);
    }


    //Não pode lançar uma exceção quando ocorrer um erro ao escrever o registro no banco de dados.
    @Test
    public void exeception_size() {
        clearDB();

        assertDoesNotThrow(() -> dbErrosService.save("id", "moduleXXXXXXXXXXXXXXXXXX", "Error"));
        Integer count = jdbcTemplate.queryForObject("select count(*) from fq72367", Integer.class);
        assertEquals(0, count);
    }

}
