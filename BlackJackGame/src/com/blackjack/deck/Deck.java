package com.blackjack.deck;

import java.util.ArrayList;
import java.util.Random;

import com.blackjack.card.Card;
import com.blackjack.suitValue.Suit;
import com.blackjack.suitValue.Value;



public class Deck {

	private ArrayList<Card> cards;

	public Deck() {
		super();
		this.cards = new ArrayList<Card>();
	}

	public void createFullDake() {

		for (Suit suit : Suit.values()) {
			for (Value value : Value.values()) {

				cards.add(new Card(suit, value));
			}
		}
	}

	public void shuffle() {

		ArrayList<Card> tempDeck = new ArrayList<Card>();

		Random random = new Random();

		int randomCardIndex = 0;
		int originalSize = this.cards.size();

		// useful in generate random index
		for (int i = 0; i < originalSize; i++) {

			randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
			tempDeck.add(this.cards.get(randomCardIndex));
			// remove from original desk

			this.cards.remove(randomCardIndex);

		}

		this.cards = tempDeck;
	}

	
	
	public String toString() {
		String cardListOutPut = "";
		int i = 0;

		for (Card card : cards) {
			cardListOutPut += "\n" + "-" + card.toString();
		}
		return cardListOutPut;
	}

	
	public void moveAllToDeck(Deck moveTo) {
		
		int thisDeckSize= this.cards.size();
		
		for (int i = 0; i < thisDeckSize; i++) {
			moveTo.addCard(this.getCard(i));
		}
		
		for (int i = 0; i < thisDeckSize; i++) {
			this.removeCard(0);
		}
		
	}
	
	public void removeCard(int i) {
		this.cards.remove(i);
	}

	public Card getCard(int i) {
		return this.cards.get(i);
	}

	public void addCard(Card addCard) {
		this.cards.add(addCard);
	}

	public void draw(Deck commingFrom) {
		this.cards.add(commingFrom.getCard(0));
		commingFrom.removeCard(0);

	}

	public int deckSize() {
		return this.cards.size();
	}
	
	// value of the card
	public int cardValue() {

		int totalVaue = 0;
		int aces = 0;

		for (Card card : this.cards) {

			switch (card.getValue()) {
			case TWO:
				totalVaue += 2;
				break;

			case THREE:
				totalVaue += 3;
				break;

			case FOUR:
				totalVaue += 4;
				break;

			case FIVE:
				totalVaue += 5;
				break;

			case SIX:
				totalVaue += 6;
				break;

			case SEVEN:
				totalVaue += 7;
				break;

			case EIGHT:
				totalVaue += 8;
				break;
			case NINE:
				totalVaue += 9;
				break;
			case TEN:
				totalVaue += 10;
				break;
			case JACK:
				totalVaue += 10;
				break;

			case KING:
				totalVaue += 10;
				break;

			case QUEEN:
				totalVaue += 10;
				break;

			case ACE:
				aces += 1;
				break;
			}

		}

		for (int i = 0; i < aces ; i++) {
			
			if (totalVaue > 10) {
				totalVaue += 1;
			}else {
				totalVaue += 11;
			}
		}
		return totalVaue;
	}
}
