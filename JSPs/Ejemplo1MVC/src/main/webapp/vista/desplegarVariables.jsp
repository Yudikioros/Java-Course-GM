<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Despliegue de variables</title>
</head>
<body>
<h1>Despliegue de variables</h1>
Variable en request scope: ${mensaje}
<br>
<br>
Variable en session scope
<br>
Rectangulo:
<br>
Base: ${rectangulo.base}
<br>
Altura: ${rectangulo.altura}
<br>
Area: ${rectangulo.area}
<br>
<br>
<a href="${pageContext.request.contextPath}/index.jsp">Volver al inicio</a>
</html>