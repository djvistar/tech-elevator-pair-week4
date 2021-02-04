package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;



public class Inventory {
	
	
	//List of Product map
	// This hashmap contains our inventory of products. We must protect it so it is private.
		// Only way to modify data is to go through the public methods below.
		private Map<String, Product> productInventory;
		
		/**
		 * This constructor is called when the program loads (see HomeApp class). When inventory class is created
		 * it will load 'sample data'. Later in module 2, we will load data from a database. 
		 */
		public Inventory() {
			InventoryLoader loader = new InventoryLoader();
	        productInventory = loader.loadInventoryFromFile();
		}
	
	//Need a list to return a list of all products
		public List<Product> listOfProducts() {
			List<Product> productList = new ArrayList<Product>();
			
			Set<String> keys = productInventory.keySet();
			
			for (String key : keys) {
				productList.add(productInventory.get(key));
			}
			return productList;
		}

}
