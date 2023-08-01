/**
 * An Item represents a food product. Each Item has an assigned name (strName),
 * a corresponding price (dPrice), its total calorie count (nCaloricValue), and 
 * the number of such items remaining in stock (nQuantity).
 */

package com.Item;

public abstract class Item {
    protected String strName;
    protected double dPrice;
    protected int nCaloricValue;
    protected int nQuantity;

    public Item(String strName, double dPrice, int nCaloricValue, int nQuantity) {
        this.strName = strName;
        this.dPrice = dPrice;
        this.nCaloricValue = nCaloricValue;
        this.nQuantity = nQuantity;
    }

    public Item(String strName, double dPrice, int nQuantity) {
        this.strName = strName;
        this.dPrice = dPrice;
        this.nQuantity = nQuantity;
    }

    public String getName() {
        return this.strName;
    }

    public double getPrice() {
        return this.dPrice;
    }

    public int getCaloricValue() {
        return this.nCaloricValue;
    }

    public int getQuantity() {
        return this.nQuantity;
    }

    public void setName(String strName) {
        this.strName = strName;
    }

    public void setPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public void setQuantity(int nQuantity) {
        this.nQuantity = nQuantity;
    }

    public void setCaloricValue(int nCaloricValue) {
        this.nCaloricValue = nCaloricValue;
    }

    abstract void calculateCaloricValue();
}