package com.epsi.tpecommerce.entity;

/**
 * Created by Maxence on 04/06/2014.
 */
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name="PRODUIT ")
public class Produit {
    @Id
    @Column(name="idProduit")
    private int idProduit;

    @Column(name="idFournisseur",nullable=false)
    private int idFournisseur;

    @Column(name="idTva",nullable=false)
    private int idTva;

    @Column(name="idSousCategorie",nullable=false)
    private String idSousCategorie;

    @Column(name="nom",nullable=false,length = 50)
    private String nom;

    @Column(name = "description",nullable=false,length = 250)
    private String description;

    @Column(name = "qteStock",nullable=false)
    private int qteStock;


    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public int getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(int idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    public String getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(String idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
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
