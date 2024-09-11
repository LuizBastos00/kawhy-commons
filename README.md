## Container docker com oracle para rodar local

### Criar container (criando automaticamente tabelas e views)

Executar o comando com o terminal aberto na pasta do kawhy-commons

> docker run --name oracle-xe-gra
> -p 1521:1521 
> -d 
> -v ./desenv/init_scripts:/container-entrypoint-initdb.d
> --env ORACLE_PASSWORD=password 
> --env APP_USER=GRA_USER
> --env APP_USER_PASSWORD=password gvenzl/oracle-xe

### Parar o container
> docker stop oracle-xe-gra

### Executar container**
> docker start oracle-xe-gra

### Criar container (sem criar tabelas e views)
> docker run --name oracle-xe-gra -d -p 1521:1521 --env
> ORACLE_PASSWORD=password --env APP_USER=GRA_USER --env
> APP_USER_PASSWORD=password gvenzl/oracle-xe