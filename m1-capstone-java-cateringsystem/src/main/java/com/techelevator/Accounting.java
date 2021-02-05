package com.techelevator;

public class Accounting {
	
	private int totalInCents;
	private int totalInDollars;
	
	public Accounting(int totalInDollars, int totalInCents) {
		this.totalInDollars = totalInDollars;
		this.totalInCents = totalInCents;
	}

	public int getTotalInCents() {
		return totalInCents;
	}
	
	public int getTotalInDollars() {
		return totalInDollars;
	}
	
	public int getCents() {
		return (int) (totalInCents % 100);
	}
	
	

	
//	public Accounting subtract(Accounting amountToSubtract) {
//		return new Accounting(this.totalInCents - amountToSubtract.totalInCents);
//	}
	
	
	public void returnChange(){
		int totalCents = this.getTotalInCents();
		int totalNickels = 0;
		int totalDimes = 0;
		int totalQuarters = 0;
		while (totalCents > 0){
			if (totalCents >= 25){
				totalQuarters ++;
				totalCents -= 25;
			} else if (totalCents >= 10){
				totalDimes++;
				totalCents -= 10;
			} else if (totalCents >= 5){
				totalNickels++;
				totalCents -= 5;
			}
		}
	
	}
	
	public void returnDollar(){
		int totalDollars = this.getTotalInDollars();
		int totalOnes = 0;
		int totalFives = 0;
		int totalTens = 0;
		int totalTwenties = 0;
		while (totalDollars > 0){
			if (totalDollars >= 20){
				totalTwenties ++;
				totalDollars -= 20;
			} else if (totalDollars >= 10){
				totalTens++;
				totalDollars -= 10;
			} else if (totalDollars >= 5){
				totalFives++;
				totalDollars -= 5;
			} else if (totalDollars >= 1){
				totalOnes++;
				totalDollars -= 1;
			}
		}
	
	}
	
	public boolean isValidDollar(String dollarToCheck) {
		return dollarToCheck.equals("1") || dollarToCheck.equals("3") || dollarToCheck.equals("5")
				|| dollarToCheck.equals("10") || dollarToCheck.equals("20") || dollarToCheck.equals("100");
	}
	

}
