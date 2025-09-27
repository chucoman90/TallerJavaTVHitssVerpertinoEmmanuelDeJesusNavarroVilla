package ejercicios;

public class Basquetbol16 extends Jugador16 {
    
    public Basquetbol16(int idJugador, String nombre, String rol) {
        super(idJugador, nombre, rol);
    }

    @Override
    public void jugar() {
        System.out.println("El jugador de básquetbol " + nombre + " está jugando un partido.");
    }
    
}
