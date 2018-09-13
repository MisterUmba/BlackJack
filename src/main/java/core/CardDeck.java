package core;

import java.util.ArrayList;
import java.util.Comparator;
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
		
		public int getValue(boolean isAceOne) {
			String temp = this.toString();
			
			switch (temp) {
			case "HA":
				if(isAceOne)
					return 1;
				return 11;
			case "CA":
				if(isAceOne)
					return 1;
				return 11;
			case "DA":
				if(isAceOne)
					return 1;
				return 11;
			case "SA":
				if(isAceOne)
					return 1;
				return 11;
			case "H2":
				return 2;
			case "C2":
				return 2;
			case "D2":
				return 2;
			case "S2":
				return 2;
			case "H3":
				return 3;
			case "C3":
				return 3;
			case "D3":
				return 3;
			case "S3":
				return 3;
			case "H4":
				return 4;
			case "C4":
				return 4;
			case "D4":
				return 4;
			case "S4":
				return 4;
			case "H5":
				return 5;
			case "C5":
				return 5;
			case "D5":
				return 5;
			case "S5":
				return 5;
			case "H6":
				return 6;
			case "C6":
				return 6;
			case "D6":
				return 6;
			case "S6":
				return 6;
			case "H7":
				return 7;
			case "C7":
				return 7;
			case "D7":
				return 7;
			case "S7":
				return 7;
			case "H8":
				return 8;
			case "C8":
				return 8;
			case "D8":
				return 8;
			case "S8":
				return 8;
			case "H9":
				return 9;
			case "C9":
				return 9;
			case "D9":
				return 9;
			case "S9":
				return 9;
			case "H10":
				return 10;
			case "C10":
				return 10;
			case "D10":
				return 10;
			case "S10":
				return 10;
			case "HJ":
				return 10;
			case "CJ":
				return 10;
			case "DJ":
				return 10;
			case "SJ":
				return 10;
			case "HQ":
				return 10;
			case "CQ":
				return 10;
			case "DQ":
				return 10;
			case "SQ":
				return 10;
			case "HK":
				return 10;
			case "CK":
				return 10;
			case "DK":
				return 10;
			case "SK":
				return 10;
			}
			
			return -1;
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
