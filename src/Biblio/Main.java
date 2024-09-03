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
		boolean titreValide=true;
		 String titreEntree = "";
	    System.out.print("Type de document (livre/magazine) : ");
	    String type = s.nextLine();
	    if (!type.equalsIgnoreCase("livre")  && !type.equalsIgnoreCase("magazine") ) {
			   System.out.println("Type de document invalide.");
		}else {
			do {
			System.out.print("Titre : ");
		    titreEntree = s.nextLine();
		    
		    List<Document> documents = bibliotheque.obtenirTousLesDocuments();
		    for (Document doc : documents) {
		        if (doc.titre.equalsIgnoreCase(titreEntree)) {
		        	titreValide=false;
		        	System.out.println("Titre déja disponible!Veuillez entrer un titre différent:");
		        	}else {
		        		titreValide=true;
		        	}
		    	} 
			}while(!titreValide);
	    
	    System.out.print("Auteur : ");
	    String auteur = s.nextLine();
	    
	    LocalDate datePublication = null;
	    boolean correct=true;
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    do {
		    System.out.print("Date de publication (dd/MM/yyyy) : ");
		    String datePublicationStr  = s.nextLine();
		   
	        
	        try {
	            datePublication = LocalDate.parse(datePublicationStr, formatter);
                LocalDate aujourdHui = LocalDate.now();
                if (datePublication.isAfter(aujourdHui)) {
                    System.out.println("La date de publication ne peut pas être dans le futur. Veuillez entrer une date correcte.");
                    correct = false;
                } else {
                    correct = true; 
                }
	        } catch (DateTimeParseException e) {
	            System.out.println("Format de date invalide. Veuillez entrer une date au format dd/MM/yyyy.");
	            correct=false;    
	        }
	    }while(!correct);
	    
	        System.out.print("Nombre de pages : ");
		    int nombreDePages = s.nextInt();
			s.nextLine(); 
	  
	   if (type.equalsIgnoreCase("livre")) {
	        System.out.print("ISBN : ");
	        String isbn = s.nextLine();
	        Livre livre = new Livre(null, titreEntree, auteur, datePublication, nombreDePages, isbn);
	        bibliotheque.ajouterDocument(livre);
	    } else if (type.equalsIgnoreCase("magazine")) {
	        System.out.print("Numéro : ");
	        String numero = s.nextLine();
	        Magazine magazine = new Magazine(null, titreEntree, auteur, datePublication, nombreDePages, numero);
	        bibliotheque.ajouterDocument(magazine);
	    } 
	 }
	}
    public static void emprunterDocument() {
    	 System.out.print("Entrez le titre du document que vous souhaitez emprunter : ");
    	    String titreRecherche = s.nextLine();

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
    	System.out.print("Entrez le titre du document que vous souhaitez retourner : ");
	    String docRetourner = s.nextLine();
	    List<Document> documents = bibliotheque.obtenirTousLesDocuments();
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
    	System.out.print("Entrez le titre du document que vous rechercher: ");
	    String docRechercher = s.nextLine();
    	List<Document> documents = bibliotheque.obtenirTousLesDocuments(); 
    	if(!documents.isEmpty()) {
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

