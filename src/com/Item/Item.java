package com.Item;

public class Item {
    private String strName;
    private float fPrice;
    private int nCaloricValue;

    public Item (String strName, float fPrice, int nCaloricValue) {
        this.strName = strName;
        this.fPrice = fPrice;
        this.nCaloricValue = nCaloricValue;
    }

    public String getName () {
        return this.strName;
    }

    public double getPrice () {
        return this.fPrice;
    }

    public int getCaloricValue () {
        return this.nCaloricValue;
    }
}