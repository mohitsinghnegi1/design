package com.glarimy.bank.tx.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.glarimy.bank.tx.api.AccountNotFoundException;
import com.glarimy.bank.tx.api.DepositRequest;
import com.glarimy.bank.tx.api.InvalidRequestException;
import com.glarimy.bank.tx.api.Transaction;
import com.glarimy.bank.tx.api.TxService;
import com.glarimy.bank.tx.api.TxServiceException;
import com.glarimy.bank.tx.api.WithdrawalRequest;
import com.glarimy.messaging.api.Event;
import com.glarimy.messaging.api.LocalPublisher;
import com.glarimy.messaging.api.Publisher;
import com.glarimy.messaging.service.SimpleBroker;

public class SimpleTxService implements TxService {
	private AccountRepository repo;
	private static SimpleTxService INSTANCE;
	private AtomicInteger idGenerator;

	private SimpleTxService() {
		repo = InMemoryAccountRepository.getInstance();
		SimpleBroker.getInstance().register(new AccountCreationHandler(repo));
		idGenerator = new AtomicInteger();
	}

	public static synchronized SimpleTxService getInstance() {
		if (INSTANCE == null)
			INSTANCE = new SimpleTxService();
		return INSTANCE;
	}

	@Override
	public Transaction process(DepositRequest request)
			throws AccountNotFoundException, InvalidRequestException, TxServiceException {
		Account account = repo.find(request.getAccNo());
		if (account == null)
			throw new AccountNotFoundException();

		Transaction tx = new Transaction();
		tx.setId(idGenerator.incrementAndGet());
		tx.setNumber(request.getAccNo());
		tx.setAmount(request.getAmount());
		tx.setDate(new Date());
		tx.setType("Credit");
		tx.setBalance(account.getBalance() + request.getAmount());

		account.setBalance(tx.getBalance());

		Map<String, Object> body = new HashMap<>();
		body.put("number", tx.getNumber());
		body.put("transaction", tx.getType());
		body.put("amount", tx.getAmount());
		body.put("balance", tx.getBalance());
		body.put("date", tx.getDate());
		Event event = new Event("account.balance.updated", body);

		Publisher publisher = new LocalPublisher();
		publisher.publish(event);

		return tx;
	}

	@Override
	public Transaction process(WithdrawalRequest request)
			throws AccountNotFoundException, InvalidRequestException, TxServiceException {
		Account account = repo.find(request.getAccNo());
		if (account == null)
			throw new InvalidRequestException("Account Not Found");

		if (account.getBalance() < request.getAmount())
			throw new InvalidRequestException("Insufficient Balance");

		Transaction tx = new Transaction();
		tx.setId(idGenerator.incrementAndGet());
		tx.setNumber(request.getAccNo());
		tx.setAmount(request.getAmount());
		tx.setDate(new Date());
		tx.setType("Debit");
		tx.setBalance(account.getBalance() - request.getAmount());

		account.setBalance(tx.getBalance());

		Map<String, Object> body = new HashMap<>();
		body.put("number", tx.getNumber());
		body.put("transaction", tx.getType());
		body.put("amount", tx.getAmount());
		body.put("balance", tx.getBalance());
		body.put("date", tx.getDate());
		Event event = new Event("account.balance.updated", body);

		Publisher publisher = new LocalPublisher();
		publisher.publish(event);

		return tx;
	}

}
