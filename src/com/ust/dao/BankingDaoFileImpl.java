package com.ust.dao;

import com.ust.exception.BankingException;
import com.ust.util.FileUtil;

public class BankingDaoFileImpl implements BankingDAO {
	private String balanceRepo = "bank.txt";
	
	public BankingDaoFileImpl() {
		FileUtil.initialize(balanceRepo);
	}

	@Override
	public double deposit(double amount) {
		double balance = FileUtil.getValue();
		balance += amount;
		// write back into file
		FileUtil.writeValue(balance+"");
		return balance;
	}

	@Override
	public double getBalance() throws BankingException {	
		double balance = FileUtil.getValue();
		if(balance==-1)
			throw new BankingException("Error retrieving balance");
		return balance;
	}

	@Override
	public double withdraw(double amount) throws BankingException {
		double balance = FileUtil.getValue();
		double temp = balance - amount;
		if(temp<FileUtil.MIN_BALANCE)
			throw new BankingException("Insufficient Balance");
		balance = temp;
		FileUtil.writeValue(balance+"");
		return balance;
	}

	@Override
	public void close() {
		FileUtil.close();		
	}

}
