<%@taglib prefix="s" uri="/struts-tags" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title><s:text name="form.titulo"/></title>
    <s:head/>
</head>
<body>
<h1><s:text name="form.titulo"/> </h1>
<s:form>
    <s:textfield key="form.nombre" name="persona.nombre"/>
    <s:textfield key="form.calle" name="persona.domicilio.calle"/>
    <s:textfield key="form.no.calle" name="persona.domicilio.numeroCalle"/>
    <s:textfield key="form.pais" name="persona.domicilio.pais"/>
    <s:submit key="form.enviar"/>
</s:form>
<h2><s:text name="form.resultado"/></h2>
<s:text name="form.nombre"/> <s:property value="persona.nombre"/>
<br>
<s:text name="form.calle"/> <s:property value="persona.domicilio.calle"/>
<br>
<s:text name="form.no.calle"/> <s:property value="persona.domicilio.numeroCalle"/>
<br>
<s:text name="form.pais"/> <s:property value="persona.domicilio.pais"/>

<s:url var="localeES" action="personas" >
    <s:param name="request_locale">es</s:param>
</s:url>

<s:url var="localeEN" action="personas" >
    <s:param name="request_locale">en</s:param>
</s:url>

<s:a href="%{localeES}"><s:text name="form.idioma.spanish"/></s:a>
<s:a href="%{localeEN}"><s:text name="form.idioma.ingles"/></s:a>

</body>
</html>
