<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP con Scriplets</title>
</head>
<body>
<h1>JSP con Scriplets</h1>
<br>
<%-- Scriplet para enviar información al navegador --%>
<%
    out.print("Saludos desde un Scriplet");
%>
<br>
<%-- Scriplet para manipular los obtejos implicitos --%>
<%
    String nombreAplicacion = request.getContextPath();
    out.println("Nombre de la aplicación: " + nombreAplicacion);
%>
<br>
<%-- Scriplet con código condicionado --%>
<%
    if (session != null && session.isNew()) {
%>
La sesión SI es nueva
<%
} else if (session != null) {
%>
La sesión NO es nueva
<%
    }
%>
<br>
<a href="index.html">Regresar al inicio</a>
</body>
</html>
