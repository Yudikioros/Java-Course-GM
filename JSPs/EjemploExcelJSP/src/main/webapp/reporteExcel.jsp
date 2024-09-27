<%@page errorPage="/WEB-INF/manejoErrores.jsp" %>
<%@page import="utilerias.Conversiones, java.util.Date" %>
<%@page contentType="application/vnd.ms-excel" pageEncoding="UTF-8" %>
<%
    String nombreArchivo = "reporte.xls";
    response.setHeader("Content-Disposition", "inline; filename=" + nombreArchivo);
%>

<html>
    <head>
        <title>Reporte de Excel</title>
    </head>
    <body>
        <h1>Reporte Excel</h1>
        <table border="1">
            <tr>
                <th>Curso</th>
                <th>Descripción</th>
                <th>Fecha</th>
            </tr>
            <tr>
                <th>1. Fundamentos de JAVA</th>
                <th>Aprenderemos la sintaxis básica de JAVA</th>
                <th><%=Conversiones.format(new Date())%></th>
            </tr>
            <tr>
                <th>2. Programación con JAVA</th>
                <th>Pondremos en práctica conceptos de la programación orientada a objetos</th>
                <th><%=Conversiones.format(new Date())%></th>
            </tr>
        </table>
    </body>
</html>
