package com.lld.design.Transaction;


import com.lld.design.check.Check;

public class CheckDepositTransaction extends Transaction {

    Check check;

    public CheckDepositTransaction(Check check) {
        this.check = check;
        super.transactionType = TransactionType.CHECK_DEPOSIT;
    }
}
