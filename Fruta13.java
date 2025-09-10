package ejercicios;

public class Fruta13 extends Producto13 {
    
    private double peso;
    private String color;
    
    public Fruta13(String nombre, double precio, double peso, String color) {
        super(nombre, precio);
        this.peso = peso;
        this.color = color;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruta {nombre:" + nombre + ", peso:" + peso + ", precio:" + precio + ", color:" + color + "}";
    }

    
    
}
