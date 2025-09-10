package ejercicios;

public class Producto13 {
    protected String nombre;
    protected double precio;

    public Producto13(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto {nombre:" + nombre + ", precio:" + precio + "}";
    }

    
    
}
