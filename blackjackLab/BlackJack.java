//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import static java.lang.System.*;
import java.util.Scanner;

public class BlackJack
{
	private Player player;  //add in Player instance variable
	private Dealer dealer;  //add in Dealer instance variable

	public BlackJack(){
		player = new Player();
		dealer = new Dealer();
	}

	public static void main(String[] args){
		BlackJack game = new BlackJack();
		game.playGame();
	}

	public void playGame(){
		Scanner keyboard = new Scanner(System.in);
		char choice = 0;
	}

	public boolean startGame(){
	}
}