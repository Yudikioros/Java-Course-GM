<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Formulario Personas</title>
    <s:head/>
</head>
<body>
<h1>Formulario Personas</h1>
<s:form>
    <s:textfield label="Nombre" name="persona.nombre"/>
    <s:textfield label="Calle" name="persona.domicilio.calle"/>
    <s:textfield label="No. Calle" name="persona.domicilio.numeroCalle"/>
    <s:textfield label="Pais" name="persona.domicilio.pais"/>
    <s:submit value="Enviar"/>
</s:form>
<h2>Valores proporcionados</h2>
Nombre: <s:property value="persona.nombre"/>
<br>
Calle: <s:property value="persona.domicilio.calle"/>
<br>
No. Calle: <s:property value="persona.domicilio.numeroCalle"/>
<br>
Pais: <s:property value="persona.domicilio.pais"/>

<br>
<s:if test="persona.nombre != null">
    <s:if test="persona.nombre == 'admin'">
        Es un usuario administrador
    </s:if>
    <s:else>
        El usuario NO es administrador
    </s:else>
</s:if>

</body>
</html>
