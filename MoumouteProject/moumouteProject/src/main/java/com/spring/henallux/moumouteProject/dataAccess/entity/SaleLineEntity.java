package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name = "saleline")
public class SaleLineEntity
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitprice")
    private double unitPrice;

    @JoinColumn(name = "saleid", referencedColumnName = "id")
    @ManyToOne
    private SaleEntity sale;

    @JoinColumn(name = "wigid", referencedColumnName = "id")
    @ManyToOne
    private WigEntity wig;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public SaleEntity getSale() {
        return sale;
    }

    public void setSale(SaleEntity sale) {
        this.sale = sale;
    }

    public WigEntity getWig() {
        return wig;
    }

    public void setWig(WigEntity wig) {
        this.wig = wig;
    }
}
