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

    public void addItem (String strName, float fPrice, int nCaloricValue, int nQuantity) {
        itemList.add(new Item(strName, fPrice, nCaloricValue, nQuantity));
    }

    public void removeItem (int nIndex) {
        itemList.remove(nIndex);
    }

    public void updateItem (int nIndex, float fPrice) {
        itemList.get(nIndex).setPrice(fPrice);
    }

    public void updateItem (int nIndex, int nQuantity) {
        itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nQuantity);
    }

    public float collectMoney () {
       return cashBox.releaseCash();
    }

    public void replenishReserves (int nIndex, int nCount) {
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
