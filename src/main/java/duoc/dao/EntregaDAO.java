package duoc.dao;

import duoc.conexion.ConexionBD;
import duoc.util.EstadoPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {

    public void registrarEntrega(int idPedido, int idRepartidor) throws SQLException{
        Connection conn = ConexionBD.obtenerConexion();
        PedidoDAO pediDao = new PedidoDAO();

        try{
            conn.setAutoCommit(false);//quitamos el autocommit para registrar la entrega y cambiar el estado

            String sqlInsertEntrega = "INSERT INTO entregas (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, CURDATE(), CURTIME())";
            try(PreparedStatement ps = conn.prepareStatement(sqlInsertEntrega)){
                ps.setInt(1,idPedido);
                ps.setInt(2,idRepartidor);
                ps.executeUpdate();
            }

            //actualizar estado pedido
            pediDao.actualizar(idPedido, EstadoPedido.EN_REPARTO, conn);

            conn.commit();
        }catch (SQLException e){
            conn.rollback();//si falla, deshacemos
            throw e;
        }finally {
            conn.close();
        }
    }

    public void finalizarEntrega(int idPedido) throws SQLException{
        Connection conn = ConexionBD.obtenerConexion();
        PedidoDAO pediDao = new PedidoDAO();

        try {
            conn.setAutoCommit(false);
            pediDao.actualizar(idPedido, EstadoPedido.ENTREGADO, conn);

            conn.commit();
        }catch (SQLException e){
            conn.rollback();
            throw e;
        }finally {
            conn.close();
        }
    }
}
