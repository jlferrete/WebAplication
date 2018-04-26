<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="true" import="java.util.*, es.studium.modelo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado de Pedidos</title>
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
	<h1>Pedidos MVC: Listado de pedidos</h1>
	<hr />
	<h2>Este es el listado de los pedidos en la base de datos:</h2>
	<table id="example" class="display">
		<thead>
			<tr>
				<th>idPedido</th>
				<th>fechaEnvioPedido</th>
				<th>fechaPedido</th>
				<th>cantidadPedido</th>
				<th>loginUsuario</th>
				<th>tituloLibro</th>
			</tr>
		</thead>
			<%
				//TODO Muestra los elementos del carrito
				List<Pedido> listaPedidos = (List<Pedido>) session.getAttribute("pedidos");
				for (Pedido pedido : listaPedidos) {
			%>
		
		<tbody>
			<tr>
				<td align="right"><%=pedido.getIdPedido()%></td>
				<td><%=pedido.getFechaEnvioPedido()%></td>
				<td><%=pedido.getFechaPedido()%></td>
				<td><%=pedido.getCantidadPedido()%></td>
				<td><%=pedido.getLoginUsuario()%></td>
				<td><%=pedido.getTituloLibro()%></td>
			</tr>
		</tbody>
		<%
			}
			//session.invalidate();
		%>

	</table>
	<br />
	<hr />
	<h2>Inserte idLibro para marcar como enviado</h2>
	<form name="modificarPed" action="../modificarPedido" method="POST">
		<input type="hidden" id="todo" name="todo" value="modify">
		<div class="form1">
			<label for="idPedido" id="idPedido1">idPedido<br /></label>
		</div>
		<div class="form2">
			<select name="idPedido">
				<%
				for (Pedido pedido : listaPedidos) {
					// Scriplet 1: Carg los libros en el SELECT

						out.println("<option value='" + pedido.getIdPedido() + "'>");
						out.println(pedido.getIdPedido()+ " | " + pedido.getLoginUsuario()
						+ " | " + pedido.getTituloLibro());
						out.println("</option>");
				}
					%>
			</select>
		</div>
		<br /> <input id="submitButton" type="submit"
			value="Modificar pedido">
	</form>
	<br />
	<a class="button" href="../menu.jsp">Volver al menú</a>
	<br/><br/>
	<a class="button" href="../logout">Cerrar la sesión</a>
</body>
</html>