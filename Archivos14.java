package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Archivos14 {

    public static void crearDirectorio(String nombreDirectorio) {
        
        // Ruta actual del programa en ejecucion.
        //Convierto la ruta relativa en absoluta
        Path rutaActual = Paths.get("").toAbsolutePath();

        // Combina la ruta actual con el nombre del nuevo directorio
        Path rutaDirectorio = rutaActual.resolve(nombreDirectorio);

        try {
            // Crea el directorio (y todos los intermedios si es necesario)
            Files.createDirectories(rutaDirectorio);
            System.out.println("Directorio creado en: " + rutaDirectorio);
        } catch (IOException e) {
            System.out.println("Error al crear el directorio.");
        }
    }

    public static void guardarArchivo(Factura14 factura, String nombreArchivo, String nombreDirectorio) {
        
        // Ruta actual del programa en ejecucion.
        //Convierto la ruta relativa en absoluta
        Path rutaActual = Paths.get("").toAbsolutePath();

        // Combina la ruta actual con el nombre del nuevo directorio
        Path rutaDirectorio = rutaActual.resolve(nombreDirectorio);
        // Combina la ruta del directorio con el nombre del archivo
        Path rutaArchivo = rutaDirectorio.resolve(nombreArchivo);

        try {
            // Crea el directorio (y todos los intermedios si es necesario)
            Files.writeString(rutaArchivo, factura.generarReporte());
            System.out.println("Factura guardada con éxito, en: " + rutaArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar la factura.");
        }
    }

    public static void leerArchivo(String nombreArchivo, String nombreDirectorio) {
        // Ruta actual del programa en ejecucion.
        //Convierto la ruta relativa en absoluta
        Path rutaActual = Paths.get("").toAbsolutePath();

        // Combina la ruta actual con el nombre del nuevo directorio
        Path rutaArchivo = rutaActual.resolve(nombreDirectorio).resolve(nombreArchivo);

        try {
            //Lee el contenido del archivo
            var factura = Files.readString(rutaArchivo);
            System.out.println("\n"+factura);
        } catch (IOException e) {
            System.out.println("Error al leer archivo de la factura.");
        }
    }   

    public static void listarArchivos(String nombreDirectorio) {
        // Ruta actual del programa en ejecucion.
        //Convierto la ruta relativa en absoluta
        Path rutaActual = Paths.get("").toAbsolutePath();

        // Combina la ruta actual con el nombre del nuevo directorio
        Path rutaDirectorio = rutaActual.resolve(nombreDirectorio);

        try {
            System.out.println("Archivos en directorio " + nombreDirectorio + ":");
            // Lista los archivos en el directorio
            Files.list(rutaDirectorio).forEach(ruta -> System.out.println(ruta.getFileName()));
        } catch (IOException e) {
            System.out.println("Error al listar archivos en el directorio.");
        }
    }
}
