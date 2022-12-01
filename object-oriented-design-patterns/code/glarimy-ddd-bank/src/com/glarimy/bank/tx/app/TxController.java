package com.glarimy.bank.tx.app;

import com.glarimy.bank.tx.api.AccountNotFoundException;
import com.glarimy.bank.tx.api.DepositRequest;
import com.glarimy.bank.tx.api.InvalidRequestException;
import com.glarimy.bank.tx.api.Transaction;
import com.glarimy.bank.tx.api.TxServiceException;
import com.glarimy.bank.tx.api.WithdrawalRequest;
import com.glarimy.bank.tx.service.SimpleTxService;

public class TxController {
	public Response process(Request request) {
		try {
			if (request.type == "credit") {
				DepositRequest dr = new DepositRequest();
				dr.setAccNo(request.accNo);
				dr.setAmount(request.amount);
				Transaction tx = SimpleTxService.getInstance().process(dr);
				Record record = new Record();
				record.date = tx.getDate().toString();
				record.number = tx.getNumber();
				record.reference = tx.getId();
				record.balance = tx.getBalance();
				return new Response(200, record);
			}

			if (request.type == "debit") {
				WithdrawalRequest wr = new WithdrawalRequest();
				wr.setAccNo(request.accNo);
				wr.setAmount(request.amount);
				Transaction tx = SimpleTxService.getInstance().process(wr);
				Record record = new Record();
				record.date = tx.getDate().toString();
				record.number = tx.getNumber();
				record.reference = tx.getId();
				record.balance = tx.getBalance();
				return new Response(200, record);
			}
			return new Response(400, "No Op");

		} catch (AccountNotFoundException anfe) {
			return new Response(404, "Account Not Found");
		} catch (InvalidRequestException ire) {
			return new Response(400, ire.getMessage());
		} catch (TxServiceException e) {
			return new Response(500, e.getMessage());
		}
	}

}
