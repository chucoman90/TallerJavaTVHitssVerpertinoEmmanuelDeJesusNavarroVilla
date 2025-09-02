package ejercicios;

public class EjemploMamiferos10 {
    public static void main(String[] args) {

        Mamifero10[] mamiferos = new Mamifero10[5];
        
        
        mamiferos[0] = new Tigre10("Selva", 3, 3, 250, "Panthera tigris", 20, 60, "Bengala");
        mamiferos[1] = new Leon10("Sabana Africa", 2, 2, 250, "Panthera leo", 20, 50, 3, 5); 
        mamiferos[2] = new Guepardo10("Sabana Africa", 2, 3, 150, "Acinonyx jubatus", 3, 150);
        mamiferos[3] = new Lobo10("Bosque", 1, 1, 120, "Canis lupus", "Gris", 3, 100, "Mexicano");
        mamiferos[4] = new Perro10("Hogar Humano", 1, 1, 30, "Canis lupus familiaris", "Negro", 2, 3); 
        
        for (Mamifero10 mamifero : mamiferos) {
            System.out.println(mamifero);
        }
    }
}
