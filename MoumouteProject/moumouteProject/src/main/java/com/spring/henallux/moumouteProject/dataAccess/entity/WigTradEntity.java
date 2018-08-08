package com.spring.henallux.moumouteProject.dataAccess.entity;

import javax.persistence.*;

@Entity
@Table(name = "wigtrad")
public class WigTradEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "wigname")
    private String wigName;

    @Column(name = "description")
    private String description;

    @JoinColumn(name = "wigid", referencedColumnName = "id")
    @ManyToOne
    private WigEntity wig;

    @JoinColumn(name = "languagecode", referencedColumnName = "code")
    @ManyToOne
    private LanguageEntity language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public WigEntity getWig() {
        return wig;
    }

    public void setWig(WigEntity wig) {
        this.wig = wig;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
