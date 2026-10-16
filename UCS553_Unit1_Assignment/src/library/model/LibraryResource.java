package library.model;

public abstract class LibraryResource {
    private int resourceId;
    private String title;
    private String author;
    private static String libraryName = "UCS Smart Library";
    private static int totalResources;

    public LibraryResource(int resourceId, String title, String author) {
        this.resourceId = resourceId;
        this.title = title;
        this.author = author;
        totalResources++;
    }

    public int getResourceId() { return resourceId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public static String getLibraryName() { return libraryName; }

    protected String getResourceSummary() {
        return "Library: " + libraryName + "\nResource ID: " + resourceId
                + "\nTitle: " + title + "\nAuthor: " + author;
    }

    public abstract double calculateFine(int overdueDays);

    public static void displayTotalResources() {
        System.out.println("Total resources created: " + totalResources);
    }
}
