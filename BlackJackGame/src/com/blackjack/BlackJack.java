package com.blackjack;

import java.util.Scanner;

import com.blackjack.deck.Deck;

public class BlackJack {

	public static void main(String[] args) {
		
		Deck playingDeck = new Deck();
		playingDeck.createFullDake();
		
		playingDeck.shuffle();
		
		Deck playerDeck = new Deck();
		Deck delarDeck = new Deck();
		
		double playerMOney = 100.00;
		
		Scanner userInput = new Scanner(System.in);
		
		
		//Game Loop
		while (playerMOney > 0) {
			
			System.out.println("You have "+playerMOney+"$ , How much would like to bet ?");
			double playerBet = userInput.nextDouble();
			if (playerBet>playerMOney) {
				System.out.println("You don't have enough money");
				break;
			}
			
			boolean endRound = false;
			//Player Get Two Card
			playerDeck.draw(playingDeck);
			playerDeck.draw(playingDeck);

			//Dealer Two Card
			
			delarDeck.draw(playingDeck);
			delarDeck.draw(playingDeck);
			
			
			while (true) {
				
				System.out.println("Your Hand:");
				System.out.println(playerDeck.toString());
				
				System.out.println("Your deck value : "+ playerDeck.cardValue());
				
				// Dealer hand
				System.out.println("Dealer hand:"+ delarDeck.getCard(0).toString() + "[Hidden]");
				
				// What player want to do ?
				System.out.println("Would you like to (1)Hit or (2)Stand ?");
				
				int response = userInput.nextInt();
				if (response == 1) {
						playerDeck.draw(playingDeck);
						System.out.println("You draw a: " + playerDeck.getCard(playerDeck.deckSize()-1));
						
					//bust or not 
					if(playerDeck.cardValue()>21) {
						System.out.println("Your Current value :" + playerDeck.cardValue());
						playerMOney -= playerBet;
						endRound = true;
						break;
					}
						
					
				}
				if(response == 2) {
					break;
				}
				
			}
			
			System.out.println("Dealer Cars:"+delarDeck.toString());
			
			if ((delarDeck.cardValue()> playerDeck.cardValue())&& endRound == false) {
				
				System.out.println("Dealer beats you!");
				playerMOney -= playerBet;
				
				endRound = true;
				
			}
			
			//dealer draws at 16 && stand at 17
			
			while ((delarDeck.cardValue() < 17) && endRound == false) {
				delarDeck.draw(playerDeck);
				System.out.println("Dealer Draws:" + delarDeck.getCard(delarDeck.deckSize()-1).toString());
			}
			
			//display total value for dealer
			
			System.out.println("Dealr's hand is valued at:" + delarDeck.cardValue());
			// determine if dealer busted
			if((delarDeck.cardValue()>21) && endRound == false){
				System.out.println("Dealer busted !  you win");
				
				playerMOney += playerBet;
				endRound = true; 
			}
			
			// determine if push
			if((playerDeck.cardValue() == delarDeck.cardValue()) && endRound == false) {
				System.out.println("Push");
				endRound = true; 
			}
			
			
			if ((playerDeck.cardValue() > delarDeck.cardValue()) && endRound== false) {
				
				System.out.println("You win the hand!");
				playerMOney += playerBet;
				endRound = true;
				
			}else if(endRound == false){
				System.out.println("You Lose the Hand");
				playerMOney -= playerBet;
				endRound = false;
			}
				
			playerDeck.moveAllToDeck(playerDeck);
			delarDeck.moveAllToDeck(playerDeck);
			System.out.println("End OF Hand");
		}
		
		System.out.println("You Don't have enough money !!");
	}
	
}
