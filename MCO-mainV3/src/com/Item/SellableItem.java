package com.Item;

public class SellableItem extends Item {
    public SellableItem(String strName, double dPrice, int nCaloricValue, int nQuantity) {
        super(strName, dPrice, nCaloricValue, nQuantity);
    }

    @Override
    public void calculateCaloricValue() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'calculateCaloricValue'");
    }
}
