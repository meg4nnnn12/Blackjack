// //(c) A+ Computer Science
// //www.apluscompsci.com
// //Name - Megan Cheng
// //Date - 8 Feb 2024

public class BlackJackCard extends Card{
	int faceIndex;

  	public BlackJackCard(int cardNum){  //constructor
		super(cardNum);
		this.faceIndex = super.faceIndex;
	}

	public int getValue(){
  		//enables you to build the value for the game into the card
  		//this makes writing the whole program a little easier
		if (faceIndex % 13 == 0)
			return 11;
		else if(faceIndex >= 10){
			return 10;
		}
		else return faceIndex + 1;
  	}
 }