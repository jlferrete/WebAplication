SELECT nombreAutor,apellido1Autor,apellido2Autor from Autores JOIN Libros ON Libros.idAutorFK = Autores.idAutor WHERE Libros.idLibro= 1;

SELECT idLibro,tituloLibro,precioLibro,cantidadLibro,nombreEditorial,nombreAutor,apellido1Autor,apellido2Autor from Libros INNER JOIN Autores ON Libros.idAutorFK = Autores.idAutor INNER JOIN Editoriales ON Libros.idEditorialFK = Editoriales.idEditorial;

SELECT idPedido,fechaEnvioPedido,fechaPedido,cantidadPedido,loginUsuario,tituloLibro from Pedidos INNER JOIN Usuarios ON Pedidos.idUsuarioFK = usuarios.idUsuario INNER JOIN Libros ON Pedidos.idLibroFK = Libros.idLibro;