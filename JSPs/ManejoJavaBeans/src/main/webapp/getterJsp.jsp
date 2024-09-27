<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Jsp que obtiene los valores del JavaBean</title>
</head>
<body>
<h1>Jsp que modifica JavaBean</h1>
<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session"/>
<%--<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="request"/>--%>
<br>
Valor base: <jsp:getProperty name="rectangulo" property="base"/>
<br>
Valor altura: <jsp:getProperty name="rectangulo" property="altura"/>
<br>
<%--Llamada a propiedad que no esta mapeada--%>
Area del rectangulo: <jsp:getProperty name="rectangulo" property="area"/>
<br>
<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
