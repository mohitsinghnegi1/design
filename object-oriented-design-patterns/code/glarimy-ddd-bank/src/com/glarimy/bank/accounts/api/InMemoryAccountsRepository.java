package com.glarimy.bank.accounts.api;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.glarimy.bank.accounts.service.AccountsRepository;

public class InMemoryAccountsRepository implements AccountsRepository {
	private Map<Integer, Account> accounts;
	private static InMemoryAccountsRepository INSTANCE;
	private AtomicInteger idGenerator;

	private InMemoryAccountsRepository() {
		accounts = new HashMap<Integer, Account>();
		idGenerator = new AtomicInteger();
	}

	public static synchronized InMemoryAccountsRepository getInstance() {
		if (INSTANCE == null)
			INSTANCE = new InMemoryAccountsRepository();
		return INSTANCE;
	}

	@Override
	public Account save(Account account) {
		int id = idGenerator.incrementAndGet();
		account.setId(id);
		accounts.put(id, account);
		return account;
	}

	@Override
	public Account find(int id) {
		return accounts.get(id);
	}

	@Override
	public Account update(Account account) {
		accounts.put(account.getId(), account);
		return account;
	}

}
