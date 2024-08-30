package com.library.business;

import java.time.LocalDate;

public class Book extends Document {
    private String isbn;

    public Book(String id, String title, String author, LocalDate publicationDate, int numberOfPages, String isbn) {
        super(id, title, author, publicationDate, numberOfPages);
        this.isbn = isbn;
    }

    @Override
    public void borrow() {
        System.out.println("The book " + title + " has been borrowed.");
    }

    @Override
    public void returnDocument() {
        System.out.println("The book " + title + " has been returned.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Book: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Date: " + publicationDate);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("ISBN: " + isbn);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}