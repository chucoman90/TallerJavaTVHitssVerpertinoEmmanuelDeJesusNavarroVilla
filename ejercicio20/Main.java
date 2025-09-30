package ejercicios.ejercicio20;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        IConteoPalabras palabraMasRepetida = frase -> {
            Map<String, Integer> conteoPalabra = new HashMap<>();
            // Covierto la frase en minusculas y la separo en un array, donde cada palabra es un elemento. suponeindo que la frase original venga separa por espacios.
            String[] palabras = frase.toLowerCase().split(" ");

            // Cuento cada palabra en el array.
            for (String palabra : palabras) {
                //Sumo 1 o actualizo el valor cada vez que coincida la clave o palabra que se repita. si no se repite regreso cero como valor.
                conteoPalabra.put(palabra, conteoPalabra.getOrDefault(palabra, 0) + 1);
            }

            // Busco la palabra que se repite
            String palabraRepetida = null;
            int conteoRepeticiones = 0;
            for (Map.Entry<String, Integer> palabra : conteoPalabra.entrySet()) {
                var repeticiones = palabra.getValue();
                if (repeticiones > conteoRepeticiones) {
                    conteoRepeticiones = repeticiones;
                    palabraRepetida = palabra.getKey();
                }
            }

            // Devolver solo la palabra más repetida
            return Map.of(palabraRepetida, conteoRepeticiones);
        };

        String frase = "michi firulais michi perro perro michi gato firulais perro perro";
        Map<String, Integer> resultado = palabraMasRepetida.contarPalabra(frase);
        
        
        System.out.println("Frase:" + frase);

        // Iterar el Map con un lambda
        resultado.forEach((palabra, cantidad) ->
            System.out.println("Palabra: " + palabra + " - Repeticiones: " + cantidad));


        String palabra = resultado.keySet().iterator().next();
        System.out.println("Con get(): " + palabra + " - " + resultado.get(palabra));
    }
}

