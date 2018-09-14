package core;

public class GameCases {
	CardDeck deck;
	
	public GameCases(CardDeck deck) {
		this.deck = deck;
	}
	
	public boolean playerBlackJack() {
		// Player has a black Jack and Dealer Doesn't
		if(deck.getPlayer().size() == 2 &&
				deck.playerContainAce() && deck.playerHasTens() &&
				!dealerBlackJack())
			return true;
		return false;
	}
	
	public boolean dealerBlackJack() {
		// Dealer has a Black Jack
		if(deck.getDealer().size() == 2 && deck.dealerContainAce() &&
				deck.dealerHasTens())
			return true;
		return false;
	}
	
	public boolean playerHigherHand() {
		int playerSum = deck.getValueOfPlayerHand();
		int dealerSum = deck.getValueOfDealerHand();
		
		if(playerSum > dealerSum && playerSum < 22)
			return true;
		return false;
	}
	
	public boolean dealerHigherHand() {
		int playerSum = deck.getValueOfPlayerHand();
		int dealerSum = deck.getValueOfDealerHand();
		
		if(dealerSum >= playerSum && dealerSum < 22)
			return true;
		return false;
	}
}
