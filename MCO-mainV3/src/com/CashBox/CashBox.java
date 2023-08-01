/**
 * A CashBox represents a register for storing money. Each cashbox contains an array with
 * slots accounting for the different denominations of the Philippine currency (cashBox).
 */

package com.CashBox;

import com.Money.*;

import java.util.ArrayList;

public class CashBox {
    private ArrayList<Money> cashBox = new ArrayList<Money>();

    /**
     * creates a CashBox object with an initialized set of Money objects,
     * each representing a different denomination of the Philippine currency.
     */
    public CashBox () {
        cashBox.add(new Money(1));
        cashBox.add(new Money(5));
        cashBox.add(new Money(10));
        cashBox.add(new Money(20));
        cashBox.add(new Money(50));
        cashBox.add(new Money(100));
        cashBox.add(new Money(200));
        cashBox.add(new Money(500));
        cashBox.add(new Money(1000));
    }

    /**
     * initializes the count of the selected denomination to 0.
     * @param nIndex index of the selected denomination
     */
    public void initCount (int nIndex) {
        cashBox.get(nIndex).setCount(0);
    }

    /**
     * increments the count of the selected denomination by the supplied count number.
     * @param nIndex index of the selected denomination
     * @param nCount number of denominations to add
     */
    public void addCount (int nIndex, int nCount) {
        cashBox.get(nIndex).setCount(cashBox.get(nIndex).getCount()+nCount);
    }

    /**
     * decrements the count of the selected denomination by the supplied count number.
     * @param nIndex index of the selected denomination
     * @param nCount number of denominations to subtract
     */
    public void subtractCount (int nIndex, int nCount) {
        cashBox.get(nIndex).setCount(cashBox.get(nIndex).getCount()-nCount);
    }

    /**
     * returns the count of the selected denomination.
     * @param nIndex index of the selected denomination
     */
    public int getCount (int nIndex) {
        return cashBox.get(nIndex).getCount();
    }

    /**
     * returns the amount of the selected denomination.
     * @param nIndex index of the selected denomination
     */
    public double getAmount (int nIndex) {
        return cashBox.get(nIndex).getAmount();
    }

    /**
     * returns the size of the cashbox array.
     */
    public int getSize () {
        return cashBox.size();
    }

}