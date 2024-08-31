package Biblio;


public class Magazine extends Document {
	private String numero;

    public Magazine(String id, String titre, String auteur, String datePublication, int nombreDePages, String numero) {
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
        System.out.println("Le magazine '" + titre + "' a été retourné.");
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
