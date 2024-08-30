package Biblio;



public abstract class Document {
	
	  	protected String id;
	    protected String titre;
	    protected String auteur;
	    protected String datePublication;
	    protected int nombreDePages;
	    
	    public Document(String id, String t, String aut, String datePub, int nbrPages) {
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
