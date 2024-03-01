//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Megan Cheng
//Date -

import java.util.*;

public class Player{
   private ArrayList<BlackJackCard> hand;

   public Player(){
      hand = new ArrayList<BlackJackCard>();  //creates array list of cards
   }

   // public Player (int money){
   //    hand = new ArrayList<BlackJackCard>();  //creates array list of cards
   // }

   public void addCardToHand(BlackJackCard temp){  //add temporary card to the array list
      hand.add(temp);
   }

   public void resetHand(){
      hand.clear();
   }

   public ArrayList showHand(){
      return hand;
   }

   public int getHandSize(){
      return hand.size(); 
   }

   public int getHandValue(){  //returns value of cards in hand
      int total = 0;
      for (BlackJackCard myCard : hand){
         total += myCard.getValue();
      }
      // System.out.println("Total = " + total);
      return total;
   }

   public boolean hit(){
      return false;
   }

   public String toString(){
      return "";
   }
}