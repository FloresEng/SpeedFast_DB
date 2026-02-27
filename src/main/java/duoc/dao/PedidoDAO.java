package duoc.dao;

import duoc.conexion.ConexionBD;
import duoc.modelo.Pedido;
import duoc.util.EstadoPedido;
import duoc.util.InterfazActualizar;
import duoc.util.InterfazCRUD;
import duoc.util.TipoPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PedidoDAO implements InterfazCRUD<Pedido>, InterfazActualizar<EstadoPedido> {

    @Override
    public void crear(Pedido p) throws SQLException{

        String sqlInsert = "INSERT INTO pedidos (direccion, tipo, estado) VALUES (?, ?, ?)";
        try(Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert)){
            stmt.setString(1, p.getDireccion());
            stmt.setString(2, p.getTipo().name());//.name para pasar de ENUM a String
            stmt.setString(3, p.getEstado().name());//.name para pasar de ENUM a String

            stmt.executeUpdate();

        }
    }

    @Override
    public List<Pedido> listar() throws SQLException{
        List<Pedido> lista = new ArrayList<>();
        String sqlSelect = "SELECT * FROM pedidos";

        try(Connection conn = ConexionBD.obtenerConexion();
            ResultSet rs = conn.createStatement().executeQuery(sqlSelect)){
            while(rs.next()){
                lista.add(new Pedido(rs.getInt("id"),
                        rs.getString("direccion"),
                        TipoPedido.valueOf(rs.getString("tipo")),
                        EstadoPedido.valueOf(rs.getString("estado"))
                ));
            }
        }
        return lista;
    }

    @Override
    public void borrar(int id) throws SQLException{

        String sqlDelete = "DELETE FROM pedidos WHERE id = ?";
        try(Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sqlDelete)){
            stmt.setInt(1,id);

            stmt.executeUpdate();
        }
    }

    @Override
    public void actualizar(int id, EstadoPedido nuevoEstado, Connection conn) throws SQLException{

        String sqlUpdate = "UPDATE pedidos SET estado = ? WHERE id = ?";
        try(PreparedStatement ps = conn.prepareStatement(sqlUpdate)){
            ps.setString(1, nuevoEstado.name());
            ps.setInt(2, id);
            ps.executeUpdate();
        }
    }
}
