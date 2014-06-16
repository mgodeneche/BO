package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.Calendar;

@Entity
@Table(name="HistoriqueStatueCmd")
public class HistoriqueStatutCmd {
    @Id
    @Column(name="idHistoStatutCmd")
    private int idHistoStatutCmd;

    @Column(name="dateStatut")
    private Calendar dateStatut;

    @Column(name="IdStatutCmd")
    private StatutCmd statut;

    public int getIdHistoStatutCmd() {
        return idHistoStatutCmd;
    }

    public void setIdHistoStatutCmd(int idHistoStatutCmd) {
        this.idHistoStatutCmd = idHistoStatutCmd;
    }

    public Calendar getDateStatut() {
        return dateStatut;
    }

    public void setDateStatut(Calendar dateStatut) {
        this.dateStatut = dateStatut;
    }

    public StatutCmd getStatut() {
        return statut;
    }

    public void setStatut(StatutCmd statut) {
        this.statut = statut;
    }
}
