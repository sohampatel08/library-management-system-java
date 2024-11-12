package in.ac.adit.pwj.miniproject.library;

import java.io.*;
import java.util.*;

public class LibraryManagementSystem {

    private class Inventory {
        private HashMap<String, Integer> books = new HashMap<>();

        public synchronized void addBook(String bookName, int quantity) {
            books.put(bookName, books.getOrDefault(bookName, 0) + quantity);
        }

        public synchronized void borrowBook(String bookName) throws Exception {
            if (!books.containsKey(bookName) || books.get(bookName) == 0) {
                throw new Exception("Sorry, the book '" + bookName + "' is currently not available.");
            }
            books.put(bookName, books.get(bookName) - 1);
            System.out.println("\nYou have successfully borrowed '" + bookName + "'.");
        }

        public synchronized void returnBook(String bookName) {
            books.put(bookName, books.getOrDefault(bookName, 0) + 1);
            System.out.println("\nYou have successfully returned '" + bookName + "'.");
        }

        public void displayBooks() {
            System.out.println("\n============= Book Inventory =============");
            System.out.printf("%-30s %s\n", "Book Name", "Available Copies");
            System.out.println("------------------------------------------");
            for (Map.Entry<String, Integer> entry : books.entrySet()) {
                System.out.printf("%-30s %d\n", entry.getKey(), entry.getValue());
            }
            System.out.println("==========================================");
        }
    }

    private Inventory inventory = new Inventory();
    private Scanner scanner = new Scanner(System.in);

    public LibraryManagementSystem() {
        inventory.addBook("Java Programming", 5);
        inventory.addBook("Data Structures", 3);
        inventory.addBook("Operating Systems", 2);
        inventory.addBook("Database Management", 4);
        inventory.addBook("Artificial Intelligence", 1);
    }

    public void saveBookData() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("BookData.txt"))) {
            for (Map.Entry<String, Integer> entry : inventory.books.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadBookData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("BookData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                inventory.addBook(parts[0], Integer.parseInt(parts[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addBookFromUser() {
        System.out.println("\n=========== Add a New Book ===========");
        System.out.print("Enter book name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter number of copies: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();
        inventory.addBook(bookName, quantity);
        System.out.println("\nThe book '" + bookName + "' has been successfully added with " + quantity + " copies.");
        System.out.println("======================================");
    }

    public void borrowBookFromUser(User user) {
        System.out.println("\n=========== Borrow a Book ===========");
        System.out.print("Enter book name to borrow: ");
        String bookName = scanner.nextLine();
        try {
            inventory.borrowBook(bookName);
            user.borrowBook(bookName);
        } catch (Exception e) {
            System.out.println("\n" + e.getMessage());
        }
        System.out.println("=====================================");
    }

    public void returnBookFromUser(User user) {
        System.out.println("\n=========== Return a Book ===========");
        System.out.print("Enter book name to return: ");
        String bookName = scanner.nextLine();
        inventory.returnBook(bookName);
        user.returnBook(bookName);
        System.out.println("=====================================");
    }

    public static void main(String[] args) {
        LibraryManagementSystem librarySystem = new LibraryManagementSystem();

        librarySystem.loadBookData();
        librarySystem.inventory.displayBooks();

        User[] users = {
                new Student("Dev Narola", 1011),
                new Faculty("XYZ", 1021)
        };

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\n========= Library Management System =========");
            System.out.println("1. Add a New Book");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Display Books");
            System.out.println("5. Exit");
            System.out.println("==============================================");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    librarySystem.addBookFromUser();
                    librarySystem.saveBookData();
                    break;
                case 2:
                    System.out.println("\nBorrowing as 1. Student  2. Faculty");
                    System.out.print("Choose user type: ");
                    int userType = scanner.nextInt();
                    scanner.nextLine();
                    if (userType == 1) {
                        librarySystem.borrowBookFromUser(users[0]);
                    } else if (userType == 2) {
                        librarySystem.borrowBookFromUser(users[1]);
                    } else {
                        System.out.println("\nInvalid user type.");
                    }
                    break;
                case 3:
                    System.out.println("\nReturning as 1. Student  2. Faculty");
                    System.out.print("Choose user type: ");
                    userType = scanner.nextInt();
                    scanner.nextLine();
                    if (userType == 1) {
                        librarySystem.returnBookFromUser(users[0]);
                    } else if (userType == 2) {
                        librarySystem.returnBookFromUser(users[1]);
                    } else {
                        System.out.println("\nInvalid user type.");
                    }
                    break;
                case 4:
                    librarySystem.inventory.displayBooks();
                    break;
                case 5:
                    exit = true;
                    System.out.println("\nThank you for using the Library Management System.");
                    break;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }

        scanner.close();
        librarySystem.saveBookData();
    }
}
