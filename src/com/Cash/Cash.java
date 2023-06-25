package com.Cash;

public class Cash {
    private float fAmount;
    private boolean bType;

    public Cash (float fAmount, boolean bType) {
        this.fAmount = fAmount;
        this.bType = bType;
    }

    public float getAmount () {
        return this.fAmount;
    }

    public boolean getType () {
        return this.bType;
    }
}
