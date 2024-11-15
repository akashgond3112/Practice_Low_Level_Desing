package com.lld.design.cash;

import com.lld.design.deposit.DepositMedium;
import com.lld.design.deposit.DepositSlot;

public class CashDepositSlot extends DepositSlot {

    public CashDepositSlot() {
        super.depositMedium= DepositMedium.CASH;
    }
}
