package com.ust.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	public static final double MIN_BALANCE = 1000;
	private static String fileName="bank.config";
	private static BufferedReader bReader;
	private static BufferedWriter bWriter;
	public static void initialize(String balanceRepo) {
		fileName = balanceRepo;		
	}
	public static double getValue() {		
		try {
			bReader = new BufferedReader(new FileReader(fileName));
			return Double.parseDouble(bReader.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			if(bReader!=null)
				try {bReader.close();} catch (IOException e) {}
		}
		return -1;
	}
	public static void writeValue(String data) {
		try {
			bWriter = new BufferedWriter(new FileWriter(fileName));
			bWriter.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(bWriter!=null)
				try {bWriter.close();} catch (IOException e) {}
		}
		
	}
	public static void close() {
		if(bReader!=null)
			try {bReader.close();} catch (IOException e) {}
		
	}

}
