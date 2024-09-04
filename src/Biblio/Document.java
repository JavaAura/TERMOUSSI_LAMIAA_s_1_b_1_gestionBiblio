package Biblio;

import java.time.LocalDate;


public abstract class Document {
	
	  private String id;
	  private String titre;
	  private String auteur;
	  private LocalDate   datePublication;
	  private int nombreDePages;
	    
	    protected boolean estEmprunte; 

	    
	    public Document(String id, String t, String aut, LocalDate   datePub, int nbrPages) {
	        this.id = id;
	        this.titre = t;
	        this.auteur = aut;
	        this.datePublication = datePub;
	        this.nombreDePages = nbrPages;
	    
	        this.estEmprunte = false;
	    }
	    
	    public String getId() {
	        return id;
	    }

	    public String getTitre() {
	        return titre;
	    }

	    public String getAuteur() {
	        return auteur;
	    }

	    public LocalDate getDatePublication() {
	        return datePublication;
	    }

	    public int getNombreDePages() {
	        return nombreDePages;
	    }

	    public boolean isEstEmprunte() {
	        return estEmprunte;
	    }

	    public void setEstEmprunte(boolean estEmprunte) {
	        this.estEmprunte = estEmprunte;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }
	    public abstract void emprunter();
	    public abstract void retourner();
	    public abstract void afficherDetails();
	    



}
