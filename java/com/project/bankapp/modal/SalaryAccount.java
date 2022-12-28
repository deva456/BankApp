package com.project.bankapp.modal;



public class SalaryAccount extends SavingAccount {

	public SalaryAccount() {
		super();
	}

	public SalaryAccount(int accNo, String accName, double balance) {
		super(accNo, accName, balance);
	}

	public SalaryAccount(String accName, double balance) {
		super(accName, balance);
	}

}
