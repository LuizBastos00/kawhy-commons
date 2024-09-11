-- VERIFICAR REGISTROS QUE TEM RESUMO MAS NÃO CHEGOU A NOTA
select *
from proddta.kwnfe_consultanfes
where demi like '2023-12%'
    and xml = 'N';
    
-- REPROCESSAR EVENTOS DE CIENCIA DA OPERAÇÃO QUE DERAM ERRO
update proddta.kwnfe_consultanfes
where demi like '2023-12%'
    and xml = 'N'
    and status_evento in (3, 4)
    and tpevento = '210210';