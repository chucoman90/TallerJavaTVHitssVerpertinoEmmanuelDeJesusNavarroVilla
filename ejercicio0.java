package ejercicios;
import java.util.Scanner;

public class ejercicio0 {
    public static void main(String[] args) {
        
        //! Declaración de variables
        String nombre1,nombre2,nombre3,resultNombres;
        Scanner sc = new Scanner(System.in);
        
        //! Entrada de datos del usuario
        System.out.print("Introduce el primer nombre:");
        nombre1 = sc.nextLine();
        System.out.print("Introduce el segundo nombre:");
        nombre2 = sc.nextLine();
        System.out.print("Introduce el tercer nombre:");
        nombre3 = sc.nextLine();
        
        //! Por cada nombre accedo al segundo carácter, lo convierto a mayúscula y concateno con los dos últimos caracteres del nombre
        resultNombres = Character.toUpperCase(nombre1.charAt(1)) + "." + nombre1.substring(nombre1.length()-2) + "_" +
                        Character.toUpperCase(nombre2.charAt(1)) + "." + nombre2.substring(nombre2.length()-2) + "_" +
                        Character.toUpperCase(nombre3.charAt(1)) + "." + nombre3.substring(nombre3.length()-2);
        
        System.out.println("Los nombres modificados son: " + resultNombres);
        sc.close();
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    
    
}
