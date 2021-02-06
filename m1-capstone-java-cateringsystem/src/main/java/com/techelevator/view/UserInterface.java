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
			
			printProducts(products);

		}

	}
	
	/**
	 * This method prints out the product.  We 'could' have put this up in the for each loop above, but breaking
	 * it out on it's own keeps the code above cleaner AND we can also reuse when printing out from menu option 2 
	 */
	public void printProducts(Product product) {
		
		System.out.println("Slot Number: " + product.getSlot());
		System.out.println("Product Name: " + product.getProductName());
		System.out.println("Product Price: " + product.getPrice());
		System.out.println("Product Type: " + product.getType());
		
		System.out.println("\n*********** *** *** ***  ************\n");

//		if (home.getAddress() != null) {
//			System.out.println("Street Address: " + home.getAddress().getStreetNumber() + " "
//					+ home.getAddress().getStreetName() + " " + home.getAddress().getCity() + " "
//					+ home.getAddress().getState() + " " + home.getAddress().getZipCode() + "\n");
//		}
//		
//		System.out.println(String.format("%-25s %s", "Bedrooms: ", home.getNumberOfBedrooms()));
//		System.out.println(String.format("%-25s %s", "Bathrooms: ", home.getNumberOfBathrooms()));
//		System.out.println(String.format("%-25s %s", "Description: ", home.getShortDescription()));
//		System.out.println(String.format("%-25s $%s", "Price: ", String.format("%.2f", home.getPrice())));
		
				
		
	}
	
	
	
	
	
}
