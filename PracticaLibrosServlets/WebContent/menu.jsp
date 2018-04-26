<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bienvenido al Menu</title>
<link rel='stylesheet' type='text/css' href='./css/styleMenu.css'>
<link rel="stylesheet" type="text/css"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="./js/jquery-latest.js"></script>
<script type="text/javascript" src='./js/menu.js'></script>
</head>
<body>
	<div class="container">
		<div id="navMenu" class="diamond">
			<div id="mainRotCorrect" class="rotCorrect">
				<i class="fa fa-cubes fa-4x" aria-hidden="true"
					title="Pulsa para abrir menú"></i>
			</div>
		</div>
		<div id="nav1" class="nav nav1 diamond">
			<div class="rotCorrect">
				<a href="/PracticaLibrosServlets/muestraLibro"><i class="fa fa-book fa-2x" aria-hidden="true" title="Pulsa para consultar los libros"></i></a>
			</div>
		</div>
		<div id="nav2" class="nav nav2 diamond">
			<div class="rotCorrect">
				<a href="vistas/insertLibro.jsp"><i class="fa fa-file-text-o fa-2x" aria-hidden="true" title="Pulsa para insertar un nuevo libro"></i>
			</div>
		</div>
		<div id="nav3" class="nav nav3 diamond">
			<div class="rotCorrect">
				<a href="vistas/modificarLibro.jsp"><i class="fa fa-edit fa-2x" aria-hidden="true" title="Pulsa para modificar un libro existente"></i>
			</div>
		</div>
		<div id="nav5" class="nav nav5 diamond">
			<div class="rotCorrect">
				<a href="/PracticaLibrosServlets/muestraEditorial"><i class="fa fa-cogs fa-2x" aria-hidden="true"title="Pulsa para consultar las editoriales"></i></a>
			</div>
		</div>
		
		<div id="nav7" class="nav nav7 diamond">
			<div class="rotCorrect">
				<a href="/PracticaLibrosServlets/muestraAutor"><i class="fa fa-paint-brush fa-2x" aria-hidden="true" title="Pulsa para consultar los autores"></i></a>
			</div>
		</div>
		<div id="nav8" class="nav nav8 diamond">
			<div class="rotCorrect">
				<a href="/PracticaLibrosServlets/muestraPedido"><i class="fa fa-truck fa-2x" aria-hidden="true"title="Pulsa para consultar los pedidos"></i></a>
			</div>
		</div>
	</div>
	<div id="user"><i class="fa fa-user-circle-o fa-1x" aria-hidden="true"></i> <%=(String)session.getAttribute("usuario")%></div>
	
</body>
</html>