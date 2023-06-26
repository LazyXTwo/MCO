package com.Item;

public class Item {
    private String strName;
    private double dPrice;
    private int nCaloricValue;
    private int nQuantity;

    public Item (String strName, double dPrice, int nCaloricValue, int nQuantity) {
        this.strName = strName;
        this.dPrice = dPrice;
        this.nCaloricValue = nCaloricValue;
        this.nQuantity = nQuantity;
    }

    public Item (String strName, double dPrice, int nQuantity) {
        this.strName = strName;
        this.dPrice = dPrice;
        this.nQuantity = nQuantity;
    }

    public String getName () {
        return this.strName;
    }

    public double getPrice () {
        return this.dPrice;
    }

    public int getCaloricValue () {
        return this.nCaloricValue;
    }

    public int getQuantity () {
        return this.nQuantity;
    }

    public void setQuantity (int nQuantity) {
        this.nQuantity = nQuantity;
    }
    
}