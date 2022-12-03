create database if not exists JavaWebApi61181;
use JavaWebApi61181;

create table if not exists usuarios(
	correo varchar(100) not null primary key,
	clave blob, 
	fechaCreacion date not null,
	fechaModificacion datetime not null
);
