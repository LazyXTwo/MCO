package com.Item;

public class Item {
    private String strName;
    private float fPrice;
    private int nCaloricValue;
    private int nQuantity;

    public Item (String strName, float fPrice, int nCaloricValue, int nQuantity) {
        this.strName = strName;
        this.fPrice = fPrice;
        this.nCaloricValue = nCaloricValue;
        this.nQuantity = nQuantity;
    }

    public Item (String strName, float fPrice, int nQuantity) {
        this.strName = strName;
        this.fPrice = fPrice;
        this.nQuantity = nQuantity;
    }

    public String getName () {
        return this.strName;
    }

    public float getPrice () {
        return this.fPrice;
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