<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>EL y variables implicitas</title>
</head>
<body>
<h1>EL y variables implicitas</h1>
<ul>
    <li>Nombre de la aplicacion: ${pageContext.request.contextPath}</li>
    <li>Navegador del cliente: ${header["User-Agent"]}</li>
    <li>ID de la sesion: ${cookie.JSESSIONID.value}</li>
    <li>Web Server: ${pageContext.servletContext.serverInfo}</li>
    <li>Valor parametro: ${param.usuario}</li>
<%--    <li>Valor parametro: #{param["usuario"]}</li>--%>
    <br>
    <br>
    <a href="index.jsp">Volver a inicio</a>
</ul>
</body>
</html>