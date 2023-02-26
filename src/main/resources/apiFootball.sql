DROP DATABASE IF EXISTS apifutbol;
CREATE DATABASE IF NOT EXISTS apifutbol;
USE apifutbol;

DROP TABLE IF EXISTS jugadores; 
CREATE TABLE IF NOT EXISTS jugadores(
id INT AUTO_INCREMENT,
nombre VARCHAR(200) NOT NULL,
edad INT NOT NULL,
nacionalidad VARCHAR(100) NOT NULL,
urlfoto VARCHAR(200),
equipo INT NOT NULL,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS equipos; 
CREATE TABLE IF NOT EXISTS equipos(
id INT AUTO_INCREMENT,
nombre VARCHAR(200) NOT NULL,
pais VARCHAR(200) NOT NULL,
urlfoto VARCHAR(200) NOT NULL,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS estadios; 
CREATE TABLE IF NOT EXISTS estadios(
id INT AUTO_INCREMENT,
nombre VARCHAR(200) NOT NULL,
ciudad VARCHAR(200) NOT NULL,
capacidad INT NOT NULL,
urlfoto VARCHAR(200),
equipo INT NOT NULL,
PRIMARY KEY(id)
);

DROP TABLE IF EXISTS entrenadores; 
CREATE TABLE IF NOT EXISTS entrenadores(
id INT AUTO_INCREMENT,
nombre VARCHAR(200) NOT NULL,
edad INT NOT NULL,
nacionalidad VARCHAR(100) NOT NULL,
urlfoto VARCHAR(200),
equipo INT NOT NULL,
PRIMARY KEY(id)
);


create table users(
	username varchar(50) not null primary key,
	password varchar(250) not null,
	enabled boolean not null
);

create table authorities (
	username varchar(50) not null,
	authority varchar(50) not null,
	constraint fk_authorities_users foreign key(username) references users(username)
);
create unique index ix_auth_username on authorities (username,authority);