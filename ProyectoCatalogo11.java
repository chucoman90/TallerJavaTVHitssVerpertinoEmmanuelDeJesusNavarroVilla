package ejercicios;

import java.time.LocalDateTime;

public class ProyectoCatalogo11 {
    public static void main(String[] args) {
        
        IProducto11 productos [] = new IProducto11[4];

        productos[0] = new Iphone11(700, "Apple", "Iphone 11 Pro", "Negro");
        productos[1] = new TvLcd11(400, "Samsung", 55   );
        productos[2] = new Libro11(20,LocalDateTime.now(), "Gabriel Garcia Marquez", "Cien Años de Soledad", "Editorial Sudamericana");
        productos[3] = new Comics11(15, LocalDateTime.now(), "Stan Lee", "Spiderman", "Marvel Comics", "Spiderman");
        
        for (IProducto11 producto : productos) {
            System.out.println(producto+"\n");
        }
    }
}
