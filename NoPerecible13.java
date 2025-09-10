package ejercicios;

public class NoPerecible13 extends Producto13{
    
    private int contenido;
    private int calorias;
    
    public NoPerecible13(String nombre, double precio, int contenido, int calorias) {
        super(nombre, precio);
        this.contenido = contenido;
        this.calorias = calorias;
    }

    public int getContenido() {
        return contenido;
    }

    public void setContenido(int contenido) {
        this.contenido = contenido;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    @Override
    public String toString() {
        return "NoPerecible {nombre:" + nombre + ", contenido:" + contenido + ", precio:" + precio + ", calorias:"
                + calorias + "}";
    }

    
}
