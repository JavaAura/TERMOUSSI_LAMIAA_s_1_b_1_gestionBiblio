package Biblio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bibliotheque {
	
	private List<Document> documents = new ArrayList<>();
    private Map<String, Document> documentMap = new HashMap<>();
    private static int compteurId = 1;
    
    public void ajouterDocument(Document document) {
        String id = generateUniqueId();
        document.setId(id);  
        documents.add(document);
        documentMap.put(id, document);
        System.out.println("Document ajouté avec succès avec l'ID : " + id);
    }

    private String generateUniqueId() {
        return "document_" + compteurId++;  
    }
    

    public List<Document> obtenirTousLesDocuments() {
        return this.documents;
    }
}
