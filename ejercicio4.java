package ejercicios;
import java.util.Scanner;

//! Autor: [EMMANUEL DE JESUS NAVARRO VILLA]
public class ejercicio4 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        double totalVentas = 0.0;
        int opcion;
        double precioProducto;

        do {
            System.out.println("Menú:");
            System.out.println("1. Registrar un pedido");
            System.out.println("2. Mostrar el total de ventas");
            System.out.println("3. Salir del sistema");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1 -> {

                    System.out.print("Ingrese el precio del pedido: ");
                    precioProducto = scanner.nextDouble();

                    if (precioProducto > 0) {
                        //! Añado el precio del producto al total de ventas
                        totalVentas += precioProducto;
                        System.out.println("Pedido registrado.");
                    } else {
                        System.out.println("El precio debe ser positivo.");
                    }
                }
                case 2 -> System.out.printf("Total de ventas: %.2f\n", totalVentas);
                case 3 -> System.out.println("Saliendo del sistema...");
                default -> System.out.println("Opción no válida.");
            }
            System.out.println();
        } while (opcion != 3);

        scanner.close();
    }
}
