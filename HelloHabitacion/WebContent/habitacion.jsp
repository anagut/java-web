<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos de la habitación</h1>
	<ul>
	<li>Id: ${requestScope.laCasa.hid} </li>
	<li>Calle: ${resquestScope.laCasa.calle} </li>
	<li>Número: ${requestScope.laCasa.num}</li>
	<li>Ciudad: ${requestScope.laCasa.ciudad} </li>
	<li><a href="./usuario">Casa de pepe</a></li>
	</ul>
</body>
</html>