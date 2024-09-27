<%--Agregamos una declaración de JSP--%>
<%!
    //Declaramos una variable con su método GET
    private String usuario = "José";
    public String getUsuario() {
        return this.usuario;
    }

    //Declaramos un contador de visitas y su método GET
    private int contadorVisitas = 1;
    public int getContadorVisitas() {
        return this.contadorVisitas;
    }
%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Uso de declaraciones con JSPs</title>
</head>
<body>
<h1>Uso de declaraciones con JSPs</h1>
Valor de usuario por medio del atributo: <%=this.usuario%>
<br>
Valor usuario por medio del método: <%=this.getUsuario()%>
<br>
Contador de visitas: <%=this.contadorVisitas++%>
</body>
</html>
