package com.glarimy.bank.accounts.app;

import com.glarimy.bank.accounts.api.AccountNotFoundException;
import com.glarimy.bank.accounts.api.AccountServiceException;
import com.glarimy.bank.accounts.api.Address;
import com.glarimy.bank.accounts.api.Customer;
import com.glarimy.bank.accounts.api.InvalidCustomerException;
import com.glarimy.bank.accounts.api.Name;
import com.glarimy.bank.accounts.api.Phone;
import com.glarimy.bank.accounts.service.SimpleAccountService;

public class AccountController {
	public Response openAccountFor(User user) {
		Customer customer = new Customer();
		for (long number : user.phones)
			customer.getPhones().add(new Phone(number));
		customer.setAddress(new Address(user.location, user.city, user.pincode));
		String firstName = user.name.substring(0, user.name.indexOf(" "));
		String lastName = user.name.substring(user.name.indexOf(" ") + 1);
		customer.setName(new Name(firstName, lastName));
		try {
			com.glarimy.bank.accounts.api.Account result = SimpleAccountService.getInstance().openAccountFor(customer);
			Account account = new Account();
			account.number = result.getId();
			account.owner = result.getCustomer().getName().getFirstName() + " "
					+ result.getCustomer().getName().getLastName();
			account.address = result.getCustomer().getAddress().getLocation() + ", "
					+ result.getCustomer().getAddress().getCity() + ", "
					+ result.getCustomer().getAddress().getPincode();
			account.balance = result.getBalance();
			if (result.getCustomer().getPhones().size() == 2)
				account.phones = result.getCustomer().getPhones().get(0).getNumber() + ","
						+ result.getCustomer().getPhones().get(1);
			else
				account.phones = result.getCustomer().getPhones().get(0).getNumber() + "";
			return new Response(200, account);
		} catch (InvalidCustomerException ice) {
			return new Response(400);
		} catch (AccountServiceException e) {
			return new Response(500);
		}
	}

	public Response find(int id) {
		try {
			com.glarimy.bank.accounts.api.Account result = SimpleAccountService.getInstance().find(id);
			Account account = new Account();
			account.number = result.getId();
			account.owner = result.getCustomer().getName().getFirstName()
					+ result.getCustomer().getName().getLastName();
			account.address = result.getCustomer().getAddress().getLocation()
					+ result.getCustomer().getAddress().getCity() + result.getCustomer().getAddress().getPincode();
			account.balance = result.getBalance();
			if (result.getCustomer().getPhones().size() == 2)
				account.phones = result.getCustomer().getPhones().get(0).getNumber() + ","
						+ result.getCustomer().getPhones().get(1).getNumber();
			else
				account.phones = result.getCustomer().getPhones().get(0).getNumber() + "";
			return new Response(200, account);
		} catch (AccountNotFoundException anf) {
			return new Response(404);
		} catch (AccountServiceException e) {
			return new Response(500);
		}
	}

}
