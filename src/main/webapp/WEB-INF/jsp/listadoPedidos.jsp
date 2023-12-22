<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Listado de Pedidos</title>
</head>
<body>
<h1>Listado de Pedidos</h1>
<div class="col-md-4 align-self-center" ><form method="get" action="GrabarPedidosServlet">
    <input class="btn btn-primary"  type="submit" value="Crear Pedido">
</form></div>
<%
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda","root", "user");

    Statement s = conexion.createStatement();
    ResultSet listado = s.executeQuery ("SELECT * FROM pedido");

    while (listado.next()) {
        out.println(listado.getInt("codigo_pedido") + " " + listado.getDate("fecha_pedido") + " "+ listado.getDate("fecha_esperada") + " "+ listado.getDate("fecha_entrega") + " "+ listado.getString("estado") + " "+ listado.getString("estado") + " "+ listado.getInt("codigo_cliente"));
%>
<form class="d-inline" method="post" action="BorrarPedidosServlet">
    <input type="hidden" name="codigo" value="<%=listado.getInt("codigo_pedido") %>"/>
    <input class="btn btn-primary"  type="submit" value="Borrar">
</form>
<form class="d-inline" method="get" action="EditarPedidosServlet">
    <input type="hidden" name="codigo" value="<%=listado.getInt("codigo_pedido") %>"/>
    <input class="btn btn-primary"  type="submit" value="Editar">
</form><br>
<%

    }
    listado.close();
    s.close();
    conexion.close();
%>
</body>
</html>