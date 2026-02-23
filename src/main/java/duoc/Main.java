package duoc;

import duoc.conexion.ConexionBD;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main (String[] args){

        try(Connection conn = ConexionBD.obtenerConexion()){
            System.out.println("Conexión exitosa a BD");
        }catch (SQLException e){
            System.err.println("Error al conectarse a BD");
        }
    }
}
