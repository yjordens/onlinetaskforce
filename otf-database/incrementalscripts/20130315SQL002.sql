------------------
-- Yvan Jordens --
------------------

create table GEBRUIKER (
    id                      varchar(50) not null,
    VERSIE                  bigint DEFAULT 0 NOT NULL,
    creatieTijdstip         timestamp without time zone default CURRENT_TIMESTAMP NOT NULL,
    wijzigingsTijdstip      timestamp without time zone,
    creatieGebruiker_id     varchar(50),
    wijzigingsGebruiker_id  varchar(50),
    inszNummer              varchar(11),
    naam                    varchar(250),
    voornaam                varchar(250),
    initialen               varchar(3),
    telefoonnummer          varchar(50),
    email                   varchar(100),
    user_id                 varchar(50) not null,
    wachtwoord              varchar(41) not null,
    actief                  integer DEFAULT 0 CHECK (actief IN(0,1)) NOT NULL,
    constraint PK_GEBRUIKER primary key (id) using index tablespace pg_default,
    constraint FK01_GEBRUIKER foreign key (creatieGebruiker_id) references GEBRUIKER,
    constraint FK02_GEBRUIKER foreign key (wijzigingsGebruiker_id) references GEBRUIKER
);

CREATE UNIQUE INDEX UN01_GEBRUIKER ON GEBRUIKER(user_id);
create index I_FK01_GEBRUIKER on GEBRUIKER(creatieGebruiker_id) tablespace pg_default;
create index I_FK02_GEBRUIKER on GEBRUIKER(wijzigingsGebruiker_id) tablespace pg_default;

create sequence GEBRUIKER_SEQ;

insert into gebruiker(id, naam, voornaam, user_id, wachtwoord, actief) values (nextval('GEBRUIKER_SEQ'),'Jordens','Yvan','jordenyv','4d7547a1d2787c72f0e985d8b5194295e4aa6141',1);

-----------------------------------
-- scriptid                      --
-----------------------------------
insert into dbscript  (scriptnaam) values ('20130315SQL002');