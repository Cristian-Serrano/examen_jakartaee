<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
  <h1>Redirigiendo. Por favor, espere...<h1>
  <%
    response.sendRedirect("ListarPedidosServlet");
  %>
</body>
</html>