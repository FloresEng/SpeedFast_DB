package duoc.controlador;

import duoc.dao.EntregaDAO;
import duoc.dao.PedidoDAO;
import duoc.modelo.Pedido;
import duoc.util.EstadoPedido;

import java.sql.SQLException;
import java.util.List;

public class ControladorEntrega {

    private EntregaDAO entreDao = new EntregaDAO();
    private PedidoDAO pediDao = new PedidoDAO();

    public boolean pedidosPendientes(){
        try{
            List<Pedido> todos = pediDao.listar();
            long cont = todos.stream().filter(p -> p.getEstado() == EstadoPedido.PENDIENTE).count();
            return cont > 0;
        }catch (Exception e){
            return false;
        }
    }

    public boolean pedidosEnReparto(){
        try{
            List<Pedido> todos = pediDao.listar();
            long cont = todos.stream().filter(pedido -> pedido.getEstado() == EstadoPedido.EN_REPARTO).count();
            return cont > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public String iniciarEntrega(int idPedido, String nomRepartidor){
        try{
            if (!pedidosPendientes()){
                return "¡ERROR!: No existen pedidos pendientes a los que asignar repartidor.";
            }
            entreDao.registrarEntrega(idPedido,nomRepartidor);
            return "Entrega registrada e iniciada correctamente.";
        }catch (SQLException e){
            return "Error al procesar la entrega. " + e.getMessage();
        }
    }

    public String finalizarEntrega(int idPedido){
        try{
            if (!pedidosEnReparto()){
                return "¡ERROR!: No existen pedidos en reparto.";
            }
            entreDao.finalizarEntrega(idPedido);
            return "Entrega finalizado correctamente.";
        } catch (SQLException e) {
            return "Error al finalizar la entrega. "+e.getMessage();
        }
    }
}
