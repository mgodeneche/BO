package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity(name="SousCategorie")
public class SousCategorie {

    public int getIdSousCat() {
        return idSousCat;
    }

    public void setIdSousCat(int idSousCat) {
        this.idSousCat = idSousCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Id
    @Column(name="idSousCat")
    private int idSousCat;

    @Column(name="nom")
    private String nom;
}
