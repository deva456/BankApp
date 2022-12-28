package com.project.bankapp.controller;

import com.project.bankapp.modal.SavingAccount;
import com.project.bankapp.util.MinBalException;

public class SATransaction extends BankTransaction<SavingAccount> {

	public SATransaction(SavingAccount account1, SavingAccount account2) {
		super(account1, account2);
	}

	@Override
	public boolean withdraw(SavingAccount account, double amount) throws Exception {
		final double diffBalance = account.getBalance() - amount;
		if (diffBalance >= account.MIN_BAL) {
			account.setBalance(diffBalance);
			return true;
		}
		throw new MinBalException("Try another amount, Keep min balance 10000");

	}

	@Override
	public String transfer(double amount) throws Exception {
		if (withdraw(account1, amount)) {
			if (deposit(account2, amount)) {
				return account1.getAccNo() + " transfered " + amount + " to " + account2.getAccNo();
			}
		}
		return "Transaction Failed";

	}


	@Override
	public boolean deposit(SavingAccount account, double amount) {
		double balance=account.getBalance()+amount;
		account.setBalance(balance);
		return true;
	}

}
