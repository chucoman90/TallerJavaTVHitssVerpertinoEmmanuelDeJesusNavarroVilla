package ejercicios;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Libro11 extends Producto11 implements ILibro11 {
    
    private LocalDateTime fechaPublicacion;
    private String autor;
    private String titulo;
    private String editorial;

    protected DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
    
    public Libro11(int precio, LocalDateTime fechaPublicacion, String autor, String titulo, String editorial) {
        super(precio);
        this.fechaPublicacion = fechaPublicacion;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
    }

    @Override
    public double getPrecioVenta() {
        
        return (getPrecio() * 0.15) + getPrecio();
    }

    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public String getEditorial() {
        return editorial;
    }

    @Override
    public LocalDateTime getFechaPublicacion() {
        return fechaPublicacion;
    }

    @Override
    public String getTitulo() {
        return titulo;
    }

    @Override
    public String toString() {
        return "Libro {fechaPublicacion: " + fechaPublicacion.format(formato) + ", autor: " + autor + ", titulo: " + titulo
                + ", editorial: " + editorial + ", precio: " + getPrecio() + ", PrecioVenta: " + getPrecioVenta()
                + "}";
    }

    
}
