package ejercicios;

import java.util.ArrayList;
import java.util.Arrays;

public class TestMain14 {
    public static void main(String[] args) {
        
        ServicioGenerico14<Cliente14,String> clienteServicio =  new ServicioGenerico14<>();
        ServicioGenerico14<Producto14,Integer> productoServicio =  new ServicioGenerico14<>();
        ServicioGenerico14<Factura14,Long> facturaServicio = new ServicioGenerico14<>();
        //Clientes
        Cliente14 c1 = new Cliente14("C001", "Juan Perez");
        Cliente14 c2 = new Cliente14("C001", "Maria Gomez");
        Cliente14 c3 = new Cliente14("C002", "Luis Martinez");
        clienteServicio.agregar(c1);
        //No se agrega porque ya existe un cliente con el mismo id
        clienteServicio.agregar(c2);
        clienteServicio.agregar(c3);
        //Productos
        Producto14 p1 = new Producto14(101, "Laptop", 1500.0);
        Producto14 p2 = new Producto14(102, "Smartphone", 800.0);
        Producto14 p3 = new Producto14(103, "Tablet", 300.0);
        Producto14 p4 = new Producto14(104, "Monitor", 400.0);
        productoServicio.agregar(p1);
        productoServicio.agregar(p2);
        productoServicio.agregar(p3);
        productoServicio.agregar(p4);
        //Facturas 
        Factura14 f1 = new Factura14(1001L, c1,new ArrayList<>(Arrays.asList(p1, p2)));
        Factura14 f2 = new Factura14(1002L, c3,new ArrayList<>(Arrays.asList(p1,p2,p3)));
        facturaServicio.agregar(f1);
        facturaServicio.agregar(f2);

        //Busqueda por ID
        System.out.println("Buscar cliente C002: " + clienteServicio.buscarPorId("C002"));
        
        //Actualizar cliente con ID
        System.out.println("Actualizando cliente C002: " + clienteServicio.actualizar("C002", new Cliente14("C002", "Luis Montoya"))); 

        //Eliminar un cliente
        Cliente14 c4 = new Cliente14("C003", "Luis Martinez");
        clienteServicio.agregar(c4);

        for (Cliente14 cliente : clienteServicio.listar()) {
            System.out.println(cliente);
        }
        clienteServicio.eliminarPorId(c4.getId());
        
        for (Cliente14 cliente : clienteServicio.listar()) {
            System.out.println(cliente);
        }
        //Agregar y eliminar un producto de forma dinamica a la factura
        System.out.println("Modificando factura, en la lista de productos");
        f2.eliminarProducto(103);
        f2.agregarProducto(p4);
        
        System.out.println("\n" + f1.generarReporte());
        System.out.println("\n" + f2.generarReporte());
        
        //Crear directorio facturas
        Archivos14.crearDirectorio("facturas");
        //Guardar y leer facturas en archivos de texto
        Archivos14.guardarArchivo(f1, "factura_" + f1.getId() + ".txt", "facturas");
        Archivos14.guardarArchivo(f2, "factura_" + f2.getId() + ".txt", "facturas");
        Archivos14.leerArchivo("factura_" + f1.getId() + ".txt", "facturas");
        Archivos14.leerArchivo("factura_" + f2.getId() + ".txt", "facturas");

        //Listar archivos en el directorio facturas
        Archivos14.listarArchivos("facturas");
    }
}
