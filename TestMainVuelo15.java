package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class TestMainVuelo15 {
    public static void main(String[] args) {
        ArrayList<Vuelo15> lista = leerVuelosArchivo("vuelos.csv");
        System.out.println("\nVuelos leidos del archivo:");
        lista.forEach(System.out::println);

        System.out.println("\n\nOrdenados por fecha y hora de llegada (ascendente):\n");
        ordenarPorLlegadaAscendente(lista);
        lista.forEach(System.out::println);

        System.out.println("\n\nUltimo vuelo en llegar:");
        System.out.println(obtenerUltimoVuelo(lista));

        System.out.println("\n\nVuelo con mayor numero de pasajeros:");
        System.out.println(obtenerVueloConMayorNumPasajeros(lista));     
    }


    public static ArrayList<Vuelo15> leerVuelosArchivo(String nombreArchivo) {

        ArrayList<Vuelo15> vuelos = new ArrayList<>();
        List<String> lineas = new ArrayList<>();
        // Ruta actual del programa en ejecucion.
        //Convierto la ruta relativa en absoluta
        Path rutaArchivo = Paths.get("ejercicios").toAbsolutePath().resolve(nombreArchivo);

        //DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("EEE dd MMM yyyy", Locale.getDefault());
        DateTimeFormatter formatoFecha = new DateTimeFormatterBuilder()
                .parseCaseInsensitive()  // ignora mayúsculas/minúsculas
                .parseLenient()          // más flexible para abreviaturas, no considera posibles errores menores
                .appendPattern("EEE dd MMM yyyy")
                .toFormatter(Locale.of("es", "MX"));
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");

        try {
            lineas = Files.readAllLines(rutaArchivo);
            for (int i = 1; i < lineas.size(); i++) { // saltamos encabezado
                String[] columnaVuelo = lineas.get(i).split(",");

                String vuelo = columnaVuelo[0];
                String origen = columnaVuelo[1];
                String destino = columnaVuelo[2];
                LocalDate fechaLlegada = LocalDate.parse(columnaVuelo[3], formatoFecha);
                LocalTime horaLlegada = LocalTime.parse(columnaVuelo[4].replace(" hrs", ""), formatoHora);
                int numPasajeros = Integer.parseInt(columnaVuelo[5]);

                vuelos.add(new Vuelo15(vuelo, origen, destino, fechaLlegada, horaLlegada, numPasajeros));
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
            return null;
        }

        return vuelos;
    }

    public static void ordenarPorLlegadaAscendente(List<Vuelo15> vuelos) {
        vuelos.sort(Comparator.comparing(Vuelo15::fechaLlegada).thenComparing(Vuelo15::horaLlegada));
    }

    public static Vuelo15 obtenerUltimoVuelo(List<Vuelo15> vuelos) {
        return Collections.max(vuelos,Comparator.comparing(Vuelo15::fechaLlegada).thenComparing(Vuelo15::horaLlegada));
    }

    public static Vuelo15 obtenerVueloConMayorNumPasajeros(List<Vuelo15> vuelos) {
        return Collections.max(vuelos, Comparator.comparingInt(Vuelo15::numPasajeros));
    }


}

