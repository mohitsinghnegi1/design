package com.glarimy.bank.tx.service;

public interface AccountRepository {
	public void save(Account account);

	public Account find(int number);
}
