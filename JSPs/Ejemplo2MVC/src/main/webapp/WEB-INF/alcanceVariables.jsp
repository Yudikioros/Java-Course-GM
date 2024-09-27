<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Alcance Variables</title>
</head>
<body>
<h1>Alcance Variables</h1>
<br>
Variable request:
Base: ${recRequest.base}
Altura: ${recRequest.altura}
Area: ${recRequest.area}
<br><br>
Variable sesión:
Base: ${recSession.base}
Altura: ${recSession.altura}
Area: ${recSession.area}
<br><br>
Variable aplicación:
Base: ${recApplication.base}
Altura: ${recApplication.altura}
Area: ${recApplication.area}
<br><br>
<a href="${pageContext.request.contextPath}/index.jsp">Volver a inicio</a>

</body>
</html>