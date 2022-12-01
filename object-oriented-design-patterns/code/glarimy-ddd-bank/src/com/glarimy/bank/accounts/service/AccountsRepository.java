package com.glarimy.bank.accounts.service;

import com.glarimy.bank.accounts.api.Account;

public interface AccountsRepository {
	public Account save(Account account);

	public Account find(int id);

	public Account update(Account account);
}
