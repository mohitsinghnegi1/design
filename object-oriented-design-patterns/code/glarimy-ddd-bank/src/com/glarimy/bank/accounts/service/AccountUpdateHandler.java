package com.glarimy.bank.accounts.service;

import java.util.Map;

import com.glarimy.bank.accounts.api.Account;
import com.glarimy.messaging.api.Event;
import com.glarimy.messaging.api.Handler;

public class AccountUpdateHandler implements Handler {
	private AccountsRepository repo;

	public AccountUpdateHandler(AccountsRepository repo) {
		this.repo = repo;
	}

	@Override
	public void on(Event event) {
		Map<String, Object> body = event.getBody();
		int id = (Integer) (body.get("number"));
		double balance = (Double) (body.get("balance"));

		Account account = repo.find(id);
		account.setBalance(balance);
		repo.update(account);
	}

	@Override
	public String getTopic() {
		return "account.balance.updated";
	}

}
