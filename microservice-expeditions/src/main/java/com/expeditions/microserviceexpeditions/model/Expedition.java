package com.expeditions.microserviceexpeditions.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Expedition {

    @Id
    @GeneratedValue
    private int id;

    private String idCommande;

    private String etat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(String idCommande) {
        this.idCommande = idCommande;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Expedition{" +
                "id=" + id +
                ", idCommande='" + idCommande + '\'' +
                ", etat='" + etat + '\'' +
                '}';
    }
}
