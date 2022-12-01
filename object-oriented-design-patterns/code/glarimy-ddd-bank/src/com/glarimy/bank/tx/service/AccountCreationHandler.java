package com.glarimy.bank.tx.service;

import java.util.Map;

import com.glarimy.messaging.api.Event;
import com.glarimy.messaging.api.Handler;

public class AccountCreationHandler implements Handler {
	private AccountRepository repo;

	public AccountCreationHandler(AccountRepository repo) {
		this.repo = repo;
	}

	@Override
	public void on(Event event) {
		Map<String, Object> body = event.getBody();
		int number = (Integer) (body.get("number"));
		Account account = new Account();
		account.setNumber(number);
		account.setBalance(0);

		repo.save(account);
	}

	@Override
	public String getTopic() {
		return "account.created";
	}

}
