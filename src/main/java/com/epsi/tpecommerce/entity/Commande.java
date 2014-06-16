package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Calendar;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity
public class Commande {


    @Column(name="idCommande")
    private int idCommande;

    @Column(name="dateDebut")
    private Calendar dateDebut;

    @Column(name="dateFin")
    private Calendar dateFin;

    @Column(name="Qte")
    private int Qte;


}
