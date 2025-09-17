package ejercicios;

public class Producto14  implements Identificable14<Integer>{
    private int id;
    private String descripcion;
    private double precio;

    public Producto14(int id, String descripcion, double precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Producto {id: " + id + ", descripcion: "  + descripcion + ", precio: " + precio + "}";
    }
}
