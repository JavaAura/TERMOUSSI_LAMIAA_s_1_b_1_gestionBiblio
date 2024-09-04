package Biblio;

import java.time.LocalDate;

public class Livre extends Document {
    private String isbn;

    public Livre(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String isbn) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.isbn = isbn;
    }

    @Override
    public void emprunter() {
        if (!isEstEmprunte()) {
            setEstEmprunte(true);
            System.out.println("Le livre '" + getTitre() + "' a été emprunté avec succès.");
        } else {
            System.out.println("Le livre '" + getTitre() + "' est indisponible.");
        }
    }

    @Override
    public void retourner() {
        if (isEstEmprunte()) {
            setEstEmprunte(false);
            System.out.println("Le livre '" + getTitre() + "' a été retourné avec succès.");
        } else {
            System.out.println("Le livre '" + getTitre() + "' a déjà été retourné.");
        }
    }

    @Override
    public void afficherDetails() {
        System.out.println("Livre - ID: " + getId()
                + ", Titre: " + getTitre()
                + ", Auteur: " + getAuteur()
                + ", Date de Publication: " + getDatePublication()
                + ", Nombre de Pages: " + getNombreDePages()
                + ", ISBN: " + isbn);
    }
}
