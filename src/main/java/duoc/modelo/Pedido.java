package duoc.modelo;

import duoc.util.EstadoPedido;
import duoc.util.TipoPedido;

public class Pedido {

    private int id;
    private String direccion;
    private TipoPedido tipo;
    private EstadoPedido estado;

    //Creación de pedidos
    public Pedido(String direccion, TipoPedido tipo) {
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = EstadoPedido.PENDIENTE; //Pendiente de manera predeterminada
    }

    //Sobrecarga, para cargar pedidos desde BD
    public Pedido(int id, String direccion, TipoPedido tipo, EstadoPedido estado){
        this.id = id;
        this.direccion = direccion;
        this.tipo = tipo;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public TipoPedido getTipo() {
        return tipo;
    }

    public EstadoPedido getEstado() {
        return estado;
    }


}
