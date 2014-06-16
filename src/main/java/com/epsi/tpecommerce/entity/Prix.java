package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="prix")
public class Prix {

    @Id
    @Column(name="idPrix")
    private int idPrix;

    @Column(name="prix")
    private double prix;

    public int getIdPrix() {
        return idPrix;
    }

    public void setIdPrix(int idPrix) {
        this.idPrix = idPrix;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}
