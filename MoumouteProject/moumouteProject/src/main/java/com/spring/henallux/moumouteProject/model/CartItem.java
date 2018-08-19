package com.spring.henallux.moumouteProject.model;


public class CartItem
{
    public CartItem(int numLine, double EVATPrice, double VATRate, int quantity, String pictureLink, String wigName) {
        this.numLine = numLine;
        this.EVATPrice = EVATPrice;
        this.VATRate = VATRate;
        this.quantity = quantity;
        this.pictureLink = pictureLink;
        this.wigName = wigName;
    }

    public int getNumLine() {
        return numLine;
    }

    public void setNumLine(int numLine) {
        this.numLine = numLine;
    }

    private int numLine;
    private double EVATPrice;
    private double VATRate;
    private int quantity;
    private String pictureLink;
    private String wigName;



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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
}
