ALTER SESSION SET CONTAINER=XEPDB1;

-- kwnfe_consultanfes
-- kwnfe_controle
CREATE VIEW GRA_USER.kwnfse_padraoxml
AS
SELECT tpq72475 AS padrao_xml
	,tpq72482 AS schema_xml
FROM GRA_USER.fq72482;

CREATE VIEW GRA_USER.kwnfe_infeventodfe
AS
SELECT mdq721280 AS corgao
	,mdq720717 AS tpamb
	,mdq720652 AS chnfe
	,mdq720804 AS cnpj
	,mdq727067 AS dhevento
	,mdq721095 AS tpevento
	,mdq727068 AS nseqevento
	,mdq721281 AS verevento
	,mdq727069 AS descevento
	,mdq727070 AS xcorrecao
	,mdq721282 AS xconduso
	,mdq72c100 AS chcte
	,mdq72c121 AS modal
	,mdq721201 AS dhemi
	,mdq721024 AS nprot
	,mdq721026 AS dhrecbto
	,mdq720853 AS cnpjemi
	,mdq720858 AS ieemi
	,mdq720806 AS xnomeemi
	,mdq721283 AS tpambev
	,mdq721284 AS veraplicev
	,mdq721285 AS corgaoev
	,mdq721286 AS cstatev
	,mdq721287 AS xeventoev
	,mdq721288 AS xmotivoev
	,mdq721289 AS tpeventoev
	,mdq721290 AS nseqeventoev
	,mdq721291 AS dhregeventoev
	,mdq721292 AS nprotev
	,mdq721090 AS nsu
FROM GRA_USER.fq72345;

CREATE VIEW GRA_USER.kwnfe_eventosdfe
AS
SELECT mdq721280 AS corgao
	,mdq720804 AS cnpj
	,mdq720805 AS cpf
	,mdq720652 AS chnfe
	,mdq727067 AS dhevento
	,mdq721090 AS nsu
	,mdq721095 AS tpevento
	,mdq727068 AS nseqevento
	,mdq727069 AS xevento
	,mdq721026 AS dhrecbto
	,mdq721024 AS nprot
FROM GRA_USER.fq72346;

CREATE VIEW GRA_USER.kwnfe_eventos
AS
SELECT evq720652 AS chnfe
	,evq720804 AS cnpj
	,evq721095 AS tpevento
	,evq721140 AS descevento
	,evq720723 AS xjust
	,evq721143 AS tpamb
	,evq72s12 AS cstatheader
	,evq721142 AS xmotivoheader
	,evq72s11 AS cstat
	,evq721141 AS xmotivo
	,evq721026 AS dhregevento
	,evq720841 AS nprot
	,evuser AS audit_usuario
	,evpid AS audit_servico
	,evjobn AS audit_maquina
	,evq72cs0001 AS audit_data
	,evupmt AS audit_hora
	,evq72cs0002 AS audit_datainsert
	,evq72cn0002 AS audit_horainsert
	,evq72cn0001 AS sequencia
FROM GRA_USER.fq72344;

CREATE VIEW GRA_USER.kwnfe_cartacorrecao
AS
SELECT mdq720652 AS chnfe
	,mdq721090 AS nsu
	,mdq727067 AS dhevento
	,mdq721095 AS tpevento
	,mdq727068 AS nseqevento
	,mdq727069 AS descevento
	,mdq727070 AS xcorrecao
	,mdq727071 AS tpnfe
	,mdq727072 AS dhrecbto
	,mdq720707 AS serie
	,mdq720708 AS nnf
FROM GRA_USER.fq72343;

INSERT INTO GRA_USER.kwnfse_padraoxml (
	padrao_xml
	,schema_xml
	)
VALUES (
	'XML RECEPCAO EVENTO '
	,'<?xml version="1.0" encoding="UTF-8"?> 
<envEvento versao="1.00" xmlns="http://www.portalfiscal.inf.br/nfe"><idLote>##IdLote##</idLote><evento versao="1.00"><infEvento Id="##Id##"><cOrgao>##cOrgao##</cOrgao><tpAmb>##tpAmb##</tpAmb><CNPJ>##CNPJ##</CNPJ><chNFe>##chNFe##</chNFe><dhEvento>##dhEvento##</dhEvento><tpEvento>##tpEvento##</tpEvento><nSeqEvento>1</nSeqEvento><verEvento>1.00</verEvento><detEvento versao="1.00"><descEvento>##descEvento##</descEvento><xJust>##xJust##</xJust></detEvento></infEvento></evento></envEvento>'
	);
