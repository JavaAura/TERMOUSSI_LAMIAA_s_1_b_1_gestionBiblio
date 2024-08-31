package Biblio;


public class Livre  extends Document {
		private String isbn;

		public Livre(String id, String titre, String auteur, String datePublication, int nombreDePages, String isbn) {
	        super(id, titre, auteur, datePublication, nombreDePages);
	        this.isbn = isbn;
	    }
	    
	    @Override
	    public void emprunter() {
	    	  if (!estEmprunte) {
	              estEmprunte = true;
	              System.out.println("Le livre '" + titre + "' a été emprunté avec succés.");
	          } else {
	              System.out.println("Le livre '" + titre + "' est indisponible.");
	          }
	    }
	    
	    @Override
	    public void retourner() {
	        System.out.println("Le livre '" + titre + "' a été retourné.");
	    }
	    
	    @Override
	    public void afficherDetails() {
	    	System.out.println("Livre - ID: " + id 
	                + ", Titre: " + titre 
	                + ", Auteur: " + auteur 
	                + ", Date de Publication: " + datePublication 
	                + ", Nombre de Pages: " + nombreDePages 
	                + ", ISBN: " + isbn);
	    }
	    
	 
}
