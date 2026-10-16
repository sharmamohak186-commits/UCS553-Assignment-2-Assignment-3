public class ExceptionHierarchyDemo {
    public static void main(String[] args) {
        try { int x = 10 / 0; } catch (ArithmeticException e) {
            System.out.println("ArithmeticException: " + e.getMessage());
        }
        try { String s = null; System.out.println(s.length()); } catch (NullPointerException e) {
            System.out.println("NullPointerException caught");
        }
        try { int[] a = {1, 2}; System.out.println(a[5]); } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught");
        }
        try { int n = Integer.parseInt("abc"); } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught");
        }
        System.out.println("These exceptions are unchecked and descend from RuntimeException.");
    }
}
