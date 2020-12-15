  CREATE TABLE "MV"."CLIENTE" 
   (	"ID" NUMBER NOT NULL, 
	"NOME" VARCHAR2(255) NOT NULL, 
	"EMAIL" VARCHAR2(100) NOT NULL, 
	"TELEFONE" VARCHAR2(100), 
	"CPF_CNPJ" VARCHAR2(100) NOT NULL, 
	 CONSTRAINT "CLIENTE_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" 
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1
  BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;

  CREATE TABLE "MV"."EMPRESA" 
   (	"ID" NUMBER NOT NULL, 
	"NOME" VARCHAR2(100) NOT NULL, 
	"SALDO" NUMBER DEFAULT 000.00 NOT NULL, 
	 CONSTRAINT "EMPRESA_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" 
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;


  CREATE TABLE "MV"."ENDERECO" 
   (	"ID" NUMBER NOT NULL, 
	"RUA" VARCHAR2(100), 
	"NUMERO" VARCHAR2(100), 
	"BAIRRO" VARCHAR2(100), 
	"CIDADE" VARCHAR2(100), 
	"ESTADO" VARCHAR2(100), 
	"PAIS" VARCHAR2(100), 
	"CEP" VARCHAR2(100), 
	"ID_CLIENTE" NUMBER NOT NULL, 
	 CONSTRAINT "ENDERECO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" , 
	 CONSTRAINT "FK_CLIENTE_ENDERECO" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "MV"."CLIENTE" ("ID")
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

  CREATE TABLE "MV"."INSTITUICAO" 
   (	"ID" NUMBER NOT NULL, 
	"NOME" VARCHAR2(100) NOT NULL, 
	 CONSTRAINT "INSTITUICAO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" 
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

  CREATE TABLE "MV"."CONTA" 
   (	"ID" NUMBER NOT NULL, 
	"NUMERO" NUMBER NOT NULL, 
	"SALDO" NUMBER DEFAULT 000.00 NOT NULL, 
	"ID_CLIENTE" NUMBER NOT NULL, 
	"ACTIVE" VARCHAR2(1) DEFAULT 'Y' NOT NULL, 
	"ID_INSTITUICAO" NUMBER NOT NULL, 
	 CONSTRAINT "CONTA_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" , 
	 CONSTRAINT "FK_CLIENTE_CONTA" FOREIGN KEY ("ID_CLIENTE")
	  REFERENCES "MV"."CLIENTE" ("ID"), 
	 CONSTRAINT "FK_INSTITUICAO" FOREIGN KEY ("ID_INSTITUICAO")
	  REFERENCES "MV"."INSTITUICAO" ("ID")
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

  CREATE TABLE "MV"."MOVIMENTACAO" 
   (	"ID" NUMBER NOT NULL, 
	"DATA" DATE NOT NULL, 
	"ID_CONTA" NUMBER NOT NULL, 
	"VALOR" NUMBER NOT NULL, 
	"TIPO" VARCHAR2(100) NOT NULL, 
	 CONSTRAINT "MOVIMENTACAO_PK" PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  TABLESPACE "USERS" , 
	 CONSTRAINT "FK_CONTA_MOVIMENTACAO" FOREIGN KEY ("ID_CONTA")
	  REFERENCES "MV"."CONTA" ("ID")
   ) SEGMENT CREATION DEFERRED 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 
 NOCOMPRESS LOGGING
  TABLESPACE "USERS" ;

CREATE SEQUENCE seq_cliente START WITH 1;

CREATE SEQUENCE seq_conta START WITH 1;

CREATE SEQUENCE seq_empresa START WITH 1;

CREATE SEQUENCE seq_endereco START WITH 1;

CREATE SEQUENCE seq_instituicao START WITH 1;

CREATE SEQUENCE seq_movimentacao START WITH 1;