package ejercicios.ejercicio21;

import ejercicios.ejercicio21.Enums.TipoCliente;

public class Main {
    public static void main(String[] args) {

        SupermercadoService service = new SupermercadoService();

        // Crear productos
        System.out.println("\nCreando productos...");
        Producto p1 = new Producto(1, "Audifonos", 1500.0, 3);
        Producto p2 = new Producto(2, "Ipod", 2500.0, 10);
        Producto p3 = new Producto(3, "LapTop", 20000.0, 2);
        System.out.println("Productos creados:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);

        // Crear cliente y empleado
        System.out.println("\nCreando cliente y empleado..");
        Cliente c1 = new Cliente(1, "Emmanuel Villa", TipoCliente.VIP);
        Empleado e1 = new Empleado(1, "Abigail López", "Cajera");
        System.out.println(c1);
        System.out.println(e1);

        // Crear venta
        System.out.println("\nCreando venta..");
        Venta v1 = new Venta(1, c1, e1);
        v1.agregarProducto(p1);
        v1.agregarProducto(p2);
        v1.agregarProducto(p3);
        

        //2.Calcular el total de una venta a partir de la lista de productos 
        double total = service.calcularTotal.apply(v1);
        System.out.println("Total venta calculado: " + total);
        v1.setTotal(total);


        System.out.println("\nProductos con stock bajo:");
        for (Producto producto : v1.getProductos()) {
            if(service.stockBajo.test(producto)){// 1. Filtrar productos con stock bajo (stock < 5).
                service.impimirProducto.accept(producto);
            }
        }

        // 3. Imprimir detalles de la venta
        System.out.println("\nDetalles de venta:");
        service.imprimirVenta.accept(v1);

        // 4. Generar un producto de muestra para pruebas.
        System.out.println("\nProducto de muestra:");
        System.out.println(service.productoMuestra.get());

        //5. Aplicar un descuento del 10% a un producto.
        System.out.println("\nDescuento en producto:");
        System.out.println(p3);
        System.out.println(p3.getNombre() + " con 10% descuento..");
        System.out.println(service.descuentoProducto.apply(p3));

         // 6. Comparar dos productos y devolver el más caro.
        System.out.println("\nMás caro entre " + p1.getNombre() + " y " + p3.getNombre() +":");
        System.out.println(service.masCaro.apply(p1, p3));

         // 7. Cliente con descuento
        System.out.println("\nAlgún cliente con descuento?");
        if(service.clienteConDescuento.test(c1, v1)){
            System.out.println(c1);
            System.out.println("\nVenta:");
            System.out.println(v1);
            System.out.println("\n\nDescuento del 10% en su compra..");
            //var totalVip = c1.getTipo().aplicarDescuento(v1.getTotal());
            v1.setTotal(service.descuentoCompra.apply(v1.getTotal()));
            //v1.setTotal(totalVip);
            System.out.println(v1);
        }

        // 8. Ticket de venta
        System.out.println("\nTicket generado:");
        System.out.println(service.generarTicket.apply(c1, v1));

        // 9. Notificación al cliente
        System.out.println("\nNotificación:");
        service.notificarCompra.accept(c1, e1);
    }
}
