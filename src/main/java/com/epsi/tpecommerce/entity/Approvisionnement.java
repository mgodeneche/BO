package com.epsi.tpecommerce.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Approvisionnement")
public class Approvisionnement {

	@Id
	@Column(name="idAppro")
	private int idAppro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCommande")
	private Calendar dateCommande;
	
	@Column(name="qte")
	private int qte;
	
	@Column(name="reception")
	private int reception;
	
	@ManyToOne
    @JoinColumn(name="Produit", referencedColumnName ="idProduit")
	private Produit produit;

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public int getIdAppro() {
		return idAppro;
	}

	public void setIdAppro(int idAppro) {
		this.idAppro = idAppro;
	}

	public Calendar getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Calendar dateCommande) {
		this.dateCommande = dateCommande;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public int getReception() {
		return reception;
	}

	public void setReception(int reception) {
		this.reception = reception;
	}
	
	
}
