package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "orderticket")
public class OrderTicketEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "orderdate")
    private Date orderDate;

    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "linenumber", fetch = FetchType.LAZY)
    private Collection<OrderLineEntity> OrderLines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Collection<OrderLineEntity> getOrderLines() {
        return OrderLines;
    }

    public void setOrderLines(Collection<OrderLineEntity> orderLines) {
        OrderLines = orderLines;
    }
}
