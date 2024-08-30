package Biblio;

import java.util. Scanner;
import java.time.LocalDate;

public class Main {
	static Scanner s;
	
	public static void main(String[] args) {
		
		System.out.println("Bienvenue dans la bibliothèque municipale \n"
				+ "1. Ajouter un document\n2. Emprunter un document"
				+ "\n3. Retourner un document\n4. Afficher tous les documents"
				+ "\n5. Rechercher un document\n6. Quitter");
		
				 s = new Scanner(System.in);
				int n = s.nextInt();

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
				
	}
	
		
	public static void ajouterDocument() {
    	
    }
	
    public static void emprunterDocument() {
    	
    }
    
    public static void retournerDocument() {
    	
    }
    
    public static void afficherDocuments() {
    	
    }
    
    public static void rechercherDocument() {
    	
    }
}
