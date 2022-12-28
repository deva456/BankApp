package com.project.bankapp.modal;

public class SavingAccount extends BankAccount {
	public static final double MIN_BAL = 10000;
	public SavingAccount() {
		super();
	}

	public SavingAccount(int accNo, String accName, double balance) {
		super(accNo, accName, balance);
	}

	public SavingAccount(String accName, double balance) {
		super(accName, balance);
	}

}