package com.Item;

public class NonSellableItem extends Item {
    public NonSellableItem(String strName, int nCaloricValue, int nQuantity) {
        super(strName, nCaloricValue, nQuantity);
    }

    @Override
    public void calculateCaloricValue() {
        // Implement the calculation logic for caloric value for non-sellable items
        // here.
    }
}
