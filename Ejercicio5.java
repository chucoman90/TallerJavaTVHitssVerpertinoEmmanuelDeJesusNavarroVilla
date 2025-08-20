package ejercicios;
import java.util.Scanner;
import java.util.Arrays;

public class Ejercicio5{
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] numeros = new int [10];
        int [] concurrencia = new int [10];
        int valor, numero = 0;

        //Llenar el array con validación
        for (int i = 0; i < numeros.length; i++) {
            
            do {
                System.out.print("Ingresa un número entre 1 y 9: ");
                valor = sc.nextInt();
                
                if (valor < 1 || valor > 9) {
                    System.out.println("Error: número fuera de rango. Ingresa numero valido.");
                }
                
            } while (valor < 1 || valor > 9);
            
            numeros[i] = valor;
        }
        
        //Conteo de las veces que aparece x numero
        for(int num : numeros){
            concurrencia[num]++;
        }
        
        //Obtengo el numero que tiene mayor recurrencia
        for(int i = 1; i < concurrencia.length; i++){
            if(concurrencia[i] > numero){
                numero = i;
            }
            
        }
        
        Arrays.sort(numeros);
        
        System.out.println(Arrays.toString(numeros));
        System.out.printf("El numero que tiene mayor recurrencia es el %d\n",numero);
        System.out.printf("Y aparece %d veces", concurrencia[numero]);
        sc.close();
    }
    
    
}