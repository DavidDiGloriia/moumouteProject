package com.spring.henallux.moumouteProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "wigcolor")
public class WigColorEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @JoinColumn(name = "wigid", referencedColumnName = "id")
    @ManyToOne
    private WigEntity wig;

    @JoinColumn(name = "colorid", referencedColumnName = "id")
    @ManyToOne
    private ColorEntity color;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WigEntity getWig() {
        return wig;
    }

    public void setWig(WigEntity wig) {
        this.wig = wig;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }
}
