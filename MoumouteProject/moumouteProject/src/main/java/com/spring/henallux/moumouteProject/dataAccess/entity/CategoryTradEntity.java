package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name = "categorytrad")
public class CategoryTradEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "categoryname")
    private String categoryName;

    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    @JoinColumn(name = "languagecode", referencedColumnName = "code")
    @ManyToOne
    private LanguageEntity language;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public LanguageEntity getLanguage() {
        return language;
    }

    public void setLanguage(LanguageEntity language) {
        this.language = language;
    }
}
