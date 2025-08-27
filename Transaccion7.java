package ejercicios;

public class Transaccion7 {
    public enum TipoTransaccion {
        DEPOSITO, RETIRO
    }

    private static int contadorTransacciones = 1;
    private int id;
    private TipoTransaccion tipo;
    private double monto;
    private CuentaBancaria7 cuenta; 

    public Transaccion7(TipoTransaccion tipo, double monto, CuentaBancaria7 cuenta) {
        this.id = contadorTransacciones++;
        this.tipo = tipo;
        this.monto = monto;
        this.cuenta = cuenta;
    }

    public int getId() {
        return id;
    }

    public TipoTransaccion getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public CuentaBancaria7 getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "{Transacción ID: " + id + ", Tipo: " + tipo + ", Monto: $" + monto + ", Cuenta ID: " + cuenta.getId() + "}";
    }
}
