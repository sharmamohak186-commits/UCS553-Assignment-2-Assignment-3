package library.main;

import library.model.LibraryResource;
import library.model.Book;
import library.model.DigitalResource;
import library.model.Printable;
import library.service.ResourceService;
import library.util.InputValidator;

public class Main {
    public static void main(String[] args) {
        LibraryResource[] resources = {
            new Book(1, "Java Programming", "Herbert Schildt"),
            new DigitalResource(2, "Data Structures E-Book", "Mark Allen"),
            new Book(3, "Operating Systems", "Galvin"),
            new DigitalResource(4, "Java Tutorial", "Oracle"),
            new Book(5, "Computer Networks", "Andrew Tanenbaum")
        };

        int[] overdueDays = {4, 7, 0, 3, 2};
        double totalFine = 0;

        for (int i = 0; i < resources.length; i++) {
            if (InputValidator.validateResourceId(resources[i].getResourceId())
                    && InputValidator.validateFineDays(overdueDays[i])) {
                ((Printable) resources[i]).printDetails();
                System.out.println("Overdue days: " + overdueDays[i]);
                System.out.printf("Fine: Rs. %.2f%n", resources[i].calculateFine(overdueDays[i]));
                totalFine += resources[i].calculateFine(overdueDays[i]);
                System.out.println("--------------------------------");
            } else {
                System.out.println("Invalid resource/fine data.");
            }
        }

        System.out.printf("Total fine of all resources: Rs. %.2f%n", totalFine);
        LibraryResource.displayTotalResources();
    }
}
