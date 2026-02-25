package duoc.dao;

import duoc.conexion.ConexionBD;
import duoc.modelo.Cliente;
import duoc.util.InterfazActualizar;
import duoc.util.InterfazCRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements InterfazCRUD<Cliente>, InterfazActualizar<String> {

    public void crear(Cliente c) throws SQLException{

        String sqlInsert = "INSERT INTO clientes (nombre, telefono) VALUES (?, ?)";
        try(Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sqlInsert)){
            stmt.setString(1, c.getNombre());
            stmt.setString(2, c.getTelefono());

            stmt.executeUpdate();
        }
    }

    public List<Cliente> listar() throws SQLException{
        List<Cliente> lista = new ArrayList<>();
        String sqlSelect = "SELECT * FROM clientes";

        try(Connection conn = ConexionBD.obtenerConexion();
            ResultSet rs = conn.createStatement().executeQuery(sqlSelect)){
            while(rs.next()){
                lista.add(new Cliente(rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("telefono")));
            }
        }
        return lista;
    }

    public void borrar(int id) throws SQLException{

        String sqlDelete = "DELETE FROM clientes WHERE id = ?";
        try(Connection conn = ConexionBD.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement(sqlDelete)){
            stmt.setInt(1, id);

            stmt.executeUpdate();
        }
    }

    public void actualizar(int id, String telefono, Connection conn) throws SQLException{

        String sqlUpdate = "UPDATE clientes SET telefono = ? WHERE id = ?";
        try(PreparedStatement stmt = conn.prepareStatement(sqlUpdate)){
            stmt.setInt(1,id);
            stmt.setString(2,telefono);

            stmt.executeUpdate();
        }
    }

}
