package core;

import java.util.Scanner;

public class MainGame {
	private static CardDeck deck;
	private static GameCases gameCase;
	private static Scanner input;
	
	public static void main(String args[]) {
		deck = new CardDeck();
		gameCase = new GameCases(deck);
		input = new Scanner(System.in);
		
		deck.shuffle();
		
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
			temp = input.nextLine();
			if(temp.toLowerCase().equals("c") || 
					temp.toLowerCase().equals("f"))
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
		String temp = type();
		 deck.giveDealerCards();
		 deck.giveDealerCards();

		
		 if(temp.equals("c")) {
			// Game while loop
			 while(true) {
				// Take input from file or User
				 
				 
				 temp = userInput();
				// Apply rules of the game
				 
				// If condition is met, we have a winner
				
				// prompt for another game (Yes/No)?
			 }
		 }else {
			 // file type game loop
		 }
		
	}

	private static String userInput() {
		String temp = input.nextLine();
		System.out.println("Enter \"H\" to Hit Or \"S\" to Stand");
		
		while(!(temp.toLowerCase().equals("H")||
				(temp.toLowerCase().equals("S")))){
			System.out.println("*NOT A VALIED INPUT*");
			System.out.println("Enter \"H\" to Hit Or \"S\" to Stand");
			temp = input.nextLine();
		}
		clearPrompt();
		return temp;
	}
}
