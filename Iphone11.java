package ejercicios;

public class Iphone11 extends Electronico11{
    
    private String modelo;
    private String color;

    public Iphone11(int precio, String fabricante, String modelo, String color) {
        super(precio, fabricante);
        this.modelo = modelo;
        this.color = color;
    }

    @Override
    public double getPrecioVenta() {
        return (getPrecio() * 0.4) + getPrecio();
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Iphone {modelo: " + modelo + ", color: " + color + ", fabricante: " + getFabricante()
                + ", PrecioVenta: " + getPrecioVenta() + ", precio: " + getPrecio() + "}";
    }

    
}
