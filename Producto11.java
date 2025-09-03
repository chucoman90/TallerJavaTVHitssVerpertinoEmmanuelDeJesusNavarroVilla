package ejercicios;

public abstract class Producto11 implements IProducto11 {
    private int precio;
    
    public Producto11(int precio) {
        this.precio = precio;
    }
    
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public int getPrecio() {
        return precio;
    }
    
    

}
