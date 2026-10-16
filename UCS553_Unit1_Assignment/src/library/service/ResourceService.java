package library.service;

import library.model.LibraryResource;

public class ResourceService {
    public static double calculateTotalFine(LibraryResource[] resources, int[] overdueDays) {
        double total = 0;
        for (int i = 0; i < resources.length; i++) {
            total += resources[i].calculateFine(overdueDays[i]);
        }
        return total;
    }
}
