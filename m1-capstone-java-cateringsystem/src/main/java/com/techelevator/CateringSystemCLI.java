package com.techelevator;

import com.techelevator.view.UserInterface;

public class CateringSystemCLI {

	private UserInterface ui;

	public CateringSystemCLI(UserInterface ui) {
		this.ui = ui;
	}
	
	public static void main(String[] args) {
		UserInterface menu = new UserInterface();
		CateringSystemCLI cli = new CateringSystemCLI(menu);
		cli.run();
	}	

	
	
	public void run() {
		//probably should do stuff here... ;-)

	}
	
	



}
