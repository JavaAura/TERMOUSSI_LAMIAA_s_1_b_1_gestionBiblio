package Biblio;

import java.time.LocalDate;

public class Magazine extends Document {
    private String numero;

    public Magazine(String id, String titre, String auteur, LocalDate datePublication, int nombreDePages, String numero) {
        super(id, titre, auteur, datePublication, nombreDePages);
        this.numero = numero;
    }

    @Override
    public void emprunter() {
        if (!isEstEmprunte()) {
            setEstEmprunte(true);
            System.out.println("Le magazine '" + getTitre() + "' a été emprunté avec succès.");
        } else {
            System.out.println("Le magazine '" + getTitre() + "' est indisponible.");
        }
    }

    @Override
    public void retourner() {
        if (isEstEmprunte()) {
            setEstEmprunte(false);
            System.out.println("Le magazine '" + getTitre() + "' a été retourné avec succès.");
        } else {
            System.out.println("Le magazine '" + getTitre() + "' a déjà été retourné.");
        }
    }

    @Override
    public void afficherDetails() {
        System.out.println("Magazine - ID: " + getId()
                + ", Titre: " + getTitre()
                + ", Auteur: " + getAuteur()
                + ", Date de Publication: " + getDatePublication()
                + ", Nombre de Pages: " + getNombreDePages()
                + ", Numéro: " + numero);
    }
}
