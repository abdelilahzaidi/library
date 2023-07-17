package org.example;

import java.util.Objects;

public class User {
    private String nom;
    private String prenom;

    public User(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(getNom(), user.getNom()) && Objects.equals(getPrenom(), user.getPrenom());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNom(), getPrenom());
    }

    @Override
    public String toString() {
        return "User{" +
                "nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                '}';
    }
}
