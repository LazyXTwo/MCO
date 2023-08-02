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
    
    public boolean restockItemS(int nIndex, int nQuantity) {
        if (nQuantity > 0) {
            nonSellableItemsList.get(nIndex).setQuantity(nonSellableItemsList.get(nIndex).getQuantity() + nQuantity);
            return true;
        }
        return false;
    }

    public void dispenseItemS(int nIndex) {
        nonSellableItemsList.get(nIndex).setQuantity(nonSellableItemsList.get(nIndex).getQuantity() - 1);
        transactionSummary.get(nIndex).setQuantity(nonSellableItemsList.get(nIndex).getQuantity() + 1);
    }

    public void initStartingInventoryS() {
        for (int i = 0; i < nonSellableItemsList.size(); i++) {
            transactionSummary.get(i).setName(nonSellableItemsList.get(i).getName());
            transactionSummary.get(i).setPrice(nonSellableItemsList.get(i).getPrice());
            transactionSummary.get(i).setQuantity(nonSellableItemsList.get(i).getQuantity());
        }
    }
    public String getItemNameS(int nIndex) {
        return nonSellableItemsList.get(nIndex).getName();
    }

    public double getItemPriceS(int nIndex) {
        return nonSellableItemsList.get(nIndex).getPrice();
    }

    public int getItemCaloricValueS(int nIndex) {
        return nonSellableItemsList.get(nIndex).getCaloricValue();
    }

    public int getItemQuantityS(int nIndex) {
        return nonSellableItemsList.get(nIndex).getQuantity();
    }

    public int getItemListSizeS() {
        return nonSellableItemsList.size();
    }

    public boolean Combine(String strName, SellableItem sellableItem, NonSellableItem nonSellableItem) {
        combineItemList.add(new CombineItem(strName, sellableItem, nonSellableItem));
        transactionSummary.add(new CombineItem(strName, sellableItem, nonSellableItem));
        return true;
    }
}
