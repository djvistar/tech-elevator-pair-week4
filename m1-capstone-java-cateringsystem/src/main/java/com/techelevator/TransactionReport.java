package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TransactionReport {
	
	
private PrintWriter writer;
	
	public TransactionReport(String fileName) {
		try {
			writer = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)));
		} 
		catch (IOException e) {				
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void writeRecord(Product newProduct) {
		LocalDateTime now = LocalDateTime.now();
		String date = now.format(DateTimeFormatter.ISO_DATE);
		String text = String.format("%-25s %-25s ",  "ADD MONEY: ", newProduct.getBalance());
		writer.println(text);
		writer.flush();
	}
	
	public void closeFile() {
		writer.flush();
		writer.close();
	}

//updates balance after a transaction in the shopping cart
	public void updateBalance(double productPrice) {
		double balance=0;
		double remainingBalance = balance - productPrice;
		// TODO Auto-generated method stub
		
	}

	//updates inventory after a transaction in the shopping cart

	public void updateInventory(String productName) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	
	
	

}
