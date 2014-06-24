package com.epsi.tpecommerce.entity;

import javax.persistence.*;

@Entity
@Table(name="CLIENT")
public class Client {

    @Id
    @Column(name="idClient")
    @GeneratedValue(strategy=GenerationType.AUTO,generator="SEQ_CLIENT")
    @SequenceGenerator(name="SEQ_CLIENT",sequenceName="SEQ_CLIENT")
    private int idClient;

    @Column(name="prenom", nullable=false, length=250)
    private String prenom;

    @Column(name="nom", nullable=false, length=250)
    private String nom;

    @Column(name="email", nullable=false, length=250)
    private String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public Client(String prenom, String nom, String email) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
    }
}
