package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Librairie {
    private List<Book> livres;

    public Librairie(List<Book> livres) {
        this.livres = livres;
    }

    public Librairie() {
        this.livres = new ArrayList<>();
    }

    public void ajouterLivre(Book livre) {
        livres.add(livre);
    }

    public void supprimerLivre(Book livre) {
        livres.remove(livre);
    }

    public void afficherLivres() {
        if (livres.isEmpty()) {
            System.out.println("La bibliothèque est vide.");
        } else {
            System.out.println("Liste des livres :");
            for (Book livre : livres) {
                System.out.println("Titre : " + livre.getTitre());
                System.out.println("Auteur : " + livre.getAuteur());
                System.out.println("ISBN : " + livre.getIsbn());
                System.out.println("---------------------------");
            }
        }
    }

    public Book chercherLivre(String titre, String auteur) {
        for (Book livre : livres) {
            if (livre.getTitre().equalsIgnoreCase(titre) && livre.getAuteur().equalsIgnoreCase(auteur)) {
                return livre;
            }
        }
        return null;
    }

    public double calculerAmende(Book livre) {
        if (livre.getDateRetour() != null && livre.getDateRetour().isAfter(livre.getDateEmprunt())) {
            LocalDate dateActuelle = LocalDate.now();
            long joursRetard = livre.getDateRetour().toEpochDay() - livre.getDateEmprunt().toEpochDay();
            long semainesRetard = joursRetard / 7;
            return semainesRetard * 2.5; // Supposons une amende de 2,50 euros par semaine de retard
        } else {
            return 0.0;
        }
    }

}
