package ejercicios;

public class Cliente9 extends Persona9 {
    private int clienteId;

    

    public Cliente9(String nombre, String apellido, String numeroFiscal, String direccion, int clienteId) {
        super(nombre, apellido, numeroFiscal, direccion);
        this.clienteId = clienteId;
    }

    public int getClienteId() {
        return clienteId;
    }



    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public String toString() {
        return "Cliente {Nombre:" + getNombre() + "\nApellido:" + getApellido() + "\nNumeroFiscal:" + getNumeroFiscal()
                + "\nDireccion:" + getDireccion() + "\nclienteId:" + clienteId +"}";
    }
}
