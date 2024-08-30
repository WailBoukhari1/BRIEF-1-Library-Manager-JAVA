package com.library.business;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private List<Document> documents;
    private Map<String, Document> documentMap;

    public Library() {
        documents = new ArrayList<>();
        documentMap = new HashMap<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
        documentMap.put(document.getId(), document);
    }

    public Document searchDocument(String id) {
        return documentMap.get(id);
    }

    public void borrowDocument(String id) {
        Document document = searchDocument(id);
        if (document != null) {
            document.borrow();
        } else {
            System.out.println("Document not found.");
        }
    }

    public void returnDocument(String id) {
        Document document = searchDocument(id);
        if (document != null) {
            document.returnDocument();
        } else {
            System.out.println("Document not found.");
        }
    }

    public void displayAllDocuments() {
        for (Document document : documents) {
            document.displayDetails();
            System.out.println("--------------------");
        }
    }
}