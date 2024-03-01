//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack{
	public void initializeGame(){    //prints out rules and regulations of the game 
		System.out.println("Welcome to Blackjack!");
		System.out.println("\n");
		System.out.println("  BLACKJACK RULES: ");
		System.out.println("Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("The players cards are added up for their total.");
		System.out.println("Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("Dealer “Hits” until they equal or exceed 17.");
		System.out.println("The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
	}
	public static void main(String[] args){    //main game 
		Scanner keyboard = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		Money money = new Money();

		player.addCardToHand(dealer.deal());
		player.addCardToHand(dealer.deal());

		out.println("Your hand: ");
		out.println(player.showHand());

		out.println("\nHandValue:");
		out.println(player.getHandValue());

		dealer.addCardToHand(dealer.deal());

		out.println("\n\nDealer's hand: ");
		out.println(dealer.showHand());
		dealer.addCardToHand(dealer.deal());

		boolean done = false;
		boolean playAgain = true;

		while (playAgain == true){
			while (player.getHandValue() < 21 && !done){
				System.out.println("Do you want to hit? (Yes/No)");
				String letter = keyboard.next();
				player.addCardToHand(dealer.deal());
				if (letter.charAt(0) == 'y' || letter.charAt(0) == 'Y'){
					System.out.println("Your hand: "); 
					player.addCardToHand(dealer.deal());
					out.println(player);
				}
				else{
					done = true;
				}
			}

			if (player.getHandValue() > 21){
				System.out.println("\n Dealer's hand: ");
				out.println(dealer.showHand());
				System.out.println("\n\n You lose...");
				System.out.println("\n Your hand: ");
				out.println(player.showHand());
				money.gameLost();
			}

			if (player.getHandValue() == 21){
				System.out.println("Blackjack! You win!");
				money.naturalWin();
			}

			while (dealer.getHandValue() <= 17){
				dealer.addCardToHand(dealer.deal());
				System.out.println("Dealer's hand: ");
				out.println(dealer.showHand());
			}

			while (dealer.getHandValue() <= 18 && dealer.getHandValue() < 21){
				if (player.getHandValue() > dealer.getHandValue()){
					System.out.println("You win!");
					money.gameWon();
				}
			}

			while (dealer.getHandValue() == 21){
				money.gameWon();
				System.out.println("Dealer wins...");
			}

			if (dealer.getHandValue() > 21 && player.getHandValue() <= 21){
				System.out.println("You win!");
				money.gameWon();
			}

			System.out.println("Do you want to play again? (Yes/No)");
			String letter = keyboard.next();
			if (letter.charAt(0) == 'y' || letter.charAt(0) == 'Y'){
				playAgain = true;
				player.resetHand();
			}
			else{
				System.out.println("Thank you for playing!");
				playAgain = false;
			}
		}
	}
}