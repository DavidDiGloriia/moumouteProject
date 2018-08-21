package com.spring.henallux.moumouteProject.model;

import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;

import java.util.Date;

public class Promotion
{
    private Integer id;
    private Date endDate;
    private Date startDate;
    private double percRed;
    private WigEntity wig;

    public Promotion() {}

    public Promotion(Integer id, Date endDate, Date startDate, double percRed, WigEntity wig) {
        this.id = id;
        this.endDate = endDate;
        this.startDate = startDate;
        this.percRed = percRed;
        this.wig = wig;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public double getPercRed() {
        return percRed;
    }

    public void setPercRed(double percRed) {
        this.percRed = percRed;
    }

    public WigEntity getWig() {
        return wig;
    }

    public void setWig(WigEntity wig) {
        this.wig = wig;
    }
}
