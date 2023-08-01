

package com.Machine;

import com.Item.*;
import com.CashBox.*;
import java.util.ArrayList;

public class Machine {
    protected ArrayList<SellableItem> sellableItemsList = new ArrayList<SellableItem>();
    protected ArrayList<Item> transactionSummary = new ArrayList<Item>();
    protected CashBox cashBox = new CashBox();
    protected CashBox pendingPayment = new CashBox();
    protected CashBox changeFund = new CashBox();
    protected CashBox pendingChange = new CashBox();

    double dBalance;

    /**
     * deposits a selected denomination with the supplied count number to the
     * corresponding register.
     * 
     * @param nIndex index of the selected denomination
     * @param nCount number of denominations to deposit
     * @param bFlag  status of the payment as to whether it is final or not
     */
    public void receivePayment(int nIndex, int nCount, boolean bFlag) {
        if (bFlag == false)
            pendingPayment.addCount(nIndex, nCount);
        else
            cashBox.addCount(nIndex, nCount);
    }

    /**
     * transfers the contents of pendingPayment to the cashBox.
     */
    public void finalizePayment() {
        for (int i = 0; i < pendingPayment.getSize(); i++) {
            receivePayment(i, pendingPayment.getCount(i), true);
            pendingPayment.initCount(i);
        }
    }

    /**
     * creates a new sellable Item object if there is no existing Item object with
     * the same
     * name.
     * returns the status of the Item object creation as a boolean value.
     * 
     * @param strName       item name
     * @param dPrice        item price
     * @param nCaloricValue total number of calories for the item
     * @param nQuantity     total number of items to stock
     */
    public boolean stockItem(String strName, double dPrice, int nCaloricValue, int nQuantity) {
        for (int i = 0; i < sellableItemsList.size(); i++)
            if (sellableItemsList.get(i).getName().equals(strName))
                return false;
        sellableItemsList.add(new SellableItem(strName, dPrice, nCaloricValue, nQuantity));
        transactionSummary.add(new SellableItem(strName, dPrice, nCaloricValue, 0));
        return true;
    }

    /**
     * updates the quantity of a selected item using the supplied count.
     * 
     * @param nIndex    index of the selected item
     * @param nQuantity total number of items to restock
     */
    public boolean restockItem(int nIndex, int nQuantity) {
        if (nQuantity > 0) {
            sellableItemsList.get(nIndex).setQuantity(sellableItemsList.get(nIndex).getQuantity() + nQuantity);
            return true;
        }
        return false;
    }

    /**
     * decrements the quantity of an item in the item inventory given by its index.
     * accounts of the successful purchase via the transaction summary by
     * incrementing the quantity of the same item given by its index.
     * 
     * @param nIndex index of the selected item
     */
    public void dispenseItem(int nIndex) {
        sellableItemsList.get(nIndex).setQuantity(sellableItemsList.get(nIndex).getQuantity() - 1);
        transactionSummary.get(nIndex).setQuantity(sellableItemsList.get(nIndex).getQuantity() + 1);
    }

    /**
     * initializes the contents of the cashBox to 0.
     * returns the sum of the denominations, each multiplied by their corresponding
     * count.
     */
    public double collectMoney() {
        dBalance = 0;
        for (int i = 0; i < cashBox.getSize(); i++) {
            dBalance += cashBox.getAmount(i) * cashBox.getCount(i);
            cashBox.initCount(i);
        }
        return dBalance;
    }

    /**
     * increments the number of the selected denomination in the changeFund by the
     * given count.
     * returns true if the given count is valid; false otherwise.
     * 
     * @param nIndex index of the selected denomination
     * @param nCount number of denominations to add
     */
    public boolean replenishMoney(int nIndex, int nCount) {
        if (nCount > 0) {
            changeFund.addCount(nIndex, nCount);
            return true;
        }
        return false;
    }

    /**
     * returns true if there is enough denominations to produce a change; false
     * otherwise.
     * 
     * @param dChange total change amount
     */
    public boolean checkChangeFund(double dChange) {
        for (int i = 0; i < pendingChange.getSize(); i++)
            pendingChange.initCount(i);
        for (int i = cashBox.getSize() - 1; i != -1; i--) {
            if (changeFund.getCount(i) >= dChange / cashBox.getAmount(i)) {
                pendingChange.addCount(i, (int) (dChange / cashBox.getAmount(i)));
                dChange = dChange % cashBox.getAmount(i);
            }
        }
        if (dChange != 0) {
            for (int i = 0; i < pendingChange.getSize(); i++)
                pendingChange.initCount(i);
            return false;
        }
        return true;
    }

    /**
     * resets the transaction record summary for the starting inventory.
     */
    public void initStartingInventory() {
        for (int i = 0; i < sellableItemsList.size(); i++) {
            transactionSummary.get(i).setName(sellableItemsList.get(i).getName());
            transactionSummary.get(i).setPrice(sellableItemsList.get(i).getPrice());
            transactionSummary.get(i).setQuantity(sellableItemsList.get(i).getQuantity());
        }
    }

    /**
     * initializes the count of each denomination in pendingPayment to 0.
     */
    public void initPaymentBalance() {
        for (int i = 0; i < pendingPayment.getSize(); i++)
            pendingPayment.initCount(i);
    }

    /**
     * returns the total amount of deposited money in pendingPayment.
     */
    public double getPaymentBalance() {
        dBalance = 0;
        for (int i = 0; i < pendingPayment.getSize(); i++)
            dBalance += pendingPayment.getAmount(i) * pendingPayment.getCount(i);
        return dBalance;
    }

    /**
     * returns the name of the selected item.
     * 
     * @param nIndex index of the selected item
     */
    public String getItemName(int nIndex) {
        return sellableItemsList.get(nIndex).getName();
    }

    /**
     * returns the price of the selected item.
     * 
     * @param nIndex index of the selected item
     */
    public double getItemPrice(int nIndex) {
        return sellableItemsList.get(nIndex).getPrice();
    }

    /**
     * returns the number of calories of the selected item.
     * 
     * @param nIndex index of the selected item
     */
    public int getItemCaloricValue(int nIndex) {
        return sellableItemsList.get(nIndex).getCaloricValue();
    }

    /**
     * returns the remaining quantity in stock of the selected item.
     * 
     * @param nIndex index of the selected item
     */
    public int getItemQuantity(int nIndex) {
        return sellableItemsList.get(nIndex).getQuantity();
    }

    /**
     * returns the size of the itemList array.
     */
    public int getItemListSize() {
        return sellableItemsList.size();
    }

    public void removeLast(int n) {
        sellableItemsList.remove(n);
    }

    /**
     * returns the size of the changeFund array.
     */
    public int getChangeFundSize() {
        return changeFund.getSize();
    }

    /**
     * returns the amount of the selected denomination in changeFund.
     * 
     * @param nIndex index of the selected denomination
     */
    public double getChangeFundAmount(int nIndex) {
        return changeFund.getAmount(nIndex);
    }

    /**
     * returns the count of the selected denomination in changeFund.
     * 
     * @param nIndex index of the selected denomination
     */
    public int getChangeFundCount(int nIndex) {
        return changeFund.getCount(nIndex);
    }

    /**
     * returns the count of the selected denomination in pendingPayment.
     * 
     * @param nIndex index of the selected denomination
     */
    public int getPaymentCount(int nIndex) {
        return pendingPayment.getCount(nIndex);
    }

    /**
     * returns the selected item's original quantity since last restock.
     * 
     * @param nIndex index of the selected item
     */
    public int getTransactionSummaryQuantity(int nIndex) {
        return transactionSummary.get(nIndex).getQuantity();
    }

    /**
     * decrements the denomination count in changeFund by the corresponding
     * denomination count in pendingChange.
     * initializes the denomination count for pendingChange to 0 after returning the
     * total amount of change.
     */
    public double getChange() {
        dBalance = 0;
        for (int i = 0; i < pendingChange.getSize(); i++) {
            dBalance += pendingChange.getAmount(i) * pendingChange.getCount(i);
            changeFund.subtractCount(i, pendingChange.getCount(i));
            pendingChange.initCount(i);
        }
        return dBalance;
    }
}
