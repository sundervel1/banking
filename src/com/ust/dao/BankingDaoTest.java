package com.ust.dao;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ust.exception.BankingException;

public class BankingDaoTest {
	private BankingDAOImpl bDao = new BankingDAOImpl();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("before testing");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("after testing");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("set up");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("tear down");
	}

	@Test
	public void testDeposit() {
		double bal =0;
		bal = bDao.deposit(4000);
		assertEquals(5000, bal, 0.1);
	}

	@Test
	public void testGetBalance() {
		double bal = 0;
		bal = bDao.getBalance();
		assertEquals(1000, bal, 0.1);
	}

	@Test(expected = BankingException.class)
	public void testWithdrawEx() throws BankingException {
		double bal = 0;
		bal = bDao.withdraw(500);
		assertEquals(500, bal, 0.1);
	}
	@Test
	public void testWithdraw() throws BankingException {
		double bal = 0;
		bDao.deposit(5000);
		bal = bDao.withdraw(500);
		assertEquals(5500, bal, 0.1);
	}

}
