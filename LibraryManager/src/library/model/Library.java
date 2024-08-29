package library.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Document> documents;
    private Map<String, Document> documentMap;
    private int nextId;

    public Library() {
        this.documents = new ArrayList<>();
        this.documentMap = new HashMap<>();
        this.nextId = 1;
    }

    public void addDocument(Document document) {
        documents.add(document);
        documentMap.put(document.getTitle().toLowerCase(), document);
    }

    public boolean borrowDocument(int id) {
        Document document = findDocumentById(id);
        if (document != null && !document.isBorrowed()) {
            document.borrow();
            return true;
        }
        return false;
    }

    public boolean returnDocument(int id) {
        Document document = findDocumentById(id);
        if (document != null && document.isBorrowed()) {
            document.returnDocument();
            return true;
        }
        return false;
    }

    public void displayAllDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents in the library.");
        } else {
            for (Document document : documents) {
                document.displayDetails();
            }
        }
    }

    public Document searchDocument(String title) {
        return documentMap.get(title.toLowerCase());
    }

    private Document findDocumentById(int id) {
        return documents.stream()
                .filter(doc -> doc.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public int getNextId() {
        return nextId++;
    }
}