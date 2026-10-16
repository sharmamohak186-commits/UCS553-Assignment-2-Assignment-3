package food.utility;

import food.model.Discountable;
import food.model.FoodOrder;

public class OrderPrinter {
    public static void printBill(FoodOrder order) {
        double amount = order.getAmount();
        double discount = ((Discountable) order).applyDiscount();
        double delivery = order.calculateDeliveryCharge();
        double payable = amount - discount + delivery;

        System.out.println("--------------------------------");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Customer: " + order.getCustomerName());
        System.out.printf("Food amount: Rs. %.2f%n", amount);
        System.out.printf("Discount: Rs. %.2f%n", discount);
        System.out.printf("Delivery charge: Rs. %.2f%n", delivery);
        System.out.printf("Final payable: Rs. %.2f%n", payable);
    }
}
