package ejercicios;

import java.util.List;

public class Factura14 implements Identificable14<Long> {

    private long id;
    private Cliente14 cliente;
    private List<Producto14> productos;

    public Factura14(Long id, Cliente14 cliente, List<Producto14> productos) {
        this.id = id;
        this.cliente = cliente;
        this.productos = productos;
    }

    @Override
    public Long getId() {
        return id;
    }

    public Cliente14 getCliente() {
        return cliente;
    }

    public List<Producto14> getProductos() {
        return productos;
    }

    //Método dinamico para agregar un producto a la factura
    public void agregarProducto(Producto14 producto){
        productos.add(producto);
        System.out.println("Agregado a la factura: " + producto);
    }

    //Eliminar un producto de la factura de forma dinamica
    public boolean eliminarProducto(int idProducto){
        for (int i = 0; i < productos.size(); i++) {
            if (productos.get(i).getId() == idProducto) {
                var producto =  productos.remove(i);
                System.out.println("Producto eliminado: " + producto);
                return true;
            }
        }
        System.out.println("No se encontró producto con ID: " + idProducto);
        return false;
    }

    public double calcularTotal(){
        double total = 0;
        for (Producto14 producto : productos) {
            total += producto.getPrecio();
        }
        return total;
    }

    public String generarReporte() {

        StringBuilder reporte = new StringBuilder();
        reporte.append("Factura ID: ").append(id).append("\n");
        reporte.append("Cliente: ").append(cliente.getNombre()).append("\n");
        reporte.append("Productos:\n");

        // Definir el formato de columnas
        String formato = "%-20s %-10s $%9.2f%n";

        // Encabezado
        reporte.append(String.format("%-20s %-10s %10s%n", "Descripción", "ID", "Precio"));

        // Detalle de productos
        for (Producto14 producto : productos) {
            reporte.append(String.format(formato,
                    producto.getDescripcion(),
                    producto.getId(),
                    producto.getPrecio()
            ));
        }

        reporte.append("\n");

        // Total alineado exactamente con la columna de precios
        reporte.append(String.format("%-31s $%9.2f%n", "TOTAL:", calcularTotal()));

        return reporte.toString();
}



    @Override
    public String toString() {
        return "Factura {id: " + id + ", cliente: " + cliente + ", productos: " + productos + "total: " + calcularTotal() + "}";
    }
    
    
}
