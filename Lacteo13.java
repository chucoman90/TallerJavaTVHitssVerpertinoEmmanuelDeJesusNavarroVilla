package ejercicios;

public class Lacteo13 extends Producto13 {
    
    private int cantidad;
    private int proteinas;
    
    public Lacteo13(String nombre, double precio, int cantidad, int proteinas) {
        super(nombre, precio);
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }

    @Override
    public String toString() {
        return "Lacteo {nombre:" + nombre + ", cantidad:" + cantidad + ", precio:" + precio + ", proteinas:"
                + proteinas + "}";
    }

    

    
}
