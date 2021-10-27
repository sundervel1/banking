package com.ust.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ust.exception.BankingException;
import com.ust.service.BankingService;
import com.ust.service.BankingServiceImpl;

public class BankingMain {
	
	private BankingService bService;
	private void start() {
		bService = new BankingServiceImpl();
		Scanner scan = new Scanner(System.in);
		boolean canrun = true;
		int choice = 0;
		while (canrun) {
			
			choice = getChoice(scan);
			switch (choice) {
			case 1:
				System.out.println("Deposit Amount");
				double amount = 0;
				System.out.println("Enter amount to be deposited");
				amount = scan.nextDouble();
				double balance = bService.deposit(amount);
				System.out.println("Amount deposited, current balance: " + balance);
				break;
			case 2:
				System.out.println("Withdraw Amount");
				System.out.println("Enter amount to withdraw");
				amount = scan.nextDouble();
				try {
					balance = bService.withdraw(amount);
					System.out.println("Amount withdrawn, current balance: " + balance);
				} catch (BankingException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Check Balance");
				try {
					balance = bService.getBalance();
					System.out.println("Balance : " + balance);
				} catch (BankingException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				bService.close();
				System.out.println("Thank you. Exiting system.");
				canrun = false;
				break;

			default:
				System.err.println("Please enter 1 to 4 only");
				break;
			}
			
		}
		scan.close();
	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("Welcome to UST bank");
		System.out.println("1. Deposit Amount");
		System.out.println("2. Withdraw Amount");
		System.out.println("3. Check Balance");
		System.out.println("4. Exit System");
		System.out.println("Please enter your choice 1 to 4");
		try {
		choice = scan.nextInt();
		}catch (InputMismatchException e) {
			System.out.println("Please enter numbers only");
			scan.nextLine();
		}
		return choice;
	}

	public static void main(String[] args) {
		new BankingMain().start(); // can write initiate, execute, proceed,....
	}
}
