package br.com.actionsys.kawhycommons.integration;

import br.com.actionsys.kawhycommons.infra.util.FilesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class IntegrationInitFiles implements ApplicationRunner {

    @Value("${dir.entrada:#{null}}")
    public String dirEntrada;
    @Value("${dir.saida:#{null}}")
    public String dirSaida;
    @Value("${dir.erro:#{null}}")
    public String dirErro;
    @Value("${dir.outros:#{null}}")
    public String dirOutros;
    @Value("${dir.duplicados:#{null}}")
    public String dirDuplicados;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        FilesUtil.createDirectoryIfNotNull(dirEntrada);
        FilesUtil.createDirectoryIfNotNull(dirSaida);
        FilesUtil.createDirectoryIfNotNull(dirErro);
        FilesUtil.createDirectoryIfNotNull(dirOutros);
        FilesUtil.createDirectoryIfNotNull(dirDuplicados);
    }

}
