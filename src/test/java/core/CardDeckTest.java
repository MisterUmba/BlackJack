package core;


import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Collection;

import junit.framework.TestCase;

public class CardDeckTest extends TestCase{
	
	// Test getDeck
	public void TestgetDeck() {
		CardDeck deck = new CardDeck();
		
		// Make sure it returns something
		assertNotNull(deck.getDeck());
		
		// Make it turns an array (collections) type
		assertEquals(Collection.class, deck.getDeck().getClass());
		
		// Test if element type is CardDeck.Card
		assertEquals(CardDeck.Card.class, deck.getDeck().get(0).getClass());
	}
	
	//Test shuffle
	public void TestShuffle() {
		CardDeck deck = new CardDeck();
		
		Collection arr = deck.getDeck();
		deck.shuffle();
		
		String temp1 = "";
		String temp2 = "";
		
		for(CardDeck.Card e: deck.getDeck()) {
			temp1 += e.toString();
		}
		
		for(CardDeck.Card e: arr) {
			temp2 += e.toString();
		}
		
	    assertNotEquals(false, temp1.compareTo(temp2)==0);
	}
	
	
}
