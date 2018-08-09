package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "color")
public class ColorEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "rgb")
    private String rgb;

    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private Collection<WigColorEntity> wigColors;

    @OneToMany(mappedBy = "color", fetch = FetchType.LAZY)
    private Collection<ColorTradEntity> colorTrads;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }

    public Collection<WigColorEntity> getWigColors() {
        return wigColors;
    }

    public void setWigColors(Collection<WigColorEntity> wigColors) {
        this.wigColors = wigColors;
    }

    public Collection<ColorTradEntity> getColorTrads() {
        return colorTrads;
    }

    public void setColorTrads(Collection<ColorTradEntity> colorTrads) {
        this.colorTrads = colorTrads;
    }
}
