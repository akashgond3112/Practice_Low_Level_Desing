package com.java.lld.design.java;

import com.java.lld.design.java.model.Account;
import com.java.lld.design.java.model.common.Tag;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountController {
	private final AccountService accountService;

	public Account createAccount(Account account) {
		return accountService.createAccount(account);
	}

	public Optional<Account> getAccount(String id) {
		return accountService.getAccountById(id);
	}

	public Optional<Account> getAccountByUsername(String username) {
		return accountService.getAccountByUsername(username);
	}

	public List<Account> getAllAccounts() {
		return accountService.getAllAccounts();
	}

	public Account updateAccount(Account account) {
		return accountService.updateAccount(account);
	}

	public void deleteAccount(String id) {
		accountService.deleteAccount(id);
	}

	public List<Account> getAccountsByTag(Tag tag) {
		return accountService.getAccountsByTag(tag);
	}

	public boolean login(String username, String password) {
		return accountService.validateLogin(username, password);
	}
}
