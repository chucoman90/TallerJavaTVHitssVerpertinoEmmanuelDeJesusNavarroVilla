package ejercicios.ejercicio21;

public abstract class Enums {
    public enum TipoCliente {
        NORMAL {
            @Override
            public double aplicarDescuento(double total) {
                // No hay descuento para clientes normales
                return total;
            }
        },
        VIP {
            @Override
            public double aplicarDescuento(double total) {
                // Descuento del 10% para VIP
                return total * 0.9;
            }
        };

        // Método abstracto que cada tipo debe implementar
        public abstract double aplicarDescuento(double total);
    }
}
