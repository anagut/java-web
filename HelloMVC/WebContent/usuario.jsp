<%@page import="com.ana.models.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
<%-- <%
Usuario elUsuario = (Usuario)request.getAttribute("elUsuario");
%> --%>

   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Datos de usuario</h1>
	<ul>
	<li>Id: ${requestScope.elUsuario.id} </li>
	<li>Nombre: ${requestScope.elUsuario.name} </li>
	<li>Email: ${requestScope.elUsuario.email}</li>
	</ul>
<!-- 	<ul> -->
<%-- 	<li>Id: <%=elUsuario.id %> </li>
	<li>Nombre: <%=elUsuario.name %> </li>
	<li>Email: <%=elUsuario.email %> </li --%>
<!-- 	</ul> -->
</body>
</html>