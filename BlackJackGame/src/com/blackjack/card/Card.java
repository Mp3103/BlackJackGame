package com.blackjack.card;

import com.blackjack.suitValue.Suit;
import com.blackjack.suitValue.Value;

public class Card {

	private Suit suit;
	private Value value;

	public Card(Suit suit, Value value) {
		super();
		this.suit = suit;
		this.value = value;
	}

	@Override
	public String toString() {
		return ""+ suit + "- value=" + value +"";
	}

	public Value getValue() {
		return value;
	}
	

}
