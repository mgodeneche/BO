package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity(name = "Tva")
public class Tva {

    @Id
    @Column(name="idTva")
    private int idTva;

    @Column(name="nom")
    private String nom;

    @Column(name="taux")
    private double taux;

    public int getIdTva() {
        return idTva;
    }

    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
