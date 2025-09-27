package ejercicios;


import java.util.ArrayList;
import java.util.List;

public abstract class Jugador16 implements Comparable<Jugador16> {
    protected int idJugador;
    protected String nombre;
    protected List<String> roles; 
    

    public Jugador16(int idJugador, String nombre , String rol) {
        this.idJugador = idJugador;
        this.nombre = nombre;
        roles = new ArrayList<>();
        roles.add(rol);
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdJugador() {
        return idJugador;
    }
    public void agregarRol(String rol) {
        roles.add(rol);
    }

    public String obtenerRoles() {
        return String.join(", ", roles);
    }

    public abstract void jugar();

    @Override
    public String toString() {
        return "{idJugador: " + idJugador + ", nombre: " + nombre + ", rol: "+ obtenerRoles() +"}";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + idJugador;
        result = prime * result + ((nombre == null) ? 0 : nombre.toLowerCase().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Jugador16 other = (Jugador16) obj;
        if (idJugador != other.idJugador)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equalsIgnoreCase(other.nombre))
            return false;
        return true;
    }

    @Override
    public int compareTo(Jugador16 o) {
        var result = this.nombre.compareToIgnoreCase(o.nombre);
        if(result == 0){
            result = Integer.compare(this.idJugador, o.idJugador);
        }
        return result; 
    }
}