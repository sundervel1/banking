package com.ust.service;

import com.ust.dao.BankingDAO;
import com.ust.dao.BankingDAOImpl;
import com.ust.dao.BankingDaoFileImpl;
import com.ust.exception.BankingException;

public class BankingServiceImpl implements BankingService {
	private BankingDAO bDao;
	
	public BankingServiceImpl() {
		//bDao = new BankingDAOImpl();
		bDao = new BankingDaoFileImpl();
	}

	@Override
	public double deposit(double amount) {		
		return bDao.deposit(amount);
	}

	@Override
	public double getBalance() throws BankingException {
		return bDao.getBalance();
	}

	@Override
	public double withdraw(double amount) throws BankingException {
		return bDao.withdraw(amount);
	}

	@Override
	public void close() {
		bDao.close();
	}

}
