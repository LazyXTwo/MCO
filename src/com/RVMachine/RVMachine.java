package com.RVMachine;

import com.Item.*;
import com.CashBox.*;

import java.util.ArrayList;

public class RVMachine {
    private ArrayList<Item> itemList;
    private ArrayList<Item> transactionHistory;
    private CashBox cashBox;
    private CashBox payment;
    private CashBox changeFund;

    float fBalance = 0;
    boolean bRestock = false;

    public RVMachine () {
        itemList.clear();
    }

    public void receivePayment (int nIndex, int nCount, boolean bFlag) {
        if (bFlag == false) {
            payment.addCount(nIndex, nCount);
        }
        else {
            cashBox.addCount(nIndex, nCount);
        }
    }

    public void dispenseItem (int nIndex, int nCount) {
        itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()-nCount);
        transactionHistory.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nCount);
    }

    public void finalizePayment () {
        for (int i = 0 ; i < payment.getSize() ; i++ ) {
            receivePayment(i, payment.getCount(i), true);
            payment.initCount(i);
        }
    }

    public float returnPayment () {
        fBalance = 0;
        for (int i = 0 ; i < payment.getSize() ; i++) {
            fBalance += payment.getAmount(i)*payment.getCount(i);
            payment.initCount(i);
        }
        return fBalance;
    }

    public void stockItem (String strName, float fPrice, int nCaloricValue, int nQuantity) {
        itemList.add(new Item(strName, fPrice, nCaloricValue, nQuantity));
        transactionHistory.add(new Item(strName, fPrice, 0));
    }

    public void isRestocking (boolean bRestock) {
        this.bRestock = bRestock;
    }

    public void restockItem (int nIndex, int nQuantity) {
        itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nQuantity);
    }

    public float collectMoney () {
        fBalance = 0;
        for (int i = 0 ; i < cashBox.getSize() ; i++) {
            fBalance += cashBox.getAmount(i)*cashBox.getCount(i);
            cashBox.initCount(i);
        }
        return fBalance;
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
