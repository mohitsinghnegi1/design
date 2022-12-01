package com.glarimy.bank.ui;

import com.glarimy.bank.accounts.app.Account;
import com.glarimy.bank.accounts.app.AccountController;
import com.glarimy.bank.accounts.app.User;
import com.glarimy.bank.tx.app.Request;
import com.glarimy.bank.tx.app.TxController;

public class BankApplication {
	public static void main(String[] args) {
		BankDeployer.deploy();
		User user = new User();
		user.name = "Krishna Mohan";
		user.location = "Pai Layout";
		user.city = "Bengaluru";
		user.pincode = 560016;
		user.phones = new long[1];
		user.phones[0] = 9731423166L;

		AccountController accountController = new AccountController();
		TxController txController = new TxController();

		com.glarimy.bank.accounts.app.Response r1 = accountController.openAccountFor(user);
		Account account = (Account) r1.body;
		System.out.println(r1);

		com.glarimy.bank.tx.app.Response r2 = txController.process(new Request(account.number, 500, "credit"));
		System.out.println(r2);

		com.glarimy.bank.tx.app.Response r3 = txController.process(new Request(account.number, 300, "debit"));
		System.out.println(r3);

		com.glarimy.bank.accounts.app.Response r4 = accountController.find(account.number);
		System.out.println(r4);
	}
}
