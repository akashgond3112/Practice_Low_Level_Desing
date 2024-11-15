package com.lld.design.check;

import com.lld.design.deposit.DepositMedium;
import com.lld.design.deposit.DepositSlot;

public class CheckDepositSlot extends DepositSlot {

    public CheckDepositSlot() {
        super.depositMedium = DepositMedium.CHECK;
    }
}
