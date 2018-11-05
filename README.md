# hotel
Sistema para gerenciar hospedes e check in de um hotel

#Criar a database e as tabelas conforme script

CREATE DATABASE hotel
    WITH 
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1;   


CREATE TABLE hospede
(
    codigo_hos SERIAL NOT NULL,
    nome_hos text COLLATE pg_catalog."default" NOT NULL,
    docume_hos text COLLATE pg_catalog."default" NOT NULL,
    telefo_hos text COLLATE pg_catalog."default",
    CONSTRAINT hospede_pkey PRIMARY KEY (codigo_hos)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE hospede
    OWNER to postgres;
    
CREATE TABLE checkin
(
    codigo_che SERIAL NOT NULL,
    datent_che timestamp with time zone,
    datsai_che timestamp with time zone,
    veicul_che integer,
    codhos_che integer NOT NULL,
    valor_che decimal(15,2) NULL,
    CONSTRAINT checkin_pkey PRIMARY KEY (codigo_che),
    CONSTRAINT codhos_che FOREIGN KEY (codhos_che)
        REFERENCES hospede (codigo_hos) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.checkin
    OWNER to postgres;    


# Dentro do caminho (hotel/model/config/) configurar conexão com BD

# Antes de executar o servidor, atualizar o maven (alt+F5 com o projeto selecionado)

# URLS para testar o backend do HOSPEDE

POST

http://localhost:8080/hotel/rest/hospede/add

{
	"nome": "Guilherme",
	"documento": "999",
	"telefone": "7777"
}


GET

- Retorna todos os hospedes

http://localhost:8080/hotel/rest/hospede/all

- Retorna o hospede pertecente ao codigo passado por parametro

http://localhost:8080/hotel/rest/hospede/get/2

- Retorno todos os checkins do hospede passado por parametro

http://localhost:8080/hotel/rest/hospede/checkin/2

- Retorna todos os hospedes que ainda estão no hotel

http://localhost:8080/hotel/rest/hospede/hospedenohotel

- Retorna todos os hospedes que já sairam do hotel

http://localhost:8080/hotel/rest/hospede/hospedecomchekin


DELETE

http://localhost:8080/hotel/rest/hospede/delete/1


PUT

http://localhost:8080/hotel/rest/hospede/edit/2

{
	"nome": "Guilherme",
	"documento": "999",
	"telefone": "7777"
}


# URLS para testar o backend do CHECK IN

POST

http://localhost:8080/hotel/rest/checkin/add

{
	"hospede": {
				"nome": "Guilherme",
				"documento": "999",
				"telefone": "7777"
				},
	"dataSaida": "2018-01-01T11:10:00",
	"isVeiculo": false
}

GET

- Retorna todos os checkins com data de saída
http://localhost:8080/hotel/rest/checkin/todoscomcheckin

- Retorna todos os checkins se a data de saída, ou seja, que ainda estão no hotel
http://localhost:8080/hotel/rest/checkin/todossemsaida

- Retorna o checkin pertecente ao codigo passado por parametro
http://localhost:8080/hotel/rest/checkin/get/1

PUT
http://localhost:8080/hotel/rest/checkin/edit/1

{
	"hospede": {
				"nome": "Guilherme",
				"documento": "999",
				"telefone": "7777"
				},
	"dataSaida": "2018-01-01T11:10:00",
	"isVeiculo": false
}

DELETE
http://localhost:8080/hotel/rest/checkin/delete/1


