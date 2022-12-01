package com.glarimy.bank.accounts.service;

import com.glarimy.bank.accounts.api.Account;
import com.glarimy.bank.accounts.api.AccountNotFoundException;
import com.glarimy.bank.accounts.api.AccountServiceException;
import com.glarimy.bank.accounts.api.Customer;
import com.glarimy.bank.accounts.api.InvalidCustomerException;

public interface AccountService {
	public Account openAccountFor(Customer customer) throws InvalidCustomerException, AccountServiceException;

	public Account find(int id) throws AccountNotFoundException, AccountServiceException;

}
