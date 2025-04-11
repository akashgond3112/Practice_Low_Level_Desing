package com.java.lld.design.java;

import com.java.lld.design.java.model.Account;
import com.java.lld.design.java.model.common.Tag;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class AccountRepositoryImpl implements AccountRepository {
	private final Map<String, Account> accountStore = new ConcurrentHashMap<>();

	@Override
	public Account save(Account account) {
		accountStore.put(account.getId(), account);
		return account;
	}

	@Override
	public Optional<Account> findById(String id) {
		return Optional.ofNullable(accountStore.get(id));
	}

	@Override
	public Optional<Account> findByUsername(String username) {
		return accountStore.values().stream().filter(account -> account.getUsername().equals(username)).findFirst();
	}

	@Override
	public List<Account> findAll() {
		return new ArrayList<>(accountStore.values());
	}

	@Override
	public List<Account> findByTag(Tag tag) {
		return accountStore.values().stream().filter(account -> account.getTag() == tag).collect(Collectors.toList());
	}

	@Override
	public void deleteById(String id) {
		accountStore.remove(id);
	}
}
