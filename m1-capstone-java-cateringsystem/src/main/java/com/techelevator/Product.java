package com.techelevator;



public class Product {

	
	
	
	private String slot;
	private String productName;
	private double price;
	private String type;
	private int quantity =50;
	
	//constructor
	public Product( String slot, String productName , double price, String type) {
		this.slot = slot;
		this.productName = productName;
		this.price = price;
		this.type = type;
	}
	
	public int Quantity(int quantity) {
		this.quantity = quantity;
		return quantity;
	}
	
	//methods
	//keeping track of product being taken out
	public void quantityDecrease() {
		quantity --;
	}
	
//	
//	public String soldOut() {
//		if (quantity == 0) {
//			return "SOLD OUT";
//		} else {
//			return Integer.toString(quantity);
//		}
//	}
	
	//make a formatted string that has slot number, item name, price, type, and quantity (?)
//	public String toString() {
//		String productLog = String.format(slot, productName, price, type, soldOut());
//	}





	//getters and setters
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getSlot() {
		return slot;
	}
	public void setSlot(String slot) {
		this.slot = slot;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
		
	
	
}
