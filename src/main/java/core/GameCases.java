package core;

public class GameCases {
	CardDeck deck;
	
	public GameCases(CardDeck deck) {
		this.deck = deck;
	}
	
	public boolean playerBlackJack() {
		// Player has a black Jack and Dealer Doesn't
		return false;
	}
	
	public boolean dealerBlackJack() {
		
		return false;
	}
	
	public boolean playerHigherHand() {
		
		return false;
	}
	
	public boolean dealerHigherHand() {
		
		return false;
	}
}
