package ejercicios;

public class Futbol16 extends Jugador16 {
    

    public Futbol16(int idJugador, String nombre, String rol) {
        super(idJugador, nombre, rol);
        
    }

    @Override
    public void jugar() {
        System.out.println("El jugador de fútbol " + nombre + " está jugando un partido.");
    }
    
}
