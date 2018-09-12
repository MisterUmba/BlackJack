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


}