package com.salwa.soretrak.Model;

public class DataModel {

    int id,quantite;
    String nom, prenom, pseudo, email, mot_de_passe, type;
    String reference,numero;

    public DataModel(int id,int quantite,String numero,String reference, String nom, String prenom, String pseudo, String email, String mot_de_passe, String type) {
        this.id = id;
        this.nom = nom;
        this.quantite = quantite;
        this.prenom = prenom;
        this.numero=numero;
        this.pseudo = pseudo;
        this.reference = reference;
        this.email = email;
        this.mot_de_passe = mot_de_passe;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
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

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
