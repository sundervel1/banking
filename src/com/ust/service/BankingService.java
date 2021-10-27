package com.ust.service;

import com.ust.exception.BankingException;

public interface BankingService {

	double deposit(double amount);

	double getBalance() throws BankingException;

	double withdraw(double amount) throws BankingException;

	void close();

}
