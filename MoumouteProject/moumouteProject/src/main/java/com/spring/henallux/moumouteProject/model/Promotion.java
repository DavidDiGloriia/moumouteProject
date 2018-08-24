package com.spring.henallux.moumouteProject.model;

import com.spring.henallux.moumouteProject.dataAccess.entity.WigEntity;

import java.util.Date;

public class Promotion
{
    private Date endDate;
    private Date startDate;
    private double percRed;

    public Promotion() {}

    public Promotion(Date endDate, Date startDate, double percRed) {
        this.endDate = endDate;
        this.startDate = startDate;
        this.percRed = percRed;
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
}
