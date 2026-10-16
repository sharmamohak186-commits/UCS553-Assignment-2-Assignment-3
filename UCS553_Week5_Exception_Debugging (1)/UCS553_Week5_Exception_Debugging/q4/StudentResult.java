import java.util.Scanner;

class InvalidMarksException extends Exception {
    public InvalidMarksException(String message) { super(message); }
}

public class StudentResult {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter number of subjects: ");
            int n = Integer.parseInt(sc.nextLine());
            if (n <= 0) throw new IllegalArgumentException("Subject count must be positive.");

            int total = 0;
            for (int i = 1; i <= n; i++) {
                System.out.print("Enter marks for subject " + i + " (0-100): ");
                int marks = Integer.parseInt(sc.nextLine());
                if (marks < 0 || marks > 100)
                    throw new InvalidMarksException("Marks must be between 0 and 100.");
                total += marks;
            }

            double percentage = (double) total / n;
            String grade = percentage >= 90 ? "A+" :
                          percentage >= 80 ? "A" :
                          percentage >= 70 ? "B" :
                          percentage >= 60 ? "C" :
                          percentage >= 50 ? "D" : "F";
            System.out.println("Total: " + total);
            System.out.printf("Percentage: %.2f%%%n", percentage);
            System.out.println("Grade: " + grade);
        } catch (InvalidMarksException e) {
            System.out.println("Invalid marks: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Enter marks as whole numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
