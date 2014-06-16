package com.epsi.tpecommerce.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Commande")
public class Commande {
    @Column(name="idCommande")
    private int idCommande;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dateDebut")
    private Calendar dateDebut;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="dateFin")
    private Calendar dateFin;

    @Column(name="Qte")
    private int qte;

    @ManyToOne
    @JoinColumn(name="Client", referencedColumnName="idClient")
    private Client client;
    
    @ManyToOne
    @JoinColumn(name="HistoriqueStatutCmd", referencedColumnName="idHistoStatutCmd")
    private HistoriqueStatutCmd historiqueStatutCmd;
    
    @ManyToOne
    @JoinColumn(name="Produit", referencedColumnName="idProduit")
    private Produit produit;

	public int getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
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

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public HistoriqueStatutCmd getHistoriqueStatutCmd() {
		return historiqueStatutCmd;
	}

	public void setHistoriqueStatutCmd(HistoriqueStatutCmd historiqueStatutCmd) {
		this.historiqueStatutCmd = historiqueStatutCmd;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}
}
