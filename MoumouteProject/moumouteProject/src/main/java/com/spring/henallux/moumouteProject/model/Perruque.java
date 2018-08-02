package com.spring.henallux.moumouteProject.model;

public class Perruque {

    public int numPerruque;
    public double prixHTVA;
    public double tauxTVA;
    public boolean estHomme;
    public boolean estFemme;
    public String  lienImage;

    public Perruque(int numPerruque, double prixHTVA, double tauxTVA, boolean estHomme, boolean estFemme, String lienImage) {
        this.numPerruque = numPerruque;
        this.prixHTVA = prixHTVA;
        this.tauxTVA = tauxTVA;
        this.estHomme = estHomme;
        this.estFemme = estFemme;
        this.lienImage = lienImage;
    }

    public int getNumPerruque() {
        return numPerruque;
    }

    public void setNumPerruque(int numPerruque) {
        this.numPerruque = numPerruque;
    }

    public double getPrixHTVA() {
        return prixHTVA;
    }

    public void setPrixHTVA(double prixHTVA) {
        this.prixHTVA = prixHTVA;
    }

    public double getTauxTVA() {
        return tauxTVA;
    }

    public void setTauxTVA(double tauxTVA) {
        this.tauxTVA = tauxTVA;
    }

    public boolean isEstHomme() {
        return estHomme;
    }

    public void setEstHomme(boolean estHomme) {
        this.estHomme = estHomme;
    }

    public boolean isEstFemme() {
        return estFemme;
    }

    public void setEstFemme(boolean estFemme) {
        this.estFemme = estFemme;
    }

    public String getLienImage() {
        return lienImage;
    }

    public void setLienImage(String lienImage) {
        this.lienImage = lienImage;
    }
}
