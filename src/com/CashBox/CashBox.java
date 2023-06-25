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

    public void storeCash (int nIndex, int nCount) {
        cashBox.get(nIndex).setCount(cashBox.get(nIndex).getCount()+nCount);
    }

}