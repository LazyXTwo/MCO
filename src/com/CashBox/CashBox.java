package com.CashBox;

import com.Money.*;

import java.util.ArrayList;

public class CashBox {
    private ArrayList<Money> cashBox = new ArrayList<Money>();
    
    float fBalance;

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
    
    public float releaseCash () {
        fBalance = 0;
        for (int i = 0 ; i < cashBox.size() ; i++) {
            fBalance += cashBox.get(i).getCount()*cashBox.get(i).getAmount();
            cashBox.get(i).setCount(0);
        }     
        return fBalance;
    }

    public void addCount (int nIndex, int nCount) {
        cashBox.get(nIndex).setCount(cashBox.get(nIndex).getCount()+nCount);
    }

    public void subtractCount (int nIndex, int nCount) {
        cashBox.get(nIndex).setCount(cashBox.get(nIndex).getCount()-nCount);
    }

    public float getAmount (int nIndex) {
        return cashBox.get(nIndex).getAmount();
    }

    public int getCount (int nIndex) {
        return cashBox.get(nIndex).getCount();
    }

    public void initCount (int nIndex) {
        cashBox.get(nIndex).setCount(0);
    }
    
    public int getSize () {
        return cashBox.size();
    }


}