package library.model;

public abstract class Document {
    protected int id;
    protected String title;
    protected String author;
    protected String publicationDate;
    protected int numberOfPages;
    protected boolean borrowed;

    public Document(int id, String title, String author, String publicationDate, int numberOfPages) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationDate = publicationDate;
        this.numberOfPages = numberOfPages;
        this.borrowed = false;
    }

    public abstract void borrow();
    public abstract void returnDocument();
    public abstract void displayDetails();

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return borrowed;
    }

    public void setBorrowed(boolean borrowed) {
        this.borrowed = borrowed;
    }
}