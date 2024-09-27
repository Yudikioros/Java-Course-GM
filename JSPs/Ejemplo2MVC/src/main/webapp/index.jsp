<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Ejemplo MV 2</title>
</head>
<body>
<h1>Ejemplo MV 2</h1>
<br>
<div style="color: red">${mensaje}</div>
<br>
<a href="${pageContext.request.contextPath}/ServletControlador">Link al Servlet controlador SIN parametros</a>
<br><br>
<a href="${pageContext.request.contextPath}/ServletControlador?accion=agregarVariables">
    Link al Servlet controlador para agregar variables
</a>
<br><br>
<a href="${pageContext.request.contextPath}/ServletControlador?accion=listarVariables">
    Link al Servlet controlador para listar variables
</a>
<br><br>


</body>
</html>
