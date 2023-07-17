package org.example;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String titre;
    private String auteur;
    private String isbn;
    private User emprunteur;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public Book(String titre, String auteur, String isbn, User emprunteur, LocalDate dateEmprunt, LocalDate dateRetour) {
        this.titre = titre;
        this.auteur = auteur;
        this.isbn = isbn;
        this.emprunteur = emprunteur;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public User getEmprunteur() {
        return emprunteur;
    }

    public void setEmprunteur(User emprunteur) {
        this.emprunteur = emprunteur;
    }

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }

    public boolean emprunter(User utilisateur, LocalDate dateEmprunt, LocalDate dateRetour) {
        if (this.emprunteur == null && dateEmprunt.isBefore(dateRetour)) {
            this.emprunteur = utilisateur;
            this.dateEmprunt = dateEmprunt;
            this.dateRetour = dateRetour;
            return true;
        } else {
            return false;
        }
    }

    public boolean rendre() {
        if (this.emprunteur != null) {
            this.emprunteur = null;
            this.dateEmprunt = null;
            this.dateRetour = null;
            return true;
        } else {
            return false;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return Objects.equals(getTitre(), book.getTitre()) && Objects.equals(getAuteur(), book.getAuteur()) && Objects.equals(getIsbn(), book.getIsbn()) && Objects.equals(getEmprunteur(), book.getEmprunteur()) && Objects.equals(getDateEmprunt(), book.getDateEmprunt()) && Objects.equals(getDateRetour(), book.getDateRetour());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitre(), getAuteur(), getIsbn(), getEmprunteur(), getDateEmprunt(), getDateRetour());
    }

    public Book() {
        super();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Book{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", isbn='" + isbn + '\'' +
                ", emprunteur=" + emprunteur +
                ", dateEmprunt=" + dateEmprunt +
                ", dateRetour=" + dateRetour +
                '}';
    }
}
