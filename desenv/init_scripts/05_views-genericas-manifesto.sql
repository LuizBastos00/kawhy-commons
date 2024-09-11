ALTER SESSION SET CONTAINER=XEPDB1;

CREATE VIEW GRA_USER.kwfun_certificados
AS
SELECT cdq720804 AS cnpj
	,cdq727012 AS tipo
	,cddrpt AS diretorio
	,cdq727013 AS senha
	,cdq727014 AS alias
FROM GRA_USER.fq72361;

CREATE VIEW GRA_USER.kwfun_sequence
AS
SELECT sqq721144 AS kwobjeto
	,sqq721145 AS kwseque
FROM GRA_USER.fq72362;

CREATE VIEW GRA_USER.kwfun_infconfig
AS
SELECT dsq720853 AS cnpj_remetente
	,dsq727009 AS tipo
	,dsq727008 AS informacao
	,dsq72470 AS procurar_por
	,dsq72471 AS recuperar_por
	,dsq72472 AS parar_quando
FROM GRA_USER.fq72484;

CREATE VIEW GRA_USER.kwfun_erros
AS
SELECT ejq720652 AS nfe_id
	,ejq721147 AS aplicativo
	,ejq721148 AS erro
	,ejq720881 AS audit_date
	,ejq720874 AS audit_time
FROM GRA_USER.fq72367;

CREATE VIEW GRA_USER.kwdist_controlensu
AS
SELECT mdq720804 AS cnpj
	,mdq721090 AS ultnsu
	,mdq720961 AS cstat
	,mdq720833 AS xmotivo
	,mdq727073 AS dhresp
	,mdq727074 AS indcont
	,mdq727075 AS minutos
	,mdq720702 AS coduf
	,mdq727078 AS tpamb
	,mdq727076 AS indnfe
	,mdq727077 AS tpdoc
FROM GRA_USER.fq72342;

INSERT INTO GRA_USER.kwfun_sequence (
	kwobjeto
	,kwseque
	)
VALUES (
	'KWNFE_MANIF_DEST    '
	,0
	);