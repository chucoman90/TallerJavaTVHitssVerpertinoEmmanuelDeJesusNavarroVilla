package ejercicios.ejercicio19;

public class Main {
    public static void main(String[] args) {
        ITransformador transformador = cadena ->
            cadena.replaceAll("[ ,.]", "").toUpperCase();

        String cadena = "Hola, mundo. Bienvenido al tema programacion funcional.";

        System.out.println(transformador.transformar(cadena));
    }
}
