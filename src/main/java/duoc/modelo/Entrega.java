package duoc.modelo;

import java.sql.Date;
import java.sql.Time;

public class Entrega {

    private int id;
    private int idPedido;
    private int idRepartidor;
    private Date fecha;
    private Time hora;

    //Creador de entregas
    public Entrega(int idPedido, int idRepartidor){
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
    }

    //Sobrecarga, cargamos entregas desde BD
    public Entrega(int id, int idPedido, int idRepartidor, Date fecha, Time hora){
        this.id = id;
        this.idPedido = idPedido;
        this.idRepartidor = idRepartidor;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public int getIdRepartidor() {
        return idRepartidor;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }
}
