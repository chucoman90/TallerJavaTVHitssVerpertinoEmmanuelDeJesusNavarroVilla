package ejercicios.ejercicio21;

import ejercicios.ejercicio21.Enums.TipoCliente;

public class Cliente {
    private int id;
    private String nombre;
    private TipoCliente tipo;
    
    public Cliente(int id, String nombre, TipoCliente tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {return id;}
    public String getNombre() {return nombre;}
    public TipoCliente getTipo() {return tipo;}

    @Override
    public String toString() {
        return "Cliente {id: " + id + ", nombre: " + nombre + ", tipo: " + tipo + "}";
    }
}
