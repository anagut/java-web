<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva habitación</title>

<link rel="stylesheet" href="./css/style.css"></link>

</head>

<body>
	<h1>Nueva habitación</h1>
	
	<div class="error">${error}</div>
	
	<form action="" method="POST">
	<div>
	<input type="text" placeholder="calle" name="calle" id="calle" value="${newhabitacion.calle}"/>
	</div>
	<div>
	<input type="text" placeholder="numero" name="numero" id="numero" value="${newhabitacion.num}"/>
	</div>
	<div>
	<input type="text" placeholder="ciudad" name="ciudad" id="ciudad" value="${newhabitacion.ciudad}"/>
	</div>
	
	<button>Añadir</button>
	
	</form>
</body>

<script src="./js/script.js"></script>

</html>