package duoc.dao;

import duoc.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EntregaDAO {

    public void registrarEntrega(int idPedido, int idRepartidor) throws SQLException{
        Connection conn = ConexionBD.obtenerConexion();

        try{
            conn.setAutoCommit(false);//quitamos el autocommit para registrar la entrega y cambiar el estado

            String sqlInsertEntrega = "INSERT INTO entregas (id_pedido, id_repartidor, fecha, hora) VALUES (?, ?, CURDATE(), CURTIME())";
            try(PreparedStatement ps = conn.prepareStatement(sqlInsertEntrega)){
                ps.setInt(1,idPedido);
                ps.setInt(2,idRepartidor);
                ps.executeUpdate();
            }

            //actualizar estado pedido
            String sqlEstado = "UPDATE pedidos SET estado = 'EN_REPARTO' WHERE id = ?";
            try(PreparedStatement ps = conn.prepareStatement(sqlEstado)){
                ps.setInt(1, idPedido);
                ps.executeUpdate();
            }
            conn.commit();
        }catch (SQLException e){
            conn.rollback();//si falla, deshacemos
            throw e;
        }finally {
            conn.close();
        }
    }
}
