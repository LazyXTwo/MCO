package com.Money;

public class Money {
    private double dAmount;
    private int nCount;

    public Money (double dAmount) {
        this.dAmount = dAmount;
        this.nCount = 0;
    }

    public double getAmount () {
        return this.dAmount;
    }

    public int getCount () {
        return this.nCount;
    }

    public void setCount (int nCount) {
        this.nCount = nCount;
    }    
}
