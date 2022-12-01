package com.glarimy.bank.tx.service;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {
	private Map<Integer, Account> accounts;
	private static InMemoryAccountRepository INSTANCE;

	private InMemoryAccountRepository() {
		accounts = new HashMap<>();
	}

	public static synchronized InMemoryAccountRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryAccountRepository();
		return INSTANCE;
	}

	@Override
	public void save(Account account) {
		accounts.put(account.getNumber(), account);
	}

	@Override
	public Account find(int number) {
		return accounts.get(number);
	}
}