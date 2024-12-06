package com.mycorp.birdobs.models;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Observation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportID;

    private String nom;
    private String espece;
    private Integer nombre;
    private String ville;
    private Timestamp date_pub;

    public Integer getReportID() {
        return reportID;
    }

    public void setReportID(Integer reportID) {
        this.reportID = reportID;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEspece() {
        return espece;
    }

    public void setEspece(String espece) {
        this.espece = espece;
    }

    public Integer getNombre() {
        return nombre;
    }

    public void setNombre(Integer nombre) {
        this.nombre = nombre;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Timestamp getDate_pub() {
        return date_pub;
    }

    public void setDate_pub(Timestamp date_pub) {
        this.date_pub = date_pub;
    }

    @Override
    public String toString() {
        return "Report(" + 
            "id=" + reportID +
            ", nom=" + nom +
            ", espece=" + espece +
            ", nombre=" + nombre +
            ", ville=" + ville +
            ", date_pub=" + date_pub +
            ")";
    }
}