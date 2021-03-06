package com.techelevator;

import java.util.List;

import com.techelevator.product.Product;
import com.techelevator.shoppingCart.Inventory1;
import com.techelevator.shoppingCart.TransactionReport;
import com.techelevator.view.UserInterface;

public class CateringSystemCLI {
//
//	private UserInterface ui;
//
//	public CateringSystemCLI(UserInterface ui) {
//		this.ui = ui;
//	}
//	
//	public static void main(String[] args) {
//		UserInterface menu = new UserInterface();
//		CateringSystemCLI cli = new CateringSystemCLI(menu);
//		cli.run();
//	}	
	private static final String DISPLAY_CATERING_ITEMS = "1";
	private static final String ORDER = "2";
	private static final String QUIT = "3";
	
	//private Menu menu = new Menu();
	
	private UserInterface menu = new UserInterface();
	
	public static void main(String[] args) {
		
		CateringSystemCLI app = new CateringSystemCLI();
		app.run();
	}
	
	public void run() {
	
		//probably should do stuff here... ;-)

		
		
		Inventory1 productInventory = new Inventory1();
    	TransactionReport report = new TransactionReport("receipt.txt");
    	
    	//this is a boolean value to keep the program running unless user enters exit.
    	boolean running = true;
    	
        while (running) {
        	
        	
        	String choice = menu.printMainMenu();   //this method calls the menu class to print menu and get response

    		if (choice.equals(DISPLAY_CATERING_ITEMS)) {
    			
    			//call the inventory class
    			List<Product> products = productInventory.listOfProducts();
    			
    			//send list to menu class to print
    			menu.printListOfProducts(products);
    			
    		}
    		else if (choice.equals(ORDER)) {
      		
    		    //Agent Management
  			
    			handleSubMenu();
   			
    		}
    		else if (choice.equals(QUIT)){
    			running = false;  // this allows us to exit the loop
    		}
    		else {
    			System.out.println("Nice try but not a valid options!");
    		}    		

        }  // end of main while loop
    //close the report file
       report.closeFile();
       
		//exit the program
		System.out.println("Exiting the program.... Goodbye!");
    	
    	
    }
		
	private static final String ADD_MONEY = "1";
	private static final String SELECT_PRODUCTS = "2";
	private static final String COMPLETE_TRANSACTION = "3";
	
	private void handleSubMenu() {
    	
		
		boolean isLooping = true;
		
    	while (isLooping) {
    				
    		String subMenuChoice = menu.purchasingProcessMenu();
    			//This links to account class to check balance	
    		if (subMenuChoice.equals(ADD_MONEY)) {
    			
    				System.out.println("You chose ADD MONEY");	
    		}
    		else if (subMenuChoice.equals(SELECT_PRODUCTS)) {
    			System.out.println("You chose SELECT PRODUCTS");	
    		}
    		else if (subMenuChoice.equals(COMPLETE_TRANSACTION)){
    			System.out.println("Returning to previous menu");
    			isLooping = false;
    			
    		}
    		else {
    			System.out.println("TRY AGAIN!!");	
    		}
    				
    } 	
    	
	} 	//sends us back to main menu
	

		
}
	
	




