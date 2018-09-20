package core;


import junit.framework.TestCase;

public class GameCasesTest extends TestCase{
	// Check if Player won
	
		// Player black-Jack
	public void testPlayerBlackJack() {
		CardDeck temp = new CardDeck();
		GameCases gameCase = new GameCases(temp);
		
		temp.getPlayer().add(temp.getDeck().get(0));
		temp.getPlayer().add(temp.getDeck().get(51));
		
		assertEquals(true, gameCase.playerBlackJack());
	}
	
		// Player higher Hand
	public void testPlayerHigherHand() {
		CardDeck temp = new CardDeck();
		GameCases gameCase = new GameCases(temp);
		
		temp.getPlayer().add(temp.getDeck().get(51));
		temp.getPlayer().add(temp.getDeck().get(50));
		
		temp.getDealer().add(temp.getDeck().get(4));
		temp.getDealer().add(temp.getDeck().get(5));
		
		assertEquals(true, gameCase.playerHigherHand());
	}
	
	
	
	// Check if Dealer Won
	
		// Dealer black-Jack
	public void testDealerBlackJack() {
		CardDeck temp = new CardDeck();
		GameCases gameCase = new GameCases(temp);
		
		temp.getDealer().add(temp.getDeck().get(0));
		temp.getDealer().add(temp.getDeck().get(51));
		
		assertEquals(true, gameCase.dealerBlackJack());
	}
	
		// Dealer higher Hand
	public void testDealerHigherHand() {
		CardDeck temp = new CardDeck();
		GameCases gameCase = new GameCases(temp);
		
		temp.getPlayer().add(temp.getDeck().get(4));
		temp.getPlayer().add(temp.getDeck().get(5));
		
		temp.getDealer().add(temp.getDeck().get(51));
		temp.getDealer().add(temp.getDeck().get(50));
		
		assertEquals(true, gameCase.dealerHigherHand());
	}
	
	public void testPlayerBust() {
		CardDeck deck = new CardDeck();
		GameCases gameCase = new GameCases(deck);
		
		deck.getPlayer().add(deck.getDeck().get(51));
		deck.getPlayer().add(deck.getDeck().get(50));
		deck.getPlayer().add(deck.getDeck().get(49));
		
		assertEquals(true, gameCase.playerBust());
	}

	public void testDealerBust() {
		CardDeck deck = new CardDeck();
		GameCases gameCase = new GameCases(deck);
		
		deck.getDealer().add(deck.getDeck().get(51));
		deck.getDealer().add(deck.getDeck().get(50));
		deck.getDealer().add(deck.getDeck().get(49));
		
		assertEquals(true, gameCase.dealerBust());
	}
	
	public void testSoft17() {
		CardDeck deck = new CardDeck();
		GameCases gameCase = new GameCases(deck);
		
		deck.getDealer().add(deck.getDeck().get(0));
		deck.getDealer().add(deck.getDeck().get(24));
		
		assertEquals(true, gameCase.soft17());
	}

}
