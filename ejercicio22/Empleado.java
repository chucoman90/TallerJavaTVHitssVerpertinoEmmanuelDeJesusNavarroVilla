package ejercicios.ejercicio22;

import java.util.ArrayList;
import java.util.List;

public class Empleado {
    private int id;
    private String nombre;
    private String departamento;
    private double salario;
    private int aniosExperiencia;
    private List<Evaluacion> evaluaciones;

    public Empleado(int id, String nombre, String departamento, double salario, int aniosExperiencia, List<Evaluacion> evaluaciones) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.aniosExperiencia = aniosExperiencia;
        this.evaluaciones = evaluaciones;
    }

    

    public Empleado(int id, String nombre, String departamento, double salario, int aniosExperiencia) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;
        this.salario = salario;
        this.aniosExperiencia = aniosExperiencia;
        this.evaluaciones = new ArrayList<>();
    }



    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getDepartamento() { return departamento; }
    public double getSalario() { return salario; }
    public int getAniosExperiencia() { return aniosExperiencia; }
    public List<Evaluacion> getEvaluaciones() { return evaluaciones; }

    public void agregarEvaluacion(Evaluacion evaluacion){
        evaluaciones.add(evaluacion);
    }

    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Empleado other = (Empleado) obj;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equalsIgnoreCase(other.nombre))
            return false;
        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("===Empleado===").append("\n");
        sb.append("Id: ").append(id).append("\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Departamento: ").append(departamento).append("\n");
        sb.append("Salario: ").append("$"+salario).append("\n");
        sb.append("Experiencia: ").append(aniosExperiencia).append("\n");
        sb.append("Evaluaciones:").append("\n");

        for (Evaluacion evaluacion : evaluaciones) {
            sb.append("[").append("Año: ").append(evaluacion.getAnio()).append(", Puntaje: ").append(evaluacion.getPuntaje()).append("]").append("\n");
        }

        sb.append("\n");
        return sb.toString();
    }

    
}
