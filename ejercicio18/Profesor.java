import java.util.HashSet;
import java.util.Set;

public class Profesor {
    private String nombre;
    private Set<Curso> cursos = new HashSet<>();

    public Profesor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public Set<Curso> getCursos() { return cursos; }

    void agregarCurso(Curso c) {
        cursos.add(c);
    }

    @Override
    public String toString() {
        return "Profesor {nombre: " + nombre + ", cursos: " + cursos + "}";
    }

    
}

