<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*, es.studium.modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//ES"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Editoriales</title>
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
	<h1>Editoriales MVC: Listado de editoriales</h1>
	<hr />
	<h2>Este es el listado de las editoriales en la base de datos:</h2>
	<table id="example" class="display" cellspacing="0">
		<thead>
			<tr>
				<th>idEditorial</th>
				<th>NombreEditorial</th>
			</tr>
		</thead>
		<tbody>

			<%
				List<Editorial> listaEditoriales = (List<Editorial>) session.getAttribute("editoriales");
				for (Editorial editorial : listaEditoriales) {
			%>
			<tr>
				<td align="right"><%=editorial.getIdEditorial()%></td>
				<td><%=editorial.getNombreEditorial()%></td>
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