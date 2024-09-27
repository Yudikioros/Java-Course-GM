<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP con Expresiones</title>
</head>
<body>
<h1>
    JSP con Expresiones
</h1>
Concatenación: <%= "Saludos" + " " + "JSP" %>
<br>
Operación Matemática: <%= 2 * 3 / 2 %>
<br>
Session id: <%= session.getId() %>
<br>
<br>
<a href="index.html">Regresar al inicio</a>
</body>
</html>