package com.Money;

public class Money {
    private float fAmount;
    private int nCount;

    public Money (float fAmount) {
        this.fAmount = fAmount;
        this.nCount = 0;
    }

    public float getAmount () {
        return this.fAmount;
    }

    public int getCount () {
        return this.nCount;
    }

    public void setCount (int nCount) {
        this.nCount = nCount;
    }    
}
