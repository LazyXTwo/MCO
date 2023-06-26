package com.ChangeFund;

import com.Money.*;

import java.util.ArrayList;

public class ChangeFund {
    private ArrayList<Money> changeFund = new ArrayList<Money>();
    
    int nCount;

    public ChangeFund () {
        changeFund.add(new Money(1));
        changeFund.add(new Money(5));
        changeFund.add(new Money(10));
        changeFund.add(new Money(20));
        changeFund.add(new Money(50));
        changeFund.add(new Money(100));
        changeFund.add(new Money(200));
        changeFund.add(new Money(500));
        changeFund.add(new Money(1000));
    }

    public void addCount (int nIndex, int nCount) {
        changeFund.get(nIndex).setCount(changeFund.get(nIndex).getCount()+nCount);
    }

    public void subtractCount (int nIndex, int nCount) {
        changeFund.get(nIndex).setCount(changeFund.get(nIndex).getCount()-nCount);
    }

    public float getAmount (int nIndex) {
        return changeFund.get(nIndex).getAmount();
    }

    public float getCount (int nIndex) {
        return changeFund.get(nIndex).getCount();
    }

}
