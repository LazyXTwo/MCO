package com.InternalRegister;

import com.Cash.*;

import java.util.ArrayList;

public class InternalRegister {
    private ArrayList<Cash> internalRegister = new ArrayList<Cash>();

    public void addCash (Cash cash) {
        this.internalRegister.add(cash);
    }

    public void removeCash (Cash cash) {
        for (int i = 0, j = 0 ; i < internalRegister.size() && j == 0 ; i++) {
            if (this.internalRegister.get(i) == cash) {
                this.internalRegister.remove(i);
                j = 1;
            }
        }
    }

    public float getBalance () {
        float fTotal = 0;
        for (int i = 0 ; i < internalRegister.size() ; i++) {
            fTotal += internalRegister.get(i).getAmount();
        }
        return fTotal;
    }
}