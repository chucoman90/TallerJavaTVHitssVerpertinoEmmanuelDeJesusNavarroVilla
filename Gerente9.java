package ejercicios;

public class Gerente9 extends Empleado9 {
    private double presupuesto;

    public Gerente9(String nombre, String apellido, String numeroFiscal, String direccion, double remuneracion,
            int empleadoId, double presupuesto) {
        super(nombre, apellido, numeroFiscal, direccion, remuneracion, empleadoId);
        this.presupuesto = presupuesto;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return "Gerente {Nombre: " + getNombre() + "\nApellido: " + getApellido() + 
        "\nNumeroFiscal: " + getNumeroFiscal() + "\nDireccion: " + getDireccion() + 
        "\nRemuneracion: " + getRemuneracion() + "\nEmpleadoId: " + getEmpleadoId() +"Presupuesto: " + presupuesto + "}";
    }
}
