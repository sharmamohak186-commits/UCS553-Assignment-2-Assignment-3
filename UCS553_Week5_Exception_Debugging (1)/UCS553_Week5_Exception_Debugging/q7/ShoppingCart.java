import java.util.ArrayList;
import java.util.List;

class ApplicationException extends Exception {
    public ApplicationException(String message) { super(message); }
}
class ProductException extends ApplicationException {
    public ProductException(String message) { super(message); }
}
class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String message) { super(message); }
}
class OutOfStockException extends ProductException {
    public OutOfStockException(String message) { super(message); }
}
class PaymentException extends ApplicationException {
    public PaymentException(String message) { super(message); }
}
class InvalidPaymentException extends PaymentException {
    public InvalidPaymentException(String message) { super(message); }
}
class InsufficientFundsException extends PaymentException {
    public InsufficientFundsException(String message) { super(message); }
}
class OrderException extends ApplicationException {
    public OrderException(String message) { super(message); }
}
class EmptyCartException extends OrderException {
    public EmptyCartException(String message) { super(message); }
}

class Product {
    String name;
    double price;
    int stock;
    Product(String name, double price, int stock) {
        this.name = name; this.price = price; this.stock = stock;
    }
}
public class ShoppingCart {
    private final List<Product> products = new ArrayList<>();
    private final List<Product> cart = new ArrayList<>();

    public ShoppingCart() {
        products.add(new Product("Notebook", 60, 10));
        products.add(new Product("Pen", 15, 20));
        products.add(new Product("Bag", 700, 2));
    }
    public void addProduct(String name) throws ProductNotFoundException, OutOfStockException {
        Product p = searchProduct(name);
        if (p.stock <= 0) throw new OutOfStockException(name + " is out of stock.");
        cart.add(p);
        p.stock--;
        System.out.println(name + " added to cart.");
    }
    public void removeProduct(String name) throws ProductNotFoundException, OrderException {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).name.equalsIgnoreCase(name)) {
                Product p = cart.remove(i);
                p.stock++;
                System.out.println(name + " removed from cart.");
                return;
            }
        }
        throw new OrderException(name + " is not in the cart.");
    }
    public Product searchProduct(String name) throws ProductNotFoundException {
        for (Product p : products)
            if (p.name.equalsIgnoreCase(name)) return p;
        throw new ProductNotFoundException("Product not found: " + name);
    }
    public double total() throws EmptyCartException {
        if (cart.isEmpty()) throw new EmptyCartException("Cart is empty.");
        double sum = 0;
        for (Product p : cart) sum += p.price;
        return sum;
    }
    public void pay(double amount) throws EmptyCartException, InvalidPaymentException, InsufficientFundsException {
        double bill = total();
        if (amount <= 0) throw new InvalidPaymentException("Payment must be positive.");
        if (amount < bill) throw new InsufficientFundsException("Insufficient payment amount.");
        System.out.printf("Payment successful. Bill: Rs. %.2f, change: Rs. %.2f%n", bill, amount - bill);
        cart.clear();
    }

    public static void main(String[] args) {
        ShoppingCart shop = new ShoppingCart();
        try {
            System.out.println("Search result: " + shop.searchProduct("Pen").name);
            shop.addProduct("Notebook");
            shop.addProduct("Pen");
            shop.removeProduct("Pen");
            shop.addProduct("Bag");
            shop.pay(800);
        } catch (ProductNotFoundException e) {
            System.out.println("Product error: " + e.getMessage());
        } catch (OutOfStockException e) {
            System.out.println("Stock error: " + e.getMessage());
        } catch (PaymentException e) {
            System.out.println("Payment error: " + e.getMessage());
        } catch (OrderException e) {
            System.out.println("Order error: " + e.getMessage());
        } finally {
            System.out.println("Shopping operation completed.");
        }
    }
}
