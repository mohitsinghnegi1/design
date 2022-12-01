package com.glarimy.bank.accounts.service;

import java.util.HashMap;
import java.util.Map;

import com.glarimy.bank.accounts.api.Account;
import com.glarimy.bank.accounts.api.AccountNotFoundException;
import com.glarimy.bank.accounts.api.AccountServiceException;
import com.glarimy.bank.accounts.api.Customer;
import com.glarimy.bank.accounts.api.InMemoryAccountsRepository;
import com.glarimy.bank.accounts.api.InvalidCustomerException;
import com.glarimy.messaging.api.Broker;
import com.glarimy.messaging.api.Event;
import com.glarimy.messaging.api.Handler;
import com.glarimy.messaging.api.LocalPublisher;
import com.glarimy.messaging.api.Publisher;
import com.glarimy.messaging.service.SimpleBroker;

public class SimpleAccountService implements AccountService {
	private AccountsRepository repo;
	public static SimpleAccountService INSTANCE;

	private SimpleAccountService() {
		repo = InMemoryAccountsRepository.getInstance();
		Handler handler = new AccountUpdateHandler(repo);
		Broker broker = SimpleBroker.getInstance();
		broker.register(handler);
	}

	public static synchronized SimpleAccountService getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SimpleAccountService();
		return INSTANCE;
	}

	@Override
	public Account openAccountFor(Customer customer) throws InvalidCustomerException, AccountServiceException {
		Account account = new Account();
		account.setCustomer(customer);
		account = repo.save(account);

		Publisher publisher = new LocalPublisher();
		Map<String, Object> body = new HashMap<>();
		body.put("number", account.getId());
		Event event = new Event("account.created", body);
		publisher.publish(event);

		return account;
	}

	@Override
	public Account find(int id) throws AccountNotFoundException, AccountServiceException {
		return repo.find(id);
	}

}
