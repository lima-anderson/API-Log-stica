create table entrega(
	id serial PRIMARY KEY,
    cliente_id bigint not null,
    taxa decimal(10,2) not null,
    status varchar(20) not null,
    data_pedido timestamp not null,
    data_finalizacao timestamp,
    
    destinatario_nome varchar(60) not null,
    destinatario_logradouro varchar(255) not null,
    destinatario_numero varchar(30) not null,
    destinatario_complemento varchar(60) not null,
    destinatario_bairro varchar(30) not null,
    
    FOREIGN KEY (cliente_id) 
    REFERENCES cliente (id))