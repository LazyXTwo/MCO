package com.Item;

public class CombineItem extends Item {
    public CombineItem(String strName, double dPrice, int nCaloricValue, int nQuantity) {
        super(strName, dPrice, nCaloricValue, nQuantity);
    }

    @Override
    public void calculateCaloricValue() {
        // Sellable items may have a specific caloric value calculation, but we're
        // leaving it empty for simplicity.
    }

    // Sellable items may have a specific method for calculating the selling price.
    public double getSellingPrice() {
        // A simple formula for calculating the selling price, you can customize it as
        // needed.
        return getPrice() * 1.2;
    }
}
