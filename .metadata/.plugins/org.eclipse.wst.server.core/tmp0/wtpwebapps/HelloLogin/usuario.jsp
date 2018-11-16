<%@page import="com.ana.models.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>

	<jsp:include page="./header.jsp"></jsp:include>

	<h1>Datos de usuario</h1>
	<ul>
	<li>Id: ${requestScope.elUsuario.id } </li>
	<li>Nombre: ${requestScope.elUsuario.name} </li>
	<li>Email: ${requestScope.elUsuario.email}</li>
	<li>Habitación: <a href="./habitacion?hid=${elUsuario.habitacion.hid}">${elUsuario.habitacion.hid}</a></li>
	</ul>
	
	<button id="volverBtn">Volver</button>

</body>

<script src="./js/script.js"></script>

</html>