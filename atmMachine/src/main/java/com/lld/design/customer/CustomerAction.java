package com.lld.design.customer;

import com.lld.design.check.Check;
import com.lld.design.exceptions.InSufficientFundException;

public interface CustomerAction {

    public Boolean depostCash(Double amount, String accountId);

    public Boolean depostCheck(Check check);

    public Double withdrawCash(Double amount, String accountId) throws InSufficientFundException;

    public Double balanceEnquiry(String accountNumber);
}
