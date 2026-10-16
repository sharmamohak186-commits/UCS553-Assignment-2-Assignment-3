package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderUtility;
import food.utility.OrderPrinter;

public class Main {
    public static void main(String[] args) {
        FoodOrder[] orders = new FoodOrder[6];

        orders[0] = new RegularOrder(101, "Aman", 500);
        orders[1] = new PremiumOrder(102, "Simran", 800);
        orders[2] = new RegularOrder(103, "Riya", 650);
        orders[3] = new PremiumOrder(104, "Karan", 1200);
        orders[4] = new RegularOrder(105, "Mehak", 450);
        orders[5] = new PremiumOrder(106, "Arjun", 900);

        for (FoodOrder order : orders) {
            if (OrderUtility.validateAmount(order.getAmount())
                    && OrderUtility.validateCustomerName(order.getCustomerName())) {
                System.out.println(OrderUtility.generateOrderSummary(order));
                OrderPrinter.printBill(order);
            } else {
                System.out.println("Invalid order data for order " + order.getOrderId());
            }
        }

        FoodOrder.displayTotalOrders();
    }
}
