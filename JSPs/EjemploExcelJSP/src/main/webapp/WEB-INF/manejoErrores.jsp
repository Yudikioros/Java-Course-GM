<%@ page isErrorPage="true" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.io.*" %>
<html>
<head>
    <title>Manejo de Errores</title>
</head>
<body>
<h1>Manejo de Errores</h1>
<br>
Ocurrió una excepción: <%=exception.getMessage()%>
<br>
<textarea cols="30" rows="5">
    <%
        exception.printStackTrace(new PrintWriter(out));
    %>
</textarea>
</body>
</html>
