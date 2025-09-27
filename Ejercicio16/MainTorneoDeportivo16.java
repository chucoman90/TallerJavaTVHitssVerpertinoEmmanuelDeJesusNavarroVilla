package ejercicios;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class MainTorneoDeportivo16 {
    static Scanner sc = new Scanner(System.in);
    static int opcion;
    static Set<Jugador16> inscripcioneSinOrden;
    static Set<Jugador16> inscripcionesFutbol;
    static Set<Jugador16> inscripcionesBasquetbol;
    static Set<Jugador16> inscripcionesVoleibol;

    public static void main(String[] args) {
        inscripcioneSinOrden = new HashSet<>();
        inscripcionesFutbol = new LinkedHashSet<>();
        inscripcionesBasquetbol = new LinkedHashSet<>();
        inscripcionesVoleibol = new LinkedHashSet<>();
        do {
            mostrarMenuPrincipal();
            switch (opcion) {
                case 1 -> registrarJugador();
                case 2 -> mostrarJugadoresPorDeporte();
                case 3 -> contarJugadoresPorDeporte();
                case 4 -> fusionarEquipos();
                case 5 -> verJugadoresEnComun();
                case 6 -> transferirJugador();
                case 7 -> mostrarJugadores();
                case 8 -> buscarJugadorPorDisciplina();
                case 9 -> eliminarJugadorPorDisciplina();
                case 10 -> System.out.println("\nSaliendo del programa Torneo Deportes...");
                default -> System.out.println("\nOpción no válida. Intente de nuevo.");

            }
        } while (opcion != 10);
        sc.close();
    }

    public static void mostrarMenuPrincipal(){
        System.out.print("\n==== Menú Torneo Deportes ====\n"
                            + "1. Registrar jugador en algún deporte.\n"
                            + "2. Mostrar jugadores por deporte.\n"
                            + "3. Contar jugadores en cada disciplina.\n"
                            + "4. Fusionar equipos(unión).\n"
                            + "5. Ver jugadores en común(intersección).\n"
                            + "6. Transferir jugador de un deporte a otro.\n"
                            + "7. Mostrar todos los jugadores por un orden\n"
                            + "8. Buscar jugador por disciplina\n"
                            + "9. Eliminar un jugador por disciplina.\n"
                            + "10. Salir.\n"
                            + "# opción: ");             
        opcion = sc.nextInt();
    }

    public static void registrarJugador() {
        int idJugador=0;
        String nombre=null;
        boolean bandera;
    

        do {
            bandera = false;
            System.out.print("\nSeleccione el deporte al que desea registrar el jugador:\n"
                                + "1. Fútbol\n"
                                + "2. Básquetbol\n"
                                + "3. Voleibol\n"
                                + "4. Regresar al menú principal\n"
                                + "# opción: ");
            opcion = sc.nextInt();
            
            if(opcion >=1 && opcion <=3){
                System.out.println("\nProporcione los siguientes datos:");
                System.out.print("ID del jugador (ID >= 1): ");
                idJugador = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                System.out.print("Nombre del jugador: ");
                nombre = sc.nextLine().trim();
                
                switch (opcion) {
                    case 1 -> {
                        Futbol16 jugador = new Futbol16(idJugador, nombre, "Futbolista");
                        if(inscripcionesFutbol.add(jugador) == false){
                            System.out.println("\nEl jugador ya está registrado en fútbol.");
                        }
                        else{
                            inscripcioneSinOrden.add(jugador);
                            System.out.println("\nRegistro de jugador de fútbol exitoso");
                        }
                    }
                    case 2 -> {
                        Basquetbol16 jugador = new Basquetbol16(idJugador, nombre, "Basquetbolista");
                        if(inscripcionesBasquetbol.add(jugador) == false)
                            System.out.println("\nEl jugador ya está registrado en básquetbol.");
                        else{
                            inscripcioneSinOrden.add(jugador);
                            System.out.println("\nRegistro de jugador de basquetbol exitoso");
                        }
                    } 
                    case 3 -> {
                        Voleibol16 jugador = new Voleibol16(idJugador, nombre, "Voleibolista");
                        if(inscripcionesVoleibol.add(jugador) == false)
                            System.out.println("\nEl jugador ya está registrado en voleibol.");
                        else{
                            inscripcioneSinOrden.add(jugador);
                            System.out.println("\nRegistro de jugador de voleibol exitoso");
                        }
                    }   
                }
                System.out.print("\n¿Desea registrar otro jugador? (1-Sí / 2-No)"
                                    + "\n# opción: ");
                opcion = sc.nextInt();
                
                if (opcion == 1)
                    bandera = true;
                

            }else if(opcion == 4){
                System.out.println("Regresando al menú principal...");
            }else{
                System.out.println("Opción no válida. Intente de nuevo.");
                bandera = true;
            }

        } while (bandera);
    }

    public static void imprimirSet(Set<Jugador16> set){
        for (Jugador16 jugador : set) {
            System.out.println(jugador);
        }
    }

    public static void mostrarJugadoresPorDeporte() {
        boolean bandera;
        do {
            bandera = false;
            System.out.print("\nSeleccione el deporte para mostrar jugadores:\n"
                                + "1. Fútbol\n"
                                + "2. Básquetbol\n"
                                + "3. Voleibol\n"
                                + "4. Regresar al menú principal\n"
                                + "# opción: ");
            opcion = sc.nextInt();

            if(opcion >=1 && opcion <=3){
                switch (opcion) {   
                    case 1 -> {
                        System.out.println("\nJugadores inscritos en Fútbol:");
                        if (inscripcionesFutbol.isEmpty())
                            System.out.println("No hay jugadores inscritos en Fútbol.");
                        else
                            imprimirSet(inscripcionesFutbol);
                        
                    }
                    case 2 -> {
                        System.out.println("\nJugadores inscritos en Básquetbol:");
                        if (inscripcionesBasquetbol.isEmpty()) 
                            System.out.println("No hay jugadores inscritos en Básquetbol.");
                        else 
                            imprimirSet(inscripcionesBasquetbol);
                    }
                    case 3 -> {
                        System.out.println("\nJugadores inscritos en Voleibol:");
                        if (inscripcionesVoleibol.isEmpty())
                            System.out.println("No hay jugadores inscritos en Voleibol.");
                        else
                            imprimirSet(inscripcionesVoleibol);
                    }
                    
                }
                System.out.print("\n¿Desea ver los jugadores de otro deporte? (1-Sí / 2-No)"
                                    + "\n# opción: ");
                opcion = sc.nextInt();
                if (opcion == 1)
                    bandera = true; 
                
            }else if(opcion == 4){
                System.out.println("\nRegresando al menú principal...");
            }else{
                System.out.println("\nOpción no válida. Intente de nuevo.");
                bandera = true;
            } 
        } while (bandera);
}

    public static void contarJugadoresPorDeporte() {
        System.out.println("\nConteo de jugadores inscritos por deporte:");
        System.out.println("Fútbol: " + inscripcionesFutbol.size() + " jugadores.");
        System.out.println("Básquetbol: " + inscripcionesBasquetbol.size() + " jugadores.");
        System.out.println("Voleibol: " + inscripcionesVoleibol.size() + " jugadores.");
    }


    //Si un jugaodr está en ambos conjuntos, solo se muestra una vez---- revisar aun
    public static void fusionarEquipos() {

        Set<Jugador16> fusion = new TreeSet<>(); // Resultado final ordenado

        // Lista temporal para combinar todos los jugadores, ya que ArrayList permite duplicados
        List<Jugador16> todos = new ArrayList<>();
        todos.addAll(inscripcionesFutbol);
        todos.addAll(inscripcionesBasquetbol);
        todos.addAll(inscripcionesVoleibol);
        
        // Recorremos todos los jugadores de todos los deportes
        for (Jugador16 jugador : todos) {
            // Bandera para saber si ya existe un jugador con el mismo nombre
            boolean encontrado = false;

            // Buscamos si ya existe un jugador con el mismo nombre en el set de fusión, si es así, combinamos roles. 
            // en la primera iteración no entra a este for porque el set está vacío
            for (Jugador16 j : fusion) {
                // Si el nombre es el mismo (ignorando mayúsculas/minúsculas) agregamos los roles
                if (j.getNombre().equalsIgnoreCase(jugador.getNombre())) {
                    // Agregamos los roles del jugador actual al jugador ya existente en el set de fusión
                    for (String rol : jugador.roles) {
                        // Solo agregamos el rol si no está ya presente
                        if (!j.roles.contains(rol)) {
                            j.agregarRol(rol);
                        }
                    }
                    //Marcamos que se encontró un jugador con el mismo nombre y que se combinaron roles
                    encontrado = true;
                    break;
                }
            }

            // Si no se encontró, lo agregamos al set
            if (!encontrado) {
                fusion.add(jugador);
            }
        }

        // Mostramos el resultado
        System.out.println("\nJugadores en la fusión de todos los deportes (roles combinados):");
        if (fusion.isEmpty())
            System.out.println("No hay jugadores inscritos en ningún deporte.");
        else
            imprimirSet(fusion);
}



    //Muestra los jugadores que están en diferentes conjuntos
    public static void verJugadoresEnComun() {
        // Jugadores en común entre fútbol y básquetbol
        // Le paso un comparador para que ordene por nombre sin importar mayúsculas/minúsculas en forma de lambda
        Set<Jugador16> comunFB = new TreeSet<>((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        // Recorremos los jugadores de fútbol y básquetbol para encontrar coincidencias por nombre
        for (Jugador16 jF : inscripcionesFutbol) {
            for (Jugador16 jB : inscripcionesBasquetbol) {
                if (jF.getNombre().equalsIgnoreCase(jB.getNombre())) {
                    // Verificamos que no esté duplicado en comunFB con una bandera
                    boolean existe = false;
                    // Recorremos comunFB para ver si ya existe un jugador con el mismo nombre
                    // en la primera iteración no entra a este for porque el set está vacío
                    for (Jugador16 jC : comunFB) {
                        // Si ya existe un jugador con el mismo nombre, marcamos la bandera y salimos del for
                        if (jC.getNombre().equalsIgnoreCase(jF.getNombre())) {
                            existe = true;
                            break;
                        }
                    }
                    // Si no existe, lo agregamos a comunFB, en la primera iteración siempre se agrega
                    if (!existe) 
                        comunFB.add(jF);
                }
            }
        }

        System.out.println("\nJugadores en común entre fútbol y básquetbol:");
        // Si el set está vacío, indicamos que no hay jugadores en común
        if (comunFB.isEmpty())
            System.out.println("No hay jugadores en común entre fútbol y básquetbol.");
        else
            imprimirSet(comunFB);

        // Jugadores en común entre fútbol y voleibol
        // Segunda vez que uso un TreeSet con un comparador lambda para ordenar por nombre sin importar mayúsculas/minúsculas
        Set<Jugador16> comunFV = new TreeSet<>((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        // Recorremos los jugadores de fútbol y voleibol para encontrar coincidencias por nombre
        for (Jugador16 jF : inscripcionesFutbol) {
            for (Jugador16 jV : inscripcionesVoleibol) {
                if (jF.getNombre().equalsIgnoreCase(jV.getNombre())) {
                    // Recorremos comunFV para ver si ya existe un jugador con el mismo nombre con una bandera
                    // en la primera iteración no entra a este for porque el set está vacío
                    boolean existe = false;
                    for (Jugador16 jC : comunFV) {
                        // Si ya existe un jugador con el mismo nombre, marcamos la bandera y salimos del for
                        if (jC.getNombre().equalsIgnoreCase(jF.getNombre())) {
                            existe = true;
                            break;
                        }
                    }
                    // Si no existe, lo agregamos a comunFV, en la primera iteración siempre se agrega
                    if (!existe) comunFV.add(jF);
                }
            }
        }
        System.out.println("\nJugadores en común entre fútbol y voleibol:");
        if (comunFV.isEmpty())
            System.out.println("No hay jugadores en común entre fútbol y voleibol.");
        else
            imprimirSet(comunFV);

        // Jugadores en común entre básquetbol y voleibol
        Set<Jugador16> comunBV = new TreeSet<>((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        for (Jugador16 jB : inscripcionesBasquetbol) {
            for (Jugador16 jV : inscripcionesVoleibol) {
                if (jB.getNombre().equalsIgnoreCase(jV.getNombre())) {
                    boolean existe = false;
                    for (Jugador16 jC : comunBV) {
                        if (jC.getNombre().equalsIgnoreCase(jB.getNombre())) {
                            existe = true;
                            break;
                        }
                    }
                    if (!existe) comunBV.add(jB);
                }
            }
        }
        System.out.println("\nJugadores en común entre básquetbol y voleibol:");
        if (comunBV.isEmpty())
            System.out.println("No hay jugadores en común entre básquetbol y voleibol.");
        else
            imprimirSet(comunBV);

        // Jugadores en común en los tres deportes
        // Tercera vez que uso un TreeSet con un comparador lambda para ordenar por nombre sin importar mayúsculas/minúsculas
        Set<Jugador16> comunFBV = new TreeSet<>((a, b) -> a.getNombre().compareToIgnoreCase(b.getNombre()));
        // Recorremos los jugadores de fútbol, básquetbol y voleibol para encontrar coincidencias por nombre
        for (Jugador16 jF : inscripcionesFutbol) {
            for (Jugador16 jB : inscripcionesBasquetbol) {
                for (Jugador16 jV : inscripcionesVoleibol) {
                    // Si el nombre del jugador de fútbol coincide con el de básquetbol y voleibol
                    if (jF.getNombre().equalsIgnoreCase(jB.getNombre()) &&
                        jF.getNombre().equalsIgnoreCase(jV.getNombre())) {
                        // Recorremos comunFBV para ver si ya existe un jugador con el mismo nombre con una bandera
                        // en la primera iteración no entra a este for porque el set está vacío
                        boolean existe = false;
                        for (Jugador16 jC : comunFBV) {
                            if (jC.getNombre().equalsIgnoreCase(jF.getNombre())) {
                                // Si ya existe un jugador con el mismo nombre, marcamos la bandera y salimos del for
                                existe = true;
                                break;
                            }
                        }
                        //Si no existe, lo agregamos al set
                        if (!existe) comunFBV.add(jF);
                    }
                }
            }
        }
        System.out.println("\nJugadores en común entre los tres deportes:");
        if (comunFBV.isEmpty())
            System.out.println("No hay jugadores en común entre los tres deportes.");
        else
            imprimirSet(comunFBV);
}



    public static void transferirJugador() {
        // 1. Elegir deporte origen
        System.out.print("\nSeleccione el deporte de origen del jugador:\n"
                + "1. Fútbol\n"
                + "2. Básquetbol\n"
                + "3. Voleibol\n"
                + "# opción: ");
        int origenOpcion = sc.nextInt();

        Set<Jugador16> origen = getSetPorDeporte(origenOpcion);
        if (origen == null || origen.isEmpty()) {
            System.out.println("No hay jugadores inscritos en ese deporte.");
            return;
        }

        // 2. Mostrar jugadores ordenados por nombre
        List<Jugador16> listaOrdenada = new ArrayList<>(origen);
        listaOrdenada.sort(Comparator.comparing(Jugador16::getNombre, String.CASE_INSENSITIVE_ORDER));

        System.out.println("\nJugadores en " + nombreDeporte(origenOpcion) + ":");
        for (int i = 0; i < listaOrdenada.size(); i++) {
            System.out.println((i + 1) + ". " + listaOrdenada.get(i));
        }

        System.out.print("\nSeleccione el jugador a transferir (número): ");
        int indiceJugador = sc.nextInt() - 1;
        if (indiceJugador < 0 || indiceJugador >= listaOrdenada.size()) {
            System.out.println("Opción inválida.");
            return;
        }

        Jugador16 jugadorSeleccionado = listaOrdenada.get(indiceJugador);

        // 3. Mostrar opciones de destino (quitando el origen)
        System.out.println("\nSeleccione el deporte de destino:");
        if (origenOpcion != 1) System.out.println("1. Fútbol");
        if (origenOpcion != 2) System.out.println("2. Básquetbol");
        if (origenOpcion != 3) System.out.println("3. Voleibol");

        System.out.print("# opción: ");
        int destinoOpcion = sc.nextInt();
        if (destinoOpcion == origenOpcion || destinoOpcion < 1 || destinoOpcion > 3) {
            System.out.println("Opción inválida.");
            return;
        }

        Set<Jugador16> destino = getSetPorDeporte(destinoOpcion);

        // 4. Transferencia
        origen.remove(jugadorSeleccionado);
        destino.add(jugadorSeleccionado);

        System.out.println("\nJugador " + jugadorSeleccionado.getNombre()
                + " transferido de " + nombreDeporte(origenOpcion)
                + " a " + nombreDeporte(destinoOpcion) + ".");
    }
    private static String nombreDeporte(int opcion) {
    return switch (opcion) {
        case 1 -> "Fútbol";
        case 2 -> "Básquetbol";
        case 3 -> "Voleibol";
        default -> "Desconocido";
    };
}

    private static Set<Jugador16> getSetPorDeporte(int opcion){
        return switch(opcion){
            case 1 -> inscripcionesFutbol;
            case 2 -> inscripcionesBasquetbol;
            case 3 -> inscripcionesVoleibol;
            default -> null;
        };
    }

    public static void mostrarJugadores(){
        boolean bandera;
        do {
            bandera = false;
            System.out.print("\nSelecciona un orden:\n"
                            + "1. Mostrar jugadores sin orden.\n"
                            + "2. Mostrar jugadores por orden de inscripción.\n"
                            + "3. Mostrar jugadores ordenados por nombre.\n"
                            + "4. Mostrar jugadores por ID.\n"
                            + "5. Regresar al menu principal.\n"
                            + "# opcion:");
                            
            opcion = sc.nextInt();
            
            if (opcion >=1 && opcion <=4) {
                switch (opcion) {
                    case 1 -> mostrarJugadoresSinOrden();
                    case 2 -> mostrarJugadoresOrdenadosPorInscripcion();
                    case 3 -> mostrarJugadoresOrdenadosPorNombre();
                    case 4 -> mostrarRankingDeJugadoresPorID();
                }       
                System.out.print("\n¿Desea ver los jugadores en otro orden? (1-Sí / 2-No)"
                                    + "\n# opción: ");
                opcion = sc.nextInt();
                if (opcion == 1)
                    bandera = true;          
            } else if(opcion == 5 ) {
                        System.out.println("Regresando al menu principal..");
                    }else{
                            System.out.println("Opción invalida, Intente de nuevo.");
                            bandera = true;
                        }
        } while (bandera);

    }
    //Llamado por mostrarJugadores()
    public static void mostrarJugadoresSinOrden(){
        System.out.println();
        if (inscripcioneSinOrden.isEmpty()) {
            System.out.println("No hay jugadores inscritos.");
        } else {
            System.out.println("Jugadores inscritos hasta el momento:\n");
            imprimirSet(inscripcioneSinOrden);        
        }
    }
    //Llamado por mostrarJugadores()
    public static void mostrarJugadoresOrdenadosPorInscripcion() {
        mostrarInscripciones("Fútbol", inscripcionesFutbol);
        mostrarInscripciones("Básquetbol", inscripcionesBasquetbol);
        mostrarInscripciones("Voleibol", inscripcionesVoleibol);
    }
    
    //Llamado por mostrarJugadoresOrdenadosPorInscripcion
    private static void mostrarInscripciones(String deporte, Set<Jugador16> inscripciones) {
    System.out.println();
    if (inscripciones.isEmpty()) {
        System.out.println("No hay jugadores inscritos en " + deporte + ".");
    } else {
        System.out.println("Jugadores de " + deporte + ":\n");
        imprimirSet(inscripciones);
    }
}

    //Llamado por mostrarJugadores()
    public static void mostrarJugadoresOrdenadosPorNombre() {
        mostrarOrdenadosNombre("Fútbol", inscripcionesFutbol);
        mostrarOrdenadosNombre("Básquetbol", inscripcionesBasquetbol);
        mostrarOrdenadosNombre("Voleibol", inscripcionesVoleibol);
    }

    //Llamado por mostrarJugadoresOrdenadoPorNombre
    private static void mostrarOrdenadosNombre(String deporte, Set<Jugador16> inscripciones) {
    System.out.println();
    if (inscripciones.isEmpty()) {
        System.out.println("No hay jugadores inscritos en " + deporte + ".");
    } else {
        TreeSet<Jugador16> ordenados = new TreeSet<>();
        ordenados.addAll(inscripciones);
        System.out.println("Jugadores de " + deporte + ":\n");
        imprimirSet(ordenados);
    }
}
    //Llamado por mostrarJugadores()
    //Mostrar con el ID más pequeño al más grande
    public static void mostrarRankingDeJugadoresPorID() {
        mostrarOrdenadosId("Fútbol", inscripcionesFutbol);
        mostrarOrdenadosId("Básquetbol", inscripcionesBasquetbol);
        mostrarOrdenadosId("Voleibol", inscripcionesVoleibol);
    }

    //Llamado por mostrarRankingDeJufaoresPorId
    public static void mostrarOrdenadosId(String deporte, Set<Jugador16> inscripciones){
        System.out.println();
        if (inscripciones.isEmpty()) {
            System.out.println("No hay jugadores inscritos en " + deporte + ".");
        } else {
            TreeSet<Jugador16> ordenados = new TreeSet<>(Comparator.comparingInt(j -> j.idJugador));
            ordenados.addAll(inscripciones);
            System.out.println("Jugadores de " + deporte + "por ID" + ":\n");
            imprimirSet(ordenados);
        }
    }
    public static void buscarJugadorPorDisciplina() {
        System.out.println("\nSeleccione el deporte para buscar al jugador:");
        System.out.println("1. Fútbol");
        System.out.println("2. Básquetbol");
        System.out.println("3. Voleibol");
        System.out.print("# opción: ");
        int opcionDeporte = sc.nextInt();

        Set<Jugador16> disciplina = getSetPorDeporte(opcionDeporte);
        String nombreDeporte = nombreDeporte(opcionDeporte);

        if (disciplina == null || disciplina.isEmpty()) {
            System.out.println("No hay jugadores inscritos en " + nombreDeporte + ".");
            return;
        }

        sc.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el nombre del jugador a buscar: ");
        String nombreBuscado = sc.nextLine().trim();

        boolean encontrado = false;
        for (Jugador16 jugador : disciplina) {
            if (jugador.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("\nJugador encontrado en " + nombreDeporte + ":");
                System.out.println(jugador);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún jugador con el nombre \"" + nombreBuscado + "\" en " + nombreDeporte + ".");
        }
    }
    
    public static void eliminarJugadorPorDisciplina() {
        System.out.println("\nSeleccione el deporte del jugador a eliminar:");
        System.out.println("1. Fútbol");
        System.out.println("2. Básquetbol");
        System.out.println("3. Voleibol");
        System.out.print("# opción: ");
        int opcionDeporte = sc.nextInt();

        Set<Jugador16> disciplina = getSetPorDeporte(opcionDeporte);
        String nombreDeporte = nombreDeporte(opcionDeporte);

        if (disciplina == null || disciplina.isEmpty()) {
            System.out.println("No hay jugadores inscritos en " + nombreDeporte + ".");
            return;
        }

        // Mostrar jugadores en la disciplina
        System.out.println("\nJugadores inscritos en " + nombreDeporte + ":");
        imprimirSet(disciplina);

        sc.nextLine(); // Limpiar buffer
        System.out.print("\nIngrese el nombre del jugador a eliminar: ");
        String nombreEliminar = sc.nextLine().trim();

        Jugador16 jugadorAEliminar = null;

        for (Jugador16 jugador : disciplina) {
            if (jugador.getNombre().equalsIgnoreCase(nombreEliminar)) {
                jugadorAEliminar = jugador;
                break;
            }
        }

        if (jugadorAEliminar != null) {
            disciplina.remove(jugadorAEliminar);
            System.out.println("\nJugador \"" + jugadorAEliminar.getNombre() + "\" eliminado de " + nombreDeporte + ".");
        } else {
            System.out.println("No se encontró ningún jugador con el nombre \"" + nombreEliminar + "\" en " + nombreDeporte + ".");
        }
    }
}
