package com.spring.henallux.moumouteProject.model;

public class User
{
    private String username;
    private String password;
    private String lastname;
    private String firstname;
    private String email;
    private String street;
    private int postalCode;
    private String city;
    private String country;
    private String authorities;
    private Boolean non_Expired;
    private Boolean non_Locked;
    private Boolean credentials_Non_Expired;
    private Boolean enabled;

    public User() {}

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
}
