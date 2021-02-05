package com.techelevator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		DateTimeFormatter now;
		String date = now.format(DateTimeFormatter.ISO_DATE);
		String text = String.format("%-25s %-25s ",  "ADD MONEY: ", newProduct.getBalance());
		writer.println(text);
		writer.flush();
	}
	
	public void closeFile() {
		writer.flush();
		writer.close();
	}
	
	
	
	
	
	
	

}
