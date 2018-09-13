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
	private ArrayList<Card> player;
	private ArrayList<Card> dealer;
	private ArrayList<Card> usedCards;

	// Constructors
	public CardDeck() {
		rand = new Random();
		deck = new ArrayList<>();
		player = new ArrayList<>();
		dealer = new ArrayList<>();
		usedCards = new ArrayList<>();
		
		// initialize 
		char [] suits = {'H','C','D','S'};
		String [] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
		for(String r: ranks)
			for(char s: suits) {
				deck.add(new Card(r, s));
			}
	}
	
	public ArrayList<Card> getPlayer(){return player;}
	
	public ArrayList<Card> getDealer(){return dealer;}
	
	public ArrayList<Card> getUsedCards(){return usedCards;}
	
	public ArrayList<Card> getDeck(){return deck;}
	
	
	
	public void givePlayerCards(Card e) { player.add(deck.remove(0));}
	
	public void giveDealerCards(Card e) {dealer.add(deck.remove(0));}
	
	
	public void removeUsedCards() {
		for(int x = 0; x< player.size(); x++) {
			usedCards.add(player.remove(x));
		}
		
		for(int x = 0; x< dealer.size();x++) {
			usedCards.add(dealer.remove(x));
		}
	}
	
	public void returnCardsToDeck() {
		for(int x = 0; x< usedCards.size(); x++) {
			deck.add(usedCards.remove(x));
		}
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
