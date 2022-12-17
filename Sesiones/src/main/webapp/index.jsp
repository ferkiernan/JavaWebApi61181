<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ansert title hereeee</title>
</head>
<body>

<form action="Validacion" method="post">
	<input type="email" id="correo" name="correo" placeholder="usuario@dominio.com" required="required">
	<br/>
	<input type="password" id="clave" name="clave" placeholder="12345">
	<br/>
	<button type="submit"> Validar </button>
	<button type="reset"> Limpiar datos</button>
	
</form>

</body>
</html>