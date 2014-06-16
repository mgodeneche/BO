package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Fournisseur")
public class Fournisseur {

    @Id
    @Column(name="idFournisseur")
    private int idFournisseur;

    @Column(name="nom")
    private String nom;

    @Column(name="email")
    private String email;

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournissur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
