package com.library.presentation;

import com.library.business.*;
import com.library.utility.DateUtils;

import java.util.Scanner;

public class ConsoleUI {
    private Library library;
    private Scanner scanner;

    public ConsoleUI() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

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
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        System.out.println("Goodbye!");
    }

    private void displayMenu() {
        System.out.println("\n--- Menu ---");
        System.out.println("1. Add a document");
        System.out.println("2. Borrow a document");
        System.out.println("3. Return a document");
        System.out.println("4. Display all documents");
        System.out.println("5. Search for a document");
        System.out.println("6. Exit");
        System.out.print("Enter your choice (1-6): ");
    }

    private void addDocument() {
        System.out.println("Add a document:");
        System.out.print("Type (1 for Book, 2 for Magazine): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("ID: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publication date (dd/mm/yyyy): ");
        String dateString = scanner.nextLine();
        System.out.print("Number of pages: ");
        int numberOfPages = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Document document;
        if (type == 1) {
            System.out.print("ISBN: ");
            String isbn = scanner.nextLine();
            document = new Book(id, title, author, DateUtils.stringToDate(dateString), numberOfPages, isbn);
        } else {
            System.out.print("Issue number: ");
            int issue = scanner.nextInt();
            document = new Magazine(id, title, author, DateUtils.stringToDate(dateString), numberOfPages, issue);
        }

        library.addDocument(document);
        System.out.println("Document added successfully.");
    }

    private void borrowDocument() {
        System.out.print("Enter the ID of the document to borrow: ");
        String id = scanner.nextLine();
        library.borrowDocument(id);
    }

    private void returnDocument() {
        System.out.print("Enter the ID of the document to return: ");
        String id = scanner.nextLine();
        library.returnDocument(id);
    }

    private void displayAllDocuments() {
        library.displayAllDocuments();
    }

    private void searchDocument() {
        System.out.print("Enter the ID of the document to search: ");
        String id = scanner.nextLine();
        Document document = library.searchDocument(id);
        if (document != null) {
            document.displayDetails();
        } else {
            System.out.println("Document not found.");
        }
    }

    public static void main(String[] args) {
        ConsoleUI ui = new ConsoleUI();
        ui.start();
    }
}
