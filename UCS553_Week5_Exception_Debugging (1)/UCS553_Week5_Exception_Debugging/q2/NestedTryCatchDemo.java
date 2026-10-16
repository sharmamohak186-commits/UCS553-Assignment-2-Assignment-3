public class NestedTryCatchDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Outer block started");
            try {
                int[] values = {10, 20};
                System.out.println(values[4]);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: array index is invalid");
            }
            int result = 12 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: division by zero");
        } finally {
            System.out.println("Finally block executed");
        }
    }
}
