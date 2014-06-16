package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity
@Table(name="Categorie")
public class Categorie {

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Id
    @Column(name="idCat")
    private int idCat;

    @Column(name="nom")
    private String nom;



}
