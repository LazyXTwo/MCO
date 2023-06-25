package com.InternalRegister;

import com.Cash.*;

import java.util.ArrayList;

public class InternalRegister {
    private ArrayList<Cash> internalRegister = new ArrayList<Cash>();

    public void addCash (Cash cash) {
        this.internalRegister.add(cash);
    }

    public void removeCash (Cash cash) {
        this.internalRegister.remove(cash);
    }

    public float getBalance () {
        float fTotal = 0;
        for (int i = 0 ; i < internalRegister.size() ; i++) {
            fTotal += internalRegister.get(i).getAmount();
        }
        return fTotal;
    }
}