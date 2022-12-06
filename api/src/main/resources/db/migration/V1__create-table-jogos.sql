CREATE TABLE jogos (
    id bigint not null auto_increment,
    titulo varchar(100) not null,
    ano varchar(10) not null,
    plataforma varchar(100) not null,
    faixa_etaria char(2) not null,
    quantidade tinyint not null,

    primary key(id)
);