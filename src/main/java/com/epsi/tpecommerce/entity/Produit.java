package com.epsi.tpecommerce.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="PRODUIT ")
public class Produit {
    @Id
    @Column(name="idProduit")
    private int idProduit;

    @ManyToOne
    @JoinColumn(name="fournisseur", referencedColumnName="idFournisseur")
    private Fournisseur fournisseur;

    @ManyToOne
    @JoinColumn(name="tva", referencedColumnName="idTva")
    private Tva tva;

    @ManyToOne
    @JoinColumn(name="sousCategorie", referencedColumnName="idSousCat")
    private SousCategorie sousCategorie;

    @Column(name="nom",nullable=false,length = 50)
    private String nom;

    @Column(name = "description",nullable=false,length = 250)
    private String description;

    @Column(name = "qteStock",nullable=false)
    private int qteStock;



    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int p_idProduit) {
        idProduit = p_idProduit;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur p_fournisseur) {
        fournisseur = p_fournisseur;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva p_tva) {
        tva = p_tva;
    }

    public SousCategorie getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(SousCategorie p_sousCat) {
        sousCategorie = p_sousCat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQteStock() {
        return qteStock;
    }

    public void setQteStock(int qteStock) {
        this.qteStock = qteStock;
    }

}
