//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date - 

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack{
	public static void main(String[] args){    //main game 
		Scanner keyboard = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		Money money = new Money();
		Deck deck = new Deck();

		System.out.println("Welcome to Blackjack!");
		System.out.println("BLACKJACK RULES: ");
		System.out.println("Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("The players cards are added up for their total.");
		System.out.println("Players “Hit” to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("Dealer “Hits” until they equal or exceed 17.");
		System.out.println("The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
		System.out.println("Press 'y' for yes and 'no' for no when you recieve a prompt!");

		boolean done = false;
		boolean playAgain = true;

		while (playAgain == true){
			money.makeBet();

			player.addCardToHand(dealer.deal());
			player.addCardToHand(dealer.deal());

			System.out.println("\n\nYour hand: ");
			System.out.println(player.showHand());
			System.out.println("Hand Value:");
			System.out.println(player.getHandValue());

			dealer.addCardToHand(dealer.deal());

			System.out.println("\n\nDealer's hand: ");
			System.out.println(dealer.showHand());
			System.out.println("Hand Value:");
			System.out.println(dealer.getHandValue());

			dealer.addCardToHand(dealer.deal());

			while (player.getHandValue() < 21 && !done){
				System.out.println("\nDo you want to hit?");
				String letter = keyboard.next();
				player.addCardToHand(dealer.deal());
				if (letter.charAt(0) == 'y' || letter.charAt(0) == 'Y'){
					player.addCardToHand(dealer.deal());
					System.out.println("\nYour hand: "); 
					System.out.println(player.showHand());
					System.out.println("Hand Value:");
					System.out.println(player.getHandValue());
				}
				else{
					done = true;
					System.out.println("\nDealer's hand:");
					System.out.println(dealer.showHand());
					System.out.println("Hand Value:");
					System.out.println(dealer.getHandValue());
				}
			}

			while (dealer.getHandValue() <= 17){
				dealer.addCardToHand(dealer.deal());
				System.out.println("Dealer's hand: ");
				out.println(dealer.showHand());
			}

			if (player.getHandValue() > 21){
				System.out.println("\n\nBusted! You lose...");
				System.out.println("\nDealer's hand: ");
				System.out.println(dealer.showHand());
				System.out.println("\nYour hand: ");
				System.out.println(player.showHand());
				System.out.println("HandValue:");
				System.out.println(player.getHandValue());
				money.gameLost();
				System.out.println("\nMoney left:");
				System.out.println(money.returnPlayerMoney());
			}

			if (player.getHandValue() == 21){
				System.out.println("\n\nBlackjack! You win!");
				System.out.println("\nDealer's hand");
				System.out.println(dealer.showHand());
				System.out.println("\nYour hand: ");
				System.out.println(player.showHand());
				System.out.println("\nHandValue:");
				System.out.println(player.getHandValue());
				money.naturalWin();
				System.out.println("\nMoney left:");
				System.out.println(money.returnPlayerMoney());
			}

			if (dealer.getHandValue() <= 18 && dealer.getHandValue() < 21){
				if (player.getHandValue() > dealer.getHandValue()){
					System.out.println("You win!");
					money.gameWon();
				}
			}

			if (dealer.getHandValue() == 21){
				System.out.println("Dealer wins...");
				money.gameLost();
			}

			if (dealer.getHandValue() > 21 && player.getHandValue() <= 21){
				System.out.println("You win!");
				money.gameWon();
			}
			
			System.out.println("\nDo you want to play again?");
			String letter = keyboard.next();
			if (letter.charAt(0) == 'y' || letter.charAt(0) == 'Y'){
				playAgain = true;
				player.resetHand();
				dealer.resetHand();
			}
			else{
				System.out.println("Thank you for playing!");
				playAgain = false;
			}
		}
	}
}