package org.iesvdm.tienda.dao;

import org.iesvdm.tienda.model.Pedido;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PedidoDAOImpl extends AbstractDAOImpl implements PedidoDAO {

    @Override
    public List<Pedido> getAll() {

        Connection conn = null;
        Statement s = null;
        ResultSet rs = null;

        List<Pedido> lista = new ArrayList<>();

        try {
            conn = connectDB();

            // Se utiliza un objeto Statement dado que no hay parámetros en la consulta.
            s = conn.createStatement();

            rs = s.executeQuery("SELECT * FROM pedido");
            while (rs.next()) {
                Pedido pedido = new Pedido();

                pedido.setCodigoPedido(rs.getInt("id"));
                pedido.setFechaPedido(rs.getDate("fecha del pedido"));
                pedido.setFechaEsperada(rs.getDate("fecha esperada"));
                pedido.setFechaEntrega(rs.getDate("fecha de entrega"));
                pedido.setEstado(rs.getString("estado"));
                pedido.setComentarios(rs.getString("comentarios"));
                pedido.setCodigoCliente(rs.getInt("codigo de cliente"));
                lista.add(pedido);
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeDb(conn, s, rs);
        }
        return lista;

    }

}
