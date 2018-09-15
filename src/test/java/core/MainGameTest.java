package core;

import junit.framework.TestCase;

public class MainGameTest extends TestCase{
	// Test UserInput
	public void testUserInput() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
	}
	
	// Test FileInput
	public void testFileInput() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();	
		
		mainGame.fileInput("C:\\Users\\Henri\\eclipse-workspace"
				+ "\\BlackJack\\src\\main\\resources\\core\\Input Files\\File1.txt");
		assertEquals(true, mainGame.deck.dealerWin());
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
		
		int hit = mainGame.deck.getPlayer().size();
		
		assertEquals(hit+1, mainGame.deck.getPlayer().size());
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
		
		int hit = mainGame.deck.getDealer().size();
		
		assertEquals(hit+1, mainGame.deck.getDealer().size());
	}
	
	// Dealer Stand
	public void testDealerStand() {
		CardDeck deck = new CardDeck();
		GameCases gameCases = new GameCases(deck);
		MainGame mainGame = new MainGame();
	}
	
}
