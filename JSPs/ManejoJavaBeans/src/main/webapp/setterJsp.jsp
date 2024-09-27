<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Jsp que modifica JavaBean</title>
</head>
<body>
<h1>Jsp que modifica JavaBean</h1>
<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="session" />
<%--<jsp:useBean id="rectangulo" class="beans.Rectangulo" scope="request" />--%>
Modificamos los atributos
<br>
<br>
<%
    int baseValor = 5;
    int alturaValor = 10;
%>
<jsp:setProperty name="rectangulo" property="base" value="<%=baseValor%>"/>
<jsp:setProperty name="rectangulo" property="altura" value="<%=alturaValor%>"/>
Nuevo valor de base: <%=baseValor%>
<br>
Nuevo valor de altura: <%=alturaValor%>
<br>
<br>
<a href="index.jsp">Volver al inicio</a>
</body>
</html>
