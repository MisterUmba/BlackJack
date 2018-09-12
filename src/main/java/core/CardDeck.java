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
		rand = new Random();
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
	public <T> void shuffle() {
		
		ArrayList temp = new ArrayList();
		
		while(!deck.isEmpty()) {
			temp.add(deck.remove(rand.nextInt(deck.size())));
		}
		
		deck = temp;
				
	}
	
	
}
