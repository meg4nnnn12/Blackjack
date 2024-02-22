//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

import java.util.ArrayList;
import java.util.Collections;

public class Dealer extends Player{
	public static final int NUMCARDS = 52;
	//private int topCardIndex;
	private Deck stackOfCards; //define a deck of cards

	public Dealer(){
		//topCardIndex = 51; //initialize data -> stackOfCards - topCardIndex
		stackOfCards = new Deck();
	}

	public void shuffle(){   //shuffle the deck
		stackOfCards.shuffle();
	}

	public BlackJackCard deal(){
	   return null;
	}
	
	public int numCardsLeftInDeck(){
		return 0;
	}

	public boolean hit(){
		return false;
    }
}








