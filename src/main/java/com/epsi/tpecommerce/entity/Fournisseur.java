package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity(name="Fournisseurs")
public class Fournisseur {

    @Id
    @Column(name="idFournisseur")
    private int idFournissur;

    @Column(name="nom")
    private String nom;

    @Column(name="email")
    private String email;
}
