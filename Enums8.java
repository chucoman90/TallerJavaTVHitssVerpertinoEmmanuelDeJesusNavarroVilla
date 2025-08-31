package ejercicios;

public class Enums8 {
    // Enum con estados del pedido
    enum OrderStatus {
        NEW("Pedido creado"),
        PROCESSING("Pedido en proceso"),
        SHIPPED("Pedido enviado"),
        DELIVERED("Pedido entregado"),
        CANCELLED("Pedido cancelado");

        private String message;

        OrderStatus(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    // Enum con prioridades
    enum OrderPriority {
        LOW(1),
        MEDIUM(2),
        HIGH(3);

        private int level;

        OrderPriority(int level) {
            this.level = level;
        }

        public int getLevel() {
            return level;
        }
    }

    // Enum con métodos de pago
    enum PaymentMethod {
    CASH {
        @Override
        public String getDescription() {
            return "Efectivo";
        }

        @Override
        public double getFee(double amount) {
            return 0;// Sin comisión
        }
    },
    CARD {
        @Override
        public String getDescription() {
            return "Tarjeta de crédito/débito";
        }

        @Override
        public double getFee(double amount) {
            return amount * 0.025; // Comisión del 2.5%
        }
    },
    TRANSFER {
        @Override
        public String getDescription() {
            return "Transferencia bancaria";
        }

        @Override
        public double getFee(double amount) {
            return amount * 1.50; // Comisión fija
        }
    };

    // Método abstracto que cada constante implementa
    public abstract String getDescription();
    public abstract double getFee(double amount);
}
}
