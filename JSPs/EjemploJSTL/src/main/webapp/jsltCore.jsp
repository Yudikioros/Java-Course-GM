<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>JSTL Core</title>
</head>
<body>
<h1>JSTL Core (Jsp Standard Tag Library)</h1>
<%--Manipulación de variables--%>

<%--Se define la varible--%>
<c:set var="nombre" value="Ernesto"/>
<%--Mostramos el valor de la variable--%>
Variable nombre: <c:out value="${nombre}"/>
<br>
<br>
Variable con codigo HTML:
<c:out value="<h4>Hola</h4>" escapeXml="false"/>
<br>
<br>
<%--Código condicionado, uso de if--%>
<c:set var="bandera" value="true"/>

<c:if test="${bandera}">
    La bandera es verdadera
</c:if>
<br>
<%--Código condicionado, uso de switch--%>
<c:if test="${param.opcion != null}">
    <c:choose>
        <c:when test="${param.opcion == 1}">
            <br>
            Opcion 1 seleccionada
        </c:when>
        <c:when test="${param.opcion == 2}">
            <br>
            Opcion 2 seleccionada
        </c:when>
        <c:otherwise>
            <br>
            Opcion proporcionada desconocida: ${param.opcion}
        </c:otherwise>
    </c:choose>
</c:if>
<%--Iteracion de un arreglo--%>
<%
    String[] nombres = {"Claudia", "Pedro", "Juan"};
    request.setAttribute("nombres", nombres);
%>
<br>
<br>
Lista de Nombres:
<br>
<ul>
    <c:forEach var="persona" items="${nombres}">
        <li>${persona}</li>
    </c:forEach>
</ul>
<br>
<br>
<a href="index.jsp">Regresar a inicio</a>

</body>
</html>