ALTER SESSION SET CONTAINER=XEPDB1;

-- kwcte_controle
-- kwcte_canceladas

CREATE VIEW GRA_USER.kwdist_consultactes
AS
SELECT mdq720652 AS chcte
	,mdq721091 AS tipo
	,mdq721090 AS nsu
	,mdq720804 AS cnpj
	,mdq720805 AS cpf
	,mdq720806 AS xnome
	,mdq720819 AS ie
	,mdq720709 AS demi
	,mdq720712 AS tpnf
	,mdq720737 AS vnf
	,mdq721092 AS digval
	,mdq721026 AS dhrecbto
	,mdq721093 AS csitnfe
	,mdq721094 AS csitconf
	,mdq72s05 AS xml
	,mdq720842 AS cnpjtoma
	,mdq720708 AS nct
	,mdq720707 AS serie
	,mdq721146 AS status_evento
	,mdq721095 AS tpevento
	,mdq721140 AS descevento
	,mdq720723 AS xjust
	,mdq720702 AS cuf
	,mdq72cc0001 AS manifdef
	,mdq72cc0002 AS orig_doc
	,mduser AS audit_usuario
	,mdpid AS audit_servico
	,mdjobn AS audit_maquina
	,mdupmj AS audit_data
	,mdupmt AS audit_hora
	,mdq72cs0001 AS audit_datainsert
	,mdq72cn0001 AS audit_horainsert
FROM GRA_USER.fq72340;