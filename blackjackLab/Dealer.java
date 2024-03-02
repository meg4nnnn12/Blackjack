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

	public Dealer(){   //constructor
		stackOfCards = new Deck();
	}

	public void shuffle(){   //shuffle the deck
		stackOfCards.shuffle();
	}

	public BlackJackCard deal(){   //used with addCardtoHand to deal out cards
	   return stackOfCards.nextCard();
	}
}








