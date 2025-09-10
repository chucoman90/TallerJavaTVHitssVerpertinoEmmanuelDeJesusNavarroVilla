package ejercicios;

public class Limpieza13 extends Producto13 {
    
    private String componentes;
    private double litros;
    
    public Limpieza13(String nombre, double precio, String componentes, double litros) {
        super(nombre, precio);
        this.componentes = componentes;
        this.litros = litros;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    @Override
    public String toString() {
        return "Limpieza [nombre:" + nombre + ", componentes:" + componentes + ", precio:" + precio + ", litros:"
                + litros + "}";
    }

    
}
