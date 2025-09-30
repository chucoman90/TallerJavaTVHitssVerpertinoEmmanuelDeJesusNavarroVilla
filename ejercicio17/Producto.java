package ejercicios.ejercicio17;

import java.util.HashMap;
import java.util.Map;

import ejercicios.ejercicio17.Enums.Categoria;
import ejercicios.ejercicio17.Enums.Sucursal;

public class Producto {
    private static int contador = 1;
    private String sku;
    private String nombre;    
    private Categoria categoria;
    private Map<Sucursal, Integer> stockDisponibleSucursales; // <clave: Sucursal, valor: Stock>

    public Producto(String nombre, Categoria categoria) {
        this.sku = categoriaAbreviada(categoria) + (contador++);
        this.nombre = nombre;
        this.categoria = categoria;
        this.stockDisponibleSucursales = new HashMap<>();
    }

    public String getSku() { return sku; }
    public String getNombre() { return nombre; }
    public Categoria getCategoria() { return categoria; }

    public void actualizarStockSucursal(Sucursal sucursal, int cantidad) {
        stockDisponibleSucursales.put(sucursal, stockDisponibleSucursales.getOrDefault(sucursal, 0) + cantidad);
    }

    private String categoriaAbreviada(Categoria categoria){

        return switch(categoria){
                    case FUTBOL -> "FUT";
                    case BALONCESTO -> "BAL";
                    case RUNNING -> "RUN";
                    case TENIS -> "TEN";
                    case NATACION -> "NAT";
                };
    }

    public int getStock(Sucursal sucursal) {
        return stockDisponibleSucursales.getOrDefault(sucursal, 0);
    }

    @Override
    public String toString() {
        return "{SKU: " + sku + ", Nombre: " + nombre + ", Categoria: " + categoria + ", Stock: " + stockDisponibleSucursales +"}";
    }

}
