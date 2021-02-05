package com.techelevator;

public class Accounting {
	
	private double totalInCents;
	private double totalInDollars;
	
	public Accounting(double totalInDollars, double totalInCents) {
		this.totalInDollars = totalInDollars;
		this.totalInCents = totalInCents;
	}

	public double getTotalInCents() {
		return totalInCents;
	}
	
	public double getTotalInDollars() {
		return totalInDollars;
	}
	
	public double getCents() {
		return  (totalInCents % 100);
	}
	
	

	
//	public Accounting subtract(Accounting amountToSubtract) {
//		return new Accounting(this.totalInCents - amountToSubtract.totalInCents);
//	}
	
	
	public void returnCents(){
		double totalCents = this.getTotalInCents();
		double totalNickels = 0;
		double totalDimes = 0;
		double totalQuarters = 0;
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
		double totalDollars = this.getTotalInDollars();
		double totalOnes = 0;
		double totalFives = 0;
		double totalTens = 0;
		double totalTwenties = 0;
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
	
	public double makeChange() {
		double change =0;
		if (totalInDollars <1) {
			change = totalInCents;
		}
		return change;
	}
	
	public boolean isValidDollar(String dollarToCheck) {
		return dollarToCheck.equals("1") || dollarToCheck.equals("3") || dollarToCheck.equals("5")
				|| dollarToCheck.equals("10") || dollarToCheck.equals("20") || dollarToCheck.equals("100");
	}
	

}
