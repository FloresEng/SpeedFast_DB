package duoc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

    private static final String URL = "jdbc:mysql://localhost:3306/speedfast_db?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "admin";
    private static final String CONTRASENA = "Admin01.";

    public static Connection obtenerConexion() throws SQLException{
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
