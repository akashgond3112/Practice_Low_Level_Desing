package com.lld.design.customer;

import com.lld.design.exceptions.InSufficientFundException;

public class CustomerAccount {
	private final String accountNumber;
	private final String routingNumber;
	private Double currentBalance = 0.0;

	public CustomerAccount(String accountNumber, String routingNumber) {
		this.accountNumber = accountNumber;
		this.routingNumber = routingNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public String getRoutingNumber() {
		return routingNumber;
	}

	public Double getCurrentBalance() {
		return currentBalance;
	}

	public void depositAmount(Double depositAmount) {
		this.currentBalance += depositAmount;
	}

	public void withdrawAmount(Double withdrawAmount) {

		if (currentBalance < withdrawAmount) {
			throw new InSufficientFundException("Account balance is low than entered amount!");
		}

		this.currentBalance -= withdrawAmount;
	}

}
