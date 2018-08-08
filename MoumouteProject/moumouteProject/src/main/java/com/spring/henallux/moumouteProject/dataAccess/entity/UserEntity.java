package com.spring.henallux.moumouteProject.dataAccess.entity;


import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="user")
public class UserEntity
{
    //ATTENTION PAR DE MAJ DANS LES NOM DE COLONE ET TABLE
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "email")
    private String email;

    @Column(name = "street")
    private String street;

    @Column(name = "postalcode")
    private int postalCode;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "authorities")
    private String authorities;

    @Column(name = "non_expired")
    private Boolean non_Expired;

    @Column(name = "non_locked")
    private Boolean non_Locked;

    @Column(name = "credentials_non_expired")
    private Boolean credentials_Non_Expired;

    @Column(name = "enabled")
    private Boolean enabled;

    @OneToMany(mappedBy = "username", fetch = FetchType.LAZY)
    private Collection<OrderTicketEntity> OrderTickets;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public Boolean getNon_Expired() {
        return non_Expired;
    }

    public void setNon_Expired(Boolean non_Expired) {
        this.non_Expired = non_Expired;
    }

    public Boolean getNon_Locked() {
        return non_Locked;
    }

    public void setNon_Locked(Boolean non_Locked) {
        this.non_Locked = non_Locked;
    }

    public Boolean getCredentials_Non_Expired() {
        return credentials_Non_Expired;
    }

    public void setCredentials_Non_Expired(Boolean credentials_Non_Expired) {
        this.credentials_Non_Expired = credentials_Non_Expired;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Collection<OrderTicketEntity> getOrderTickets() {
        return OrderTickets;
    }

    public void setOrderTickets(Collection<OrderTicketEntity> orderTickets) {
        OrderTickets = orderTickets;
    }
}
