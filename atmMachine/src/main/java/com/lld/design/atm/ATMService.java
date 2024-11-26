package com.lld.design.atm;

import com.lld.design.customer.CustomerAccount;
import com.lld.design.exceptions.CustomerDoesNotExist;

import java.util.HashMap;
import java.util.Map;

public class ATMService {

    // Account Number to CustomerAccount Mapping
    private final Map<String, CustomerAccount> customerAccountMap = new HashMap<>();

    // Add a new CustomerAccount to the map
    public void addCustomerAccount(String accountId, CustomerAccount account) {
        customerAccountMap.put(accountId, account);
    }

    // Get a CustomerAccount by account ID
    public CustomerAccount getCustomerAccountByAccountId(String accountId) {
        CustomerAccount customer = customerAccountMap.get(accountId);
        if (customer != null) {
            return customer;
        } else {
            throw new CustomerDoesNotExist("Customer account does not exist!");
        }
    }

    // Update a CustomerAccount in the map
    public void updateCustomerAccount(String accountId, CustomerAccount updatedAccount) {
        if (customerAccountMap.containsKey(accountId)) {
            customerAccountMap.put(accountId, updatedAccount);
        } else {
            throw new CustomerDoesNotExist("Customer account does not exist!");
        }
    }

    // Remove a CustomerAccount from the map
    public void removeCustomerAccount(String accountId) {
        if (customerAccountMap.containsKey(accountId)) {
            customerAccountMap.remove(accountId);
        } else {
            throw new CustomerDoesNotExist("Customer account does not exist!");
        }
    }

    // Deposit cash into a CustomerAccount
    public Boolean depositCash(Double amount, String accountId) {
        CustomerAccount customer = getCustomerAccountByAccountId(accountId);
        customer.depositAmount(amount);
        return true;
    }
}
