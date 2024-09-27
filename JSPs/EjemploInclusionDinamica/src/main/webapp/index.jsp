<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ejemplo inclusión dinámica</title>
</head>
<body>
<h1>Ejemplo inclusión dinámica</h1>
<jsp:include page="paginas/recursoPublico.jsp"/>
<jsp:include page="WEB-INF/recursoPrivado.jsp">
    <jsp:param name="colorFondo" value="yellow"/>
</jsp:include>
</body>
</html>