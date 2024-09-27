<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Agregar Alumno</title>
</head>
<body>
<h1>Agregar Alumno</h1>
<form name="form1" action="${pageContext.request.contextPath}/ServletModificar" method="post">
    <input type="hidden" name="idAlumno" value="${alumno.idAlumno}">
    Nombre: <input type="text" name="nombre" value="${alumno.nombre}">
    Apellido: <input type="text" name="apellido" value="${alumno.apellido}">
    <br>
    <br>
    Datos Domicilio:
    <br>
    Calle: <input type="text" name="calle" value="${alumno.domicilio.calle}">
    No. Calle <input type="text" name="noCalle" value="${alumno.domicilio.noCalle}">
    Pais: <input type="text" name="pais" value="${alumno.domicilio.pais}">
    <br>
    <br>
    Datos de Contacto:
    <br>
    Email: <input type="email" name="email" value="${alumno.contacto.email}">
    Telefono: <input type="tel" name="telefono" value="${alumno.contacto.telefono}">
    <br>
    <input type="submit" value="Modificar" name="modificar">
    <input type="submit" value="Eliminar" name="eliminar">

</form>
</body>
</html>