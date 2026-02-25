package duoc.util;

import java.sql.Connection;
import java.sql.SQLException;

public interface InterfazActualizar<T> {

    //Actualizar
    void actualizar(int id, T objeto, Connection conn) throws SQLException;
}
