package com.glarimy.bank.tx.api;

public interface TxService {
	public Transaction process(DepositRequest request)
			throws AccountNotFoundException, InvalidRequestException, TxServiceException;

	public Transaction process(WithdrawalRequest request)
			throws AccountNotFoundException, InvalidRequestException, TxServiceException;
}
