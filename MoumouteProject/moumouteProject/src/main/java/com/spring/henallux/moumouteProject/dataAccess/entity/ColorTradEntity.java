package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name = "colortrad")
public class ColorTradEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "colorname")
    private String colorName;

    @JoinColumn(name = "colorid", referencedColumnName = "id")
    @ManyToOne
    private ColorEntity color;

    @JoinColumn(name = "languagecode", referencedColumnName = "code")
    @ManyToOne
    private LanguageEntity language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
