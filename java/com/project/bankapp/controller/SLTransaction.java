package com.project.bankapp.controller;

import com.project.bankapp.modal.SavingAccount;
import com.project.bankapp.util.InsufficientBalException;

public class SLTransaction extends BankTransaction<SavingAccount> {

	private SLTransaction(SavingAccount account1, SavingAccount account2) {
		super(account1, account2);

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
		double balance = account.getBalance() + amount;
		account.setBalance(balance);
		return true;
	}

	@Override
	public boolean withdraw(SavingAccount account, double amount) throws Exception {
		final double diffBalance = account.getBalance() - amount;
		if (diffBalance >= 0) {
			account.setBalance(diffBalance);
			return true;
		}
		throw new InsufficientBalException("Insufficient Balance.Current Balance is: " + account.getBalance());

	}

}
