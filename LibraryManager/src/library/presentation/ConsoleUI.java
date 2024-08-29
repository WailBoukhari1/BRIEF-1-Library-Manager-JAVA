package library.presentation;

import library.model.Library;
import library.model.Document;
import library.model.Book;
import library.model.Magazine;

import java.util.Scanner;

public class ConsoleUI {
    private Library library;
    private Scanner scanner;

    public ConsoleUI() {
        this.library = new Library();
        this.scanner = new Scanner(System.in);
    }

    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = readChoice();
            switch (choice) {
                case 1:
                    addDocument();
                    break;
                case 2:
                    borrowDocument();
                    break;
                case 3:
                    returnDocument();
                    break;
                case 4:
                    displayAllDocuments();
                    break;
                case 5:
                    searchDocument();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Thank you for using our Library Management System!");
    }

    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add a document");
        System.out.println("2. Borrow a document");
        System.out.println("3. Return a document");
        System.out.println("4. Display all documents");
        System.out.println("5. Search for a document");
        System.out.println("6. Exit");
        System.out.print("Please enter your choice (1-6): ");
    }

    private int readChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Invalid input. Please enter a number between 1 and 6: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private void addDocument() {
        System.out.print("Document type (1: Book, 2: Magazine): ");
        int type = readChoice();
        scanner.nextLine(); // Consume newline

        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publication date (YYYY-MM-DD): ");
        String publicationDate = scanner.nextLine();
        System.out.print("Number of pages: ");
        int numberOfPages = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Document document;
        if (type == 1) {
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            document = new Book(library.getNextId(), title, author, publicationDate, numberOfPages, isbn);
        } else {
            System.out.print("Issue number: ");
            int issueNumber = scanner.nextInt();
            document = new Magazine(library.getNextId(), title, author, publicationDate, numberOfPages, issueNumber);
        }

        library.addDocument(document);
        System.out.println("Document added successfully.");
    }

    private void borrowDocument() {
        System.out.print("Enter the ID of the document to borrow: ");
        int id = scanner.nextInt();
        if (library.borrowDocument(id)) {
            System.out.println("Document borrowed successfully.");
        } else {
            System.out.println("Unable to borrow the document.");
        }
    }

    private void returnDocument() {
        System.out.print("Enter the ID of the document to return: ");
        int id = scanner.nextInt();
        if (library.returnDocument(id)) {
            System.out.println("Document returned successfully.");
        } else {
            System.out.println("Unable to return the document.");
        }
    }

    private void displayAllDocuments() {
        library.displayAllDocuments();
    }

    private void searchDocument() {
        System.out.print("Enter the title of the document to search: ");
        scanner.nextLine(); // Consume newline
        String title = scanner.nextLine();
        Document document = library.searchDocument(title);
        if (document != null) {
            document.displayDetails();
        } else {
            System.out.println("Document not found.");
        }
    }
}