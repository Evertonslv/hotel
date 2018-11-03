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
