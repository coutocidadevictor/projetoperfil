CREATE DATABASE Perfil_V2;

USE Perfil_V2;

CREATE table servicos(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64),
	valor VARCHAR(16)
);

CREATE TABLE colaboradores(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64),
	telefone VARCHAR(16)
);

CREATE TABLE clientes(
	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(64),
	telefone VARCHAR(16)
);

CREATE TABLE atendimentos (
    id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idClientes BIGINT NOT NULL,
    idServico BIGINT NOT NULL,
    idColaboradores BIGINT NOT NULL,
    dataAtendimento VARCHAR(16) NOT NULL,
    FOREIGN KEY (idClientes) REFERENCES clientes(id),
    FOREIGN KEY (idServico) REFERENCES servicos(id),
    FOREIGN KEY (idColaboradores) REFERENCES colaboradores(id)
);