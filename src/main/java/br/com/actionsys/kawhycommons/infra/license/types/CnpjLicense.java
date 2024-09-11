package br.com.actionsys.kawhycommons.infra.license.types;

import br.com.actionsys.kawhycommons.types.EstadoType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data

public class CnpjLicense {

    private String cnpj;

    @JsonProperty("estado")
    private EstadoType estadoType;

    //NFe
    private boolean kawhyNfe;
    private boolean distribuicaoNfe;
    private boolean nfeDevolucao;
    private boolean consultaNfe;

    //CTe
    private boolean kawhyCte;
    private boolean distribuicaoCte;
    private boolean consultaCte;

    //NFSe
    private boolean kawhyNfse;
    private boolean kawhyNfseProcessarOutrosDocumentos;

    //Uteis
    private boolean kawhyEmail;
    private boolean KawhyRegistraEventos;
}
