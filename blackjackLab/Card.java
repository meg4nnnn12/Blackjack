//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date - 8 Feb 2024

public class Card{
	public static final String FACES[] = {"ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	public static final String SUITS[] = {"DIAMONDS", "CLUBS", "SPADES", "HEARTS"};

	//public int face = 0;
	public int faceIndex = 0; 
	public int suitIndex = 0;

  	public Card(int cardNum){   //constructor
		faceIndex = cardNum % 13;  //0-12 -> diamonds; 13-25 -> clubs; 26-38 -> spades; 39-51 -> hearts
		suitIndex = cardNum / 13;
	}

	//modifiers

  	//accessors

	public String getSuit(){
		return SUITS [suitIndex];
	}

	public int getValue(){
		return faceIndex + 1;
	}

	public String getFace(){
		return FACES [faceIndex];
	}
 
	public void setFace(int cardFace){
		faceIndex = 1;
	}

	public boolean equals(Object obj){
		return false;
	}

  	public String toString(){   //toString
		return (getFace() + " of " + getSuit() + " | " + " VALUE: " + getValue());
	}
 }