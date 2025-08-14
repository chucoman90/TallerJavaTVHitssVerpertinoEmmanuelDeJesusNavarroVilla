package ejercicios;
import java.util.Scanner;

//! Autor: [EMMANUEL DE JESUS NAVARRO VILLA]

public class ejercicio2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int num1 = 0, num2 = 0, num3 = 0, num4 = 0, num5 = 0, num6 = 0, num7 = 0, num8 = 0, num9 = 0, num10 = 0, menor;

        for (int i = 1; i <= 10; i++) {

            System.out.print("Ingrese el valor para la variable " + i + ": ");
            
            int valor = sc.nextInt();
            
            switch (i) {
                case 1 -> num1 = valor;
                case 2 -> num2 = valor;
                case 3 -> num3 = valor;
                case 4 -> num4 = valor;
                case 5 -> num5 = valor;
                case 6 -> num6 = valor;
                case 7 -> num7 = valor;
                case 8 -> num8 = valor;
                case 9 -> num9 = valor;
                case 10 -> num10 = valor;
            }
        }

        /*
         *  Encontrar el menor de los 10 números, tomo el primero como base o pivote.
         *  sustituyo el valor de variable menor si y solo si encuentro uno menor a el.
         */
        menor = num1;
        menor = Math.min(menor, num2);
        menor = Math.min(menor, num3);
        menor = Math.min(menor, num4);
        menor = Math.min(menor, num5);
        menor = Math.min(menor, num6);
        menor = Math.min(menor, num7);
        menor = Math.min(menor, num8);
        menor = Math.min(menor, num9);
        menor = Math.min(menor, num10);


        if (menor < 10) {
            System.out.println("El número menor es menor que 10!");    
        } else {
            System.out.println("El número menor es igual o mayor que 10!");    
        }
        
        sc.close();

    }
}
