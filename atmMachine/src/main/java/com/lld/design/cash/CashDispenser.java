package com.lld.design.cash;

import com.lld.design.atm.ATM;

public class CashDispenser {

    private ATM atm;

    private Double dispenseCash(Double amount) {
        System.out.println("Dispensing cash - " + amount);
        return atm.debit(amount);
    }
}
