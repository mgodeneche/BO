package com.epsi.tpecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Calendar;

/**
 * Created by maxencegodeneche on 16/06/2014.
 */
@Entity
public class HistoriqueStatutCmd {
    @Id
    @Column(name="idHistoStatutCmd")
    private int idHistoStatutCmd;

    @Column(name="dateStatut")
    private Calendar dateStatut;

    @Column(name="IdStatutCmd")
    private Statut statut;

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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
}
