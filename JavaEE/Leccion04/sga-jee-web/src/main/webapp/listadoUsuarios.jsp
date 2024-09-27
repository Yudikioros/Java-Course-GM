<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listado de Usuarios</title>
</head>
<body>
<h1>Listado de Usuarios</h1>
<ul>
    <c:forEach items="${usuarios}" var="usuario">
        <li>${usuario.username} ${usuario.password}</li>
    </c:forEach>
</ul>
</body>
</html>
