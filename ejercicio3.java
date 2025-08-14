package ejercicios;
import java.util.Scanner;

//! Autor: [EMMANUEL DE JESUS NAVARRO VILLA]
public class ejercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        double sumAprobadas = 0, sumReprobadas = 0, sumTotal = 0;
        int countAprobadas = 0, countReprobadas = 0, countUno = 0;

        while (count < 20) {
            System.out.print("Ingrese la calificación #" + (count + 1) + "(1.0 - 10.0): ");
            double calificacion = sc.nextDouble();

            if (calificacion < 1.0 || calificacion > 10.0) {
                System.out.println("Error: Calificación fuera de rango. Programa finalizado.");
                break;
            }

            sumTotal += calificacion;

            if (calificacion >= 6.0) {
                sumAprobadas += calificacion;
                countAprobadas++;
            } else {
                sumReprobadas += calificacion;
                countReprobadas++;
            }

            if (calificacion == 1.0) {
                countUno++;
            }

            count++;
        }// Fin del bucle

        if (count == 0) {
            System.out.println("No se ingresaron calificaciones válidas.");
        } else {
            if (countAprobadas > 0)
                System.out.println("Promedio de calificaciones >= 6: " + (sumAprobadas / countAprobadas));
            else
                System.out.println("No hay calificaciones mayores o iguales a 6.");

            if (countReprobadas > 0)
                System.out.println("Promedio de calificaciones < 6: " + (sumReprobadas / countReprobadas));
            else
                System.out.println("No hay calificaciones menores a 6.");

            System.out.println("Cantidad de notas iguales a 1: " + countUno);
            System.out.println("Promedio total: " + (sumTotal / count));
        }
        sc.close();
    }
}
