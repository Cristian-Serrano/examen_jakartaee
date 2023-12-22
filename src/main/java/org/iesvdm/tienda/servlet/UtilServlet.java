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

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //FIN CÓDIGO DE VALIDACIÓN
        return Optional.empty();
    }
}
