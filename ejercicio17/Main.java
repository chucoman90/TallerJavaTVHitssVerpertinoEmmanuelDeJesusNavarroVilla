package ejercicios.ejercicio17;

import java.util.Scanner;

import ejercicios.ejercicio17.Enums.Categoria;
import ejercicios.ejercicio17.Enums.Sucursal;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Inventario inventarioTiendaDeportes =  new Inventario();
    static int opcion;
    static boolean bandera;
    public static void main(String[] args) {
        do {
            opcion = mostrarMenuPrincipal();
            sc.nextLine();//Limpiar buffer

            switch (opcion) {
                case 1 -> registrarProducto();
                case 2 -> consultarProductoPorCodigo();
                case 3 -> generarReporte();
                case 4 -> actualizarStock();
                case 5 -> registrarVenta();
                case 6 -> System.out.println("\nSaliendo de gestion programa..");
                default -> System.out.println("\nOpción no válida. Intenta de nuevo");

            }
        } while (opcion != 6);
        sc.close();
    }

    public static int mostrarMenuPrincipal(){
        System.out.print("\n==== Gestion Inventario ====\n"
                            + "1. Registrar producto.\n"
                            + "2. Consultar producto por código(SKU).\n"
                            + "3. Generar un reporte.\n"
                            + "4. Actualizar stock.\n"
                            + "5. Registrar venta.\n"
                            + "6. Salir.\n"
                            + "# opción:");             
        return sc.nextInt();
    }

    public static void registrarProducto(){
        Producto p;
        String nombre;
        Categoria categoria;
        Sucursal sucursal;
        int numPiezas;
        
        do{
            do {
                bandera = false;
                System.out.println("\nElegir sucursal para agregar producto nuevo.");
                opcion = menuSucursal();
                sc.nextLine();
                sucursal = obtenerSucursal(opcion);

                if(opcion == 6){
                    System.out.println("\nRegresando a ménu principal..");
                    return;
                }else if (sucursal == null){
                        System.out.println("\nOpción no válida. Intenta de nuevo.");
                        bandera = true;
                    }
            } while (bandera);

            do{
                System.out.println("\n=== SUCURSAL " + sucursal + " ===");
                System.out.println("\nAgregar producto en categoría:");
                opcion = menuCategoria();
                sc.nextLine();//Limpio buffer
                categoria = obtenerCategoria(opcion);
                
                if(opcion == 6){
                    System.out.println("\nRegresando a ménu sucursal..");
                    bandera = true;
                    break;
                }else if(categoria == null){
                    System.out.println("\nOpción no válida. Intenta de nuevo.");
                    bandera = true;
                }else{
                        do{
                            System.out.println("\n=== SUCURSAL " + sucursal + " ===");
                            System.out.print("\nIngrese nombre del producto:");
                            nombre = sc.nextLine().trim();
                            System.out.print("Número de piezas:");
                            numPiezas = sc.nextInt();
                            sc.nextLine();
                            p = new Producto(nombre, categoria);
                            inventarioTiendaDeportes.registrarProducto(p);
                            inventarioTiendaDeportes.actualizarStock(p.getSku(), sucursal, numPiezas);
                            System.out.println("\nProducto agregado con exito a inventario:\n" + p.toString());

                            System.out.print("\n¿Desea registrar otro producto en la sucursal " + sucursal + "? (1-Sí / 2-No)."
                            + "\n# opción:");
                            opcion = sc.nextInt();
                            sc.nextLine();
                            
                            if(opcion == 1){
                                bandera = true;
                            }else if(opcion == 2)
                                    bandera = false;
                                
                        }while(bandera);
                    }

            }while (bandera);
                    
                    System.out.print("\n¿Desea registrar otro producto en otra sucursal? (1-Sí / 2-No)."
                    + "\n# opción:");
                    opcion = sc.nextInt();
                    sc.nextLine();
                    if(opcion == 1)
                        bandera = true;
        }while(bandera);
    }

    public static int menuSucursal(){
        System.out.print("1. Centro.\n"
                        +"2. Norte.\n"
                        +"3. Sur.\n"
                        +"4. Este.\n"
                        +"5. Oeste.\n"
                        +"6. Regresar a ménu principal.\n"
                        +"# opción:");
        return sc.nextInt();
    }

    public static int menuCategoria(){
        System.out.print( "1. Fútbol.\n"
                        + "2. Baloncesto.\n"
                        + "3. Running.\n"
                        + "4. Tenis.\n"
                        + "5. Natación.\n"
                        + "6. Regresar ménu sucursal.\n"
                        +"# opción:");
        return sc.nextInt();
    }

    public static Categoria obtenerCategoria(int opcion){
        return switch (opcion){
            case 1 -> Categoria.FUTBOL;
            case 2 -> Categoria.BALONCESTO;
            case 3 -> Categoria.RUNNING;
            case 4 -> Categoria.TENIS;
            case 5 -> Categoria.NATACION;
            default -> null;
        };
    }

    public static Sucursal obtenerSucursal(int opcion){
        return switch (opcion){
            case 1 -> Sucursal.CENTRO;
            case 2 -> Sucursal.NORTE;
            case 3 -> Sucursal.SUR;
            case 4 -> Sucursal.ESTE;
            case 5 -> Sucursal.OESTE;
            default -> null;
        };
    }

    public static void consultarProductoPorCodigo(){
        Producto producto;
        String sku;
        System.out.print("\nIngresa SKU(FUT#,BAL#,RUN#,TEN#,NAT#):");
        sku = sc.nextLine().trim();
        producto = inventarioTiendaDeportes.buscarPorSku(sku);
        if (producto != null) {
            for (var sucursal : Sucursal.values()) {
                var stockSucursal = producto.getStock(sucursal);
                System.out.println("=== SUCURSAL " + sucursal + " ===");
                System.out.println("Stock:" + stockSucursal);
            }
        } else {
            System.out.println("Producto no encontrado con SKU: " + sku);
        }
    }

    public static void generarReporte(){
        
        do {
            bandera = false;
            System.out.print("Generar reporte por:\n"
                            + "1. Orden en que fueron agregados.\n"
                            + "2. Orden alfabéticamente por nombre.\n"
                            + "# opción:");
            opcion = sc.nextInt();
            sc.nextLine();

            if(opcion == 1){
                inventarioTiendaDeportes.reportePorOrden();
            }else if(opcion == 2){
                inventarioTiendaDeportes.reporteAlfabetico();
            }else{
                System.out.println("\nOpción no válida. Intenta de nuevo.");
                bandera = true;
            }

        } while (bandera);
    }

    public static void actualizarStock(){
        Sucursal sucursal;
        Producto producto;
        int numPiezas;
        String sku;
        do {
            bandera = false;
            System.out.println("\nElegir sucursal para actualizar stock.");
            opcion = menuSucursal();
            sc.nextLine();
            sucursal = obtenerSucursal(opcion);

            if(opcion == 6){
                System.out.println("\nRegresando a ménu principal..");
                return;
            }else if(sucursal == null){
                        System.out.println("\nOpción no válida. Intenta de nuevo.");
                        bandera = true;
                    }else{
                            System.out.println("\n=== SUCURSAL " + sucursal + " ===");
                            System.out.print("\nIngresa SKU(FUT#,BAL#,RUN#,TEN#,NAT#):");
                            sku = sc.nextLine().trim();
                            producto = inventarioTiendaDeportes.buscarPorSku(sku);
                            if(producto != null){
                                System.out.println("Stock en existencia:" + producto.getStock(sucursal));
                                System.out.print("Número de piezas nuevas a agregar:");
                                numPiezas = sc.nextInt();
                                sc.nextLine();
                                inventarioTiendaDeportes.actualizarStock(sku, sucursal, numPiezas);
                                System.out.println("Inventario actualizado con éxito.");
                            }else{
                                System.out.println("Producto no encontrado con SKU: " + sku);
                            }
                        }
            } while (bandera);
    }

    public static void registrarVenta(){
        Sucursal sucursal;
        String sku;
        int numPiezasVendidas;
        do {
            bandera = false;
            System.out.println("\nElegir sucursal para registrar venta.");
            opcion = menuSucursal();
            sc.nextLine();
            sucursal = obtenerSucursal(opcion);

            if(opcion == 6){
                System.out.println("\nRegresando a ménu principal..");
                return;
            }else if(sucursal == null){
                        System.out.println("\nOpción no válida. Intenta de nuevo.");
                        bandera = true;
                    }else{
                            System.out.println("\n=== SUCURSAL " + sucursal + " ===");
                            System.out.print("\nIngresa SKU(FUT#,BAL#,RUN#,TEN#,NAT#)."
                                            + "\nDe producto vendido:");
                            sku = sc.nextLine().trim();
                            
                            do{
                                System.out.print("Ingresa número de piezas vendidas:");
                                numPiezasVendidas = sc.nextInt();
                                sc.nextLine();
                                if(numPiezasVendidas > 0){
                                    inventarioTiendaDeportes.registrarVenta(sku, sucursal, numPiezasVendidas);
                                }else{
                                    System.out.println("Número de piezas debe ser mayor a cero.");
                                    bandera = true;
                                }
                            }while (bandera);
                        }
        } while (bandera);
    }
}
