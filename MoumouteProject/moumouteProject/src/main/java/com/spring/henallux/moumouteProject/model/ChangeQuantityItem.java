package com.spring.henallux.moumouteProject.model;

public class ChangeQuantityItem {

    private int idItem;
    private int newQuantity;

    public ChangeQuantityItem()
    {
    }

    public int getIdItem() {

        return idItem;
    }

    public void setIdItem(int idItem) {
        this.idItem = idItem;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }
}
