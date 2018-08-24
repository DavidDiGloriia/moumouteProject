package com.spring.henallux.moumouteProject.model;

public class Wig
{
    private int id;
    private double EVATPrice;
    private double VATRate;
    private String pictureLink;
    private String wigName;
    private String description;
    private int categoryId;
    private Promotion promotion;


    public Wig()
    {}

    public Wig(int id, double EVATPrice, double VATRate, String pictureLink, String wigName, String description, int categoryId) {
        this.id = id;
        this.EVATPrice = EVATPrice;
        this.VATRate = VATRate;
        this.pictureLink = pictureLink;
        this.wigName = wigName;
        this.description = description;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getEVATPrice() {
        return EVATPrice;
    }

    public void setEVATPrice(double EVATPrice) {
        this.EVATPrice = EVATPrice;
    }

    public double getVATRate() {
        return VATRate;
    }

    public void setVATRate(double VATRate) {
        this.VATRate = VATRate;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public String getWigName() {
        return wigName;
    }

    public void setWigName(String wigName) {
        this.wigName = wigName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public double getPrice() {
        return Math.round((this.getEVATPrice() * (1 + (this.getVATRate()/100))) * 100.0) / 100.0;
    }

    public double getReductedPrice() {
        return Math.round(((1 - (this.getPromotion().getPercRed()/100)) * this.getPrice()) * 100.0) / 100.0;
    }
}
