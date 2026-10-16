import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter first number: ");
            double a = Double.parseDouble(sc.nextLine());
            System.out.print("Enter operator (+, -, *, /): ");
            String op = sc.nextLine().trim();
            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine());

            switch (op) {
                case "+" -> System.out.println("Result: " + (a + b));
                case "-" -> System.out.println("Result: " + (a - b));
                case "*" -> System.out.println("Result: " + (a * b));
                case "/" -> {
                    if (b == 0) throw new ArithmeticException("Division by zero");
                    System.out.println("Result: " + (a / b));
                }
                default -> throw new IllegalArgumentException("Invalid operator");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Enter valid numeric input.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
            System.out.println("Calculator closed.");
        }
    }
}
