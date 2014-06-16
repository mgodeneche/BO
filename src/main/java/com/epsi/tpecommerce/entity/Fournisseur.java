package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Fournisseur")
public class Fournisseur {

    @Id
    @Column(name="idFournisseur")
    private int idFournissur;

    @Column(name="nom")
    private String nom;

    @Column(name="email")
    private String email;

    public int getIdFournissur() {
        return idFournissur;
    }

    public void setIdFournissur(int idFournissur) {
        this.idFournissur = idFournissur;
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
