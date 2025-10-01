package ejercicios.ejercicio21;

import java.util.ArrayList;
import java.util.List;

public class Venta {
    private int id;
    private Cliente cliente;
    private Empleado empleado;
    private List<Producto> productos;
    private double total;

    public Venta(int id, Cliente cliente, Empleado empleado) {
        this.id = id;
        this.cliente = cliente;
        this.empleado = empleado;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    public void calcularTotal(){
        for (Producto producto : productos) {
            total += producto.getPrecio();
        }
    }

    public int getId() {return id;}
    public Cliente getCliente() {return cliente;}
    public Empleado getEmpleado() {return empleado;}
    public List<Producto> getProductos() {return productos;}
    public double getTotal() {return total;}
    public void setTotal(double total) {this.total = total;}

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("[id: ").append(id).append("\n");
        sb.append("cliente: ").append(cliente.getNombre()).append("\n");
        sb.append("empleado: ").append(empleado.getNombre()).append("\n");
        sb.append("Productos:").append("\n");

        for (Producto producto : productos) {
            sb.append("{id: ").append(producto.getId()).append(", nombre: ").append(producto.getNombre())
            .append(", precio: ").append(producto.getPrecio()).append(", stock: ").append(producto.getStock()).append("}").append("\n");
        }

        sb.append("total: ").append(total).append("]");
        return sb.toString();
    }
}
