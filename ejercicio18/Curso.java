import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


public class Curso {
    private String nombre;
    private Profesor profesor;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Set<Estudiante> estudiantes = new HashSet<>();

    public Curso(String nombre, Profesor profesor, LocalDate fechaInicio, LocalDate fechaFin) {
        this.nombre = nombre;
        this.profesor = profesor;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        //agrego en automatico el curso a la lista de cursos del profesor cuando un curso es dado de alta por el sistema.
        profesor.agregarCurso(this);
    }

    public String getNombre() { return nombre; }
    public Profesor getProfesor() { return profesor; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaFin() { return fechaFin; }
    public Set<Estudiante> getEstudiantes() { return estudiantes; }

    public boolean estaActivoEn(LocalDate fecha) {
        return (fecha.isEqual(fechaInicio) || fecha.isAfter(fechaInicio)) &&
            (fecha.isEqual(fechaFin) || fecha.isBefore(fechaFin));
    }

    public boolean seSolapa(Curso otro) {
        return !(fechaFin.isBefore(otro.fechaInicio) || fechaInicio.isAfter(otro.fechaFin));
    }

    @Override
    public String toString() {
        return "{nombre: " + nombre + ", fecha: " + fechaInicio + " - " + fechaFin + "}";
    }
}


