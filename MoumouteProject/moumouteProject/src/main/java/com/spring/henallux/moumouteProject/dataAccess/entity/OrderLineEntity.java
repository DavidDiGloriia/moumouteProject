package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;

@Entity
@Table(name = "orderline")
public class OrderLineEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "linenumber")
    private int lineNumber;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitpriceevat")
    private double unitPriceEVAT;

    @JoinColumn(name = "orderid", referencedColumnName = "id")
    @ManyToOne
    private OrderTicketEntity orderTicket;

    @JoinColumn(name = "wigid", referencedColumnName = "id")
    @ManyToOne
    private WigEntity wig;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPriceEVAT() {
        return unitPriceEVAT;
    }

    public void setUnitPriceEVAT(double unitPriceEVAT) {
        this.unitPriceEVAT = unitPriceEVAT;
    }

    public OrderTicketEntity getOrderTicket() {
        return orderTicket;
    }

    public void setOrderTicket(OrderTicketEntity orderTicket) {
        this.orderTicket = orderTicket;
    }

    public WigEntity getWig() {
        return wig;
    }

    public void setWig(WigEntity wig) {
        this.wig = wig;
    }
}
