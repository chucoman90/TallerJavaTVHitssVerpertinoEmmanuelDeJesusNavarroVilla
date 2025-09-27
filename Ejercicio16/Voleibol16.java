package ejercicios;

public class Voleibol16 extends Jugador16 {
    
    
    public Voleibol16(int idJugador, String nombre, String rol) {
        super(idJugador, nombre, rol);
    }

    @Override
    public void jugar() {
        System.out.println("El jugador de voleibol " + nombre + " está jugando un partido.");
    }
}
