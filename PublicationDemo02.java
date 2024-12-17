// Base class for all publications
abstract class Publication {
    protected String title;
    protected double price;
    protected int copies;

    public Publication(String title, double price) {
        this.title = title;
        this.price = price;
        this.copies = 0;
    }

    public double saleCopy() {
        if (copies > 0) {
            copies--;
            return price;
        }
        return 0;
    }
}

class Book extends Publication {
    private String author;

    public Book(String title, double price, String author) {
        super(title, price);
        this.author = author;
    }

    public void orderCopies(int count) {
        copies += count;
        System.out.println("Ordered " + count + " copies of book: " + title);
    }
}

class Magazine extends Publication {
    private String currentIssue;

    public Magazine(String title, double price) {
        super(title, price);
    }

    public void orderQty(int quantity) {
        copies += quantity;
        System.out.println("Ordered " + quantity + " copies of magazine: " + title);
    }

    public void receiveIssue(String issue) {
        currentIssue = issue;
        System.out.println("Received issue: " + issue);
    }
}

public class PublicationDemo02 {
    public static void main(String[] args) {
        Book book = new Book("Java Programming", 500.0, "John Doe");
        Magazine magazine = new Magazine("Tech Weekly", 100.0);

        book.orderCopies(10);
        magazine.orderQty(5);

        double totalSales = 0;
        for (int i = 0; i < 3; i++) {
            totalSales += book.saleCopy();
            totalSales += magazine.saleCopy();
        }

        System.out.println("Total Sales: $" + totalSales);
    }
}
