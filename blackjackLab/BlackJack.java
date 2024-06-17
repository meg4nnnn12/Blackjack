//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date - 8 Feb 2024

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack{
	public static void main(String[] args){    //main game 
		Scanner keyboard = new Scanner(System.in);
		Player player = new Player();
		Dealer dealer = new Dealer();
		Money money = new Money();
		Deck deck = new Deck();
 
		System.out.println("Welcome to Blackjack!");   //rules to explain the game 
		System.out.println("BLACKJACK RULES: ");
		System.out.println("Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
		System.out.println("Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
		System.out.println("The players cards are added up for their total.");
		System.out.println("Players 'Hit' to gain another card from the deck. Players “Stay” to keep their current card total.");
		System.out.println("Dealer 'Hits' until they equal or exceed 17.");
		System.out.println("The goal is to have a higher card total than the dealer without going over 21.");
		System.out.println("Players win their bet if they beat the dealer. Players win 1.5x their bet if they get “Blackjack” which is 21.");
		System.out.println("Press 'y' for yes and 'n' for no when you recieve a prompt!");

		boolean done = false;    //boolean that changes to true when the player is done taking cards (decides to stand)
		boolean playAgain = true;   //restarts round

		while (playAgain == true){   //while the boolean "playAgain" is still true, it runs the code
			money.makeBet();   //player makes their bet

			player.addCardToHand(dealer.deal());   //player is dealt two cards
			player.addCardToHand(dealer.deal());

			System.out.println("\n\nYour hand: ");
			System.out.println(player.showHand());
			System.out.println("Hand Value:");
			System.out.println(player.getHandValue());

			dealer.addCardToHand(dealer.deal());   //dealer is dealt one card (face up) first

			System.out.println("\n\nDealer's hand: ");
			System.out.println(dealer.showHand());
			System.out.println("Hand Value:");
			System.out.println(dealer.getHandValue());

			dealer.addCardToHand(dealer.deal());   //the second card the dealer is dealt cannot be seen by the player 

			while (player.getHandValue() < 21 && !done){   //checks if the player has a hand value of less than 21, if they do, they can choose to hit or stand 
				System.out.println("\nDo you want to hit?");
				String letter = keyboard.next();
				if (letter.charAt(0) == 'y' || letter.charAt(0) == 'Y'){   //if the player chooses to hit 
					player.addCardToHand(dealer.deal());
					System.out.println("\nYour hand: "); 
					System.out.println(player.showHand());
					System.out.println("Hand Value:");
					System.out.println(player.getHandValue());
				}
				else{   //if the player chooses to stand
					done = true;
					System.out.println("\nDealer's hand:");
					System.out.println(dealer.showHand());
					System.out.println("Hand Value:");
					System.out.println(dealer.getHandValue());
				}
			}

			while (dealer.getHandValue() < 17){    //if the dealer has a hand less than 17, they have to continue to take cards
				dealer.addCardToHand(dealer.deal());
				System.out.println("Dealer's hand: ");
				System.out.println(dealer.showHand());
				System.out.println("Hand Value:");
				System.out.println(dealer.getHandValue());
			}

			if (player.getHandValue() > 21){   //a player is "busted" if their hand is more than 21
				System.out.println("\n\nBusted! You lose...");
				System.out.println("\nDealer's hand: ");
				System.out.println(dealer.showHand());
				System.out.println("Hand Value:");
				System.out.println(dealer.getHandValue());
				System.out.println("\nYour hand: ");
				System.out.println(player.showHand());
				System.out.println("HandValue:");
				System.out.println(player.getHandValue());
				money.gameLost();
				System.out.println("\nMoney left:");
				System.out.println(money.returnPlayerMoney());
			}

			if (player.getHandValue() == 21){   //if the player has a hand of exactly 21, they win automatically
				System.out.println("\n\nBlackjack! You win!");
				System.out.println("\nDealer's hand");
				System.out.println(dealer.showHand());
				System.out.println("Hand Value:");
				System.out.println(dealer.getHandValue());
				System.out.println("\nYour hand: ");
				System.out.println(player.showHand());
				System.out.println("\nHand Value:");
				System.out.println(player.getHandValue());
				money.naturalWin();
				System.out.println("\nMoney left:");
				System.out.println(money.returnPlayerMoney());
			}

			if (dealer.getHandValue() >= 18 && dealer.getHandValue() < 21 && player.getHandValue() <= 21){  //checking if the dealer has more than 17 in their hand(so they can't take more cards) and that the player has a hand less than or equal to 21
				if (player.getHandValue() > dealer.getHandValue()){  //if the player has more than the dealer, the player wins
					System.out.println("You win!!");
					money.gameWon();
					System.out.println("\nMoney left:");
					System.out.println(money.returnPlayerMoney());
				}
			}

			if (dealer.getHandValue() == 21){   //if the dealer gets a blackjack, they automatically win
				System.out.println("Dealer wins...");
				money.gameLost();
				System.out.println("\nMoney left:");
				System.out.println(money.returnPlayerMoney());
			}

			if (dealer.getHandValue() > 21 && player.getHandValue() <= 21){   //if the dealer is busted and the player has less or equal to 21, the player wins
				System.out.println("You win!!!");
				money.gameWon();
				System.out.println("\nMoney left:");
				System.out.println(money.returnPlayerMoney());
			}
			
			System.out.println("\nDo you want to play again?");  //asking the player if they want to play again
			String letter = keyboard.next();
			if (letter.charAt(0) == 'y' || letter.charAt(0) == 'Y'){    //yes
				playAgain = true;
				player.resetHand();
				dealer.resetHand();
			}
			else{    //no
				System.out.println("Thank you for playing!");
				playAgain = false;
			}
		}
	}
}