package org.iesvdm.tienda.servlet;

import jakarta.servlet.http.HttpServletRequest;
import org.iesvdm.tienda.model.Cliente;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class UtilServlet {

    public static Optional<Cliente> validaEditar(HttpServletRequest request) {

        //CÓDIGO DE VALIDACIÓN
        boolean valida = true;
        int codigoCliente;
        String nombreCliente;
        String nombreContacto;
        String apellidoContacto;
        String telefono;
        String lineaDireccion;
        String ciudad;
        String region;
        String pais;
        String codigoPostal;
        BigDecimal limiteCredito;

        try {
            Objects.requireNonNull(request.getParameter("nombre"));
            if (request.getParameter("nombre").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            nombre = request.getParameter("nombre");

            estatura = Integer.parseInt(request.getParameter("estatura"));

            edad = Integer.parseInt(request.getParameter("edad"));

            Objects.requireNonNull(request.getParameter("localidad"));
            if (request.getParameter("localidad").isBlank()) throw new RuntimeException("Parámetro vacío o todo espacios blancos.");
            localidad = request.getParameter("localidad");

            return Optional.of(new Cliente(-1, nombre, estatura, edad, localidad));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();
    }
}
