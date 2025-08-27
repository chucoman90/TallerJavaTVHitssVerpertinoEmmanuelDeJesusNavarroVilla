package ejercicios;

public class Banco7 {

    public static void main(String[] args) {
        // Crear cuentas
        CuentaBancaria7 ana = crearCuenta("Ana", 5000);
        CuentaBancaria7 luis = crearCuenta("Luis", 10000);

        // Registrar transacciones
        Transaccion7 t1 = depositar(ana, 2000);
        Transaccion7 t2 = retirar(ana, 1000);
        if(t2 == null)
            System.out.println("No se pudo realizar el retiro por fondos insuficientes.");
        Transaccion7 t3 = retirar(luis, 3000);
        if (t3 == null)
            System.out.println("No se pudo realizar el retiro por fondos insuficientes.");
        Transaccion7 t4 = depositar(luis, 1500);
        
        // Mostrar información de cuentas
        System.out.println("=== Detalle de Cuentas ===");
        mostrarCuenta(ana);
        mostrarCuenta(luis);

        // Mostrar historial de transacciones
        System.out.println("=== Historial de Transacciones ===");
        mostrarTransaccion(t1);
        mostrarTransaccion(t2);
        mostrarTransaccion(t3);
        mostrarTransaccion(t4);
    }

    public static CuentaBancaria7 crearCuenta(String titular, double depositoInicial) {
        return new CuentaBancaria7(titular, depositoInicial);
    }

    public static Transaccion7 depositar(CuentaBancaria7 cuenta, double monto) {
        cuenta.depositar(monto);
        return new Transaccion7(Transaccion7.TipoTransaccion.DEPOSITO, monto, cuenta);
    }

     public static Transaccion7 retirar(CuentaBancaria7 cuenta, double monto) {
        if(cuenta.retirar(monto) == true)
            return new Transaccion7(Transaccion7.TipoTransaccion.RETIRO, monto, cuenta);
        return null;
    }

    public static void mostrarCuenta(CuentaBancaria7 cuenta) {
        System.out.println(cuenta);
    }

    public static void mostrarTransaccion(Transaccion7 transaccion) {
        System.out.println(transaccion);
    }
}

