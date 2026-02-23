package duoc.controlador;

import duoc.dao.PedidoDAO;
import duoc.modelo.Pedido;
import duoc.util.TipoPedido;

import java.util.List;

public class ControladorPedido {

    private PedidoDAO pediDao = new PedidoDAO();

    public String registrar(String direccion, TipoPedido tipo){
        if(direccion.trim().isEmpty())
            return "La dirección es obligatoria.";
        try{
            pediDao.crear(new Pedido(direccion, tipo));
            return "Pedido creado con éxito";
        }catch (Exception e){
            return "¡Error!: "+e.getMessage();
        }
    }

    public List<Pedido> obtenerTodos(){
        try {
            return pediDao.listar();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
