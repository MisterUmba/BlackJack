package core;

import java.util.ArrayList;
import java.util.Random;

import core.CardDeck.Card;

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
		if(!(player.isEmpty() && dealer.isEmpty())) {
			if(!player.isEmpty()) {
				for(Card e: player) 
					usedCards.add(e);
				player.clear();
			}
			
			if(!dealer.isEmpty()) {
				for(Card e: dealer) 
					usedCards.add(e);
				dealer.clear();
			}
		}
	}
	
	public void returnCardsToDeck() {
		for(int x = 0; x< usedCards.size(); x++)
			deck.add(usedCards.get(x));
		usedCards.clear();
		
	}
	
	// shuffle()
	public void shuffle() {
		
		ArrayList<Card> temp = new ArrayList<>();
		
		while(!deck.isEmpty()) {
			temp.add(deck.remove(rand.nextInt(deck.size())));
		}
		
		deck = temp;
				
	}
	
	
}
