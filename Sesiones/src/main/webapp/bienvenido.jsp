<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.educacionit.entidades.Usuario"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bienvenido page</title>
</head>
<body>
<h1>Bienvenido usuario:</h1>
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	
	out.print(usuario);
	
 	String recargaste =  (String) request.getAttribute("recargaste");
 	if (recargaste != null) {
 		out.print(recargaste);
 	}
 	
	
%>
<br/><br/><br/>
<a href="Validacion?CerrarSesion=true">Cerrar Sesion</a>

</body>
</html>