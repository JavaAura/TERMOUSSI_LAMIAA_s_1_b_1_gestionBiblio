package Biblio;

import java.util. Scanner;

import java.util.List;


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
				s.nextLine(); //lire l'entree
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
	
		
	private static void ajouterDocument() {
	    System.out.print("Type de document (livre/magazine) : ");
	    String type = s.nextLine();
	    if (!type.equalsIgnoreCase("livre")  && !type.equalsIgnoreCase("magazine") ) {
			   System.out.println("Type de document invalide.");
		}else {
	    System.out.print("Titre : ");
	    String titre = s.nextLine();
	    System.out.print("Auteur : ");
	    String auteur = s.nextLine();
	    System.out.print("Date de publication (dd/MM/yyyy) : ");
	    String datePublication = s.nextLine();
	    System.out.print("Nombre de pages : ");
	    int nombreDePages = s.nextInt();
	   s.nextLine(); 
		   
	  
	   if (type.equalsIgnoreCase("livre")) {
	        System.out.print("ISBN : ");
	        String isbn = s.nextLine();
	        Livre livre = new Livre(null, titre, auteur, datePublication, nombreDePages, isbn);
	        bibliotheque.ajouterDocument(livre);
	    } else if (type.equalsIgnoreCase("magazine")) {
	        System.out.print("Numéro : ");
	        String numero = s.nextLine();
	        Magazine magazine = new Magazine(null, titre, auteur, datePublication, nombreDePages, numero);
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
    	        for (Document doc : documents) {
    	            doc.afficherDetails(); 
    	        }
    	    }
    }
    
    public static void rechercherDocument() {
    	
    }
}
