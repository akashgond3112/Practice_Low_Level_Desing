package com.lld.design.check;

public class Check {
    private String ifsc;

    public String getIfsc() {
        return ifsc;
    }

    public void setIfsc(String ifsc) {
        this.ifsc = ifsc;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(String depositAmount) {
        this.depositAmount = depositAmount;
    }

    private String accountNumber;
    private String depositAmount;

    public Check(String ifsc, String accountNumber, String depositAmount) {
        this.ifsc = ifsc;
        this.accountNumber = accountNumber;
        this.depositAmount = depositAmount;
    }
}
