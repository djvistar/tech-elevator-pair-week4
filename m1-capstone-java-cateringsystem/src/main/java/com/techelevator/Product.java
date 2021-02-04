package com.techelevator;



public class Product {

	
	
	
	private String slot;
	private String productName;
	private double price;
	private String type;
	private int quantity =50;
	
	//constructor
	public Product( String slot, String productName , double price, String type, int quantity) {
		this.slot = slot;
		this.productName = productName;
		this.price = price;
		this.type = type;
		this.quantity = quantity;
	}
	
	
	
	





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
