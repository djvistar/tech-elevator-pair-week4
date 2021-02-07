package com.techelevator.product;

import java.math.BigDecimal;

public abstract class Product {

	private String name;
	private  BigDecimal price;
	private String type;
	
	//constrcutor
	
    public Product(String name, BigDecimal price, String type) {
        this.name = name;
        this.price = price;
        this.type = type;
    }
	
	
	//getters
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public BigDecimal getPrice() {
		return price;
	}
	
	
	
	
}
