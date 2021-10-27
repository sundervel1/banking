package com.ust.dao;

import com.ust.exception.BankingException;

public interface BankingDAO {

	double deposit(double amount);

	double getBalance() throws BankingException;

	double withdraw(double amount) throws BankingException;

	void close();

}
