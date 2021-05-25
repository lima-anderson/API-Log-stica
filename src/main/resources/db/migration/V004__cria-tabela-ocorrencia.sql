create table ocorrencia (
	id serial PRIMARY KEY,
    entrega_id bigint not null,
    descricao text not null,
    data_registro timestamp not null,
    
    FOREIGN KEY (entrega_id)
    REFERENCES entrega (id));