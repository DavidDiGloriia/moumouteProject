package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "language")
public class LanguageEntity
{
    @Id
    @Column(name = "code")
    private String code;

    @OneToMany(mappedBy = "languagecode", fetch = FetchType.LAZY)
    private Collection<CategoryTradEntity> categoryTrads;

    @OneToMany(mappedBy = "languagecode", fetch = FetchType.LAZY)
    private Collection<WigTradEntity> wigTrads;

    @OneToMany(mappedBy = "languagecode", fetch = FetchType.LAZY)
    private Collection<ColorTradEntity> colorTrads;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Collection<CategoryTradEntity> getCategoryTrads() {
        return categoryTrads;
    }

    public void setCategoryTrads(Collection<CategoryTradEntity> categoryTrads) {
        this.categoryTrads = categoryTrads;
    }

    public Collection<WigTradEntity> getWigTrads() {
        return wigTrads;
    }

    public void setWigTrads(Collection<WigTradEntity> wigTrads) {
        this.wigTrads = wigTrads;
    }

    public Collection<ColorTradEntity> getColorTrads() {
        return colorTrads;
    }

    public void setColorTrads(Collection<ColorTradEntity> colorTrads) {
        this.colorTrads = colorTrads;
    }
}
