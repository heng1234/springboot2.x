CREATE TABLE  "T_USER"

(    "ID" NUMBER(20,0) NOT NULL ENABLE,

    "USERNAME" VARCHAR2(50),

    "PASSWORD" VARCHAR2(50),

    "CREATE_TIME" DATE

) SEGMENT CREATION IMMEDIATE

PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING

STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645

PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)

TABLESPACE "SYSTEM";



INSERT INTO "BOOT"."user"("ID", "USERNAME", "PASSWORD", "CREATE_TIME") VALUES ('1', 'loren', '123456', TO_DATE('2019-10-22 09:38:29', 'SYYYY-MM-DD HH24:MI:SS'));

INSERT INTO "BOOT"."user"("ID", "USERNAME", "PASSWORD", "CREATE_TIME") VALUES ('2', 'hlvy', '123456', TO_DATE('2019-10-22 09:38:48', 'SYYYY-MM-DD HH24:MI:SS'));