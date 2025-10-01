package ejercicios.ejercicio21;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import ejercicios.ejercicio21.Enums.TipoCliente;

public class SupermercadoService {
    // 1. Filtrar productos con stock bajo
    // Predicate<T> -> boolean test(T t)
    Predicate<Producto> stockBajo = p -> p.getStock() < 5;

    // 2. Calcular el total de una venta (Function)
    // Function<T,R> -> R apply(T t)
    Function<Venta, Double> calcularTotal = venta -> {
        double total = 0;
        for (Producto producto : venta.getProductos()) {
            total += producto.getPrecio();
        }
        return total;
    };
        
    // 3. Imprimir detalles de una venta
    // Consumer<T> -> void accept(T t)
    Consumer<Venta> imprimirVenta = venta -> System.out.println(venta);
    Consumer<Producto> impimirProducto = producto -> System.out.println(producto);

    // 4. Generar un producto de muestra
    // Supplier<T> -> T get()
    Supplier<Producto> productoMuestra = () -> new Producto(4, "Producto de muestra", 10.0, 100);

    // 5. Aplicar un 10% de descuento a un producto
    // UnaryOperator<T> -> T apply(T t)
    UnaryOperator<Producto> descuentoProducto = p -> new Producto(p.getId(), p.getNombre(), p.getPrecio() * 0.9, p.getStock());
    UnaryOperator<Double> descuentoCompra = totalCompra -> totalCompra * 0.9;

    // 6. Comparar dos productos y devolver el más caro
    // BinaryOperator<T> -> T apply(T t1, T t2)
    BinaryOperator<Producto> masCaro = (p1, p2) -> (p1.getPrecio() >= p2.getPrecio()) ? p1 : p2;

    // 7. Verificar si un cliente puede tener descuento
    // BiPredicate<T,U> -> boolean test(T t, U u)
    BiPredicate<Cliente, Venta> clienteConDescuento = (c, v) -> (c.getTipo() == TipoCliente.VIP) && v.getTotal() > 1000;

    // 8. Generar ticket de venta en consola
    // BiFunction<T,U,R> -> R apply(T t, U u)
    BiFunction<Cliente, Venta, String> generarTicket = (c, v) -> {
        StringBuilder sb = new StringBuilder();
        sb.append("=== TICKET DE VENTA ===\n");
        sb.append("Cliente: ").append(c.getNombre()).append("\n");
        sb.append("Tipo: ").append(c.getTipo()).append("\n");
        sb.append("Empleado: ").append(v.getEmpleado().getNombre()).append("\n");
        sb.append("Productos:\n");

        for (Producto producto : v.getProductos()) {
            sb.append(String.format("%-15s $%10.2f\n",
                    producto.getNombre(), producto.getPrecio()));
        }

        // Alineo el total con los precios con el mismo formato.
        sb.append(String.format("%-15s $%10.2f\n", "TOTAL", v.getTotal()));
        return sb.toString();
    };

    // 9. Notificar al cliente que su compra fue procesada
    // BiConsumer<T,U> -> void accept(T t, U u)
    BiConsumer<Cliente, Empleado> notificarCompra = (c, e) -> 
        System.out.println(c.getNombre() + ", su compra fue procesada por " + e.getPuesto() + ":" + e.getNombre() + "\n");
}
