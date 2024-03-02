//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date - Feb 14

import java.util.ArrayList;
import java.util.Collections;

public class Deck{
	public static final int NUMCARDS = 52;
	private int topCardIndex;
	public ArrayList<BlackJackCard> stackOfCards;

	public Deck (){   //constructor
		topCardIndex = 51; //initialize data - stackOfCards - topCardIndex
		stackOfCards = new ArrayList<>();
		
		for (int i = 0; i < NUMCARDS; i++){  //loop through suits
			stackOfCards.add(new BlackJackCard (i)); //add in a new card 
		}
		shuffle();
	}

   public void shuffle(){   //shuffles the deck
		// if (topCardIndex < 26){  //if the deck is halfway through
		//  	Collections.shuffle(stackOfCards);  //shuffle the deck
		// 	topCardIndex = 51;
		// }
		 Collections.shuffle(stackOfCards);
	}

	public int size(){   //returns the size of the ArrayList
		return stackOfCards.size();
	}

	public int numCardsLeft(){   //checks how many cards are left in the deck
		return (stackOfCards.size() - topCardIndex);
	}

	public BlackJackCard nextCard(){
		return stackOfCards.get(topCardIndex--);
	}

	public String toString(){
		return stackOfCards + " topCardIndex = " + topCardIndex;
	} 
}