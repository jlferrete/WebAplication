CREATE DATABASE tiendalibros CHARACTER SET utf8 COLLATE utf8_spanish2_ci;

use tiendalibros;

CREATE TABLE usuarios (
idUsuario INT NOT NULL AUTO_INCREMENT UNIQUE,
nombreUsuario VARCHAR(45) NOT NULL,
apellido1Usuario VARCHAR(45) NOT NULL,
apellido2Usuario VARCHAR(45) NOT NULL,
loginUsuario VARCHAR(45) NOT NULL,
passUsuario VARCHAR(256) NOT NULL,
PRIMARY KEY(idUsuario)
);

CREATE TABLE autores (
idAutor INT NOT NULL AUTO_INCREMENT UNIQUE,
nombreAutor VARCHAR(45) NOT NULL,
apellido1Autor VARCHAR(45) NOT NULL,
apellido2Autor VARCHAR(45) NOT NULL,
PRIMARY KEY(idAutor)
);

CREATE TABLE editoriales (
idEditorial INT NOT NULL AUTO_INCREMENT UNIQUE,
nombreEditorial VARCHAR(90) NOT NULL,
PRIMARY KEY(idEditorial)
);

CREATE TABLE libros (
idLibro INT NOT NULL AUTO_INCREMENT UNIQUE,
tituloLibro VARCHAR(45) NOT NULL,
precioLibro DECIMAL(6,2) NOT NULL,
cantidadLibro INT(4) NOT NULL,
idEditorialFK INT NOT NULL,
idAutorFK INT NOT NULL,
PRIMARY KEY(idLibro),
FOREIGN KEY (idEditorialFK) REFERENCES Editoriales(idEditorial),
FOREIGN KEY (idAutorFK) REFERENCES Autores(idAutor) 
);

CREATE TABLE pedidos (
idPedido INT NOT NULL AUTO_INCREMENT UNIQUE,
fechaEnvioPedido DATE,
fechaPedido DATE NOT NULL,
cantidadPedido INT NOT NULL,
idUsuarioFK INT NOT NULL,
idLibroFK INT NOT NULL,
PRIMARY KEY(idPedido),
FOREIGN KEY (idUsuarioFK) REFERENCES Usuarios(idUsuario),
FOREIGN KEY (idLibroFK) REFERENCES Libros(idLibro) 
);

INSERT INTO usuarios VALUES (DEFAULT,"Juan","Garcia","Ramirez","juangr","fc44dd02fbecac3bfbe64acfcb3a72ffadb039259074d9b55c5060df32ab95e9"),
(DEFAULT,"Maria","Pelaez","Garcia","mariapg","c1697b1de2b5fbe50848c3a21562def569d3f8e824787221fcfbbacb5bc4b845");

INSERT INTO autores VALUES (DEFAULT,"George","R.R.","Martin"),
(DEFAULT,"J","R.R.","Tolkien"),
(DEFAULT,"Arturo","Pérez","Reverte");

INSERT INTO editoriales VALUES (DEFAULT,"Gilgamesh"),
(DEFAULT,"Alianza Editorial"),
(DEFAULT, "Editorial Planeta");

INSERT INTO libros VALUES (DEFAULT,"Juego de Tronos",25.99,10,1,1),
(DEFAULT,"El Señor de los Anillos",22.99,10,2,2),
(DEFAULT,"El Capitán Alatriste",23.99,10,3,3);

INSERT INTO pedidos VALUES (DEFAULT,NULL,"2018/01/26",1,1,1),
(DEFAULT,NULL,"2018/01/28",1,2,3),
(DEFAULT,NULL,"2018/01/29",1,1,2);





 

