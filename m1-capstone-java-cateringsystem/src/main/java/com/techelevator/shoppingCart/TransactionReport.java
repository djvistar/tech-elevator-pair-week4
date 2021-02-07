package com.techelevator.shoppingCart;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import com.techelevator.product.Product;

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
	
	
	 public void recordPurchase(String slot, Product product, BigDecimal startingBalance, BigDecimal endingBalance) {
	        String action = product.getName() + " " + slot;
	        String entry = writeRecord(action, startingBalance, endingBalance);

	       // printToFile(entry);
	    }
	
	 public void recordAdd(BigDecimal amountAdded, BigDecimal endingBalance) {
	        String action = "ADD MONEY";
	      String entry = writeRecord(action, amountAdded, endingBalance);

	       // printToFile(entry);
	    }
	
	 
	 public void recordChange(BigDecimal changeGiven, BigDecimal endingBalance) {
	        String action = "GIVE CHANGE";
	       String entry = writeRecord(action, changeGiven, endingBalance);

	        //printToFile(entry);
	    }
	
	 public  String writeRecord(String action, BigDecimal startingBalance, BigDecimal endingBalance) {
		 LocalDateTime now = LocalDateTime.now();
			String date = now.format(DateTimeFormatter.ISO_DATE);
	        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
	        String startingBalanceString = (numberFormat.format(startingBalance.doubleValue()));
	        String endingBalanceString = (numberFormat.format(endingBalance.doubleValue()));

	       return String.format("%-25s%-25s%-10s%-10s", date, action, startingBalanceString, endingBalanceString);
	   
	        //writer.println(text);
			//writer.flush();
	 }
	
	 public void closeFile() {
			writer.flush();
			writer.close();
		}
	
	
}
