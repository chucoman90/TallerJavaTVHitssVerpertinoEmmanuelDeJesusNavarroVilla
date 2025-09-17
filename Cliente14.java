package ejercicios;

public class Cliente14 implements Identificable14<String> {
    
    private String  id;
    private String nombre;

    public Cliente14(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    @Override
    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente {id: " + id + ", nombre: " + nombre + "}";
    }

    
}
