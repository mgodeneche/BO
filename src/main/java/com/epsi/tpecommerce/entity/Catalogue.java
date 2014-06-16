package com.epsi.tpecommerce.entity;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name="CATALOGUE ")
public class Catalogue {
    @Column(name="idCatalogue")
    private int idCatalogue;

    @Column(name="nom")
    private String nom;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateDebut")
    private Calendar dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="DateFin")
    private Calendar dateFin;

    @ManyToOne
    @JoinColumn(name="Tva", referencedColumnName ="idTva")
    private Tva tva;

    @ManyToOne
    @JoinColumn(name="Prix", referencedColumnName ="idPrix")
    private Prix prix;

    @ManyToOne
    @JoinColumn(name="Produit", referencedColumnName ="idProduit")
    private Produit produit;

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public int getIdCatalogue() {
        return idCatalogue;
    }

    public void setIdCatalogue(int idCatalogue) {
        this.idCatalogue = idCatalogue;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Calendar getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Calendar dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Calendar getDateFin() {
        return dateFin;
    }

    public void setDateFin(Calendar dateFin) {
        this.dateFin = dateFin;
    }

    public Tva getTva() {
        return tva;
    }

    public void setTva(Tva tva) {
        this.tva = tva;
    }

    public Prix getPrix() {
        return prix;
    }

    public void setPrix(Prix prix) {
        this.prix = prix;
    }
}
