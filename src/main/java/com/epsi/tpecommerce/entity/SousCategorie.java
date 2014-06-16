package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="SousCategorie")
public class SousCategorie {

    @Id
    @Column(name="idSousCat")
    private int idSousCat;

    @Column(name="nom")
    private String nom;
    
    @ManyToOne
    @JoinColumn(name="Categorie", referencedColumnName="idCat")
    private Categorie categorie;

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

    public Categorie getCategorie() {
    	return categorie;
    }
    
    public void setCategorie(Categorie p_categorie) {
    	categorie = p_categorie;
    }
}
