package com.example.myapp.model;


import java.util.LinkedList;

public class Professeur {
    private String nom;
    private String prenom;
    private String tel;
    private String departement;
    private  String photo;
    //...

    public Professeur(String nom, String prenom, String tel, String departement, String photo){
        this.nom= new String(nom);
        this.prenom= new String(prenom);
        this.tel= new String(tel);
        this.departement=departement;
        this.photo=photo;

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

