package com.spring.henallux.moumouteProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Promotion")
public class PromotionEntity {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "enddate")
    private Date endDate;

    @Column(name = "startdate")
    private Date startDate;

    @Column(name = "percred")
    private double percRed;

    @JoinColumn(name = "wigid", referencedColumnName = "id")
    @ManyToOne
    private WigEntity wig;

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
