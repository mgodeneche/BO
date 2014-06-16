package com.epsi.tpecommerce.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="Approvisionnement")
public class Approvisionnement {

	@Id
	@Column(name="idAppro")
	private int idAppro;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dateCommande")
	private Calendar datetCommande;
	
	@Column(name="qte")
	private int qte;
	
	@Column(name="reception")
	private int reception;
}
