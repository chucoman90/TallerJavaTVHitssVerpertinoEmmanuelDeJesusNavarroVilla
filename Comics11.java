package ejercicios;
import java.time.LocalDateTime;


public class Comics11 extends Libro11 {
    
    private String personaje;

    public Comics11(int precio, LocalDateTime fechaPublicacion, String autor, String titulo, String editorial,
            String personaje) {
        super(precio, fechaPublicacion, autor, titulo, editorial);
        this.personaje = personaje;
    }

    @Override
    public double getPrecioVenta() {
        return (getPrecio() * 0.25) + getPrecio();
    }

    public String getPersonaje() {
        return personaje;
    }

    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }

    @Override
    public String toString() {
        return "Comic {personaje: " + personaje + ", precio: " + getPrecio() + ", PrecioVenta: "
                + getPrecioVenta() + ", autor: " + getAutor() + ", editorial: " + getEditorial()
                + ", fechaPublicacion: " + getFechaPublicacion().format(formato) + ", titulo: " + getTitulo() + "}";
    }
}
