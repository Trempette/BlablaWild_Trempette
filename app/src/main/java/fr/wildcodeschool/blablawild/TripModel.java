package fr.wildcodeschool.blablawild;


import java.text.SimpleDateFormat;
import java.util.Date;

public class TripModel {

    private String prenom;
    private String nom;
    private Date date;
    private int prix;

    public TripModel(String prenom, String nom, Date date, int prix){
        this.prenom=prenom;
        this.nom=nom;
        this.date = date;
        this.prix = prix;


    }

    public Date getDate() {
        return date;
    }

    public int getPrix() {
        return prix;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }
}
