<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*, es.studium.modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insercion de Libros</title>
<link rel="stylesheet" type="text/css" href=" ../css/styleInsert.css">
</head>
<body>
	<h1>Libros MVC: Modificación de Libros</h1>
	<hr />
	<form name="modificarLib" action="../modificarLibro" method="POST">
		<input type="hidden" id="todo" name="todo" value="modify">
		<div class="form1">
			<label for="idLibro" id="idLibro1">idLibro<br /></label> <label
				for="tituloLibro" id="tituloLibro1">tituloLibro<br /></label> <label
				for="precioLibro" id="precioLibro1">precioLibro<br /></label> <label
				for="cantidadLibro" id="cantidadLibro1">cantidadLibro<br /></label>
			<label for="idEditorialFK" id="idEditorialFK1">idEditorialFK<br /></label>
			<label for="idAutorFK" id="idAutorFK1">idAutorFK<br /></label>
		</div>
		<div class="form2">
			<input name="idLibro" id="idLibro" /><br /> <input
				name="tituloLibro" id="tituloLibro" /><br /> <input
				name="precioLibro" id="precioLibro" /><br /> <input
				name="cantidadLibro" id="cantidadLibro" /><br /> <select
				name="idEditorialFK">
				<%
				Editorial editorial = new Editorial();
				List <Editorial> editoriales = editorial.listarEditorial();
				session.setAttribute("editoriales", editoriales);
				
				List<Editorial> listaEditoriales = (List<Editorial>) session.getAttribute("editoriales");
				for (Editorial editorial1 : listaEditoriales) {
				
					// Scriplet 1: Carg los libros en el SELECT

					out.println("<option value='" + editorial1.getIdEditorial() + "'>");
					out.println(editorial1.getIdEditorial()  + " | " + editorial1.getNombreEditorial());
					out.println("</option>");
				}
				%>
			</select></br> <select name="idAutorFK">
				<%
			//TODO Muestra los elementos del carrito
					Autor autor = new Autor();
					List <Autor> autores = autor.listarAutor();
					session.setAttribute("autores", autores);
					List<Autor> listaAutores = (List<Autor>) session.getAttribute("autores");
			for (Autor autor1 : listaAutores) {
				
				// Scriplet 1: Carg los libros en el SELECT

				out.println("<option value='" + autor1.getIdAutor() + "'>");
				out.println(autor1.getIdAutor()+ " | " + autor1.getNombreAutor()  + " | " + autor1.getApellido1Autor() + " | " + autor1.getApellido2Autor() );
				out.println("</option>");
		
			}
			%>

			</select>
		</div>
<br/> <br /> <input id="submitButton" type="submit"
			value="Realizar modificación">
	</form>
	<br />
	<a class="button" href="../menu.jsp">Pulsa aquí para volver al menú</a>
	<br />
	<br />
	<a class="button" href="../logout">Cerrar la sesión</a>
</body>
</html>