package org.iesvdm.tienda.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.iesvdm.tienda.dao.ClienteDAO;
import org.iesvdm.tienda.dao.ClienteDAOImpl;
import org.iesvdm.tienda.model.Cliente;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "EditarClientesServlet", value = "/EditarClientesServlet")
public class EditarClientesServlet extends HttpServlet{

    private ClienteDAO clienteDAO = new ClienteDAOImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/formularioEditarCliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = null;

        Optional<Cliente> optionalCliente = UtilServlet.validaEditar(request);

        if (optionalCliente.isPresent()) {
            
            Cliente cliente = optionalCliente.get();
            
            this.clienteDAO.update(cliente);

            List<Cliente> listado = this.clienteDAO.getAll();
            
            request.setAttribute("listado", listado);

            request.setAttribute("newClienteID", cliente.getCodigoCliente() );

            dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        } else {

            request.setAttribute("error", "Error de validación!");


            dispatcher = request.getRequestDispatcher("/WEB-INF/index.jsp");
        }

        dispatcher.forward(request,response);

    }

}
