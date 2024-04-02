import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // Getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", Year: " + year + ", Price: $" + price;
    }
}

class Bookstore {
    private ArrayList<Book> books;

    public Bookstore() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equals(title));
    }

    public void displayAllBooks() {
        System.out.println("All Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void searchByTitle(String title) {
        System.out.println("Search Results for Title '" + title + "':");
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
            }
        }
    }

    public void searchByAuthor(String author) {
        System.out.println("Search Results for Author '" + author + "':");
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println(book);
            }
        }
    }

    // Additional functionality such as updateBook() can be added here
}

public class BookstoreManagementSystem {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nBookstore Management System");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. Search by Title");
            System.out.println("5. Search by Author");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter publication year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    Book newBook = new Book(title, author, year, price);
                    bookstore.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                case 2:
                    System.out.print("Enter title of book to remove: ");
                    String removeTitle = scanner.nextLine();
                    bookstore.removeBook(removeTitle);
                    System.out.println("Book removed successfully!");
                    break;
                case 3:
                    bookstore.displayAllBooks();
                    break;
                case 4:
                    System.out.print("Enter title to search: ");
                    String searchTitle = scanner.nextLine();
                    bookstore.searchByTitle(searchTitle);
                    break;
                case 5:
                    System.out.print("Enter author to search: ");
                    String searchAuthor = scanner.nextLine();
                    bookstore.searchByAuthor(searchAuthor);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
        scanner.close();
    }
}
