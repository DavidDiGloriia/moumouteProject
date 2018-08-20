package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "wig")
public class WigEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "evatprice")
    private double EVATPrice;

    @Column(name = "vatrate")
    private double VATRate;

    @Column(name = "isman")
    private boolean isMan;

    @Column(name = "picturelink")
    private String pictureLink;

    @OneToMany(mappedBy = "wig", fetch = FetchType.LAZY)
    private Collection<SaleLineEntity> saleLines;

    @OneToMany(mappedBy = "wig", fetch = FetchType.LAZY)
    private Collection<WigTradEntity> wigTrad;

    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    @ManyToOne
    private CategoryEntity category;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getEVATPrice() {
        return EVATPrice;
    }

    public void setEVATPrice(double EVATPrice) {
        this.EVATPrice = EVATPrice;
    }

    public double getVATRate() {
        return VATRate;
    }

    public void setVATRate(double VATRate) {
        this.VATRate = VATRate;
    }

    public boolean isMan() {
        return isMan;
    }

    public void setMan(boolean man) {
        isMan = man;
    }

    public String getPictureLink() {
        return pictureLink;
    }

    public void setPictureLink(String pictureLink) {
        this.pictureLink = pictureLink;
    }

    public Collection<SaleLineEntity> getSaleLines() {
        return saleLines;
    }

    public void setSaleLines(Collection<SaleLineEntity> saleLines) {
        this.saleLines = saleLines;
    }

    public Collection<WigTradEntity> getWigTrad() {
        return wigTrad;
    }

    public void setWigTrad(Collection<WigTradEntity> wigTrad) {
        this.wigTrad = wigTrad;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
