package com.techelevator.change;

import java.math.BigDecimal;
import java.util.HashMap;

public class Change {
	
	
	   private  Coins[] coin = new Coins[]{
	            new Quarters(), new Dimes(), new Nickels()};
	   
	   
	   
	   public String makeChange(BigDecimal money) {
	        StringBuilder coinReturnString = new StringBuilder();
	        int amount = (int) (money.doubleValue() * 100);
	      HashMap<Coins, Integer> change = new HashMap<>();
	      
	      
	      for (Coins coins : coin) {
	            if (amount <= 0) {
	                break;
	            }
	            
	            int cents = amount / coins.getCoinValue();
	            if (cents > 0) {
	                amount = amount % (coins.getCoinValue() * cents);
	                change.put(coins, cents);
	            }
	        }

	      for (Coins coins : change.keySet()) {
	           // String isPlural = (change.get(coin) > 1) ? "s " : " ";
	            coinReturnString.append(change.get(coin)).append(" ").append(coins.getCoinName());

	      }
	        coinReturnString.append("returned.");
	        return coinReturnString.toString().trim();
   }
}