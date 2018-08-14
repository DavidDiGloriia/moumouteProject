package com.spring.henallux.moumouteProject.dataAccess.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.hibernate.annotations.common.util.StringHelper.isEmpty;

@Entity
@Table(name="user")
public class UserEntity implements UserDetails {
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

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Collection<OrderTicketEntity> OrderTickets;





    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        if(!isEmpty(authorities)) {
            String[] authoritiesAsArray = authorities.split(",");
            for(String authority : authoritiesAsArray) {
                if(!isEmpty(authority)) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(authority));
                }
            }
        }
        return grantedAuthorities;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return non_Expired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return non_Locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentials_Non_Expired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public void setNon_Expired(Boolean non_Expired) {
        this.non_Expired = non_Expired;
    }

    public void setNon_Locked(Boolean non_Locked) {
        this.non_Locked = non_Locked;
    }

    public void setCredentials_Non_Expired(Boolean credentials_Non_Expired) {
        this.credentials_Non_Expired = credentials_Non_Expired;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }



    public void setUsername(String username) {
        this.username = username;
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


    public Collection<OrderTicketEntity> getOrderTickets() {
        return OrderTickets;
    }

    public void setOrderTickets(Collection<OrderTicketEntity> orderTickets) {
        OrderTickets = orderTickets;
    }
}
