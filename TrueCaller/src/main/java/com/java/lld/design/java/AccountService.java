package com.java.lld.design.java;

import com.java.lld.design.java.model.Account;
import com.java.lld.design.java.model.common.Tag;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class AccountService {
	private final AccountRepository accountRepository;

	public Account createAccount(Account account) {
		account = Account.builder().id(account.getId()).username(account.getUsername()).password(account.getPassword())
				.phoneNumber(account.getPhoneNumber()).tag(account.getTag()).contact(account.getContact())
				.personalInfo(account.getPersonalInfo()).socialInfo(account.getSocialInfo())
				.lastAccessed(LocalDateTime.now()).build();

		return accountRepository.save(account);
	}

	public Optional<Account> getAccountById(String id) {
		return accountRepository.findById(id);
	}

	public Optional<Account> getAccountByUsername(String username) {
		return accountRepository.findByUsername(username);
	}

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	public Account updateAccount(Account account) {
		// Check if account exists
		accountRepository.findById(account.getId())
				.orElseThrow(() -> new RuntimeException("Account not found with id: " + account.getId()));

		return accountRepository.save(account);
	}

	public void deleteAccount(String id) {
		accountRepository.deleteById(id);
	}

	public List<Account> getAccountsByTag(Tag tag) {
		return accountRepository.findByTag(tag);
	}

	public boolean validateLogin(String username, String password) {
		return accountRepository.findByUsername(username).map(account -> {
			boolean isValid = account.getPassword().equals(password);
			if (isValid) {
				// Update last accessed time
				Account updatedAccount = Account.builder().id(account.getId()).username(account.getUsername())
						.password(account.getPassword()).phoneNumber(account.getPhoneNumber()).tag(account.getTag())
						.contact(account.getContact()).personalInfo(account.getPersonalInfo())
						.socialInfo(account.getSocialInfo()).lastAccessed(LocalDateTime.now()).build();
				accountRepository.save(updatedAccount);
			}
			return isValid;
		}).orElse(false);
	}
}
