package com.RVMachine;

import com.Item.*;
import com.CashBox.*;
import com.ChangeFund.*;

import java.util.ArrayList;

public class RVMachine {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private CashBox cashBox = new CashBox();
    private ChangeFund changeFund = new ChangeFund();

    float fBalance;

    public RVMachine () {
        itemList.clear();
    }

    public void stockItem (String strName, float fPrice, int nCaloricValue, int nQuantity) {
        itemList.add(new Item(strName, fPrice, nCaloricValue, nQuantity));
    }

    public void restockItem (int nIndex, int nQuantity) {
        itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nQuantity);
    }

    public void setPrice (int nIndex, float fPrice) {
        itemList.get(nIndex).setPrice(fPrice);
    }

    public float collectMoney () {
       return cashBox.releaseCash();
    }

    public void replenishMoney (int nIndex, int nCount) {
        changeFund.addCount(nIndex, nCount);
    }

    public String getName (int nIndex) {
        return itemList.get(nIndex).getName();
    }

    public float getPrice (int nIndex) {
        return itemList.get(nIndex).getPrice();
    }

    public int getCaloricValue (int nIndex) {
        return itemList.get(nIndex).getCaloricValue();
    }

    public int getQuantity (int nIndex) {
        return itemList.get(nIndex).getQuantity();
    }
}
