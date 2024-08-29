package library.model;

public class Magazine extends Document {
    private int issueNumber;

    public Magazine(int id, String title, String author, String publicationDate, int numberOfPages, int issueNumber) {
        super(id, title, author, publicationDate, numberOfPages);
        this.issueNumber = issueNumber;
    }

    @Override
    public void borrow() {
        if (!borrowed) {
            borrowed = true;
            System.out.println("The magazine \"" + title + "\" has been borrowed.");
        } else {
            System.out.println("The magazine \"" + title + "\" is already borrowed.");
        }
    }

    @Override
    public void returnDocument() {
        if (borrowed) {
            borrowed = false;
            System.out.println("The magazine \"" + title + "\" has been returned.");
        } else {
            System.out.println("The magazine \"" + title + "\" was not borrowed.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println("Magazine - ID: " + id + ", Title: \"" + title + "\", Author: " + author + 
                           ", Publication Date: " + publicationDate + ", Number of Pages: " + numberOfPages + 
                           ", Issue Number: " + issueNumber + ", Borrowed: " + (borrowed ? "Yes" : "No"));
    }
}