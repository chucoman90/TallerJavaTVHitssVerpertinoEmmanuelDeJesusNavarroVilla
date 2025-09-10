package ejercicios;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Archivos12 {
    public static void main(String[] args) {
        //No reconocía el archivo en la raiz donde tennía el codigo, tuve que poner la ruta tal cual.
        Path ruta = Paths.get("C:\\Users\\Emma\\Documents\\VisualStudioCodeProjectsJava\\ejercicios\\usuarios.txt");

        try {
            // Leer todas las líneas del archivo en una lista
            List<String> lineas = Files.readAllLines(ruta);

            for (String linea : lineas) {
                try {
                    String nombre = linea.strip();
                    validarNombre(nombre);
                    System.out.println("Usuario válido: " + nombre);
                } catch (NombreInvalidoException12 e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
        } catch (NoSuchFileException e) {
            System.out.println("El archivo no existe: " + ruta.toAbsolutePath());
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
        }
    }

    // Método de validación
    public static void validarNombre(String nombre) throws NombreInvalidoException12 {
        if (nombre.length() < 3) {
            throw new NombreInvalidoException12(
                "El nombre '" + nombre + "' es inválido (no cumple con al menos 3 caracteres)."
            );
        }
    }
}
