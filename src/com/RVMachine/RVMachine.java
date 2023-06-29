package com.RVMachine;

import com.Item.*;
import com.CashBox.*;

import java.util.ArrayList;

public class RVMachine {
    private ArrayList<Item> itemList = new ArrayList<Item>();
    private ArrayList<Item> transactionSummary = new ArrayList<Item>();
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

    public void dispenseItem (int nIndex) {
        itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()-1);
        transactionSummary.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+1);
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

    public void initPaymentBalance () {
        for (int i = 0 ; i < payment.getSize() ; i++) {
            payment.initCount(i);
        }
    }

    public boolean stockItem (String strName, double dPrice, int nCaloricValue, int nQuantity) {

        for (int i = 0 ; i < itemList.size() ; i++) {
            if (itemList.get(i).getName().equals(strName)) {
                return false;
            }
        }

        itemList.add(new Item(strName, dPrice, nCaloricValue, nQuantity));
        transactionSummary.add(new Item(strName, dPrice, 0));

        return true;
    }

    public boolean restockItem (int nIndex, int nQuantity) {
        if (nQuantity > 0) {
            itemList.get(nIndex).setQuantity(itemList.get(nIndex).getQuantity()+nQuantity);
            return true;
        }
        return false;
    }

    public void printItemList () {
        for (int i = 0 ; i < itemList.size() ; i++) {
            System.out.println("[" + i + "]\tItem Name : " + itemList.get(i).getName() + "\tPrice : " + itemList.get(i).getPrice() + "\tCaloric Value : " + itemList.get(i).getCaloricValue() + "\tQuantity : " + itemList.get(i).getQuantity());
        }
    }

    public void printChangeFund () {
        for (int i = 0 ; i < changeFund.getSize() ; i++) {
            System.out.println("[" + i + "]" + "\tAmount : " + changeFund.getAmount(i) + "\tRemaining Count : " + changeFund.getCount(i));
        }
    }

    public void printPayment () {
        for (int i = 0 ; i < payment.getSize() ; i++) {
            System.out.println("[" + i + "]" + "\tAmount : " + payment.getAmount(i) + "\tCount : " + payment.getCount(i));
        }
    }

    public void printTransactionSummary () {
        for (int i = 0 ; i < itemList.size() ; i++) {
            System.out.println("Item Name : " + itemList.get(i).getName() + "\tPrice : " + itemList.get(i).getPrice() + "\tOriginal Quantity since Last Restock : " + transactionSummary.get(i).getQuantity() + "\tCurrent Quantity : " + itemList.get(i).getQuantity());
        }
    }

    public void setStartingInventory () {
        for (int i = 0 ; i < itemList.size() ; i++) {
            transactionSummary.get(i).setName(itemList.get(i).getName());
            transactionSummary.get(i).setPrice(itemList.get(i).getPrice());
            transactionSummary.get(i).setQuantity(itemList.get(i).getQuantity());
        }
    }

    public double collectMoney () {
        dBalance = 0;
        for (int i = 0 ; i < cashBox.getSize() ; i++) {
            dBalance += cashBox.getAmount(i)*cashBox.getCount(i);
            cashBox.initCount(i);
        }
        return dBalance;
    }

    public boolean replenishMoney (int nIndex, int nCount) {
        if (nCount > 0) {
            changeFund.addCount(nIndex, nCount);
            return true;
        }
        return false;
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

    public int getItemListSize () {
        return itemList.size();
    }

    public int getItemQuantity (int nIndex) {
        return itemList.get(nIndex).getQuantity();
    }

    public int getChangeFundSize () {
        return changeFund.getSize();
    }

    public double getItemPrice (int nIndex) {
        return itemList.get(nIndex).getPrice();
    }

    public double getChange () {
        dBalance = 0;
        for (int i = 0 ; i < changeList.getSize() ; i++) {
            dBalance += changeList.getAmount(i)*changeList.getCount(i);
            changeFund.subtractCount(i, changeList.getCount(i));
            changeList.initCount(i);
        }
        return dBalance;
    }

    public String getItemName (int nIndex) {
        return itemList.get(nIndex).getName();
    }
}
