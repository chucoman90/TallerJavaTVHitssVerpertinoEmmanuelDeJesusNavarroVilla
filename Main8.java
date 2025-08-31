package ejercicios;

import ejercicios.Enums8.OrderPriority;
import ejercicios.Enums8.OrderStatus;
import ejercicios.Enums8.PaymentMethod;

public class Main8 {
    public static void main(String[] args) {
        Order8 order1 = new Order8("Ana", OrderStatus.NEW, OrderPriority.HIGH, PaymentMethod.CARD);
        Order8 order2 = new Order8("Luis", OrderStatus.SHIPPED, OrderPriority.MEDIUM, PaymentMethod.CASH);
        Order8 order3 = new Order8("María", OrderStatus.DELIVERED, OrderPriority.LOW, PaymentMethod.TRANSFER);


        order1.showDetails();
        order2.showDetails();
        order3.showDetails();
    }
}
