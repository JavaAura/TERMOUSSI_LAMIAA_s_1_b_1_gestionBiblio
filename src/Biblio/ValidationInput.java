package Biblio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class ValidationInput {
	
	 private static Scanner s = new Scanner(System.in);
	    
	    public static String validateType() {
	        String type;
	        do {
	            System.out.print("Type de document (livre/magazine) : ");
	            type = s.nextLine();
	            if (!type.equalsIgnoreCase("livre") && !type.equalsIgnoreCase("magazine")) {
	                System.out.println("Type de document invalide. Veuillez entrer 'livre' ou 'magazine'.");
	            }
	        } while (!type.equalsIgnoreCase("livre") && !type.equalsIgnoreCase("magazine"));
	        return type;
	    }
	    
	    public static String validateTitle(List<Document> documents) {
	        String title;
	        boolean isValid;
	        do {
	            System.out.print("Titre : ");
	            title = s.nextLine();
	            if (title == null || title.trim().isEmpty()) {
	                System.out.println("Erreur: le titre ne peut pas être vide. Veuillez entrer un titre valide.");
	                isValid = false;
	                continue; 
	            }
	            isValid = true; 
	            for (Document doc : documents) {
	                if (doc.titre.equalsIgnoreCase(title)) {
	                    System.out.println("Titre déjà disponible! Veuillez entrer un titre différent.");
	                    isValid = false; 
	                    break; 
	                }
	            }
	        } while (!isValid);
	        return title; 
	    }
	    
	    public static String validateStringInput(String msg) {
	        String userInput;
	        do {
	            System.out.print(msg);
	            userInput = s.nextLine();
	            
	            if (userInput == null || userInput.trim().isEmpty()) {
	                System.out.println("Erreur: l'entrée ne peut pas être vide. Veuillez réessayer.");
	            }
	        } while (userInput == null || userInput.trim().isEmpty()); 
	        
	        return userInput; 
	    }
	    
	    public static LocalDate validateDatePub() {
	        LocalDate date;
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        while (true) {
	            System.out.print("Date de publication (dd/MM/yyyy) : ");
	            String input = s.nextLine();
	            try {
	                date = LocalDate.parse(input, formatter);
	                if (date.isAfter(LocalDate.now())) {
	                    System.out.println("La date de publication ne peut pas être dans le futur. Veuillez entrer une date correcte.");
	                } else {
	                    return date;
	                }
	            } catch (DateTimeParseException e) {
	                System.out.println("Format de date invalide. Veuillez entrer une date au format dd/MM/yyyy.");
	            }
	        }
	    }
	    
	    public static int validateNbrPages() {
	        int pages;
	        while (true) {
	            System.out.print("Nombre de pages : ");
	            try {
	                pages = Integer.parseInt(s.nextLine());
	                if (pages > 0) {
	                    return pages;
	                } else {
	                    System.out.println("Le nombre de pages doit être supérieur à zéro.");
	                }
	            } catch (NumberFormatException e) {
	                System.out.println("Veuillez entrer un nombre valide pour les pages.");
	            }
	        }
	    }
	    
	    public static String validateIsbn(String msg) {
	    	String userInput;
	        do {
	            System.out.print(msg);
	            userInput = s.nextLine();
	            
	            if (userInput == null || userInput.trim().isEmpty()) {
	                System.out.println("Erreur: l'entrée ne peut pas être vide. Veuillez réessayer.");
	                continue;
	            }
	            
	            if (!userInput.matches("\\d{13}")) {  
	                System.out.println("Erreur: l'ISBN doit contenir exactement 13 chiffres. Veuillez réessayer.");
	                continue; 
	            }
	            
	            break; // input passes all checks	
	        } while (true);      
	        return userInput; 
	    }
	    

}
