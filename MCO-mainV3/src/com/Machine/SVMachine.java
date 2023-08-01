package com.Machine;

import com.Item.*;
import java.util.ArrayList;

public class SVMachine extends Machine{
    private ArrayList<SellableItem> sellableItemsList = new ArrayList<SellableItem>();
    private ArrayList<NonSellableItem> nonSellableItemsList = new ArrayList<NonSellableItem>();

    /**
     * creates a new ingredient for combined Item object if there is no existing Item object with the same
     * name.
     * returns the status of the Item object creation as a boolean value.
     * 
     * @param strName       item name
     * @param nCaloricValue total number of calories for the item
     * @param nQuantity     total number of items to stock
     */
    public boolean stockItem(String strName, int nCaloricValue, int nQuantity) {
        for (int i = 0; i < sellableItemsList.size(); i++)
            if (sellableItemsList.get(i).getName().equals(strName))
                return false;
        nonSellableItemsList.add(new NonSellableItem(strName, nCaloricValue, 0));
        transactionSummary.add(new NonSellableItem(strName, nCaloricValue, 0));
        return true;
    }
}
