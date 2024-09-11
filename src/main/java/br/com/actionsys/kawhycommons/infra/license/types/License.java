package br.com.actionsys.kawhycommons.infra.license.types;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class License {
    private Date dateGenerated;
    private List<CnpjLicense> cnpjLicenseList;
}
