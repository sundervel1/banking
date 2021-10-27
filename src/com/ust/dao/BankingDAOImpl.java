package com.ust.dao;

import com.ust.exception.BankingException;

public class BankingDAOImpl implements BankingDAO {
	private double balance = 1000;
	private static final double MIN_BALANCE = 1000;
	@Override
	public double deposit(double amount) {
		balance += amount;
		return balance;
	}
	@Override
	public double getBalance() {
		return balance;
	}
	@Override
	public double withdraw(double amount) throws BankingException {
		double temp = balance - amount;
		if(temp<MIN_BALANCE) {
			throw new BankingException("Insufficient Balance");
		}
		balance = temp;
		return balance;
	}
	@Override
	public void close() {
		// do nothing		
	}

}
