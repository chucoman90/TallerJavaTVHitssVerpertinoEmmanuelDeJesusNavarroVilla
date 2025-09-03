package ejercicios;

public abstract class Electronico11 extends Producto11 implements IElectronico11 {
    private String fabricante;

    public Electronico11(int precio, String fabricante) {
        super(precio);
        this.fabricante = fabricante;
    }

    @Override
    public String getFabricante() {
        return fabricante;
    }
    
    
    
    
}
