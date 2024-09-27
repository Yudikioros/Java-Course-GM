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
<form name="form1" action="${pageContext.request.contextPath}/ServletAgregar" method="post">
  Nombre: <input type="text" name="nombre">
  Apellido: <input type="text" name="apellido">
  <br>
  <br>
  Datos Domicilio:
  <br>
  Calle: <input type="text" name="calle">
  No. Calle <input type="text" name="noCalle">
  Pais: <input type="text" name="pais">
  <br>
  <br>
  Datos de Contacto:
  <br>
  Email: <input type="email" name="email">
  Telefono: <input type="tel" name="telefono">
  <br>
  <input type="submit" value="Agregar" name="agregar">
</form>
</body>
</html>