<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hola Mundo JSPs</title>
</head>
<body>
<h1>Hola Mundo JSPs</h1>
<ul>
    <li>
        <% out.print("Hola Mundo con Scriplets"); %>
    </li>
    <li>
        ${"Hola mundo con Expression Language (EL)"}
    </li>
    <li>
        <%= "Hola mundo con Expresiones" %>
    </li>
    <li>
        <c:out value="Hola mundo con JSTL" />
    </li>
</ul>
</body>
</html>