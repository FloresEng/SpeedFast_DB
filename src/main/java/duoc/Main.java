package duoc;

import duoc.conexion.ConexionBD;
import duoc.vista.VistaLogin;

import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

    public static void main (String[] args){

        EventQueue.invokeLater(()->{
            new VistaLogin().setVisible(true);
        });
    }
}
