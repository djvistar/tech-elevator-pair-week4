package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;





public class InventoryLoader {
	
	
	//HashMap here
	public Map<String, Product> loadInventoryFromFile() {
		
		Map<String, Product> tempMap = new HashMap<String, Product> ();
		
		try (Scanner scanner = new Scanner(new File("cateringsystem.csv"))) {
			
			
			while (scanner.hasNextLine()) {
				
				// assign line to a string - record
				String record = scanner.nextLine();
				
				
			    // parse using split(|)
				String[] fields = record.split("|");
				
//				private String slot;
//				private String productName;
//				private double price;
//				private String type;
//				
				Product product = new Product(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3]);
				
		    	
			    }
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			return tempMap;
		}
	
	
	
	
	}


