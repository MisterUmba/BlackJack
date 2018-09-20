package core;

import junit.framework.TestCase;

public class MainGameTest extends TestCase{
	// Test UserInput
	public void testUserInput() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
		
		assertNotNull(mainGame);
	}
	
	
	// Test Dealer Algorithm
	public void testDealerAlgorithm() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
	}
	
	// Player Hits
	public void testPlayerHit() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
		
		int hit = deck.getPlayer().size();
		deck.givePlayerCards();
		
		assertEquals(hit+1, deck.getPlayer().size());
	}
	
	// Test Player Stand
	public void PlayerStand() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
	}
	
	// Dealer Hits
	public void testDealerHit() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
		
		int hit = deck.getDealer().size();
		deck.giveDealerCards();
		
		assertEquals(hit+1, deck.getDealer().size());
	}
	
	// Dealer Stand
	public void testDealerStand() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
	}
	
}
