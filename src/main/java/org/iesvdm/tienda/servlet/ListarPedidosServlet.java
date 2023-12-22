package org.iesvdm.tienda.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.tienda.dao.PedidoDAO;
import org.iesvdm.tienda.dao.PedidoDAOImpl;
import org.iesvdm.tienda.model.Pedido;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ListarPedidosServlet", value = "/ListarPedidosServlet")
public class ListarPedidosServlet extends HttpServlet {

    private PedidoDAO pedidoDAO = new PedidoDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/listadoPedidos.jsp");

        List<Pedido> listado = this.pedidoDAO.getAll();
        request.setAttribute("listado", listado);

        dispatcher.forward(request, response);
    }

}