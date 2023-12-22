<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body class="bg-light">
<div class="container bg-white">
    <div class="row border-bottom">
        <div class="col-12 h2">Introduzca los datos que quieres editar del cliente</div>
    </div>
</div>
<div class="container bg-light">
    <form method="post" action="EditarClientesServlet">
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Nombre</div>
            <div class="col-md-6 align-self-center"><input type="text" name="nombre_cliente"/></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Nombre de contacto</div>
            <div class="col-md-6 align-self-center"><input type="text" name="nombre_contacto"/></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Apellido de contacto</div>
            <div class="col-md-6 align-self-center"><input type="text" name="apellido_contacto"/></div>
        </div>
        <div class="row body mt-2">
            <div class="col-md-6 align-self-center">Telefono</div>
            <div class="col-md-6 align-self-center"><input type="text" name="telefono"/></div>
        </div>
        <div class="row mt-2">
            <div class="col-md-6">
                &nbsp;
            </div>
            <div class="col-md-6 align-self-center">
                <input class="btn btn-primary" type="submit" value="Aceptar">
            </div>
        </div>
    </form>
    <%
        String error = (String) request.getAttribute("error");
        if (error != null) {
    %>
    <div class="row mt-2">
        <div class="col-6">
            <div class="alert alert-danger alert-dismissible fade show">
                <strong>Error!</strong> <%=error%>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        </div>
    </div>
    <%
        }
    %>
</div>
</body>
</html>