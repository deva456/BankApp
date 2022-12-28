package com.project.bankapp;

import java.util.Set;

import com.project.bankapp.controller.SATransaction;
import com.project.bankapp.controller.SavingCollection;
import com.project.bankapp.modal.BankAccount;
import com.project.bankapp.modal.SavingAccount;

public class BankApp {
	public static void main(String[] args) {
		SavingCollection collection=SavingCollection.getCollection();
		Set<SavingAccount> accountSet=collection.getAccountset();
		accountSet.add(new SavingAccount("Amit",100000.0));
		accountSet.add(new SavingAccount("Sumit",100000.0));
		accountSet.add(new SavingAccount("Ajit",100000.0));
		accountSet.add(new SavingAccount("Ankit",100000.0));
		//First way
		for(BankAccount account:accountSet) {
			System.out.println(account);
		}
		final SavingAccount account1=collection.findByAccNo(3);
		final SavingAccount account2=collection.findByAccNo(4);
		final SATransaction transaction=new SATransaction(account1,account2);
		System.out.println("Before Transfer ");
		System.out.println(account1);
		System.out.println(account2);
		String message="";
		System.out.println("FailFirst Transaction");
		try {
			message = transaction.transfer(90001);
		} catch (Exception e) {
			message=e.getMessage();
		}finally {
			System.out.println(message);
			System.out.println("After Transfer ");
			System.out.println(account1);
			System.out.println(account2);

		}
		System.out.println("Successful Transaction ");
		try {
			message = transaction.transfer(90000);
		} catch (Exception e) {
			message=e.getMessage();
		}finally {
			System.out.println(message);
			System.out.println("After Transfer ");
			System.out.println(account1);
			System.out.println(account2);

		}
		
	}

}



