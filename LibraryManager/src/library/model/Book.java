package library.model;

public class Book extends Document {
    private String isbn;

    public Book(int id, String title, String author, String publicationDate, int numberOfPages, String isbn) {
        super(id, title, author, publicationDate, numberOfPages);
        this.isbn = isbn;
    }

    @Override
    public void borrow() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("The book \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("The book \"" + title + "\" is already borrowed.");
        }
    }

    @Override
    public void returnDocument() {
        if (borrowed) {
            borrowed = false;
            System.out.println("The book \"" + title + "\" has been returned.");
        } else {
            System.out.println("The book \"" + title + "\" was not borrowed.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Book - ID: " + id + ", Title: \"" + title + "\", Author: " + author + 
                           ", Publication Date: " + publicationDate + ", Number of Pages: " + numberOfPages + 
                           ", ISBN: " + isbn + ", Borrowed: " + (borrowed ? "Yes" : "No"));
    }
}