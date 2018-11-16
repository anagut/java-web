<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Lista de canciones</h1>
	<ul>

		<c:forEach var="unaCancion" items="${lasCanciones}">
		<li>
		<a href="./cancion?id=${unaCancion.id}">
			<div>(${unaCancion.id})</div>
			<div>${unaCancion.titulo}</div>
			<div>${unaCancion.autor}</div>
		</a>
		</li>
   		</c:forEach>

	</ul>
	${lasCanciones}
</body>
</html>