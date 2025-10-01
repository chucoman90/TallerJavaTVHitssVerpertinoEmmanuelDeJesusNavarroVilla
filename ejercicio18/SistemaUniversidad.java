import java.time.LocalDate;
import java.util.*;

public class SistemaUniversidad {
    private Map<String, Curso> cursos = new HashMap<>();

    public void agregarCurso(Curso curso) {
        cursos.put(curso.getNombre(), curso);
    }

    public boolean inscribirEstudiante(Estudiante estudiante, String nombreCurso) {
        Curso curso = cursos.get(nombreCurso);
        if (curso == null) return false;

        // Si ya está inscrito en ese curso
        if (curso.getEstudiantes().contains(estudiante)) return false;

        // verificar solapamientos usando los cursos que ya tiene el estudiante
        for (Curso c : estudiante.getCursos()) {
            if (c.seSolapa(curso)) {
                System.out.println("Conflicto: " + nombreCurso + " se solapa con " + c.getNombre());
                return false;
            }
        }

        // Añadir en ambas colecciones (curso -> estudiantes) y (estudiante -> cursos)
        //Esto porque un curso puede tener cero o muchos estudiantes
        //Y cada estudiante puede tener una lista de cursos.
        curso.getEstudiantes().add(estudiante);
        estudiante.agregarCurso(curso);
        return true;
    }

    public boolean retirarEstudiante(Estudiante estudiante, String nombreCurso) {
        Curso curso = cursos.get(nombreCurso);
        if (curso == null) return false;

        boolean eliminadoDelCurso = curso.getEstudiantes().remove(estudiante);
        boolean eliminadoDelEstudiante = estudiante.retirarCurso(curso);
        return eliminadoDelCurso || eliminadoDelEstudiante;
    }

    public Set<Curso> cursosDeEstudiante(Estudiante estudiante) {
        return estudiante.getCursos();
    }

    public Set<Curso> cursosDeProfesor(Profesor profesor) {
        return profesor.getCursos();
    }

    public Set<Curso> cursosActivosEn(LocalDate fecha) {
        Set<Curso> resultado = new HashSet<>();
        for (Curso c : cursos.values()) {
            if (c.estaActivoEn(fecha)) {
                resultado.add(c);
            }
        }
        return resultado;
    }

    public Curso obtenerCursoPorNombre(String nombre) {
        return cursos.get(nombre);
    }

    public Map<String, Curso> getCursos() {
        return cursos;
    }
    
    @Override
    public String toString() {
        return "SistemaUniversidad {cursos: " + cursos + "}";
    }


    
}


