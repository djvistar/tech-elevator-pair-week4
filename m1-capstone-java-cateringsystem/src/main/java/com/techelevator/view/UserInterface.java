package com.techelevator.view;

import java.util.List;
import java.util.Scanner;

import com.techelevator.Product;


public class UserInterface{

    // kind of looks like a menu class if you ask me ;-)
	
	private Scanner scanner;

	public  UserInterface() {
		scanner = new Scanner(System.in);
	}
	
	
	/**
	 * This method prints the main menu to the console
	 * 
	 * @return user choice
	 */
	
	
	public String printMainMenu() {

		System.out.println("***************************");
		System.out.println("VicJoe Catering Service");
		System.out.println("***************************\n");

		System.out.println("(1) Display Catering Items");
		System.out.println("(2) Order");
		System.out.println("(3) Quit\n");

		System.out.println("Please select your choice (number only)");

		return scanner.nextLine();

	}
	
	
	/**
	 * This method prints out the sub-menu (Option 3 from main menu)
	 * @return user choice
	 */
	public String purchasingProcessMenu() {

		System.out.println("***************************");
		System.out.println(" VicJoe Catering Menu ");
		System.out.println("***************************\n");

		System.out.println("(1) Add Money");
		System.out.println("(2) Select Products");
		System.out.println("​(3) Complete Transaction");
		//TO DO print balance
		System.out.println("Please select your choice (number only)");

		return scanner.nextLine();

	}
	
	
	
	  /**
     * This method prints out a list of products 
     * @param List<Home> homesToPrint - An ArrayList containing our list of homes 
    */
	public void printListOfProducts(List<Product> productToPrint) {

		
		System.out.println("\n*********** Listing Results ************\n");
		
		
		if (productToPrint.isEmpty()) {
			System.out.println("No Results Found!");
			return;
		}

		for (Product products : productToPrint) {
			
			printListOfProducts(products);

		}

	}
	
	
	
	
	
	
}
