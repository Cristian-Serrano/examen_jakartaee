package org.iesvdm.tienda.dao;

import org.iesvdm.tienda.model.Cliente;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteDAOImpl extends AbstractDAOImpl implements ClienteDAO {
    @Override
    public List<Cliente> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Cliente> lista = new ArrayList<>();

        try {
            conn = connectDB();

            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                Cliente cliente = new Cliente();

                cliente.setCodigoCliente(rs.getInt("codigo_cliente"));
                cliente.setNombreCliente(rs.getString("nombre_cliente"));
                cliente.setNombreContacto(rs.getString("nombre_contacto"));
                cliente.setApellidoContacto(rs.getString("apellido_contacto"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setLineaDireccion(rs.getString("linea_direccion"));
                cliente.setCiudad(rs.getString("ciudad"));
                cliente.setRegion(rs.getString("region"));
                cliente.setPais(rs.getString("pais"));
                cliente.setCodigoPostal(rs.getString("codigo_postal"));
                cliente.setLimiteCredito(rs.getBigDecimal("limite_cretito"));

                lista.add(cliente);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return lista;

    }

    @Override
    public void update(Cliente cliente) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = connectDB();

            ps = conn.prepareStatement("UPDATE cliente SET nombre = ?, estatura = ?, edad = ?, localidad = ?  WHERE socioID = ?");
            int idx = 1;
            ps.setString(idx++, cliente.getNombre());
            ps.setInt(idx++, cliente.getEstatura());
            ps.setInt(idx++, cliente.getEdad());
            ps.setString(idx, cliente.getLocalidad());

            ps.setInt(idx++, cliente.getSocioId());

            int rows = ps.executeUpdate();

            if (rows == 0)
                System.out.println("Update de cliente con 0 registros actualizados.");

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, ps, rs);
        }

    }
}
