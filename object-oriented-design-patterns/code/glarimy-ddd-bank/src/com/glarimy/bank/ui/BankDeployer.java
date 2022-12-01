package com.glarimy.bank.ui;

import com.glarimy.bank.accounts.service.SimpleAccountService;
import com.glarimy.bank.tx.service.SimpleTxService;

public class BankDeployer {
	public static void deploy() {
		SimpleAccountService.getInstance();
		SimpleTxService.getInstance();
	}
}
