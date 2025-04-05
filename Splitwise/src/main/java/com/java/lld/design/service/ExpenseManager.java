package com.java.lld.design.service;


import com.java.lld.design.model.expense.Expense;
import com.java.lld.design.model.ExpenseType;
import com.java.lld.design.model.split.Split;
import com.java.lld.design.model.User;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
public class ExpenseManager {
	List<Expense> expenses;
	public final Map<String, User> userMap;
	Map<String, Map<String, Double>> balanceSheet;

	public ExpenseManager() {
		expenses = new ArrayList<>();
		userMap = new HashMap<>();
		balanceSheet = new HashMap<>();
	}

	public void addUser(User user) {
		userMap.put(user.getId(), user);
		balanceSheet.put(user.getId(), new HashMap<>());
	}

	public void addExpense(ExpenseType expenseType, double amount, String paidBy, List<Split> splits) {
		Expense expense = ExpenseService.createExpense(expenseType, amount, userMap.get(paidBy), splits);
		expenses.add(expense);

		for (Split split : splits) {
			String paidTo = split.getUser().getId();
			Map<String, Double> balances = balanceSheet.get(paidBy);

			//updating balanceSheet of paidBy
			if (!balances.containsKey(paidTo))
				balances.put(paidTo, 0.0);

			balances.put(paidTo, balances.get(paidTo) + split.getAmount());

			//updating balanceSheet of paidTo
			balances = balanceSheet.get(paidTo);

			if (!balances.containsKey(paidBy))
				balances.put(paidBy, 0.0);

			balances.put(paidBy, balances.get(paidBy) - split.getAmount());
		}
	}

	public void showExpense(String userId) {
		boolean isEmpty = true;

		for (Map.Entry<String, Double> userBalance : balanceSheet.get(userId).entrySet()) {
			if (userBalance.getValue() != 0) {
				isEmpty = false;
				printBalance(userId, userBalance.getKey(), userBalance.getValue());
			}
		}

		if (isEmpty) {
			log.info("No Balances");
		}
	}

	private void printBalance(String user1, String user2, double amount) {
		String user1Name = userMap.get(user1).getName();
		String user2Name = userMap.get(user2).getName();
		if (amount < 0) {
			log.info("{} owes {}: {}", user1Name, user2Name, Math.abs(amount));
		} else if (amount > 0) {
			log.info("{} owes {}: {}", user2Name, user1Name, Math.abs(amount));
		}
	}

	public void showBalances() {
		boolean isEmpty = true;

		for (Map.Entry<String, Map<String, Double>> allBalances : balanceSheet.entrySet()) {
			for (Map.Entry<String, Double> userBalance : allBalances.getValue().entrySet()) {
				if (userBalance.getValue() > 0) {
					isEmpty = false;
					printBalance(allBalances.getKey(), userBalance.getKey(), userBalance.getValue());
				}
			}
		}

		if (isEmpty) {
			log.info("No Balances");
		}
	}
}
