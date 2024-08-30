package Biblio;

import java.time.LocalDate;

public abstract class Document {
	
	  	protected String id;
	    protected String titre;
	    protected String auteur;
	    protected LocalDate datePublication;
	    protected int nombreDePages;
	    
	    public Document(String id, String t, String aut, LocalDate datePub, int nbrPages) {
	        this.id = id;
	        this.titre = t;
	        this.auteur = aut;
	        this.datePublication = datePub;
	        this.nombreDePages = nbrPages;
	    }
	    
	    public abstract void emprunter();
	    public abstract void retourner();
	    public abstract void afficherDetails();
}
