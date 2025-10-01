import java.time.LocalDate;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Crear sistema universitario
        SistemaUniversidad uni = new SistemaUniversidad();

        // Crear profesores
        Profesor prof1 = new Profesor("Dr. García");
        Profesor prof2 = new Profesor("Dra. Martínez");

        // Crear estudiantes
        Estudiante est1 = new Estudiante("001", "Emmanuel Villa");
        Estudiante est2 = new Estudiante("002", "Alberto López");

        // Crear cursos
        Curso cursoProgramacion = new Curso("Programación", prof1,
                LocalDate.of(2025, 1, 10),
                LocalDate.of(2025, 3, 10));

        Curso cursoBaseDatos = new Curso("Bases de Datos", prof1,
                LocalDate.of(2025, 2, 1),
                LocalDate.of(2025, 4, 1));

        Curso cursoCalculoVectorial = new Curso("Calculo Vectorial", prof2,
                LocalDate.of(2025, 3, 15),
                LocalDate.of(2025, 5, 15));

        // Agregar cursos al sistema
        uni.agregarCurso(cursoProgramacion);
        uni.agregarCurso(cursoBaseDatos);
        uni.agregarCurso(cursoCalculoVectorial);

        //Cursos de alta  for (Map.Entry<String, Integer> palabra : conteoPalabra.entrySet())
        System.out.println("\nCursos activos en el sistema:\n");
        for (Map.Entry<String,Curso> curso : uni.getCursos().entrySet()) {
            System.out.println(curso.getValue());
        }

        // Inscribir estudiantes a cursos
        System.out.println("\nInscribir Emmanuel en Programación.");
        if(uni.inscribirEstudiante(est1, "Programación"))
            System.out.println("Inscripción exitosa.");

        System.out.println("\nIntentar inscribir Emmanuel en Bases de Datos (conflicto de fechas):");
        if(uni.inscribirEstudiante(est1, "Bases de Datos") == false)
            System.out.println("Inscripción no exitosa.");

        System.out.println("\nInscribir Emmanuel en Calculo Vectorial (sin conflicto).");
        if(uni.inscribirEstudiante(est1, "Calculo Vectorial"))
            System.out.println("Inscripción exitosa.");

        System.out.println("\nInscribir Alberto en Bases de Datos");
        if(uni.inscribirEstudiante(est2, "Bases de Datos"))
            System.out.println("Inscripción exitosa.");

        // Listar cursos de un estudiante
        System.out.println("\nCursos de Emmanuel:");
        for (Curso c : est1.getCursos()) {
            System.out.println(c);
        }

        System.out.println("\nCursos de Alberto:");
        for (Curso c : est2.getCursos()) {
            System.out.println(c);
        }

        // Listar cursos de un profesor
        System.out.println("\nCursos del profesor García:");
        for (Curso c : prof1.getCursos()) {
            System.out.println(c);
        }
        System.out.println("\nCursos del profesor Mátinez:");
        for (Curso c : prof2.getCursos()) {
            System.out.println(c);
        }
        //Listar cursos activos en una fecha determinada
        System.out.println("\nCursos activos el 15/02/2025:");
        for (Curso c : uni.cursosActivosEn(LocalDate.of(2025, 2, 15))) {
            System.out.println(c);
        }

        // Retirar estudiante
        System.out.println("\nRetirar Emmanuel de Calculo Vectorial.");
        uni.retirarEstudiante(est1, "Calculo Vectorial");

        System.out.println("\nCursos de Emmanuel después de retirar Calculo Vectorial:");
        for (Curso c : est1.getCursos()) {
            System.out.println(c);
        }
    }
}


