package com.glarimy.bank.domain;

import com.glarimy.bank.domain.Account;

public interface Criteria {
	public boolean isSatisfiedWith(Account account);
}
