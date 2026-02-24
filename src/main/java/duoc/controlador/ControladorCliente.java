package duoc.controlador;

import duoc.dao.ClienteDAO;
import duoc.modelo.Cliente;

import java.util.List;

public class ControladorCliente {

    private ClienteDAO clienDao = new ClienteDAO();

    public String registrar(String nombre, String telefono){
        if (nombre.trim().isEmpty() || telefono.trim().isEmpty())
            return "Ambos campos son obligatorios para el registro.";
        try{
            clienDao.registrarCliente(new Cliente(nombre, telefono));
            return "Cliente registrado con éxito.";
        }catch (Exception e){
            return "¡ERROR!: " + e.getMessage();
        }
    }

    public List<Cliente> obtenerTodos(){
        try {
            return clienDao.listar();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public String eliminarCliente (int id){
        if (id <= 0)
            return "Debe especificar ID del cliente a borrar.";
        try{
            clienDao.borrarCliente(id);
            return "Cliente borrado con éxito de la base de datos.";
        }catch (Exception e){
            return "¡ERROR! "+ e.getMessage();
        }
    }
}
