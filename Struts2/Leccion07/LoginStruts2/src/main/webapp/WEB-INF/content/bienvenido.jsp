<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><s:text name="bienvenido.titulo"/></title>
    <s:head/>
</head>
<body>
<h1><s:text name="bienvenido.titulo"/></h1>
<s:actionmessage/>
<s:actionerror/>
<h2><s:text name="bienvenido.mensaje"/>:</h2>
<br>
<s:text name="form.usuario"/>: <s:property value="usuario"/>
<br>
<s:text name="form.password"/>: <s:property value="password"/>
<br>
<a href="<s:url action="login"/> "><s:text name="bienvenido.regresar"/></a>
</body>
</html>