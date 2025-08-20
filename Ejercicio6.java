import java.util.Scanner;

public class Main{

    public static void main (String[] args) {
      
       Scanner sc = new Scanner(System.in);
       String [][] matriz;
       int n;
       
       System.out.print("Ingresa n > 0: ");
       n = sc.nextInt();
       
       if (n <= 0)
            System.exit(0);
        
        
       System.out.printf("\nCreando matriz %d x %d:\n",n,n);
       matriz = new String [n][n];
       
       
       // Llenar con "_" matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = "_";
            }
        }
       
        // Poner X en las diagonales
        for (int i = 0; i < n; i++) {
            //
            matriz[i][i] = "X";
            matriz[i][n - 1 - i] = "X";
        }

        // Imprimir la matriz
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    
    }



}