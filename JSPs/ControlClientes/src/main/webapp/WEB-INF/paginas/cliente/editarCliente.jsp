<!doctype html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Editar Cliente</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<%--Cabecero--%>
<jsp:include page="/WEB-INF/paginas/comunes/cabecero.jsp"/>

<form action="${pageContext.request.contextPath}/ServletControlador?accion=modificar&idCliente=${cliente.idCliente}"
method="post" class="was-validated">
    <%--Botones de Navegación--%>
    <jsp:include page="/WEB-INF/paginas/comunes/botonesNavegacionEdicion.jsp"/>

        <section id="details">
            <div class="container">
                <div class="row">
                    <div class="col">
                        <div class="card">
                            <div class="card-header">
                                <h4>Editar Cliente</h4>
                            </div>
                            <div class="card-body">
                                <div class="form-group">
                                    <label for="nombre" >Nombre</label>
                                    <input type="text" name="nombre" id="nombre" class="form-control" required value="${cliente.nombre}" />
                                </div>
                                <div class="form-group">
                                    <label for="apellido">Apellido</label>
                                    <input type="text" name="apellido" id="apellido" class="form-control" required value="${cliente.apellido}" />
                                </div>
                                <div class="form-group">
                                    <label for="email" >Email</label>
                                    <input type="email" name="email" id="email" class="form-control" required value="${cliente.email}" />
                                </div>
                                <div class="form-group">
                                    <label for="telefono" >Teléfono</label>
                                    <input type="tel" name="telefono" id="telefono" class="form-control" required value="${cliente.telefono}" />
                                </div>
                                <div class="form-group">
                                    <label for="saldo" >Saldo</label>
                                    <input type="number" name="saldo" id="saldo" class="form-control" required value="${cliente.saldo}" step="any"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

</form>


<%--Pie de página--%>
<jsp:include page="/WEB-INF/paginas/comunes/piePagina.jsp"/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://kit.fontawesome.com/3b42358e3b.js" crossorigin="anonymous"></script>
</body>
</html>
