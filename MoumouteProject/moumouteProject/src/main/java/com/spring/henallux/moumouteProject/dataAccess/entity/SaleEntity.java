package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "sale")
public class SaleEntity
{
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "saledate")
    private Date saleDate;

    @JoinColumn(name = "username", referencedColumnName = "username")
    @ManyToOne
    private UserEntity user;

    @OneToMany(mappedBy = "sale", fetch = FetchType.LAZY)
    private Collection<SaleLineEntity> saleLines;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(Date saleDate) {
        this.saleDate = saleDate;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Collection<SaleLineEntity> getSaleLines() {
        return saleLines;
    }

    public void setSaleLines(Collection<SaleLineEntity> saleLines) {
        this.saleLines = saleLines;
    }
}
