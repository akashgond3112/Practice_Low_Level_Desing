package com.lld.design;

import com.lld.design.atm.ATM;
import com.lld.design.atm.ATMService;
import com.lld.design.atm.Location;
import com.lld.design.atm.Printer;
import com.lld.design.atm.Screen;
import com.lld.design.card.CardReader;
import com.lld.design.cash.CashDispenser;
import com.lld.design.cash.CashDepositSlot;
import com.lld.design.check.CheckDepositSlot;
import com.lld.design.customer.CustomerAccount;

public class MainRunner {

	public static void main(String[] args) {
		// Initialize necessary ATM components
		Location location = new Location("Bank of Java", "London", "B123");
		Screen screen = new Screen();
		Printer printer = new Printer();
		CashDispenser cashDispenser = new CashDispenser();
		CardReader cardReader = new CardReader();
		CashDepositSlot cashDepositSlot = new CashDepositSlot();  // Instantiate specific deposit slot
		CheckDepositSlot checkDepositSlot = new CheckDepositSlot();  // Instantiate specific deposit slot

		// Initialize ATM
		ATM atm = new ATM(10000.0, location, 12345L, screen, cashDepositSlot, checkDepositSlot, printer, cashDispenser, cardReader);

		// Initialize ATM Service and a sample customer account
		ATMService atmService = new ATMService();
		CustomerAccount customerAccount = new CustomerAccount("123456789", "987654321");
		atmService.addCustomerAccount("123456789", customerAccount);
		atmService.depositCash(500.0, "123456789"); // Add initial balance to ATMService map

		// Simulate ATM Operations
		try {
			// Deposit Cash
			Double depositAmount = 200.0;
			screen.displayMessage("Depositing amount: " + depositAmount);
			atmService.depositCash(depositAmount, "123456789");

			// Display Updated Balance
			CustomerAccount updatedAccount = atmService.getCustomerAccountByAccountId("123456789");
			screen.displayMessage("Updated Balance: " + updatedAccount.getCurrentBalance());

		} catch (Exception e) {
			screen.displayMessage("Error: " + e.getMessage());
		}
	}
}
