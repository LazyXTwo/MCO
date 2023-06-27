package com.RVMachine;

import com.Item.*;
import com.CashBox.*;

import java.util.ArrayList;

public class RVMachine {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private ArrayList<Item> transactionSummary = new ArrayList<Item>();
    private ArrayList<Item> startingInventory = new ArrayList<Item>();
    private CashBox cashBox = new CashBox();
    private CashBox payment = new CashBox();
    private CashBox changeFund = new CashBox();
    private CashBox changeList = new CashBox();

    double dBalance;

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
        transactionSummary.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nCount);
    }

    public void finalizePayment () {
        for (int i = 0 ; i < payment.getSize() ; i++ ) {
            receivePayment(i, payment.getCount(i), true);
            payment.initCount(i);
        }
    }

    public double getPaymentBalance () {
        dBalance = 0;
        for (int i = 0 ; i < payment.getSize() ; i++) {
            dBalance += payment.getAmount(i)*payment.getCount(i);
        }
        return dBalance;       
    }

    public double returnPayment () {
        dBalance = 0;
        for (int i = 0 ; i < payment.getSize() ; i++) {
            dBalance += payment.getAmount(i)*payment.getCount(i);
            payment.initCount(i);
        }
        return dBalance;
    }

    public void stockItem (String strName, double dPrice, int nCaloricValue, int nQuantity) {
        itemList.add(new Item(strName, dPrice, nCaloricValue, nQuantity));
        transactionSummary.add(new Item(strName, dPrice, 0));
    }

    public void restockItem (int nIndex, int nQuantity) {
        itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nQuantity);
    }

    public void initTransactionSummary () {
        for (int i = 0 ; i < transactionSummary.size() ; i++){
            transactionSummary.get(i).setQuantity(0);
        }
    }

    public ArrayList<Item> getTransactionSummary () {
        return transactionSummary;
    }

    public void setStartingInventory () {
        startingInventory = itemList;
    }

    public ArrayList<Item> getStartingInventory () {
        return startingInventory;
    }

    public ArrayList<Item> getEndingInventory () {
        return itemList;
    }

    public double collectMoney () {
        dBalance = 0;
        for (int i = 0 ; i < cashBox.getSize() ; i++) {
            dBalance += cashBox.getAmount(i)*cashBox.getCount(i);
            cashBox.initCount(i);
        }
        return dBalance;
    }

    public void replenishMoney (int nIndex, int nCount) {
        changeFund.addCount(nIndex, nCount);
    }
    
    public boolean calculateChange (double dPayment) {
        for (int i = 0 ; i < changeList.getSize() ; i++) {
            changeList.initCount(i);
        }

        for (int i = cashBox.getSize()-1 ; i != -1 ; i--) {
            if (changeFund.getCount(i) >= dPayment/cashBox.getAmount(i)) {
                changeList.addCount(i, (int) (dPayment/cashBox.getAmount(i)));
                dPayment = dPayment%cashBox.getAmount(i);
            }
        }

        if (dPayment != 0) {
            for (int i = 0 ; i < changeList.getSize() ; i++) {
                changeList.initCount(i);
            }
            return false;
        }

        return true;
    }

}
