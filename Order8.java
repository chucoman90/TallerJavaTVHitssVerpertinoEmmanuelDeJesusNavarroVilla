package ejercicios;

import ejercicios.Enums8.OrderPriority;
import ejercicios.Enums8.OrderStatus;
import ejercicios.Enums8.PaymentMethod;

public class Order8 {
    public static int orderCount = 1;
    private int id;
    private String customer;
    private OrderStatus status;
    private OrderPriority priority;
    private PaymentMethod paymentMethod;

    public Order8(String customer, OrderStatus status, OrderPriority priority, PaymentMethod paymentMethod) {
        this.id = orderCount++;
        this.customer = customer;
        this.status = status;
        this.priority = priority;
        this.paymentMethod = paymentMethod;
    }

    public void showDetails() {
        System.out.println("Pedido #" + id);
        System.out.println("Cliente: " + customer);
        System.out.println("Estado: " + status + " -> " + status.getMessage());
        System.out.println("Prioridad: " + priority + " (Nivel " + priority.getLevel() + ")");
        System.out.println("Método de pago: " + paymentMethod + " -> " + paymentMethod.getDescription());
        System.out.println();
    }
}
