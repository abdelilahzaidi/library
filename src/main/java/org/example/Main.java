package org.example;

import java.time.LocalDate;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Librairie bibliotheque = new Librairie();
        User utilisateur = new User("John", "Doe");
        User utilisateur1 = new User("Johana", "La sainte");
        User utilisateur2= new User("Laure", "Mbelz");
        LocalDate dateEmprunt = LocalDate.of(2023, 7, 1);
        LocalDate dateRetour = LocalDate.of(2023, 7, 15);

        LocalDate dateEmprunt1 = LocalDate.of(2023, 7, 2);
        LocalDate dateRetour1 = LocalDate.of(2023, 7, 25);

        Book livre1 = new Book("Harry Potter à l'école des sorciers", "J.K. Rowling", "9782070643028", utilisateur,dateEmprunt,dateRetour);
        Book livre2 = new Book("Le Seigneur des Anneaux", "J.R.R. Tolkien", "9782070619511",utilisateur1,dateEmprunt,dateRetour);
        Book livre3 = new Book("1984", "George Orwell", "9782070343095",utilisateur2,dateEmprunt1,dateRetour1);

        bibliotheque.ajouterLivre(livre1);
        bibliotheque.ajouterLivre(livre2);
        bibliotheque.ajouterLivre(livre3);

        bibliotheque.afficherLivres();




        Book livreRecherche = bibliotheque.chercherLivre("Harry Potter à l'école des sorciers", "J.K. Rowling");
        if (livreRecherche != null) {
            System.out.println("Le livre recherché existe dans la bibliothèque.");
        } else {
            System.out.println("Le livre recherché n'existe pas dans la bibliothèque.");
        }

        boolean empruntReussi = livre1.emprunter(utilisateur, dateEmprunt, dateRetour);

        if (empruntReussi) {
            System.out.println("Le livre a été emprunté avec succès par " + utilisateur.getPrenom() + " " + utilisateur.getNom());
        } else {
            System.out.println("Le livre est déjà emprunté ou les dates d'emprunt et de retour sont invalides.");
        }

        boolean retourReussi = livre1.rendre();
        if (retourReussi) {
            System.out.println("Le livre a été rendu avec succès.");
            double amende = bibliotheque.calculerAmende(livre1);
            if (amende > 0.0) {
                System.out.println("Amende à payer : " + amende + " euros.");
            } else {
                System.out.println("Pas d'amende.");
            }
        } else {
            System.out.println("Le livre n'était pas emprunté.");
        }
    }


}