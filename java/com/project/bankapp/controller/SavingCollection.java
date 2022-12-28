package com.project.bankapp.controller;

import com.project.bankapp.modal.SavingAccount;

public class SavingCollection extends BankCollection<SavingAccount> {

	private static SavingCollection saCollection;
	private SavingCollection() {
		super();
	}

	public static SavingCollection getCollection() {
		if(saCollection==null) {
			synchronized (SavingCollection.class) {
				if(saCollection==null) {
					saCollection=new SavingCollection();
				}	
			}
		}		
		return saCollection;
	}
	@Override
	public String createNewAccount(SavingAccount account) {
		if (accountSet.add(account)) {
			return "Created new Account " + account;
		} else {
			return "Error while Creating New Account";
		}

	}

	@Override
	public String updateAccNameByAccNo(int accNo, String accName) {
		// find account by accno
		SavingAccount account = findByAccNo(accNo);
		// update the account
		account.setAccName(accName);

		return "Error while updating the details";
	}

	@Override
	public SavingAccount findByAccNo(int accNo) {
		for (SavingAccount account : accountSet) {
			if (account.getAccNo() == accNo) {
				return account;
			}
		}
		return null;
	}

}
