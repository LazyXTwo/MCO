/**
 * A Money represents an individual denomination of the Philippine currency.
 * Each Money has an amount (dAmount), and the currency count for that particular
 * amount (nCount).
 */

package com.Money;

public class Money {
    private double dAmount;
    private int nCount;

    /**
     * creates a Money object using the given amount with an initialized count of 0.
     * @param dAmount amount/value of the currency
     */
    public Money (double dAmount) {
        this.dAmount = dAmount;
        this.nCount = 0;
    }

    /**
     * returns the currency amount.
     */
    public double getAmount () {
        return this.dAmount;
    }

    /**
     * returns the currency count.
     */
    public int getCount () {
        return this.nCount;
    }

    /**
     * sets the currency count to the given number.
     * @param nCount updated currency count
     */
    public void setCount (int nCount) {
        this.nCount = nCount;
    }    
}
