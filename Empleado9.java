package ejercicios;

public class Empleado9 extends Persona9 {
    private double remuneracion;
    private int empleadoId;


    

    public Empleado9(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion,
            int empleadoId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.remuneracion = remuneracion;
        this.empleadoId = empleadoId;
    }

    public double aumentarRemuneracion(int porcentaje){

        return remuneracion += porcentaje;
    }

    public double getRemuneracion() {
        return remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    @Override
    public String toString() {
        return "Empleado {Nombre: "+ getNombre() + "\nApellido: " + getApellido() + "\nNumeroFiscal: " + getNumeroFiscal() + 
        "\nDireccion: " + getDireccion() + "\nRemuneracion: " + remuneracion + "\nempleadoId:" + empleadoId + "}";
    }

    
    

}
