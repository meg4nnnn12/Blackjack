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

	public Deck (){ 
		topCardIndex = 51; //initialize data - stackOfCards - topCardIndex
		stackOfCards = new ArrayList<>();
		
		for (int i = 0; i < NUMCARDS; i++){  //loop through suits
			stackOfCards.add(new BlackJackCard (i)); //add in a new card 
		}
		shuffle();
	}

   public void shuffle(){
		// if (topCardIndex < 26){  //if the deck is halfway through
		//  	Collections.shuffle(stackOfCards);  //shuffle the deck
		// 	topCardIndex = 51;
		// }
		 Collections.shuffle(stackOfCards);
	}

	public int size(){
		return stackOfCards.size();
	}

	public int numCardsLeft(){
		return (stackOfCards.size() - topCardIndex);
		// return (topCardIndex + 1);
	}

	public BlackJackCard nextCard(){
		return stackOfCards.get(topCardIndex--);
	}

	public String toString(){
		return stackOfCards + " topCardIndex = " + topCardIndex;
	} 
}