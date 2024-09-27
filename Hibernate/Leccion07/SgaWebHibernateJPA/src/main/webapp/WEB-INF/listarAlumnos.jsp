<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Listado de Alumnos</title>
</head>
<body>
Listar Alumnos
<br>
<a href="${pageContext.request.contextPath}/ServletRedireccionar">Agregar</a>
<br>
<table border="1">
    <tr>
        <th>Alumno ID</th>
        <th>Nombre Completo</th>
        <th>Domicilio</th>
        <th>Email</th>
        <th>Telefono</th>
    </tr>
    <c:forEach var="alumno" items="${alumnos}">
        <tr>
            <td><a href="${pageContext.request.contextPath}/ServletModificar?idAlumno=${alumno.idAlumno}">
                    ${alumno.idAlumno}
            </a></td>
            <td>${alumno.nombre} ${alumno.apellido}</td>
            <td>${alumno.domicilio.calle} ${alumno.domicilio.noCalle} ${alumno.domicilio.pais}</td>
            <td>${alumno.contacto.email}</td>
            <td>${alumno.contacto.telefono}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
