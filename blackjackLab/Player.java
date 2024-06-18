//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date -

import java.util.*;

public class Player{
   public ArrayList<BlackJackCard> hand;

   // public int total;

   public Player(){
      hand = new ArrayList<BlackJackCard>();  //creates array list of cards
      // total = 0;
   }

   // public Player (int money){
   //    hand = new ArrayList<BlackJackCard>();  //creates array list of cards
   // }

   public void addCardToHand(BlackJackCard temp){  //add temporary card to the array list
      hand.add(temp);
   }

   public void resetHand(){  //resets the player's hand (for a new game)
      hand.clear();
   }

   public ArrayList showHand(){ //returns all the cards and their values in the player's hand
      return hand;
   }

   public int getHandSize(){    //returns the number of cards the player has in their hand right now
      return hand.size(); 
   }

   public int getHandValue(){  //returns value of cards in hand
      int total = 0;
      for (BlackJackCard myCard : hand){
         total += myCard.getValue();
      }
      return total;
   }

   public boolean checkForAce(){
      for (BlackJackCard myCard : hand){
         if (myCard.faceIndex % 13 == 0){
            return true;
         }
      }
      return false;
   }

   public String toString(){
      return "";
   }
}