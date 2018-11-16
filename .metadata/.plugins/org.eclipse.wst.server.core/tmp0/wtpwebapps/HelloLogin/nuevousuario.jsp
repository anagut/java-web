<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Usuario</title>
<link rel="stylesheet" href="./css/style.css"></link>

</head>
<body>
	<h1>Nuevo Usuario</h1>
	<div class="error">${error}</div>
	<form action="" method="POST">
	<div>
	<input type="text" placeholder="Nombre" name="nombre" id="nombre" value="${newusuario.name}" required/>
	</div>
	<div>
	<input type="email" placeholder="email" name="email" id="email" value="${newusuario.email}"/>
	</div>
	<div>
	<input type="password" placeholder="password" name="password" id="password" required/>
	</div>
	<div>
	<input type="password" placeholder="confirmación de password" name="passwordconf" id="passwordconf" required/>
	</div>
		<div>
		<label for="habitacion">Habitación:</label>
		<select name="habitacion" id="habitacion">
<!-- 		Aquí irán las habitaciones -->
			<option selected disabled>Elegir habitación</option>
		<c:forEach var="unaHabitacion" items="${lasHabitaciones}">  
			<option value="${unaHabitacion.hid}">${unaHabitacion.calle}, ${unaHabitacion.num} (${unaHabitacion.ciudad})</option>
   		</c:forEach>
		</select>
	</div>
	
	<div><button>Aceptar</button></div>
	</form>
	
	
</body>
</html>