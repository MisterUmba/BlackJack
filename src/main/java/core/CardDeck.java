package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class CardDeck {
	
	// Defining a Card
	public class Card{
		String rank;
		char suit;
		
		public Card(String rank, char suit) {
			this.rank = rank;
			this.suit = suit;
		}
		
		public String toString() {
			return suit+rank;
		}
	}
	
	// Attributes / properties
	private ArrayList<Card> deck;
	private Random rand;

	// Constructors
	public CardDeck() {
		deck = new ArrayList<>();
		
		// initialize 
		char [] suits = {'H','C','D','S'};
		String [] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(String r: ranks)
			for(char s: suits) {
				deck.add(new Card(r, s));
			}
	}
	
	// getDeck()
	public Collection<Card> getDeck(){
		return deck;
	}
	
	// shuffle()
	public void shuffle() {
		shuffle(deck.toArray());
	}
	
	private <T> T[] shuffle(T[] subDeck) {
		if(subDeck.length == 1)
			return subDeck;
		
		T[] right = Arrays.copyOfRange(subDeck, 0, subDeck.length/2);
		T[] left = Arrays.copyOfRange(subDeck, subDeck.length/2, subDeck.length);
		
		shuffle(right);
		shuffle(left);
		
		
		
	}
	
	
}
