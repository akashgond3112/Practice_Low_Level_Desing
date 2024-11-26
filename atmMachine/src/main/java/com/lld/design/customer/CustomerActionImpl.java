package com.lld.design.customer;

import com.lld.design.atm.ATMService;
import com.lld.design.check.Check;
import com.lld.design.exceptions.InSufficientFundException;

public class CustomerActionImpl implements CustomerAction {

    ATMService atmService;

    public CustomerActionImpl(ATMService atmService) {
        this.atmService = atmService;
    }

    public Boolean depostCash(Double amount, String accountId) {
        return atmService.depositCash(amount, accountId);
    }

    public Boolean depostCheck(Check check) {
        return null;
    }

    public Double withdrawCash(Double amount, String accountId) throws InSufficientFundException {
        return null;
    }

    public Double balanceEnquiry(String accountNumber) {
        return null;
    }
}
