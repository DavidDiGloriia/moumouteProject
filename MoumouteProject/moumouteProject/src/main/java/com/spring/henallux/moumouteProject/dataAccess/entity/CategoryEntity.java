package com.spring.henallux.moumouteProject.dataAccess.entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "category")
public class CategoryEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @OneToMany(mappedBy = "category")
    private Collection<WigEntity> wigs;

    @OneToMany(mappedBy = "category")
    private Collection<CategoryTradEntity> categoryTrads;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Collection<WigEntity> getWigs() {
        return wigs;
    }

    public void setWigs(Collection<WigEntity> wigs) {
        this.wigs = wigs;
    }

    public Collection<CategoryTradEntity> getCategoryTrads() {
        return categoryTrads;
    }

    public void setCategoryTrads(Collection<CategoryTradEntity> categoryTrads) {
        this.categoryTrads = categoryTrads;
    }
}
