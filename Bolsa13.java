package ejercicios;

import java.util.ArrayList;
import java.util.List;

class Bolsa13<T extends Producto13> {
    private List<T> productos = new ArrayList<>();

    public void addProducto(T producto) {
        if (productos.size() <= 5) {
            productos.add(producto);
        } else {
            System.out.println("La bolsa llena con 5 productos");
        }
    }

    public List<T> getProductos() {
        return productos;
    }
}
