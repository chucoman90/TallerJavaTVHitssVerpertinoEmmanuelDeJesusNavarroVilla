import java.util.HashSet;
import java.util.Set;

public class Estudiante {
    private final String id;
    private String nombre;
    private Set<Curso> cursos = new HashSet<>();

    public Estudiante(String id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }
    public Set<Curso> getCursos() { return cursos;}

    void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    boolean retirarCurso(Curso curso) {
        return cursos.remove(curso);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
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
        Estudiante other = (Estudiante) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Estudiante {id: " + id + ", nombre: " + nombre + ", cursos: " + cursos + "}";
    }
}

