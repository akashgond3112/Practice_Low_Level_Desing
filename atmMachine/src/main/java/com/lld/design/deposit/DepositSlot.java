package com.lld.design.deposit;

public abstract class DepositSlot {
    public Double getDepositAmount() {
        return depositAmount;
    }

    public DepositMedium getDepositMedium() {
        return depositMedium;
    }

    Double depositAmount;
    protected DepositMedium depositMedium;


}
