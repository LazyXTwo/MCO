package com.Payment;

import com.Money.*;

import java.util.ArrayList;

public class Payment {
    private ArrayList<Money> payment = new ArrayList<Money>();

    float fBalance;

    public Payment () {
        payment.add(new Money(1));
        payment.add(new Money(5));
        payment.add(new Money(10));
        payment.add(new Money(20));
        payment.add(new Money(50));
        payment.add(new Money(100));
        payment.add(new Money(200));
        payment.add(new Money(500));
        payment.add(new Money(1000));
    }

    public void storeCash (int nIndex, int nCount) {
        payment.get(nIndex).setCount(payment.get(nIndex).getCount()+nCount);
    }

    public float releaseCash () {
        fBalance = 0;
        for (int i = 0 ; i < payment.size() ; i++) {
            fBalance += payment.get(i).getCount()*payment.get(i).getAmount();
            payment.get(i).setCount(0);
        }     
        return fBalance;
    }

    public void initCount (int nIndex) {
        payment.get(nIndex).setCount(0);
    }
    
    public int getCount (int nIndex) {
        return payment.get(nIndex).getCount();
    }

    public int getSize () {
        return payment.size();
    }

}
