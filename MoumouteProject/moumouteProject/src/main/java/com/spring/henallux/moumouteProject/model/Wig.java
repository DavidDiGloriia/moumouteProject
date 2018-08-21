package com.spring.henallux.moumouteProject.model;

import java.util.Date;

public class Wig
{
    private int id;
    private double EVATPrice;
    private double VATRate;
    private String pictureLink;
    private String wigName;
    private String description;
    private int categoryId;
    private double percRed;
    private Date   endDateRed;






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

    public double getPercRed() {
        return percRed;
    }

    public void setPercRed(double percRed) {
        this.percRed = percRed;
    }

    public Date getEndDateRed() {
        return endDateRed;
    }

    public void setEndDateRed(Date endDateRed) {
        this.endDateRed = endDateRed;

    }
}
