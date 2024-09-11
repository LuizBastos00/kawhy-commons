ALTER SESSION SET CONTAINER=XEPDB1;

CREATE VIEW GRA_USER.kwnfe
AS
SELECT nfq720652 AS id
	,nfq720702 AS cuf
	,nfq720703 AS cnf
	,nfq720704 AS natop
	,nfq720705 AS indpag
	,nfq720706 AS mmod
	,nfq720707 AS serie
	,nfq720708 AS nnf
	,nfq720709 AS demi
	,nfq720710 AS dsaient
	,nfq720711 AS hsaient
	,nfq720712 AS tpnf
	,nfq720713 AS cmunfg
	,nfq720714 AS tpimp
	,nfq720715 AS tpemis
	,nfq720716 AS cdv
	,nfq720717 AS tpamb
	,nfq720718 AS finnfe
	,nfq720719 AS procemi
	,nfq720720 AS verproc
	,nfq720721 AS dhcont
	,nfq720723 AS xjust
	,nfq720724 AS icms_vbc
	,nfq720725 AS vicms
	,nfq720726 AS vbcst
	,nfq720727 AS vst
	,nfq720728 AS vprod
	,nfq720729 AS vfrete
	,nfq720730 AS vseg
	,nfq720731 AS vdesc
	,nfq720732 AS vii
	,nfq720733 AS vipi
	,nfq720734 AS prod_vpis
	,nfq720735 AS prod_vcofins
	,nfq720736 AS prod_voutro
	,nfq720737 AS vnf
	,nfq720738 AS vserv
	,nfq720739 AS serv_vbc
	,nfq720740 AS iss_viss
	,nfq720741 AS serv_vpis
	,nfq720742 AS serv_vcofins
	,nfq720743 AS vretpis
	,nfq720744 AS vretcofins
	,nfq720745 AS vretcsll
	,nfq720746 AS vbcirrf
	,nfq720747 AS virrf
	,nfq720748 AS vbcretprev
	,nfq720749 AS vretprev
	,nfq720750 AS modfrete
	,nfq720751 AS rettransp_vserv
	,nfq720752 AS rettransp_vbcret
	,nfq720753 AS rettransp_picmsret
	,nfq720754 AS rettransp_vicmsret
	,nfq720755 AS rettransp_cfop
	,nfq720756 AS rettransp_cmunfg
	,nfq720757 AS placa
	,nfq720758 AS placa_uf
	,nfq720759 AS rntc
	,nfq720760 AS fat_nfat
	,nfq720761 AS fat_vorig
	,nfq720762 AS fat_vdesc
	,nfq720763 AS fat_vliq
	,nfq720764 AS infadfisco
	,nfq720765 AS infcpl
	,nfq720766 AS ufembarq
	,nfq720767 AS xlocembarq
	,nfq720768 AS xnemp
	,nfq720769 AS xped
	,nfq720770 AS xcont
	,nfq721201 AS dhemi
	,nfq721202 AS dhsaient
	,nfq721203 AS iddest
	,nfq721204 AS indfinal
	,nfq721205 AS indpres
	,nfq721240 AS vicmsdeson
	,nfq721241 AS dcompet
	,nfq721242 AS vdeducao
	,nfq721243 AS voutro
	,nfq721244 AS vdescincond
	,nfq721245 AS vdesccond
	,nfq721246 AS vissret
	,nfq721247 AS cregtrib
	,nfq721310 AS vfcpufdest
	,nfq721311 AS vicmsufdest
	,nfq721312 AS vicmsufremet
	,nfq722411 AS vfcp
	,nfq722414 AS vfcpst
	,nfq722417 AS vfcpstret
	,nfq722421 AS vipidevol
	,nfq722445 AS xnemp_n
FROM GRA_USER.fq72300;

CREATE VIEW GRA_USER.kwnfe_itens
AS
SELECT niq720652 AS nfe_id
	,niq720653 AS nitem
	,niq720654 AS cprod
	,niq720655 AS cean
	,niq720656 AS xprod
	,niq720657 AS ncm
	,niq720658 AS extipi
	,niq720671 AS genero
	,niq720660 AS cfop
	,niq720661 AS ucom
	,niq720662 AS qcom
	,niq720663 AS vuncom
	,niq720728 AS vprod
	,niq720665 AS ceantrib
	,niq720666 AS utrib
	,niq720667 AS qtrib
	,niq720668 AS vuntrib
	,niq720729 AS vfrete
	,niq720730 AS vseg
	,niq720731 AS vdesc
	,niq720672 AS voutro
	,niq720673 AS indtot
	,niq720769 AS xped
	,niq720675 AS nitemped
	,niq720676 AS orig
	,niq720677 AS icm_cst
	,niq720678 AS icm_modbc
	,niq720679 AS icm_predbc
	,niq720680 AS icm_vbc
	,niq720681 AS icm_picms
	,niq720682 AS icm_vicms
	,niq720683 AS icm_modbcst
	,niq720674 AS icm_pmvast
	,niq720684 AS icm_predbcst
	,niq720685 AS icm_vbcst
	,niq720686 AS icm_picmsst
	,niq720687 AS icm_vicmsst
	,niq720688 AS icm_motdesicms
	,niq720689 AS icm_vbcstret
	,niq720690 AS icm_vicmsstret
	,niq720691 AS icm_pbcop
	,niq720692 AS icm_ufst
	,niq720693 AS icm_vbcstdest
	,niq720694 AS icm_vicmsstdest
	,niq720695 AS icm_csosn
	,niq720696 AS icm_pcredsn
	,niq720697 AS icm_vcredicmssn
	,niq720698 AS ipi_clenq
	,niq720699 AS ipi_cnpjprod
	,niq720700 AS ipi_cselo
	,niq720771 AS ipi_qselo
	,niq720772 AS ipi_cenq
	,niq720773 AS ipi_cst
	,niq720774 AS ipi_vbc
	,niq720775 AS ipi_qunid
	,niq720776 AS ipi_vunid
	,niq720777 AS ipi_pipi
	,niq720778 AS ipi_vipi
	,niq720779 AS ii_vbc
	,niq720780 AS ii_vdespadu
	,niq720781 AS ii_vii
	,niq720782 AS ii_viof
	,niq720783 AS pis_cst
	,niq720784 AS pis_vbc
	,niq720785 AS pis_ppis
	,niq720786 AS pis_qbcprod
	,niq720787 AS pis_valiqprod
	,niq720788 AS pis_vpis
	,niq720789 AS cofins_cst
	,niq720790 AS cofins_vbc
	,niq720791 AS cofins_pcofins
	,niq720792 AS cofins_qbcprod
	,niq720793 AS cofins_valiqprod
	,niq720794 AS cofins_vcofins
	,niq720795 AS iss_vbc
	,niq720796 AS iss_valiq
	,niq720797 AS iss_vissqn
	,niq720798 AS iss_cmunfg
	,niq720799 AS iss_clistserv
	,niq720800 AS iss_csittrib
	,niq721001 AS qtd_fisica
	,niq721002 AS qtd_avariada
	,niq721003 AS cod_motivo
	,niq721004 AS des_motivo
	,niq720801 AS infadprod
	,niq721005 AS user_contagem
	,niq721006 AS data_contagem
	,niq721269 AS nfci
	,niq721222 AS vtottrib
	,niq721223 AS vicmsdeson
	,niq721224 AS vicmsop
	,niq721225 AS pdif
	,niq721226 AS vicmsdif
	,niq721227 AS vdeducao
	,niq721228 AS voutro_ret
	,niq721229 AS vdescincond
	,niq721230 AS vdesccond
	,niq721231 AS vissret
	,niq721232 AS indiss
	,niq721233 AS cservico
	,niq721234 AS cmun
	,niq721235 AS cpais
	,niq721236 AS nprocesso
	,niq721237 AS indincentivo
	,niq721238 AS pdevol
	,niq721239 AS vipidevol
	,niq721268 AS nve
	,niq721270 AS nve2
	,niq721271 AS nve3
	,niq721272 AS nve4
	,niq721273 AS nve5
	,niq721274 AS nve6
	,niq721275 AS nve7
	,niq721276 AS nve8
	,niq721221 AS nrecopi
	,niq721304 AS cest
	,niq721305 AS vbcufdest
	,niq721306 AS pfcpufdest
	,niq721307 AS picmsufdest
	,niq721308 AS picmsinter
	,niq721309 AS picmsinterpart
	,niq721310 AS vfcpufdest
	,niq721311 AS vicmsufdest
	,niq721312 AS vicmsufremet
	,niq722410 AS pfcp
	,niq722411 AS vfcp
	,niq722412 AS vbcfcpst
	,niq722413 AS pfcpst
	,niq722414 AS vfcpst
	,niq722415 AS vbcfcp
	,niq722416 AS pfcpstret
	,niq722417 AS vfcpstret
	,niq722418 AS pst
	,niq722419 AS vbcfcpstret
	,niq722420 AS vbcfcpufdest
	,niq722429 AS indescala
	,niq722430 AS cnpjfab
	,niq722431 AS cbenef
	,niq722435 AS predbcefet
	,niq722436 AS vbcefet
	,niq722437 AS picmsefet
	,niq722438 AS vicmsefet
	,niq722439 AS vicmssubstituto
FROM GRA_USER.fq72301;

CREATE VIEW GRA_USER.kwnfe_enderecos
AS
SELECT neq720652 AS nfe_id
	,neq720803 AS ctipo
	,neq720804 AS cnpj
	,neq720805 AS cpf
	,neq720806 AS xnome
	,neq720807 AS xfant
	,neq720808 AS xlgr
	,neq720809 AS nro
	,neq720810 AS xcpl
	,neq720811 AS xbairro
	,neq720812 AS cmun
	,neq720813 AS xmun
	,neq720814 AS uf
	,neq720815 AS cep
	,neq720816 AS cpais
	,neq720817 AS xpais
	,neq720818 AS xender
	,neq720819 AS ie
	,neq720820 AS isuf
	,neq720821 AS iest
	,neq720822 AS im
	,neq720823 AS fone
	,neq720824 AS email
	,neq720825 AS cnae
	,neq720826 AS crt
	,neq721206 AS idestrangeiro
	,neq721207 AS indledest
FROM GRA_USER.fq72302;

CREATE VIEW GRA_USER.kwnfe_referenciadas
AS
SELECT nrq720652 AS nfe_id
	,nrq720849 AS nsequencia
	,nrq720850 AS refnfe
	,nrq720851 AS cuf
	,nrq720852 AS aamm
	,nrq720853 AS cnpj
	,nrq720805 AS cpf
	,nrq720855 AS mod
	,nrq720707 AS serie
	,nrq720857 AS nnf
	,nrq720858 AS ie
	,nrq720859 AS refcte
	,nrq720860 AS necf
	,nrq720861 AS ncoo
FROM GRA_USER.fq72303;

CREATE VIEW GRA_USER.kwnfe_avulsa
AS
SELECT naq720652 AS nfe_id
	,naq720828 AS cnpj
	,naq720829 AS xorgao
	,naq720830 AS matr
	,naq720831 AS xagente
	,naq720832 AS fone
	,naq720814 AS uf
	,naq720834 AS ndar
	,naq720709 AS demi
	,naq720836 AS vdar
	,naq720837 AS repemi
	,naq720838 AS dpag
FROM GRA_USER.fq72304;

CREATE VIEW GRA_USER.kwnfe_volumes
AS
SELECT nvq720652 AS nfe_id
	,nvq720849 AS nsequencia
	,nvq720864 AS qvol
	,nvq720865 AS esp
	,nvq720866 AS marca
	,nvq720867 AS nvol
	,nvq720868 AS pesol
	,nvq720869 AS pesob
FROM GRA_USER.fq72305;

CREATE VIEW GRA_USER.kwnfe_dados_reboque
AS
SELECT ndq720652 AS nfe_id
	,ndq720757 AS placa
	,ndq720758 AS placa_uf
	,ndq720849 AS nsequencia
	,ndq720759 AS rntc
	,ndq720846 AS vagao
	,ndq720847 AS balsa
FROM GRA_USER.fq72306;

CREATE VIEW GRA_USER.kwnfe_lacres
AS
SELECT nlq720652 AS nfe_volumes_nfe_id
	,nlq720871 AS nseq_lacre
	,nlq720872 AS nfe_volumes_nsequencia
	,nlq720873 AS nlacre
FROM GRA_USER.fq72307;

CREATE VIEW GRA_USER.kwnfe_faturas
AS
SELECT nuq720652 AS nfe_id
	,nuq720849 AS nsequencia
	,nuq720876 AS ndup
	,nuq720877 AS dvenc
	,nuq720878 AS vdup
FROM GRA_USER.fq72308;

CREATE VIEW GRA_USER.kwnfe_observacao
AS
SELECT noq720652 AS nfe_id
	,noq720880 AS ctipoobservacao
	,noq720849 AS nsequencia
	,noq720882 AS xcampo
	,noq720883 AS xtexto
FROM GRA_USER.fq72309;

CREATE VIEW GRA_USER.kwnfe_processos
AS
SELECT npq720652 AS nfe_id
	,npq720849 AS nsequencia
	,npq720886 AS nproc
	,npq720887 AS indproc
FROM GRA_USER.fq72310;

CREATE VIEW GRA_USER.kwnfe_di_adicoes
AS
SELECT ncq720652 AS nfe_itens_di_nfe_itens_nfe_id
	,ncq720889 AS nfe_itens_di_nfe_itens_nitem
	,ncq720850 AS nfe_itens_di_nsequencia
	,ncq720900 AS nseqadic
	,ncq720901 AS nadicao
	,ncq720902 AS cfabricante
	,ncq720903 AS vdescdi
	,ncq721213 AS ndraw
FROM GRA_USER.fq72311;

CREATE VIEW GRA_USER.kwnfe_itens_di
AS
SELECT nbq720652 AS nfe_itens_nfe_id
	,nbq720889 AS nfe_itens_nitem
	,nbq720849 AS nsequencia
	,nbq720891 AS ndi
	,nbq720892 AS ddi
	,nbq720893 AS xlocdesemb
	,nbq720894 AS ufdesemb
	,nbq720895 AS ddesemb
	,nbq720896 AS cexportador
	,nbq721208 AS tpviatransp
	,nbq721209 AS vafrmm
	,nbq721210 AS tpintermedio
	,nbq721211 AS cnpj
	,nbq721212 AS ufterceiro
FROM GRA_USER.fq72312;

CREATE VIEW GRA_USER.kwnfe_itens_veiculos
AS
SELECT ngq720652 AS nfe_itens_nfe_id
	,ngq720653 AS nfe_itens_nitem
	,ngq720906 AS tpop
	,ngq720907 AS chassi
	,ngq720908 AS ccor
	,ngq720909 AS xcor
	,ngq720910 AS pot
	,ngq720911 AS cm3
	,ngq720912 AS cilin
	,ngq720913 AS pesol
	,ngq720914 AS pesob
	,ngq720915 AS nserie
	,ngq720916 AS tpcomb
	,ngq720917 AS nmotor
	,ngq720918 AS cmkg
	,ngq720919 AS cmt
	,ngq720920 AS dist
	,ngq720921 AS renavam
	,ngq720922 AS anomod
	,ngq720923 AS anofab
	,ngq720924 AS tppint
	,ngq720925 AS tpveic
	,ngq720926 AS espveic
	,ngq720927 AS vin
	,ngq720928 AS condveic
	,ngq720929 AS cmod
	,ngq720930 AS ccordenatran
	,ngq720931 AS lota
	,ngq720932 AS tprest
FROM GRA_USER.fq72313;

CREATE VIEW GRA_USER.kwnfe_itens_inf_lotes
AS
SELECT nhq720652 AS nfe_itens_nfe_id
	,nhq720653 AS nfe_itens_nitem
	,nhq720849 AS nsequencia
	,nhq720935 AS nlote
	,nhq720879 AS qlote
	,nhq720835 AS dfab
	,nhq720936 AS dval
	,nhq720937 AS vpmc
	,nhq722404 AS cprodanvisa
	,nhq722440 AS xmotivoisencao
FROM GRA_USER.fq72314;

CREATE VIEW GRA_USER.kwnfe_itens_inf_armas
AS
SELECT njq720652 AS nfe_itens_nfe_id
	,njq720653 AS nfe_itens_nitem
	,njq720849 AS nsequencia
	,njq720940 AS tparma
	,njq720941 AS nserie
	,njq720942 AS ncano
	,njq720943 AS descr
	,njq721218 AS nserie_n
	,njq721219 AS ncano_n
FROM GRA_USER.fq72315;

CREATE VIEW GRA_USER.kwnfe_itens_combustiveis
AS
SELECT nkq720652 AS nfe_itens_nfe_id
	,nkq720653 AS nfe_itens_nitem
	,nkq720946 AS cprodanp
	,nkq720947 AS codif
	,nkq720948 AS qtemp
	,nkq720949 AS ufcons
	,nkq720950 AS qbcprod
	,nkq720951 AS valiqprod
	,nkq720952 AS vcide
	,nkq720953 AS vbcicms
	,nkq720954 AS vbcicmsst
	,nkq720955 AS vicmsst
	,nkq720956 AS vbcicmsstdest
	,nkq720957 AS vicmsstdest
	,nkq720958 AS vbcicmsstcons
	,nkq720959 AS vicmsstcons
	,nkq721220 AS pmixgn
	,nkq722405 AS descanp
	,nkq722406 AS pglp
	,nkq722407 AS pgnn
	,nkq722408 AS pgni
	,nkq722409 AS vpart
	,nkq722424 AS nbico
	,nkq722425 AS nbomba
	,nkq722426 AS ntanque
	,nkq722427 AS venclni
	,nkq722428 AS vencfin
FROM GRA_USER.fq72316;

CREATE VIEW GRA_USER.kwnfe_controle
AS
SELECT nqq720652 AS nfe_id
	,nqq720841 AS protocolo
	,nqq720708 AS nnf
	,nqq720707 AS serie
	,nqq720804 AS cnpj_emit
	,nqq720814 AS uf_emit
	,nqq720812 AS xmun_emit
	,nqq720842 AS cnpj_dest
	,nqq720854 AS cpf_dest
	,nqq720856 AS uf_dest
	,nqq720813 AS xmun_dest
	,nqq720709 AS demi
	,nqq720961 AS cstatussefaz
	,nqq720833 AS xmotivo
	,nqq720962 AS dtconsultasefaz
	,nqq720963 AS hrconsultasefaz
	,nqq720973 AS arquivo
	,nqq720972 AS dtrecepcao
	,nqq720966 AS dtentrada
	,nqq720967 AS hrentrada
	,nqq720968 AS userentrada
	,nqq720862 AS ctipovalidacao
	,nqq720980 AS cstatus01
	,nqq720981 AS userchgstatus01
	,nqq720982 AS datechgstatus01
	,nqq720983 AS cstatus02
	,nqq720984 AS userchgstatus02
	,nqq720985 AS datechgstatus02
	,nqq720986 AS cstatus03
	,nqq720987 AS userchgstatus03
	,nqq720988 AS datechgstatus03
	,nqq720989 AS cstatus04
	,nqq720990 AS userchgstatus04
	,nqq720991 AS datechgstatus04
	,nqq720992 AS cstatus05
	,nqq720993 AS userchgstatus05
	,nqq720994 AS datechgstatus05
	,nqq720863 AS audit_usuario
	,nqq720870 AS audit_programa
	,nqq720881 AS audit_data
	,nqq720874 AS audit_hora
	,nqq721100 AS dtcoleta
	,nqq721101 AS cstatus06
	,nqq721102 AS userchgstatus06
	,nqq721103 AS cnpj_transport
	,nqq721104 AS datechgstatus06
	,nqq721105 AS cstatus07
	,nqq721106 AS userchgstatus07
	,nqq721107 AS datechgstatus07
	,nqq721108 AS cstatus08
	,nqq721109 AS userchgstatus08
	,nqq721110 AS datechgstatus08
	,nqq721111 AS cstatus09
	,nqq721112 AS userchgstatus09
	,nqq721113 AS datechgstatus09
	,nqq721114 AS cstatus10
	,nqq721115 AS userchgstatus10
	,nqq721116 AS datechgstatus10
	,nqq721117 AS cstatus11
	,nqq721118 AS userchgstatus11
	,nqq721119 AS datechgstatus11
	,nqq721120 AS cstatus12
	,nqq721121 AS userchgstatus12
	,nqq721122 AS datechgstatus12
	,nqq721123 AS cstatus13
	,nqq721124 AS userchgstatus13
	,nqq721125 AS datechgstatus13
	,nqq721126 AS cstatus14
	,nqq721127 AS userchgstatus14
	,nqq721128 AS datechgstatus14
	,nqq721129 AS cstatus15
	,nqq721130 AS userchgstatus15
	,nqq721131 AS datechgstatus15
	,nqq721132 AS cstatus16
	,nqq721133 AS userchgstatus16
	,nqq721134 AS datechgstatus16
	,nqq721135 AS cstatus17
	,nqq721136 AS userchgstatus17
	,nqq721137 AS datechgstatus17
	,nqq72138 AS cstatus18
	,nqq72139 AS userchgstatus18
	,nqq72140 AS datechgstatus18
	,nqq72141 AS cstatus19
	,nqq72142 AS userchgstatus19
	,nqq72143 AS datechgstatus19
	,nqq72144 AS cstatus20
	,nqq72145 AS userchgstatus20
	,nqq72146 AS datechgstatus20
	,nqq72147 AS dateuser01
	,nqq72148 AS dateuser02
	,nqq72149 AS dateuser03
	,nqq72150 AS dateuser04
	,nqq72151 AS dateuser05
	,nqq721138 AS strguser01
	,nqq721139 AS strguser02
	,nqq72152 AS strguser03
	,nqq72153 AS strguser04
	,nqq72154 AS strguser05
	,nqq72155 AS numbuser01
	,nqq72156 AS numbuser02
	,nqq72157 AS numbuser03
	,nqq72158 AS numbuser04
	,nqq72159 AS numbuser05
	,nqq72160 AS tiponfe
	,nqq721003 AS cod_motivo
	,nqq72161 AS coment_motivo
	,nqq72162 AS statusnfe
	,nqq72163 AS autorinfe
	,nqq72164 AS qtysum
	,nqq72165 AS vlrnf
	,nqq72166 AS umedida
	,nqq72167 AS comercial
	,nqq72168 AS filial
	,nqq72169 AS dtentrprevista
	,nqq72170 AS hrentrprevista
	,nqq72171 AS codigoerp
	,nqq721173 AS canc_prot
	,nqq721174 AS canc_id
	,nqq721175 AS canc_motivo
	,nqq721176 AS canc_data
	,nqq721177 AS canc_hora
FROM GRA_USER.fq72317;

CREATE VIEW GRA_USER.kwnfe_canceladas
AS
SELECT ncq720652 AS nfe_id
	,ncq721022 AS versao
	,ncq720717 AS tpamb
	,ncq721023 AS xserv
	,ncq720075 AS chnfe
	,ncq721024 AS nprot
	,ncq720723 AS xjust
	,ncq721025 AS veraplic
	,ncq720961 AS cstat
	,ncq720833 AS xmotivo
	,ncq720702 AS cuf
	,ncq721026 AS dhrecbto
	,ncq721027 AS nprotret
	,ncuser AS userid
	,ncpid AS pid
	,ncjobn AS jobn
	,ncupmj AS upmj
	,ncupmt AS upmt
	,ncq720980 AS status01
	,ncq720983 AS status02
	,ncq720986 AS status03
	,ncq720989 AS status04
	,ncq720992 AS status05
	,ncq720962 AS dtconsefaz
	,ncq720963 AS hrconsefaz
FROM GRA_USER.fq72318;

CREATE VIEW GRA_USER.kwnfe_xml
AS
SELECT nxq720652 AS nfe_id
	,nxq720897 AS xml_tipo
	,nxq720653 AS xml_seq
	,nxq720839 AS xml_nfe
	,nxuser AS xml_user
	,nxq72172 AS xml_date
	,nxtime AS xml_time
	,nxq72173 AS xml_jobn
FROM GRA_USER.fq72319;

CREATE VIEW GRA_USER.kwfun_infconfig
AS
SELECT dsq720853 AS cnpj_remetente
	,dsq727009 AS tipo
	,dsq727008 AS informacao
	,dsq72470 AS procurar_por
	,dsq72471 AS recuperar_por
	,dsq72472 AS parar_quando
FROM GRA_USER.fq72484;

CREATE VIEW GRA_USER.kwfun_cadastros
AS
SELECT abq720804 AS cnpj_cpf
	,abq720806 AS nome
	,abq720807 AS nome_fantasia
	,abq720808 AS logradouro
	,abq720809 AS numero
	,abq720811 AS bairro
	,abq720713 AS codio_municipio
	,abq720813 AS nome_municipio
	,abq720814 AS estado
	,abq720817 AS pais
	,abaddz AS cep
	,abq720819 AS inscr_estadual
	,abq720820 AS inscr_suframa
	,abq720821 AS inscr_subst
	,abq720822 AS inscr_municipal
	,abq720823 AS fone
	,abq720824 AS email
	,abq720825 AS cnae
	,abarap AS flag_emitente
	,abbvia AS flag_transp
	,abq720961 AS cstat
	,abq720833 AS xmotivo
	,abg70xcg1 AS csit
	,abg70xcg2 AS indcrednfe
	,abg70xcg3 AS indcredcte
	,abq720962 AS data_consulta
	,abgigt AS hora_consulta
FROM GRA_USER.fq72330;

CREATE VIEW GRA_USER.kwfun_cfops
AS
SELECT cfbrnop AS codigo
	,cfq720704 AS descricao
	,cfq721180 AS detalhe_cfop
	,cfq721181 AS ind_gera_pagto
	,cfq721182 AS ind_cfop_imune_cofins
	,cfq721183 AS ind_cfop_imune_pis
	,cfq721184 AS ind_cfop_isento_cofins
	,cfq721185 AS ind_cfop_isento_pis
	,cfq721186 AS ind_cfop_suspensao_cofins
	,cfq721187 AS ind_cfop_suspensao_pis
	,cfq721188 AS ind_incidencia_cofins
	,cfq721189 AS ind_incidencia_pis
	,cfq721190 AS tipo_oper
FROM GRA_USER.fq72331;

CREATE VIEW GRA_USER.kwnfe_infcpl
AS
SELECT nfq720652 AS nfe_id
	,nfq720653 AS nitm
	,nfq721200 AS infcpl
FROM GRA_USER.fq72300a;

CREATE VIEW GRA_USER.kwnfe_autxml
AS
SELECT n3q720652 AS nfe_id
	,n3q720849 AS nsequencia
	,n3q720804 AS cnpj
	,n3q720805 AS cpf
FROM GRA_USER.fq72322;

CREATE VIEW GRA_USER.kwnfe_exportacao
AS
SELECT n3q720652 AS nfe_id
	,n3q720653 AS sequencia_xml
	,n3q720849 AS nsequencia
	,n3q721213 AS ndraw
	,n3q721215 AS nre
	,n3q721216 AS chnfe
	,n3q721217 AS qexport
FROM GRA_USER.fq72323;

CREATE VIEW GRA_USER.kwnfe_pag
AS
SELECT n3q720652 AS nfe_id
	,n3q720849 AS nsequencia
	,n3q721248 AS tpag
	,n3q721249 AS vpag
	,n3q721250 AS cnpj
	,n3q721251 AS tband
	,n3q721252 AS caut
	,n3q722423 AS vtroco
	,n3q722422 AS tpintegra
	,n3q720705 AS indpag
FROM GRA_USER.fq72325;

CREATE VIEW GRA_USER.kwnfe_infcomexterior
AS
SELECT n3q720652 AS nfe_id
	,n3q720849 AS nsequencia
	,n3q721253 AS ufsaidapais
	,n3q721254 AS xlocexporta
	,n3q721255 AS xlocdespacho
FROM GRA_USER.fq72326;

CREATE VIEW GRA_USER.kwnfe_cana
AS
SELECT n3q720652 AS nfe_id
	,n3q720849 AS nsequencia
	,n3q721256 AS sagra
	,n3q721257 AS ref
	,n3q721260 AS qtotmes
	,n3q721261 AS qtotant
	,n3q721262 AS qtotger
	,n3q721265 AS vfor
	,n3q721266 AS vtotded
	,n3q721267 AS vliqfor
FROM GRA_USER.fq72327;

CREATE VIEW GRA_USER.kwnfe_cana_forndiario
AS
SELECT n3q720652 AS nfe_id
	,n3q720849 AS nsequencia
	,n3q721258 AS dia
	,n3q721259 AS qtde
FROM GRA_USER.fq72328;

CREATE VIEW GRA_USER.kwnfe_cana_deducao
AS
SELECT n3q720652 AS nfe_id
	,n3q720849 AS nsequencia
	,n3q721263 AS xded
	,n3q721264 AS vded
FROM GRA_USER.fq72329;

CREATE VIEW GRA_USER.kwnfe_rastro
AS
SELECT nsq720652 AS nfe_id
	,nsq720653 AS nitem
	,nsq720849 AS nsequencia
	,nsq722400 AS nlote
	,nsq722401 AS qlote
	,nsq722402 AS dfab
	,nsq722403 AS dval
	,nsq722433 AS cagreg
FROM GRA_USER.fq72334;

CREATE VIEW GRA_USER.kwnfe_infsuplementos
AS
SELECT nfq720652 AS nfe_id
	,nfq722434 AS qrcode
	,nfq722432 AS urlchave
FROM GRA_USER.fq72335;

CREATE VIEW GRA_USER.kwnfe_infresptec
AS
SELECT nfq72c100 AS nfe_id
	,nfq72c154 AS cnpj
	,nfq720806 AS xcontato
	,nfq720824 AS email
	,nfq720823 AS fone
	,nfq72c385 AS idcsrt
	,nfq72c386 AS hashcsrt
FROM GRA_USER.fq72336;

CREATE VIEW GRA_USER.controle_receb
AS
SELECT nfbcgf AS cnpjemit
	,nfq720708 AS nota
	,nfq720707 AS serie
	,nfq720075 AS chave
	,nfissu AS demit
	,nfbcgt AS cnpjdest
	,nfan8 AS addressnumber
	,nfq72s01 AS statussefaz
	,nfq72s05 AS statusxml
	,nfq72s06 AS statusfiscal
	,nfq72s08 AS statusreceb
	,nfq72s10 AS statusportaria
	,nfq72s03 AS statusaux3
	,nfq72s04 AS statusaux4
	,nfq72s07 AS statusaux7
	,nfq72s09 AS statusaux9
	,nfev01 AS ev01
	,nfuser AS userid
	,nfpid AS pid
	,nfjobn AS jobn
	,nfupmj AS upmj
	,nfupmt AS upmt
	,nfq721033 AS dataxml
	,nfq721034 AS horaxml
	,nfq721030 AS dataportaria
	,nfq721031 AS horaportaria
	,nfaddj AS dataintegracao
	,nfq721032 AS horaintegracao
	,nfq721035 AS datadivergencia
	,nfq721036 AS horadivergencia
	,nfq721037 AS datafisico
	,nfq721038 AS horafisico
	,nfq721039 AS dataxmlcancel
	,nfq721040 AS horaxmlcancel
	,nfdoco AS dataconstriang
	,nfn001 AS horaconstriang
FROM GRA_USER.fq72400;

CREATE VIEW GRA_USER.kwnfe_consultanfes
AS
SELECT mdq720652 AS chnfe
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
	,mdq72s05 AS XML
	,mdq720842 AS cnpjfilial
	,mdq720707 AS serie
	,mdq720708 AS nnf
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

