create table cliente (
	id serial PRIMARY KEY,
    nome varchar(60) not null,
    email varchar(255) not null,
    telefone varchar(20) not null);