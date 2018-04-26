<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*, es.studium.modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Libros</title>
<link rel="stylesheet" type="text/css" href="../css/styleInsert.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.min.css">
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script
	src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('#example').DataTable();
	});
</script>
</head>
<body>
	<h1>Libros MVC: Listado de libros</h1>
	<hr />
	<h2>Este es el listado de los libros en la base de datos:</h2>
	<table id="example" class="display" cellspacing="0">
		<thead>
			<tr>
				<th>idLibro</th>
				<th>tituloLibro</th>
				<th>precioLibro</th>
				<th>cantidadLibro</th>
				<th>nombreEditorial</th>
				<th>NombreAutor</th>
				<th>Apellido1Autor</th>
				<th>Apellido2Autor</th>
			</tr>
		</thead>
		<tbody>

			<%
				//TODO Muestra los elementos del carrito
				List<Libro> listaLibros = (List<Libro>) session.getAttribute("libros");
				for (Libro libro : listaLibros) {
			%>
			<tr>
				<td align="right"><%=libro.getIdLibro()%></td>
				<td><%=libro.getTituloLibro()%></td>
				<td align="right"><%=libro.getPrecioLibro()%></td>
				<td align="right"><%=libro.getCantidadLibro()%></td>
				<td><%=libro.getNombreEditorial()%></td>
				<td><%=libro.getNombreAutor()%></td>
				<td><%=libro.getApellido1Autor()%></td>
				<td><%=libro.getApellido2Autor()%></td>
			</tr>

			<%
				}
				
			%>

		</tbody>
	</table>
	<br />
	<a class="button" href="../menu.jsp">Volver al menú</a>
	<br/><br/>
	<a class="button" href="../logout">Cerrar la sesión</a>
	
</body>
</html>