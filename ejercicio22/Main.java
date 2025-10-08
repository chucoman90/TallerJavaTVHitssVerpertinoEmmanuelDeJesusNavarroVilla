package ejercicios.ejercicio22;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        RecursosHumanosService service;
        List<Empleado> empleados;

        //Creo lista que almacena a los diferentes empleados
        empleados = new ArrayList<>();

        //Creo objetos empleados
        Empleado emp1 = new Empleado(1, "Anabel", "IT", 60000, 6);
        Empleado emp2 = new Empleado(2, "Pablo", "IT", 45000, 4);
        Empleado emp3 = new Empleado(3, "Abigail", "Diseño", 55000, 8);
        Empleado emp4 = new Empleado(4, "Nicolas", "Marketing", 7500, 10);
        Empleado emp5 = new Empleado(5, "alberto", "IT", 52000, 7);
        
        //Creo objetos Evaluacion para los empleados
        Evaluacion ev1 = new Evaluacion(2025, 95);
        Evaluacion ev2 = new Evaluacion(2024, 88);
        Evaluacion ev3 = new Evaluacion(2025, 70);
        Evaluacion ev4 = new Evaluacion(2024, 92);
        Evaluacion ev5 = new Evaluacion(2024, 85);
        Evaluacion ev6 = new Evaluacion(2024, 90);
        Evaluacion ev7 = new Evaluacion(2025, 96);
        Evaluacion ev8 = new Evaluacion(2023, 60);
        Evaluacion ev9 = new Evaluacion(2024, 93);
        
        //Agrego evaluaciones a empleado 1
        emp1.agregarEvaluacion(ev1);
        emp1.agregarEvaluacion(ev2);
        //Agrego evaluaciones a empleado 2
        emp2.agregarEvaluacion(ev3);
        emp2.agregarEvaluacion(ev4);
        //Agrego evaluaciones a empleado 3
        emp3.agregarEvaluacion(ev5);
        emp3.agregarEvaluacion(ev6);
        //Agrego evaluaciones a empleado 4
        emp4.agregarEvaluacion(ev7);
        //Agrego evaluaciones a empleado 5
        emp5.agregarEvaluacion(ev8);
        emp5.agregarEvaluacion(ev9);

        //Agrego todos los empleados a la lista empleados
        empleados.add(emp1);
        empleados.add(emp2);
        empleados.add(emp3);
        empleados.add(emp4);
        empleados.add(emp5);

        //Creo instancia para los servicios que ofrece Recurso Humanos
        service = new RecursosHumanosService();

        System.out.println("\n1. Empleados Departamento IT:");
        service.empleadosPorDepartamento(empleados, "IT").forEach(System.out::println);

        System.out.println("\n2. Salario promedio por departamento:");
        service.salarioPromedioPorDepartamento(empleados).forEach((departamento,salarioPromedio) -> System.out.printf("{Departamento: %s, Salario promedio: $%.2f}%n",departamento,salarioPromedio));

        System.out.println("\n3. Mayor salario:");
        service.empleadoMayorSalario(empleados).ifPresent(System.out::println);//Si existe lo imprimo

        System.out.println("\n4. Empleados con más de 5 años de experiencia y con sueldo superior a 50k:");
        service.empleadosConExperienciaYSueldo(empleados).forEach(System.out::println);

        System.out.println("\n5. Top 3 última evaluación:");
        service.topNPorUltimaEvaluacion(empleados, 3).forEach(e -> System.out.println(e.getNombre()));

        System.out.println("\n6. Empleados con alguna evaluación mayor a 90:");
        System.out.println(service.empleadosConEvaluacionMayor90(empleados));

        System.out.println("\n7. Ranking promedios:");
        service.rankingPromedios(empleados).entrySet()//Convierto el mapa a un set, Set<Entry<Empleado, Double>>
                                        .stream()//Covierto  Set<Entry<Empleado, Double>>   a    Stream<Entry<Empleado, Double>>
                                        //Ordeno por el valor del Mapa, osea el promedio de las valuaciones de cada empleado y le indico a comparingByValue() explicitamente quien va hacer key y value del mapa al usar <Empleado, Double>
                                        .sorted(Map.Entry.<Empleado, Double>comparingByValue().reversed())
                                        .forEach(entry -> System.out.println("{id: " + entry.getKey().getId() + ", nombre: " + entry.getKey().getNombre() +", promedio: " + entry.getValue() + "}"));
    }
}

