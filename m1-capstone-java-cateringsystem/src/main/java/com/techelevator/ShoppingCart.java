package com.techelevator;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ShoppingCart {
	
	//When item inventory == 0 show SOLD OUT here
	
	//Have a LIST that shows what is in the inventory
	
	//If available add to the cart to be checked out
	

	    private LinkedHashMap<String, List<Product>> productsInTheMachine = new LinkedHashMap<>();
	    private final TransactionReport transactionReport = new TransactionReport(null);
	    private double balance ;

	    public double getBalance() {
	        return balance;
	    }

	    public void buyProduct(String slot) {
	        List<Product> productListStockCount = productsInTheMachine.get(slot);
	        if (outOfStock(productListStockCount)) {
	            System.out.println("SOLD OUT");
	        } else {
	        	Product product = productListStockCount.get(0);
	            double productPrice = product.getPrice();
	            if (balance < productPrice)
	                System.out.println("Please Insert More Money.");

	            else {
	                System.out.println("\nConsuming " + product.getProductName() + "..." + "\n");
	              double startingBalance = balance;

	                balance -= productPrice;


			
              transactionReport.updateBalance(productPrice);
              transactionReport.updateInventory(product.getProductName());
	                productListStockCount.remove(0);
	            }
	        }
	    }

	    private boolean outOfStock(List<Product> products) {
	        return products.isEmpty();
	    }

	    public void addMoney(double money) {
	        balance += money;
	        System.out.println("Inserted $" + money + " dollars.");
	      

	    }

	    public void displayProducts() {
	        System.out.println();
	        System.out.println(String.format("%-5s%-19s%10s%10s%10s", "Quantity", "	Type", "Product Name", "Single Price", "Multiple Price"));
	        System.out.println("---------------------------------------------");
	        for (Map.Entry<String, List<Product>> entry : productsInTheMachine.entrySet()) {
	            if (!outOfStock(entry.getValue())) {
	            	int productQuantity = 0;
	            	//String productQuantity = String.valueOf(entry.getValue().size());
	            	String productType = entry.getValue().get(0).getType();
	            	String productName = entry.getValue().get(0).getProductName();
	            	String productPrice = "$" + entry.getValue().get(0).getPrice();
	            	String multipleProductPrice = "$" + (entry.getValue().get(0).getPrice())* productQuantity; 
	          
 	 
	                System.out.println(String.format("%-5s%-19s%10s%10s%10s", productQuantity, productType, productName, productPrice,  multipleProductPrice ));
	            } else {
	                String productName = entry.getKey();
	                System.out.println(String.format("%-15s%7s", productName, "SOLD OUT")); //Prevents Array Out Of Bounds error
	            }
	        }
	        System.out.println("---------------------------------------------");
	    }

	    public Map<String, List<Product>> getProductsInTheMachine() {
	        return productsInTheMachine;
	    }


	    public void resetBalance() {
	        balance = 0;
	    }


//	    public void loadInventory() {
//	        InventoryLoader inventoryLoader = new InventoryLoader();
//	        productsInTheMachine = inventoryLoader.passToShoppingCart();
//	    }

	    public void returnChange() {
	        if (balance > 0) {  //Prevents message from displaying if balance is 0
	            Accounting accounting = new Accounting(balance, balance);
	            double changeGiven = getBalance();

	            System.out.println("\n" + accounting.makeChange());

	            resetBalance();
	         
	        }
	    }

	  

	}
	
	
	
	
	
	
	
	
	
	

