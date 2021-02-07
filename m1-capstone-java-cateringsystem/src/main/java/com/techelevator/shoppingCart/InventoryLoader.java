package com.techelevator.shoppingCart;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.techelevator.product.Appetizer;
import com.techelevator.product.Beverage;
import com.techelevator.product.Dessert;
import com.techelevator.product.Entree;
import com.techelevator.product.Product;
public class InventoryLoader {

	private final HashMap<String, List<Product>> availableProduct = new HashMap<>();
	
public Map<String, Product> loadInventoryFromFile() {
		
		Map<String, Product> tempMap = new HashMap<String, Product> ();
		
		try (Scanner scanner = new Scanner(new File("cateringsystem.csv"))) {
			
			
			while (scanner.hasNextLine()) {
				
				// assign line to a string - record
				String record = scanner.nextLine();
				
				String[] fields = record.split("|");
			
		//Product product = new Product(fields[0], fields[1], Double.parseDouble(fields[2]), fields[3]);
				
					
			    }
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			return tempMap;
		}

private void inventoryMap(String[] File) {
    for (String record : File) {

    	String[] fields = record.split("|");
        List<Product> productList = new ArrayList<>();
        String slot = fields[0];
        String name = fields[1];
        BigDecimal price = new BigDecimal(fields[2]);
        String type = fields[3];
        if (slot.startsWith("A")) {
        	Product product = new Appetizer(name, price, type);
        	productLoader(productList, slot, product, type);
        } else if (slot.startsWith("B")) {
        	 Product product = new Beverage(name, price, type);
        	 productLoader(productList, slot, product, type);
        } else if (slot.startsWith("D")) {
        	 Product product = new Dessert(name, price, type);
        	 productLoader(productList, slot, product, type);
        } else if (slot.startsWith("E")) {
        	 Product product = new Entree(name, price, type);
        	 productLoader(productList, slot, product, type);
        }

    }
}
//private Map<String, Product> productInventory;	
//public void Inventory() {
//	InventoryLoader loader = new InventoryLoader();
//   productInventory = loader.loadInventoryFromFile();
//}
//
//public List<Product> listOfProducts() {
//	List<Product> productList = new ArrayList<Product>();
//	
//	Set<String> keys = productInventory.keySet();
//	
//	for (String key : keys) {
//		productList.add(productInventory.get(key));
//	}
//	return productList;
//}


private void productLoader(List<Product> productList, String slot, Product product, String type) {
    for (int i = 0; i < 50; i++) {
    	productList.add(product);
        availableProduct.put(slot, productList);
    }
}

	
	
}
