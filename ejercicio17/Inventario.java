package ejercicios.ejercicio17;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import ejercicios.ejercicio17.Enums.Sucursal;

public class Inventario {
    private Map<String, Producto> inventarioPorSku = new HashMap<>();//Acceso rapido por SKU
    private Map<String, Producto> inventarioPorOrden = new LinkedHashMap<>();//Mantener orden de inserción
    private Map<String, Producto> inventarioPorNombre = new TreeMap<>();

    public void registrarProducto(Producto p) {
        inventarioPorSku.put(p.getSku(), p);
        inventarioPorOrden.put(p.getSku(), p);
        inventarioPorNombre.put(p.getNombre(), p);
    }

    public Producto buscarPorSku(String sku) {
        return inventarioPorSku.get(sku);
    }

    public void actualizarStock(String sku, Sucursal sucursal, int cantidad) {
        Producto p = inventarioPorSku.get(sku);
        if (p != null) {
            p.actualizarStockSucursal(sucursal, cantidad);
        }
    }
    
    public void registrarVenta(String sku, Sucursal sucursal, int cantidad) {
        Producto p = inventarioPorSku.get(sku);
        if (p != null){
            int stockActual = p.getStock(sucursal);
            if (cantidad > stockActual) {
                System.out.println("\n=== SUCURSAL " + sucursal + " ===");
                System.out.println("Stock insuficiente. Solo hay " + stockActual + " piezas.");
            } else {
                p.actualizarStockSucursal(sucursal, -cantidad); // descontar del stock, paso la cantidad en negativo
                System.out.println("\nVenta registrada. Nuevo stock en sucursal " + sucursal + ": " + p.getStock(sucursal));
            }
        }else {
            System.out.println("\n=== SUCURSAL " + sucursal + " ===");
            System.out.println("Producto no encontrado con SKU: " + sku);
        }
}


    public void reportePorOrden() {
        inventarioPorOrden.values().forEach(System.out::println);
    }

    public void reporteAlfabetico() {
        inventarioPorNombre.values().forEach(System.out::println);
    }
}
