package com.Item;

public class CombineItem extends Item {
    private SellableItem sellableItem;
    private NonSellableItem nonSellableItem;

    public CombineItem(String strName, SellableItem sellableItem, NonSellableItem nonSellableItem) {
        super(strName, 0, 0, 0); // Initialize with dummy values since we'll calculate the price and caloric
                                 // value
        this.sellableItem = sellableItem;
        this.nonSellableItem = nonSellableItem;
        calculateCaloricValue();
    }

    @Override
    public void calculateCaloricValue() {
        int combinedCaloricValue = sellableItem.getCaloricValue() + nonSellableItem.getCaloricValue();
        setCaloricValue(combinedCaloricValue);
    }

    // Combine the prices of sellable and non-sellable items to get the combined
    // selling price
    public double getCombinedSellingPrice() {
        double combinedSellingPrice = sellableItem.getPrice() + nonSellableItem.getPrice();
        return combinedSellingPrice;
    }

    // Combine the prices of sellable and non-sellable items to get the combined
    // price
    public double getCombinedPrice() {
        double combinedPrice = sellableItem.getPrice() + nonSellableItem.getPrice();
        return combinedPrice;
    }
}
