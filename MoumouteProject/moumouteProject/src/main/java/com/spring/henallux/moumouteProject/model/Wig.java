package com.spring.henallux.moumouteProject.model;

public class Wig
{
    private int id;
    private double EVATPrice;
    private double VATRate;
    private boolean isMan;
    private String pictureLink;
    private String wigName;
    private String description;
    private int categoryId;

    public Wig()
    {}

    public Wig(int id, double EVATPrice, double VATRate, boolean isMan, String pictureLink, String wigName, String description, int categoryId) {
        this.id = id;
        this.EVATPrice = EVATPrice;
        this.VATRate = VATRate;
        this.isMan = isMan;
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

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
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
}
