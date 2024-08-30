package com.library.business;

import java.time.LocalDate;

public abstract class Document {
    private static int nextId = 1; // Static variable to hold the next available ID

    protected String id;
    protected String title;
    protected String author;
    protected LocalDate publicationDate;
    protected int numberOfPages;

    public Document(String title, String author, LocalDate publicationDate, int numberOfPages) {
        this.id = generateId(); // Assign an auto-incremented ID
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
    }

    private static String generateId() {
        return String.valueOf(nextId++);
    }

    public abstract void borrow();
    public abstract void returnDocument();
    public abstract void displayDetails();

    // Getters and setters
    public String getId() {
        return id;
    }

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

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}
