<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String fondo = request.getParameter("colorFondo");
    if(fondo==null || fondo.trim().equals("")){
        fondo = "white";
    }
%>
<html>
<head>
    <title>JSP cambio de color</title>
</head>
<body bgcolor="<%=fondo%>" >
<h1>JSP cambioo de color</h1>
<br>
Color de fondo aplicado: <%=fondo%>
<br>
<a href="index.html">Regresar al inicio</a>
</body>
</html>
