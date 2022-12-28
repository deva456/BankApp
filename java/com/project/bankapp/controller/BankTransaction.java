package com.project.bankapp.controller;

public abstract class BankTransaction<T> {
	protected T account1;
	protected T account2;
	
	public BankTransaction(T account1,T account2) {
		this.account1=account1;
		this.account2=account2;
	}

	public abstract String transfer(double amount) throws Exception ;
	public abstract boolean withdraw(T account,double amount)throws Exception;
	public abstract boolean deposit(T account,double amount) ;

}

