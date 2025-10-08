package ejercicios.ejercicio22;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class RecursosHumanosService {

        // 1. Listar empleados por departamento específico ordenados alfabéticamente
        public List<Empleado> empleadosPorDepartamento(List<Empleado> empleados, String depto) {
                return empleados.stream()
                                .filter(e -> e.getDepartamento().equalsIgnoreCase(depto))
                                .sorted(Comparator.comparing(Empleado::getNombre))
                                .toList();
        }

        // 2. Calcular salario promedio por departamento
        public Map<String, Double> salarioPromedioPorDepartamento(List<Empleado> empleados) {
                //Retorno un Map<k,v> -> <k=nombre departamento,v=salario promedio departamento>
                return empleados.stream()//Stream<Empleado>
                        .collect(Collectors.groupingBy(
                                Empleado::getDepartamento,//agrupo por nombre de departamento
                                Collectors.averagingDouble(Empleado::getSalario)//Por cada departamento calculo el salario promedio.
                        ));
        }

        // 3. Obtener el empleado con mayor salario en toda la empresa.
        public Optional<Empleado> empleadoMayorSalario(List<Empleado> empleados) {
                return empleados.stream()//Stream<Empleado>
                                .max(Comparator.comparingDouble(Empleado::getSalario));//Busco en el flujo el empleado con el mayor salario
        }

        // 4. Listar todos los empleados con más de 5 años de experiencia y salario mayor a 50,000
        public List<Empleado> empleadosConExperienciaYSueldo(List<Empleado> empleados) {
                return empleados.stream()//Stream<Empleado>
                                .filter(empleado -> empleado.getAniosExperiencia() > 5 && empleado.getSalario() > 50000)//Del flujo de tipo empleado encuentro quienes cumplen la condicion
                                .toList();
        }

        // 5. Top N en la última evaluación
        //Obtener el top 3 de empleados con mejor puntaje en la última evaluación (último año)
        /* public List<Empleado> topNPorUltimaEvaluacion(List<Empleado> empleados, int n) {
                return empleados.stream()//Stream<Empleado>
                        .sorted((e1, e2) -> {
                        var puntaje1 = puntajeUltimaEvaluacion(e1);
                        var puntaje2 = puntajeUltimaEvaluacion(e2);
                        //Regresa 0 si son iguales, Regresa numNegativo si pantaje2 < puntaje1, regresa positivo si puntaje1 > puntaje2
                        return Integer.compare(puntaje2, puntaje1);
                        })
                        .limit(n)//
                        .toList();
        } */

        // 5. Top N en la última evaluación
        //Obtener el top 3 de empleados con mejor puntaje en la última evaluación (último año)
        public List<Empleado> topNPorUltimaEvaluacion(List<Empleado> empleados, int n) {
                return empleados.stream()//Stream<Empleado>
                                .sorted(Comparator.comparingInt(this::puntajeUltimaEvaluacion).reversed().thenComparing(Empleado::getNombre))
                                .limit(n)//n=top 3 empleados.
                                .toList();
        }
        //Funcion auxiliar que usa sorted cuando internamente compara dos empleados por medio del Comparator
        private int puntajeUltimaEvaluacion(Empleado empleado) {
                return empleado.getEvaluaciones().stream()//Stream<Evaluacion>
                                                //Obtengo la evaluacion del año más reciente y si hay mas de una del mismo año, la evaluacion se elige por más puntaje - Optional<Evaluacion>
                                                .max(Comparator.comparingInt(Evaluacion::getAnio).thenComparingInt(Evaluacion::getPuntaje))
                                                .map(Evaluacion::getPuntaje)//Convierto Optional<Evaluacion> -> Optional<Integer>
                                                .orElse(0);
        }

        // 6. Contar cuántos empleados tienen al menos una evaluación superior a 90 puntos.
        public long empleadosConEvaluacionMayor90(List<Empleado> empleados) {
                return empleados.stream()
                        .filter(empleado -> empleado.getEvaluaciones().stream()//La lista de evaluaciones de cada empleado la vuelvo en Stream<Evaluacion> 
                                .anyMatch(evaluacion -> evaluacion.getPuntaje() > 90))//Si algun elemento del flujo cumple la codicion, ese Empleado pasa el filter
                        .count();//Cuento los empleandos que al menos en algunas de sus evaluaciones tuvieron un puntaje mayor a 90
        }

        // 7. Ranking de promedio de puntajes por empleado
        /*  public Map<String, Double> rankingPromedios(List<Empleado> empleados) {
                return empleados.stream()
                        .collect(Collectors.toMap(
                                Empleado::getNombre,
                                e -> e.getEvaluaciones().stream()//Stream<Evaluacion>
                                        //Convierto Stream<Evaluacion> a un flujo IntStream primitivo, donde cada tipo primitivo son los puntajes de cada evaluacion de cada empleado
                                        .mapToInt(Evaluacion::getPuntaje)
                                        .average()//Del flujo de puntaje de cada empleado calculo su promedio, regresa un OptionalDouble para tipo primitivo double
                                        .orElse(0.0)//Si algun empleado no tiene puntaje porque no tiene ninguna evaluacion, regreso cero, si no regreso el promedio en tipo double
                        ));
        } */
        // 7. Ranking de promedio de puntajes por empleado
        public Map<Empleado, Double> rankingPromedios(List<Empleado> empleados) {
                return empleados.stream()
                        .collect(Collectors.toMap(
                                empleado -> empleado,
                                e -> e.getEvaluaciones().stream()//Stream<Evaluacion>
                                        //Convierto Stream<Evaluacion> a un flujo IntStream primitivo, donde cada tipo primitivo son los puntajes de cada evaluacion de cada empleado
                                        .mapToInt(Evaluacion::getPuntaje)
                                        .average()//Del flujo de puntaje de cada empleado calculo su promedio, regresa un OptionalDouble para tipo primitivo double
                                        .orElse(0.0)//Si algun empleado no tiene promedio por  no tener puntaje a raiz de no tener ninguna evaluacion, regreso cero, si no regreso el promedio en tipo double que toMap los convierte a Double.
                        ));
        }
}

