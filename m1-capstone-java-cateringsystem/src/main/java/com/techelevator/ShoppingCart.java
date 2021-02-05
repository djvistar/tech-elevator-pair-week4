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
	   // private final Logger logger = new Logger();
	  //  private final SalesReport salesReport = new SalesReport();
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

//	                logger.logPurchase(slot, item, startingBalance, balance); //Log and Sales Report
//	                salesReport.updateBalance(itemPrice);
//	                salesReport.updateInventory(item.getName());
//	                itemListStockCount.remove(0);
	            }
	        }
	    }

	    private boolean outOfStock(List<Product> products) {
	        return products.isEmpty();
	    }

	    public void addMoney(double money) {
	        balance += money;
	        System.out.println("Inserted $" + money + " dollars.");
	       // logger.logFeed(money, balance);

	    }

	    public void displayItems() {
	        System.out.println();
	        System.out.println(String.format("%-5s%-19s%10s%10s%10s", "Quantity", "	Type", "Product Name", "Single Price", "Multiple Price"));
	        System.out.println("---------------------------------------------");
	        for (Map.Entry<String, List<Product>> entry : productsInTheMachine.entrySet()) {
	            if (!outOfStock(entry.getValue())) {
	            	String productQuantity = String.valueOf(entry.getValue().size());
	            	String productType = entry.getValue().get(0).getType();
	            	String productNmae = entry.getValue().get(0).getProductName();
	            	String productPrice = "$" + entry.getValue().get(0).getPrice();
	            	String multipleProductPrice = "$" + (entry.getValue().get(0).getPrice()* productQuantity); 
	          //start back up from here  	 
	                System.out.println(String.format("%-5s%-19s%10s%10s", itemSlot, itemName, itemPrice, itemCount));
	            } else {
	                String itemSlot = entry.getKey();
	                System.out.println(String.format("%-15s%7s", itemSlot, "SOLD OUT")); //Prevents Array Out Of Bounds error
	            }
	        }
	        System.out.println("---------------------------------------------");
	    }

	    public Map<String, List<Item>> getItemsInTheMachine() {
	        return itemsInTheMachine;
	    }


	    public void resetBalance() {
	        balance = new BigDecimal(0);
	    }


	    public void loadInventory() {
	        Importer importer = new Importer();
	        itemsInTheMachine = importer.passImportMapToVendingMachine();
	    }

	    public void returnChange() {
	        if (balance.doubleValue() > 0) {  //Prevents message from displaying and logging if balance is 0
	            Change change = new Change();
	            BigDecimal changeGiven = getBalance();

	            System.out.println("\n" + change.makeChange(getBalance()));

	            resetBalance();
	            logger.logChange(changeGiven, getBalance());
	        }
	    }

	    public String formattedBalanceToCurrency() {
	        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
	        return numberFormat.format(balance.doubleValue());
	    }

	}
	
	
	
	
	
	
	
	
	
	
}
