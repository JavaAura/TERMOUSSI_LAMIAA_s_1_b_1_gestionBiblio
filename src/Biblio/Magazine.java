package Biblio;

import java.time.LocalDate;

public class Magazine extends Document {
	private String numero;

    public Magazine(String id, String titre, String auteur, LocalDate  datePublication, int nombreDePages, String numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }
    

    @Override
    public void emprunter() {
    	if (!estEmprunte) {
            estEmprunte = true;
            System.out.println("Le magazine '" + titre + "' a été emprunté avec succés.");
        } else {
            System.out.println("Le magazine '" + titre + "' est indisponible.");
        }
    }

    @Override
    public void retourner() {
    	if (estEmprunte) {
   		 estEmprunte = false;
   		 System.out.println("Le magazine '" + titre + "' a été retourné avec succés.");
    	}       
    	else {
   		 System.out.println("Le magazine '" + titre + "' a été déja retourné.");
    	}
    }

    @Override
    public void afficherDetails() {
    	 System.out.println("Magazine - ID: " + id
    	            + ", Titre: " + titre
    	            + ", Auteur: " + auteur
    	            + ", Date de Publication: " + datePublication
    	            + ", Nombre de Pages: " + nombreDePages
    	            + ", Numéro: " + numero);
    }
}
