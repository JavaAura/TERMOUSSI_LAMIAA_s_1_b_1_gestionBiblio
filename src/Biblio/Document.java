package Biblio;



public abstract class Document {
	
	  	protected String id;
	    protected String titre;
	    protected String auteur;
	    protected String datePublication;
	    protected int nombreDePages;
	    
	    protected boolean estEmprunte; 

	    
	    public Document(String id, String t, String aut, String datePub, int nbrPages) {
	        this.id = id;
	        this.titre = t;
	        this.auteur = aut;
	        this.datePublication = datePub;
	        this.nombreDePages = nbrPages;
	    
	        this.estEmprunte = false;
	    }
	    
	    public abstract void emprunter();
	    public abstract void retourner();
	    public abstract void afficherDetails();
	    

	    public boolean isEmprunte() {
	        return estEmprunte;
	    }

	    public void setEmprunte(boolean estEmprunte) {
	        this.estEmprunte = estEmprunte;  //true
	    }
}
