package duoc.modelo;

public class Cliente {

    private int id;
    private String nombre;
    private String telefono;

    //Para crear cliente
    public Cliente(String nombre, String telefono){
        this.nombre = nombre;
        this.telefono = telefono;
    }

    //Sobrecarga para cargar cliente desde BD
    public Cliente(int id, String nombre, String telefono){
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }
    public int getId(){
        return id;
    }

    public String getTelefono() {
        return telefono;
    }
}
