package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity
public class StatutCmd {
    @Id
    @Column(name="idStatutCmd")
    private int idStatut;

    @Column(name="nom")
    private String nom;

    public int getIdStatut() {
        return idStatut;
    }

    public void setIdStatut(int idStatut) {
        this.idStatut = idStatut;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
