package com.techelevator.shoppingCart;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.math.*;

import com.techelevator.change.Change;
import com.techelevator.product.Product;

public class ShoppingCart {

	
	   private HashMap<String, List<Product>> availableProduct = new HashMap<>();
	    private final TransactionReport  transactionReport = new TransactionReport(null);
	  
	    private BigDecimal balance = new BigDecimal(0);

	    public BigDecimal getBalance() {
	        return balance;
	    }

	    public void buyProduct(String slot) {
	        List<Product> productListStock = availableProduct.get(slot);
	        if (outOfStock(productListStock)) {
	            System.out.println("SOLD OUT");
	        } else {
	        	Product product = productListStock.get(0);
	            BigDecimal productPrice = product.getPrice();
	            if (balance.doubleValue() < productPrice.doubleValue())
	                System.out.println("Please Insert More Money.");

	            else {
	                System.out.println("\nPurchased " + product.getName() + "\n");
	                BigDecimal startingBalance = balance;

	                balance = balance.subtract(productPrice);

	                transactionReport.recordPurchase(slot, product, startingBalance, balance); //Log and Sales Report	                            
	                productListStock.remove(0);
	            }
	        }
	    }

	    private boolean outOfStock(List<Product> products) {
	        return products.isEmpty();
	    }

	    
	    public void addMoney(BigDecimal money) {
	        balance = balance.add(money);
	        System.out.println("Inserted $" + money.toString() + " dollars.");
	        transactionReport.recordAdd(money, balance);

	    }

//	    public void displayProducts() {
//	        System.out.println();
//	        System.out.println(String.format("%-5s%-19s%10s%10s", "Slot", "Name", "Price", "Count"));
//	        System.out.println("---------------------------------------------");
//	        for (Map.Entry<String, List<Product>> entry : availableProduct.entrySet()) {
//	            if (!outOfStock(entry.getValue())) {
//	                String itemSlot = entry.getKey();
//	                String itemName = entry.getValue().get(0).getName();
//	                String itemPrice = "$" + entry.getValue().get(0).getPrice().toString();
//	                String itemCount = String.valueOf(entry.getValue().size());
//
//	                System.out.println(String.format("%-5s%-19s%10s%10s", itemSlot, itemName, itemPrice, itemCount));
//	            } else {
//	                String itemSlot = entry.getKey();
//	                System.out.println(String.format("%-15s%7s", itemSlot, "SOLD OUT")); //Prevents Array Out Of Bounds error
//	            }
//	        }
//	        System.out.println("---------------------------------------------");
//	    }
//
//	    public Map<String, List<Item>> getItemsInTheMachine() {
//	        return itemsInTheMachine;
//	    }

	    public void displayProducts() {
	        System.out.println();
	        System.out.println(String.format("%-5s%-19s%10s%10s%10s", "Quantity", "	Type", "Product Name", "Single Price", "Multiple Price"));
	        System.out.println("---------------------------------------------");
	        for (Map.Entry<String, List<Product>> entry : availableProduct.entrySet()) {
	            if (!outOfStock(entry.getValue())) {
	            	int productQuantity = 0;
	            	//String productQuantity = String.valueOf(entry.getValue().size());
	            	String productType = entry.getValue().get(0).getType();
	            	String productName = entry.getValue().get(0).getName();
	            	String productPrice = "$" + entry.getValue().get(0).getPrice().toString();
	            	String multipleProductPrice = "$" + (entry.getValue().get(0).getPrice()).multiply(new BigDecimal(productQuantity)).toString();
 	 
	                System.out.println(String.format("%-5s%-19s%10s%10s%10s", productQuantity, productType, productName, productPrice,  multipleProductPrice ));
	            } else {
	                String productName = entry.getKey();
	                System.out.println(String.format("%-15s%7s", productName, "SOLD OUT")); //Prevents Array Out Of Bounds error
	            }
	        }
	        System.out.println("---------------------------------------------");
	    }

	    public Map<String, List<Product>> getProductsInTheMachine() {
	        return availableProduct;
	    }
	    
	    
	    

	    public void resetBalance() {
	        balance = new BigDecimal(0);
	    }


//	    public void loadInventory() {
//	       TransactionReport transactionReport = new TransactionReport(null);
//	       availableProduct =  transactionReport.;
//	    }

	    public void returnChange() {
	        if (balance.doubleValue() > 0) {  //Prevents message from displaying and logging if balance is 0
	            Change change = new Change();
	            BigDecimal changeGiven = getBalance();

	            System.out.println("\n" + change.makeChange(getBalance()));

	            resetBalance();
	            transactionReport.recordChange(changeGiven, getBalance());
	        }
	    }

	    public String formattedBalanceToCurrency() {
	        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
	        return numberFormat.format(balance.doubleValue());
	    }
	
	
	
}
