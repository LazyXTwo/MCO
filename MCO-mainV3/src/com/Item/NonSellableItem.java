package com.Item;

public class NonSellableItem extends Item {
    public NonSellableItem(String strName, double dPrice, int nCaloricValue, int nQuantity) {
        super(strName, dPrice, nCaloricValue, nQuantity);
    }

    public void calculateCaloricValue() {
    }
}
