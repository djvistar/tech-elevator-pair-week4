package com.techelevator.shoppingCart;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.techelevator.product.*;

public class Inventory1 {

	
		
		//List of Product map
		// This hashmap contains our inventory of products. We must protect it so it is private.
			// Only way to modify data is to go through the public methods below.
			
			
			
			 //This constructor is called when the program loads. 
			 
			private Map<String, Product> productInventory;	
			public void Inventory() {
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
	
	
	
	

