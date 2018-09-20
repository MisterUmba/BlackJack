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
	
	public boolean soft17() {
		CardDeck.Card temp = null;

		if(deck.dealerContainAce() && deck.getValueOfDealerHand() == 17) {
			for(CardDeck.Card e: deck.getDealer())
				if(e.toString().contains("A"))
					temp = e;
			deck.getDealer().remove(temp);
			if(deck.getValueOfDealerHand() == 6) {
				deck.getDealer().add(temp);
				return true;
			}
			deck.getDealer().add(temp);
			return false;
		}
		return false;
	}
	
	public boolean playerBust() {
		return (deck.getValueOfPlayerHand()>21);
	}
	
	public boolean dealerBust() {
		return deck.getValueOfDealerHand() > 21;
	}
}
