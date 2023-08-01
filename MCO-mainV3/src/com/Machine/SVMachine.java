package com.Machine;

import com.Item.*;
import java.util.ArrayList;

public class SVMachine extends Machine {
    private ArrayList<NonSellableItem> nonSellableItemsList = new ArrayList<NonSellableItem>();
    private ArrayList<CombineItem> combineItemList = new ArrayList<CombineItem>();

    /**
     * creates a new ingredient for nonsellable Items object if there is no existing
     * Item object with the same
     * name.
     * returns the status of the Item object creation as a boolean value.
     * 
     * @param strName       item name
     * @param nCaloricValue total number of calories for the item
     * @param nQuantity     total number of items to stock
     */
    public boolean stockNonSellableItem(String strName, double dPrice, int nCaloricValue, int nQuantity) {
        nonSellableItemsList.add(new NonSellableItem(strName, dPrice, nCaloricValue, nQuantity));
        transactionSummary.add(new NonSellableItem(strName, dPrice, nCaloricValue, 0));
        return true;
    }

    public boolean Combine(String strName, SellableItem sellableItem, NonSellableItem nonSellableItem) {
        combineItemList.add(new CombineItem(strName, sellableItem, nonSellableItem));
        transactionSummary.add(new CombineItem(strName, sellableItem, nonSellableItem));
        return true;
    }
}
