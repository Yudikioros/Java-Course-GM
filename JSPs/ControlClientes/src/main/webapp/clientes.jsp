<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Control de Clientes</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<%--Cabecero--%>
<jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

<%--Botones de navegación--%>
<jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacion.jsp"/>

<%--Listado de clientes--%>
<jsp:include page="/WEB-INF/paginas/cliente/listadoClientes.jsp"/>

<%--Pie de página--%>
<jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/3b42358e3b.js" crossorigin="anonymous"></script>
</body>
</html>