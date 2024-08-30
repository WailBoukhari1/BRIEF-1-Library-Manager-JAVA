package com.library.business;

import java.time.LocalDate;

public class Magazine extends Document {
    private int issue;

    public Magazine(String id, String title, String author, LocalDate publicationDate, int numberOfPages, int issue) {
        super(id, title, author, publicationDate, numberOfPages);
        this.issue = issue;
    }

    @Override
    public void borrow() {
        System.out.println("The magazine " + title + " has been borrowed.");
    }

    @Override
    public void returnDocument() {
        System.out.println("The magazine " + title + " has been returned.");
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine: " + title);
        System.out.println("Author: " + author);
        System.out.println("Publication Date: " + publicationDate);
        System.out.println("Number of Pages: " + numberOfPages);
        System.out.println("Issue: " + issue);
    }

    public int getIssue() {
        return issue;
    }

    public void setIssue(int issue) {
        this.issue = issue;
    }
}