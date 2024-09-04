package Biblio;

import java.text.ParseException;
import java.util. Scanner;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
	static Scanner s= new Scanner(System.in);
	private static Bibliotheque bibliotheque = new Bibliotheque();
	public static void main(String[] args) {
	      int n; 
		do {
		System.out.println("Bienvenue dans la bibliothèque municipale \n"
				+ "1. Ajouter un document\n2. Emprunter un document"
				+ "\n3. Retourner un document\n4. Afficher tous les documents"
				+ "\n5. Rechercher un document\n6. Quitter");
		
				 
				 n = s.nextInt();
				s.nextLine(); 
				switch (n) {
				case 1:
					ajouterDocument();
					break; 
				case 2:  
						 emprunterDocument();
						 break;
				case 3: 
					 retournerDocument();
	                 break;
				case 4:  
					afficherDocuments();
					break;
				case 5: 
					rechercherDocument();
                    break;
				case 6: 
					 System.out.println("Merci de visiter la bibliothèque. Au revoir!");
	                 System.exit(0);
	                 break;
				default: 
					System.out.println("Erreur! Sélection invalide.");
				} 
		}while (n != 6);
	}
	//scanner.close()
	private static void ajouterDocument() {
		List<Document> documents = bibliotheque.obtenirTousLesDocuments();
        String type = ValidationInput.validateType();
        String titre = ValidationInput.validateTitle(documents);
        String auteur = ValidationInput.validateStringInput("Auteur : ");
        LocalDate datePublication = ValidationInput.validateDatePub();
        int nombreDePages = ValidationInput.validateNbrPages();

        if (type.equalsIgnoreCase("livre")) {
            String isbn = ValidationInput.validateIsbn("ISBN : ");
            Livre livre = new Livre(null, titre, auteur, datePublication, nombreDePages, isbn);
            bibliotheque.ajouterDocument(livre);
        } else {
            String numero = ValidationInput.validateStringInput("Numéro : ");
            Magazine magazine = new Magazine(null, titre, auteur, datePublication, nombreDePages, numero);
            bibliotheque.ajouterDocument(magazine);
        }
	}
    public static void emprunterDocument() {
    	 String titreRecherche = ValidationInput.validateStringInput("Entrez le titre du document que vous souhaitez emprunter : ");

    	    List<Document> documents = bibliotheque.obtenirTousLesDocuments();
    	    
    	    for (Document doc : documents) {
    	        if (doc.titre.equalsIgnoreCase(titreRecherche)) {
    	        		doc.emprunter(); 
    	            return;
    	        }
    	    }
    	    System.out.println("Document avec le titre '" + titreRecherche + "' n'a pas été trouvé.");
    	
    }
    
    public static void retournerDocument() {
    	String docRetourner = ValidationInput.validateStringInput("Entrez le titre du document que vous souhaitez retourner : ");
	    List<Document> documents = bibliotheque.obtenirTousLesDocuments();
	    if (documents.isEmpty()) {
	    	 System.out.println("La bibliothèque est vide!");
	    }
	    for (Document doc : documents) {
	        if (doc.titre.equalsIgnoreCase(docRetourner)) {
	        		doc.retourner(); 
	            return;
	        }else {
	        	 System.out.println("document invalide");
	        }
	        
	    }
	    
    }
    
    public static void afficherDocuments() {
    	List<Document> documents = bibliotheque.obtenirTousLesDocuments(); 
    	 if (documents.isEmpty()) {
    	        System.out.println("Aucun document n'est disponible dans la bibliothèque.");
    	    } else {
    	    	//lambda expression
    	    	documents.forEach( doc->doc.afficherDetails());
    	    }
    }
    
    public static void rechercherDocument() {
    	 String docRechercher = ValidationInput.validateStringInput("Entrez le titre du document que vous recherchez : ");
    	List<Document> documents = bibliotheque.obtenirTousLesDocuments(); 
    	if(!documents.isEmpty()) {
    		//lambda expression
    		documents.forEach(doc->{
    			if (doc.titre.equalsIgnoreCase(docRechercher)) {
        			doc.afficherDetails();
        		}else {
        			  System.out.println("Le document document que vous rechercher est indisponible.");
        		}
    		});
    	}else {
    		System.out.println("La bibliotheque est vide.");
    	}
        
    }
    	
    }

