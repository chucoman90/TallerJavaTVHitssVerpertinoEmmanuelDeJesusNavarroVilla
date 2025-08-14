package ejercicios;
import java.util.Scanner;
//! Autor: [EMMANUEL DE JESUS NAVARRO VILLA]
public class ejercicio1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el primer número: ");
        int a = sc.nextInt();
        System.out.print("Ingrese el segundo número: ");
        int b = sc.nextInt();

        int resultado = multiplicar(a, b);
        System.out.println("El resultado de la multiplicación es: " + resultado);
        sc.close();
    }


    public static int multiplicar(int a, int b) {
        int resultado = 0;
        //! signos
        int signoA = Integer.signum(a);
        int signoB = Integer.signum(b);

        int absA = Math.abs(a);
        int absB = Math.abs(b);

        for (int i = 0; i < absB; i++) {
            resultado += absA;
        }
        
        resultado *= signoA * signoB;
 

        return resultado;
    }

   
}
