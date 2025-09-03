package ejercicios;

public class TvLcd11 extends Electronico11{
    
    private int pulgadas;

    public TvLcd11(int precio, String fabricante, int pulgadas) {
        super(precio, fabricante);
        this.pulgadas = pulgadas;
    }

    @Override
    public double getPrecioVenta() {
        return (getPrecio() * 0.2) + getPrecio();
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    @Override
    public String toString() {
        return "Tv {pulgadas: " + pulgadas + ", PrecioVenta: " + getPrecioVenta() + ", fabricante: "
                + getFabricante() + ", precio: " + getPrecio() + "}";
    }

    
}
