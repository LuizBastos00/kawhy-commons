ALTER SESSION SET CONTAINER=XEPDB1;

CREATE VIEW GRA_USER.kwcte
AS
SELECT ctq72c100 AS id
	,ctq72c101 AS cuf
	,ctq72c102 AS cct
	,ctq72c103 AS cfop
	,ctq72c104 AS natop
	,ctq72c105 AS forpag
	,ctq72c106 AS mod
	,ctq72c107 AS serie
	,ctq72c108 AS nct
	,ctq72c109 AS demi
	,ctq72c307 AS hemi
	,ctq72c110 AS tpimp
	,ctq72c111 AS tpemis
	,ctq72c112 AS cdv
	,ctq72c113 AS tpamb
	,ctq72c114 AS tpcte
	,ctq72c115 AS procemi
	,ctq72c116 AS verproc
	,ctq72c117 AS refcte
	,ctq72c118 AS cmunemi
	,ctq72c119 AS xmunemi
	,ctq72c120 AS ufemi
	,ctq72c121 AS modal
	,ctq72c122 AS tpserv
	,ctq72c123 AS cmunini
	,ctq72c124 AS xmunini
	,ctq72c125 AS ufini
	,ctq72c126 AS cmunfim
	,ctq72c127 AS xmunfim
	,ctq72c128 AS uffim
	,ctq72c129 AS retira
	,ctq72c130 AS xdetretira
	,ctq72c131 AS toma
	,ctq72c132 AS vprest_vtprest
	,ctq72c133 AS vprest_vrec
	,ctq72c134 AS icms_cst
	,ctq72c135 AS icms_predbc
	,ctq72c136 AS icms_vbc
	,ctq72c137 AS icms_picms
	,ctq72c138 AS icms_vicms
	,ctq72c139 AS icms_vcred
	,ctq72c308 AS icms_vbcstret
	,ctq72c309 AS icms_vicmsstret
	,ctq72c310 AS icms_picmsstret
	,ctq72c311 AS icms_predbcoutrauf
	,ctq72c312 AS icms_vbcoutrauf
	,ctq72c313 AS icms_picmsoutrauf
	,ctq72c314 AS icms_vicmsoutrauf
	,ctq72c315 AS icms_indsn
	,ctq72c140 AS infadfisco
	,ctq72c141 AS infcarga_vcarga
	,ctq72c142 AS infcarga_propred
	,ctq72c143 AS infcarga_xoutcat
	,ctq72cs0006 AS rodo_rntrc
	,ctq72c145 AS rodo_dprev
	,ctq72c146 AS rodo_lota
	,ctq72c147 AS rodo_ctrb_serie
	,ctq72c148 AS rodo_nctrb
	,ctq72c149 AS valeped_nrore
	,ctq72c150 AS vtvaleped
	,ctq72c151 AS valeped_resppg
FROM GRA_USER.fq72c300;

CREATE VIEW GRA_USER.kwcte_enderecos
AS
SELECT ceq72c100 AS cte_id
	,ceq72c152 AS ctipo
	,ceq72c153 AS nsequencia
	,ceq72c154 AS cnpj
	,ceq72c155 AS cpf
	,ceq72c156 AS ie
	,ceq72c157 AS xnome
	,ceq72c158 AS xfant
	,ceq72c159 AS fone
	,ceq72c160 AS isuf
	,ceq72c161 AS xlgr
	,ceq72c162 AS nro
	,ceq72c163 AS xcpl
	,ceq72c164 AS xbairro
	,ceq72c165 AS cmun
	,ceq72c166 AS xmun
	,ceq72c167 AS cep
	,ceq72c120 AS uf
	,ceq72c168 AS cpais
	,ceq72c169 AS xpais
	,ceq72c316 AS email
	,ceq72c170 AS cint
	,ceq72cs0006 AS rntrc
	,ceq72c171 AS tpprop
FROM GRA_USER.fq72c302;

CREATE VIEW GRA_USER.kwcte_compl
AS
SELECT ccq72c100 AS cte_id
	,ccq72c172 AS xcaracad
	,ccq72c173 AS xcaracser
	,ccq72c174 AS xemi
	,ccq72c175 AS xorig
	,ccq72c176 AS xdest
	,ccq72c177 AS xrota
	,ccq72c178 AS entrega_tpper
	,ccq72c179 AS entrega_dprog
	,ccq72c180 AS entrega_dini
	,ccq72c181 AS entrega_dfim
	,ccq72c182 AS entrega_tphor
	,ccq72c183 AS entrega_hprog
	,ccq72c184 AS entrega_hini
	,ccq72c185 AS entrega_hfim
	,ccq72c186 AS origcalc
	,ccq72c187 AS destcalc
	,ccq72c188 AS xobs
FROM GRA_USER.fq72c301;

CREATE VIEW GRA_USER.kwcte_pass
AS
SELECT cpq72c100 AS cte_compl_cte_id
	,cpq72c153 AS nsequencia
	,cpq72c189 AS xpass
FROM GRA_USER.fq72c303;

CREATE VIEW GRA_USER.kwcte_observacao
AS
SELECT coq72c100 AS cte_compl_cte_id
	,coq72c190 AS ctipoobservacao
	,coq72c153 AS nsequencia
	,coq72c191 AS xcampo
	,coq72c192 AS xtexto
FROM GRA_USER.fq72c304;

CREATE VIEW GRA_USER.kwcte_infdocumentos
AS
SELECT cdq72c193 AS cte_enderecos_ctipo
	,cdq72c194 AS cte_enderecos_cte_id
	,cdq72c195 AS cte_enderecos_nsequencia
	,cdq72c152 AS ctipo
	,cdq72c153 AS nsequencia
	,cdq72c100 AS chave
	,cdq72c196 AS pin
	,cdq72c197 AS tpdoc
	,cdq72c198 AS descoutros
	,cdq72c199 AS ndoc
	,cdq72c200 AS demi
	,cdq72c201 AS vdocfisc
	,cdq72c202 AS nroma
	,cdq72c203 AS nped
	,cdq72c106 AS mod
	,cdq72c204 AS serie
	,cdq72c205 AS vbc
	,cdq72c138 AS vicms
	,cdq72c206 AS vbcst
	,cdq72c207 AS vst
	,cdq72c208 AS vprod
	,cdq72c209 AS vnf
	,cdq72c103 AS ncfop
	,cdq72c210 AS npeso
FROM GRA_USER.fq72c305;

CREATE VIEW GRA_USER.kwcte_vprest_comp
AS
SELECT cpq72c100 AS cte_id
	,cpq72c153 AS nsequencia
	,cpq72c157 AS xnome
	,cpq72c211 AS vcomp
FROM GRA_USER.fq72c306;

CREATE VIEW GRA_USER.kwcte_infcarga_infq
AS
SELECT ciq72c100 AS cte_id
	,ciq72c153 AS nsequencia
	,ciq72c212 AS cunid
	,ciq72c213 AS tpmed
	,ciq72c214 AS qcarga
FROM GRA_USER.fq72c307;

CREATE VIEW GRA_USER.kwcte_contqt
AS
SELECT cqq72c100 AS cte_id
	,cqq72c153 AS nsequencia
	,cqq72c215 AS ncont
	,cqq72c216 AS dprev
FROM GRA_USER.fq72c308;

CREATE VIEW GRA_USER.kwcte_laccontqt
AS
SELECT clq72c317 AS cte_contqt_nsequencia
	,clq72c100 AS cte_contqt_cte_id
	,clq72c153 AS nsequencia
	,clq72c217 AS nlacre
FROM GRA_USER.fq72c309;

CREATE VIEW GRA_USER.kwcte_iddocantpap
AS
SELECT cdq72c100 AS cte_id
	,cdq72c219 AS iddocant_nsequencia
	,cdq72c153 AS nsequencia
	,cdq72c197 AS tpdoc
	,cdq72c107 AS serie
	,cdq72c218 AS subser
	,cdq72c199 AS ndoc
	,cdq72c200 AS demi
FROM GRA_USER.fq72c310;

CREATE VIEW GRA_USER.kwcte_iddocantele
AS
SELECT caq72c100 AS cte_id
	,caq72c219 AS iddocant_nsequencia
	,caq72c153 AS nsequencia
	,caq72c318 AS chave
FROM GRA_USER.fq72c311;

CREATE VIEW GRA_USER.kwcte_seg
AS
SELECT csq72c100 AS cte_id
	,csq72c153 AS nsequencia
	,csq72c220 AS respseg
	,csq72c221 AS xseg
	,csq72c222 AS napol
	,csq72c223 AS naver
	,csq72c319 AS vcarga
FROM GRA_USER.fq72c312;

CREATE VIEW GRA_USER.kwcte_rodo
AS
SELECT crq72c100 AS cte_id
	,crq72cs0006 AS rntrc
	,crq72c145 AS dprev
	,crq72c146 AS lota
	,crq72c320 AS ciot
FROM GRA_USER.fq72c313;

CREATE VIEW GRA_USER.kwcte_rodo_occ
AS
SELECT crq72c100 AS cte_rodo_cte_id
	,crq72c153 AS nsequencia
	,crq72c107 AS serie
	,crq72c225 AS nocc
	,crq72c200 AS demi
FROM GRA_USER.fq72c314;

CREATE VIEW GRA_USER.kwcte_valeped
AS
SELECT cvq72c100 AS cte_rodo_cte_id
	,cvq72c153 AS nsequencia
	,cvq72c154 AS cnpjforn
	,cvq72c230 AS ncompra
	,cvq72c321 AS cnpjpg
FROM GRA_USER.fq72c315;

CREATE VIEW GRA_USER.kwcte_rodo_veic
AS
SELECT crq72c100 AS cte_rodo_cte_id
	,crq72c153 AS nsequencia
	,crq72c170 AS cint
	,crq72c231 AS renavam
	,crq72c232 AS placa
	,crq72c233 AS tara
	,crq72c234 AS capkg
	,crq72c235 AS capm3
	,crq72c171 AS tpprop
	,crq72c236 AS tpveic
	,crq72c237 AS tprod
	,crq72c238 AS tpcar
	,crq72c120 AS uf
FROM GRA_USER.fq72c316;

CREATE VIEW GRA_USER.kwcte_lacrodo
AS
SELECT crq72c100 AS cte_rodo_cte_id
	,crq72c153 AS nsequencia
	,crq72c217 AS nlacre
FROM GRA_USER.fq72c317;

CREATE VIEW GRA_USER.kwcte_rodo_moto
AS
SELECT crq72c100 AS cte_rodo_cte_id
	,crq72c153 AS nsequencia
	,crq72c157 AS xnome
	,crq72c155 AS cpf
FROM GRA_USER.fq72c318;

CREATE VIEW GRA_USER.kwcte_aereo
AS
SELECT caq72c100 AS cte_id
	,caq72c239 AS nminu
	,caq72c240 AS noca
	,caq72c216 AS dprev
	,caq72c241 AS xlagemi
	,caq72c242 AS ciata
	,caq72c244 AS cl
	,caq72c245 AS ctar
	,caq72c246 AS vtar
	,caq72c322 AS xdime
	,caq72c323 AS cinfmanu
	,caq72c324 AS cimp
FROM GRA_USER.fq72c319;

CREATE VIEW GRA_USER.kwcte_aquav
AS
SELECT chq72c100 AS cte_id
	,chq72c247 AS vprest
	,chq72c248 AS vafrmm
	,chq72c249 AS nbooking
	,chq72c250 AS nctrl
	,chq72c251 AS xnavio
	,chq72c252 AS nviag
	,chq72c253 AS direc
	,chq72c254 AS prtemb
	,chq72c255 AS prttrans
	,chq72c256 AS prtdest
	,chq72c257 AS tpnav
	,chq72c258 AS irin
FROM GRA_USER.fq72c320;

CREATE VIEW GRA_USER.kwcte_aquav_lacre
AS
SELECT chq72c100 AS cte_aquav_cte_id
	,chq72c153 AS nsequencia
	,chq72c217 AS nlacre
FROM GRA_USER.fq72c321;

CREATE VIEW GRA_USER.kwcte_aquav_balsa
AS
SELECT chq72c100 AS cte_aquav_cte_id
	,chq72c153 AS nsequencia
	,chq72c325 AS xbalsa
FROM GRA_USER.fq72c322;

CREATE VIEW GRA_USER.kwcte_ferrov
AS
SELECT cfq72c100 AS cte_id
	,cfq72c259 AS tptraf
	,cfq72c326 AS respfat
	,cfq72c327 AS ferremi
	,cfq72c260 AS fluxo
	,cfq72c261 AS idtrem
	,cfq72c262 AS vfrete
FROM GRA_USER.fq72c323;

CREATE VIEW GRA_USER.kwcte_ferrov_detvags
AS
SELECT cfq72c100 AS cte_ferrov_cte_id
	,cfq72c152 AS ctipo
	,cfq72c153 AS nsequencia
	,cfq72c268 AS nvag
	,cfq72c269 AS cap
	,cfq72c270 AS tpvag
	,cfq72c271 AS pesor
	,cfq72c272 AS pesobc
FROM GRA_USER.fq72c324;

CREATE VIEW GRA_USER.kwcte_ferrov_lacdetvags
AS
SELECT cfq72c100 AS cte_ferrov_detvags_cte_id
	,cfq72c273 AS cte_ferrov_detvags_ctipo
	,cfq72c274 AS cte_ferrov_detvags_nsequencia
	,cfq72c153 AS nsequencia
	,cfq72c217 AS nlacre
FROM GRA_USER.fq72c325;

CREATE VIEW GRA_USER.kwcte_ferrov_contvags
AS
SELECT cfq72c100 AS cte_ferrov_detvags_cte_id
	,cfq72c273 AS cte_ferrov_detvags_ctipo
	,cfq72c274 AS cte_ferrov_detvags_nsequencia
	,cfq72c153 AS nsequencia
	,cfq72c215 AS ncont
	,cfq72c216 AS dprev
FROM GRA_USER.fq72c326;

CREATE VIEW GRA_USER.kwcte_ferrov_ratnfe
AS
SELECT cfq72c100 AS cte_ferrov_detvags_cte_id
	,cfq72c273 AS cte_ferrov_detvags_ctipo
	,cfq72c274 AS cte_ferrov_detvags_nsequencia
	,cfq72c153 AS nsequencia
	,cfq72c348 AS tiporat
	,cfq72c318 AS chave
	,cfq72c204 AS serie
	,cfq72c199 AS ndoc
	,cfq72c328 AS pesorat
FROM GRA_USER.fq72c327;

CREATE VIEW GRA_USER.kwcte_duto
AS
SELECT cdq72c100 AS cte_id
	,cdq72c246 AS vtar
	,cdq72c180 AS dini
	,cdq72c181 AS dfim
FROM GRA_USER.fq72c328;

CREATE VIEW GRA_USER.kwcte_peri
AS
SELECT cpq72c100 AS cte_id
	,cpq72c153 AS nsequencia
	,cpq72c275 AS nonu
	,cpq72c276 AS xnomeae
	,cpq72c277 AS xclarisco
	,cpq72c278 AS gremb
	,cpq72c279 AS qtotprod
	,cpq72c280 AS qvoltipo
	,cpq72c281 AS pontofulgor
FROM GRA_USER.fq72c329;

CREATE VIEW GRA_USER.kwcte_veicnovos
AS
SELECT cvq72c100 AS cte_id
	,cvq72c153 AS nsequencia
	,cvq72c282 AS chassi
	,cvq72c283 AS ccor
	,cvq72c284 AS xcor
	,cvq72c285 AS cmod
	,cvq72c286 AS vunit
	,cvq72c262 AS vfrete
FROM GRA_USER.fq72c330;

CREATE VIEW GRA_USER.kwcte_infctesub
AS
SELECT csq72c100 AS cte_id
	,csq72c318 AS chcte
	,csq72c287 AS refnfe
	,csq72c154 AS cnpj
	,csq72c106 AS mod
	,csq72c204 AS serie
	,csq72c288 AS subserie
	,csq72c162 AS nro
	,csq72c289 AS valor
	,csq72c200 AS demi
	,csq72c117 AS refcte
	,csq72c291 AS refcteanu
FROM GRA_USER.fq72c331;

CREATE VIEW GRA_USER.kwcte_infctecomp
AS
SELECT ccq72c100 AS cte_id
	,ccq72c153 AS nsequencia
	,ccq72c318 AS chave
	,ccq72c132 AS vtprest
	,ccq72c292 AS cst
	,ccq72c135 AS predbc
	,ccq72c205 AS vbc
	,ccq72c137 AS picms
	,ccq72c138 AS vicms
	,ccq72c139 AS vcred
	,ccq72c308 AS vbcstret
	,ccq72c309 AS vicmsstret
	,ccq72c310 AS picmsstret
	,ccq72c311 AS predbcoutrauf
	,ccq72c312 AS vbcoutrauf
	,ccq72c313 AS picmsoutrauf
	,ccq72c314 AS vicmsoutrauf
	,ccq72c315 AS indsn
	,ccq72c140 AS infadfisco
FROM GRA_USER.fq72c332;

CREATE VIEW GRA_USER.kwcte_infctecomp_compcomp
AS
SELECT ciq72c100 AS cte_infctecomp_cte_id
	,ciq72c317 AS cte_infctecomp_nsequencia
	,ciq72c153 AS nsequencia
	,ciq72c157 AS xnome
	,ciq72c211 AS vcomp
FROM GRA_USER.fq72c333;

CREATE VIEW GRA_USER.kwcte_infcteanu
AS
SELECT ciq72c100 AS cte_id
	,ciq72c318 AS chcte
	,ciq72c200 AS demi
FROM GRA_USER.fq72c334;

CREATE VIEW GRA_USER.kwcte_controle
AS
SELECT ccq72c100 AS cte_id
	,ccq72c108 AS nct
	,ccq72c204 AS serie
	,ccq72c154 AS cnpj_emit
	,ccq72c120 AS uf_emit
	,ccq72c119 AS xmun_emit
	,ccq72c329 AS cnpj_dest
	,ccq72c331 AS cpf_dest
	,ccq72c330 AS uf_dest
	,ccq72c332 AS xmun_dest
	,ccq72c200 AS demi
	,ccq72c307 AS hemi
	,ccq72c132 AS vtprest
	,ccq72c319 AS vcarga
	,ccq72c294 AS cstatussefaz
	,ccq72c333 AS xmotivo
	,ccq72c334 AS protocolo
	,ccq72c295 AS dtconsultasefaz
	,ccq72c296 AS hrconsultasefaz
	,ccq72c306 AS arquivo
	,ccq72c335 AS tipocte
	,ccq72c336 AS statuscte
	,ccq72c297 AS cstatuscomercial
	,ccq72c298 AS cstatusfisico
	,ccq72c337 AS comercial
	,ccq72c338 AS filial
	,ccq72c299 AS dtentrada
	,ccq72c300 AS hrentrada
	,ccq72c301 AS userentrada
	,ccq72c303 AS ctipovalidacao
	,ccq72c304 AS cstatuserp
	,ccq72c305 AS dtrecepcao
	,ccq72c339 AS hrcoleta
	,ccq72c340 AS cstatus01
	,ccq72c341 AS cstatus02
	,ccq72c342 AS cstatus03
	,ccq72c343 AS cstatus04
	,ccq72c344 AS audit_usuario
	,ccq72c345 AS audit_programa
	,ccq72c346 AS audit_data
	,ccq72c347 AS audit_hora
FROM GRA_USER.fq72c335;

CREATE VIEW GRA_USER.kwcte_canceladas
AS
SELECT ccq72c100 AS cte_id
	,ccq721022 AS versao
	,ccq720717 AS tpamb
	,ccq721023 AS xserv
	,ccq72c318 AS chcte
	,ccq721024 AS nprot
	,ccq720723 AS xjust
	,ccq721025 AS veraplic
	,ccq720961 AS cstat
	,ccq720833 AS xmotivo
	,ccq720702 AS cuf
	,ccq721026 AS dhrecbto
	,ccuser AS userid
	,ccpid AS pid
	,ccjobn AS jobn
	,ccupmj AS upmj
	,ccupmt AS upmt
	,ccq721027 AS nprotret
	,ccq72c350 AS status01
	,ccq72c351 AS status02
	,ccq72c352 AS status03
	,ccq72c353 AS status04
	,ccq72c354 AS status05
	,ccq720962 AS dtconsefaz
	,ccq720963 AS hrconsefaz
FROM GRA_USER.fq72c336;

CREATE VIEW GRA_USER.kwcte_eventos
AS
SELECT ceq72c318 AS cte_id
	,ceq72c360 AS evcte_versao
	,ceq72c361 AS evcte_corgao
	,ceq72c362 AS evcte_tpamb
	,ceq72c154 AS evcte_cnpj
	,ceq72c100 AS evcte_chcte
	,ceq72c363 AS evcte_dhevento
	,ceq72c364 AS evcte_tpevento
	,ceq72c365 AS evcte_nseqevento
	,ceq72c366 AS evcte_descevento
	,ceq72c367 AS evcte_nprot
	,ceq72c368 AS evcte_xjust
	,ceq72c370 AS retevcte_veraplic
	,ceq72c372 AS retevcte_cstat
	,ceq72c373 AS retevcte_xmotivo
	,ceq72c376 AS retevcte_xevento
	,ceq72c377 AS retevcte_nseqevento
	,ceq72c378 AS retevcte_dhregevento
	,ceq72c379 AS retevcte_nprot
	,ceuser AS userid
	,cepid AS pid
	,cejobn AS jobn
	,ceupmj AS upmj
	,ceupmt AS upmt
	,ceq72c350 AS status01
	,ceq72c351 AS status02
	,ceq72c352 AS status03
	,ceq72c353 AS status04
	,ceq72c354 AS status05
	,ceq72c380 AS dtretsefaz
	,ceq72c381 AS hrretsefaz
FROM GRA_USER.fq72c337;

CREATE VIEW GRA_USER.kwcte_infresptec
AS
SELECT rtq72c100 AS cte_id
	,rtq72c154 AS cnpj
	,rtq720806 AS xcontato
	,rtq720824 AS email
	,rtq72c385 AS idcsrt
	,rtq72c386 AS hashcsrt
FROM GRA_USER.fq72c338;

CREATE VIEW GRA_USER.kwcte_inffretamento
AS
SELECT ifq72c100 AS cte_id
	,ifq72c387 AS tpfretamento
	,ifq72c388 AS dhviagem
FROM GRA_USER.fq72c339;
