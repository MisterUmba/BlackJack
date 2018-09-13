package core;

import java.util.Collection;

import core.CardDeck.Card;

import java.util.ArrayList;

import junit.framework.TestCase;

public class CardDeckTest extends TestCase{

	// Test getDeck
	public void testGetDeck() {
		CardDeck deck = new CardDeck();

		// Make sure it returns something
		assertNotNull(deck.getDeck());

		// Make it turns an array (collections) type
		assertEquals(52, deck.getDeck().size());

		// Test if element type is CardDeck.Card
		assertEquals(CardDeck.Card.class, ((ArrayList<CardDeck.Card>) deck.getDeck()).get(0).getClass());
	}

	//Test shuffle
	public void testShuffle() {
		CardDeck deck = new CardDeck();

		Collection<Card> arr = deck.getDeck();
		deck.shuffle();

		String temp1 = "";
		String temp2 = "";

		for(CardDeck.Card e: deck.getDeck()) {
			temp1 += e.toString();
		}

		for(Object e:arr) {
			temp2 += e.toString();
		}

		assertEquals(false, temp1.compareTo(temp2)==0);
	}
	
	public void testGivePlayerCards() {
		CardDeck deck = new CardDeck();
		
		CardDeck.Card temp;
		
		temp =  deck.getDeck().get(0);
		
		deck.givePlayerCards(temp);
		
		assertEquals(temp, deck.getPlayer().get(0));
		
		assertEquals(51, deck.getDeck().size());
		
		assertEquals(1, deck.getPlayer().size());
	}
	
	public void testGiveDealerCards() {
		CardDeck deck = new CardDeck();
		
		CardDeck.Card temp;
		
		temp =  deck.getDeck().get(0);
		
		deck.giveDealerCards(temp);
		
		assertEquals(temp, deck.getDealer().get(0));
		
		assertEquals(51, deck.getDeck().size());
		
		assertEquals(1, deck.getDealer().size());
	}
	
	
	public void testReturnCardsToDeck() {
		CardDeck deck = new CardDeck();
		
		for(int x = 0; x< deck.getDeck().size()/2; x++) {
			deck.getPlayer().add(deck.getDeck().get(x));
		}
		
		for(int x = deck.getDeck().size()/2; x< deck.getDeck().size(); x++) {
			deck.getDealer().add(deck.getDeck().get(x));
		}
		
		deck.removeUsedCards();
		
		assertEquals(0, deck.getDeck().size());
		
		assertEquals(52, deck.getUsedCards().size());
		
		deck.returnCardsToDeck();
		
		assertEquals(52, deck.getDeck().size());
		
		assertEquals(0, deck.getUsedCards().size());

	}
	
	public void testRemoveUsedCards() {
		CardDeck deck = new CardDeck();
		
		deck.givePlayerCards(deck.getDeck().get(0));
		deck.givePlayerCards(deck.getDeck().get(1));
		
		deck.giveDealerCards(deck.getDeck().get(2));
		deck.giveDealerCards(deck.getDeck().get(3));
		
		deck.removeUsedCards();
		
		assertEquals(4, deck.getUsedCards().size());
	}


}