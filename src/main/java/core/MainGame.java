package core;

import java.util.Scanner;

public class MainGame {
	private static CardDeck deck;
	private static GameCases gameCase;
	private static Scanner input;
	private static boolean isPlayerStand;

	public static void main(String args[]) {
		deck = new CardDeck();
		gameCase = new GameCases(deck);
		input = new Scanner(System.in);


		gameLoop();
	}

	public static void clearPrompt() {
		System.out.println("======================================");
	}

	public static String type() {
		System.out.println("Welcome to Black Jack! (by Henri M. Umba)");
		clearPrompt();

		System.out.println("Enter \"c\" for Console Or \"f\"for file");
		String temp;
		while(true) {
			temp = input.nextLine().toLowerCase();
			if(temp.equals("c") || 
					temp.equals("f"))
				break;
			else {
				System.out.println("*NOT A VALIED INPUT*");
				System.out.println("Enter \"c\" for Console Or \"f\" for file");
			}
		}

		clearPrompt();
		return temp;
	}

	public static void gameLoop() {
		// User chooses file or console
		String temp;
		do {
			temp = type();
			if(temp.equals("c")) {
				deck.shuffle();

				// Game while loop
				deck.givePlayerCards();
				deck.givePlayerCards();

				deck.giveDealerCards();
				deck.giveDealerCards();

				if(gameCase.playerBlackJack()) {
					isPlayerStand = true;
					endGame("playerBlackJack");
				}else if(gameCase.dealerBlackJack()) {
					isPlayerStand = true;
					endGame("dealerBlackJack");
				}else {

					showGame();
					while(true) {
						// Take input from file or User
						temp = userInput();

						// Apply rules of the game
						if(logic(temp)) break;

						// Show both player's their cards
						showGame();
					}
				}
			}else {
				// file type game loop
			}
			while(true) {
				System.out.println("Would you like another game? (y/n) ");
				temp = input.nextLine().toLowerCase();
				if(temp.equals("n") || temp.equals("y"))
					break;
				System.out.println("*NOT A VALIED INPUT*");
			}

			if(temp.equals("n"))
				break;
			else {
				deck.removeUsedCards();
			}

		}while(true);

	}

	private static boolean logic(String temp) {
		
		if(deck.getDeck().size()<10) {
			shuffleDeck();
		}
		
		if(temp.equals("h")) {
			deck.givePlayerCards();
			if(deck.getValueOfPlayerHand() > 21) {
				endGame("busted");
				return true;
			}
		}else if(temp.equals("s")) {
			isPlayerStand = true;
			dealerTurn();
			if(deck.getValueOfDealerHand()>21) {
				endGame("dealerbust");
			}
			endGame("");
			return true;
		}
		return false;
	}

	private static void shuffleDeck() {
		deck.returnCardsToDeck();
		deck.shuffle();
	}

	private static void endGame(String temp) {

		// Who has more points
		if(temp.equals("busted")) {
			showGame();
			System.out.println("YOU BUSTED");
		}else if(gameCase.playerHigherHand()) {
			showGame();
			System.out.println("YOU WON!");
		}else if(gameCase.dealerHigherHand()) {
			showGame();
			System.out.println("DEALER WON!! :( ");
		}else if(temp.equals("dealerbust")) {
			showGame();
			System.out.println("DEALER BUSTED!!!");
		}else if(temp.equals("playerBlackJack")) {
			showGame();
			System.out.println("B*L*A*C*K*J*A*C*K*");
		}else if(temp.equals("dealerBlackJack")) {
			showGame();
			System.out.println("DEALER 8LACKJACK");
		}
	}

	private static void dealerTurn() {
		while(true) 
			if(deck.getValueOfDealerHand() <= 16 || soft17()) 
				deck.giveDealerCards();
			else
				break;
	}

	private static boolean soft17() {
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

	private static void showGame() {
		int max;
		if(deck.getDealer().size() >= deck.getPlayer().size())
			max = deck.getDealer().size();
		else
			max = deck.getPlayer().size();

		System.out.println("PLAYER\t\t\tDEALER");
		if(isPlayerStand) {
			for(int x = 0; x< max ; x++) {
				if(deck.getPlayer().size() > x)
					System.out.print(deck.getPlayer().get(x));
				System.out.print("\t\t\t");
				if(deck.getDealer().size() > x)
					System.out.print(deck.getDealer().get(x));
				System.out.println();
			}
			System.out.println("Ponts: "+deck.getValueOfPlayerHand()+"\t\tPonts: "+deck.getValueOfDealerHand());
		}

		if(!isPlayerStand) {
			for(int x = 0; x< max ; x++) {
				if(deck.getPlayer().size() > x)
					System.out.print(deck.getPlayer().get(x));
				System.out.print("\t\t\t");
				if(deck.getDealer().size() > x && x < 1)
					System.out.print(deck.getDealer().get(x));
				else if(x == 1)
					System.out.print("**");
				else
					System.out.print("");
				System.out.println();
			}
			System.out.println("Ponts: "+deck.getValueOfPlayerHand()+"\t\tPonts: "+deck.getDealer().get(0).getValue(false));
		}

	}

	private static String userInput() {
		String temp;

		while(true) {
			System.out.println("Enter \"H\" to hit OR \"S\" to stand.");
			temp = input.nextLine().toLowerCase();
			if(temp.equals("s") || temp.equals("h"))
				break;
			System.out.println("*NOT A VALIED INPUT*");
		}

		clearPrompt();
		return temp;
	}
}
