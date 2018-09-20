package core;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import core.CardDeck.Card;

public class MainGame {
	private static CardDeck deck;
	private static GameCases gameCase;
	private static Scanner input;
	private static boolean isPlayerStand;
	private static ArrayList<String> moves;

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
		System.out.println("Welcome to Black Jack! (by Henri M. Umba) *No Split Support*");
		clearPrompt();

		System.out.println("Enter \"c\" for Console Or \"f\" for file");
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
			}else if(temp.equals("f")){
				moves = fileInput();
				
				if(initialMoves(moves)) {
					deck.removeUsedCards();
					shuffleDeck();
				}else if(gameCase.playerBlackJack()) {
					isPlayerStand = true;
					endGame("playerBlackJack");
					deck.removeUsedCards();
					shuffleDeck();
				}else if(gameCase.dealerBlackJack()) {
					isPlayerStand = true;
					endGame("dealerBlackJack");
					deck.removeUsedCards();
					shuffleDeck();
				}else {
					// file game loop
					while(!moves.isEmpty()) {
						temp = moves.remove(0);
						
						if(fileLogic(temp))break;
						
						showGame();
					}
					deck.removeUsedCards();
					shuffleDeck();
				}
				
				
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

	private static boolean fileLogic(String temp) {
		if(temp.equals("H")) {
			deck.getPlayer().add(convertToCard(moves.remove(0)));
			if(deck.getValueOfPlayerHand() > 21) {
				endGame("busted");
				return true;
			}
		}else if(temp.equals("S")) {
			isPlayerStand = true;
			while(!moves.isEmpty()) {
				String temp1 = moves.remove(0);
				if(temp1.equals("D")) {
					System.out.println("*Game doesn't Support Splitting*");
					return true;
				}
				deck.getDealer().add(convertToCard(temp1));
			}
				
			if(deck.getValueOfDealerHand() > 21) {
				endGame("dealerbust");
				return true;
			}
			endGame("");
			return true;
		}else if(temp.equals("D")) {
			System.out.println("*Game doesn't Support Splitting*");
			return true;
		}
		return false;
	}

	private static boolean initialMoves(ArrayList<String> moves) {
		String temp;
		Card card = null;
		try {
			for(int x = 0; x<2; x++) {
				temp = moves.remove(0);
				card = convertToCard(temp);
				if(card == null) {
					endGame("Card "+temp+" is already used");
					return true;
				}
				deck.getPlayer().add(card);
			}
			for(int x = 0; x<2; x++) {
				temp = moves.remove(0);
				card = convertToCard(temp);
				if(card == null) {
					endGame("Card "+temp+" is already used");
					return true;
				}
				deck.getDealer().add(card);
			}
		}catch(ArrayIndexOutOfBoundsException e) {
			endGame("Don't have enough Cards for a game");
			return true;
		}
		return false;
	}

	private static ArrayList<String> fileInput() {
		String temp;
		BufferedReader read;
		File file;
		boolean flag = false;
		ArrayList<String> arr = null;
		
		while(true) {
			System.out.println("Enter the file location. \n"
					+ "(ex: C:\\Users\\Henri\\Downloads\\File1.txt):");
			temp = input.nextLine();
			file = new File(temp);
			
			try {
				flag = true;
				read = new BufferedReader(new FileReader(file));
				arr = fileToArray(read);
				read.close();
			} catch (FileNotFoundException e) {
				flag = false;
				System.out.println("*Wrong location Or file don't exist*\n");
				System.out.println("Enter the file location. \n"
						+ "(ex: C:\\Users\\Henri\\Downloads\\File1.txt):");
				temp = input.nextLine();
			} catch (IOException e) {
				System.out.println("*Closing File Error*");
			} 
			if(flag) break;
		}
		return arr;
	}

	private static ArrayList<String> fileToArray(BufferedReader read) throws IOException {
		String temp[] = read.readLine().split(" ");
		ArrayList<String> arrayList = new ArrayList<>();
		
		for(String e: temp) {
			arrayList.add(e);
		}
		return arrayList;
	}

	private static Card convertToCard(String temp) {
		Card card = null;
		for(Card e: deck.getDeck()) {
			if(e.toString().endsWith(temp)) {
				card = e;
				break;
			}
		}
		
		if(card != null)
			deck.getDeck().remove(card);
		return card;
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
		}else if(temp.contains("Card")) {
			System.out.println("*"+temp+"*");
		}else if(temp.contains("Don't have enough Cards for")) {
			System.out.println("*"+temp+"*");
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
			if(deck.getValueOfDealerHand() <= 16 || gameCase.soft17()) 
				deck.giveDealerCards();
			else
				break;
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
