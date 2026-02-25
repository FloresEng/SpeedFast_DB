package duoc.util;

import java.sql.SQLException;
import java.util.List;

public interface InterfazCRUD<T> {

    //Crear
    void crear(T objeto) throws SQLException;

    //Leer
    List<T> listar() throws SQLException;

    //Eliminar
    void borrar(int id) throws SQLException;



}
