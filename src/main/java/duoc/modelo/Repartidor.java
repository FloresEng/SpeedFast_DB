package duoc.modelo;

public class Repartidor {

    private int id;
    private String nombre;

    //creación de repartidor
    public Repartidor (String nombre){
        this.nombre = nombre;
    }

    //Sobrecarga, cargar repartidor desde BD
    public Repartidor(int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
