import java.util.Scanner;

public class Money { 
    private int playerMoney;  //how much money the player has in total
    private int playerBet;    //how much money the player places for a bet 
    private boolean finish;

    public Money(){
        playerMoney = 100;
        playerBet = 0;   
    }

    public boolean makeBet(){    //asking the player to make a bet
        Scanner keyboard = new Scanner(System.in);
        System.out.println("\nYou have $" + returnPlayerMoney());
        System.out.println("How much money would you like to bet?");
        playerBet = keyboard.nextInt();

        System.out.println("You placed a $" + playerBet + " bet");
        return true;
    }

    public void naturalWin(){    //when a player gets a natural, they get back 1.5x as much as they bet
        playerMoney += playerBet * 1.5;
        playerBet = 0;
    }

    public void gameLost(){      //when a player loses, they lose all the money they bet
        playerMoney -= playerBet;
        playerBet = 0;
    }

    public void gameWon(){       //when a player wins, they get back 2x as much as they bet
        playerMoney += playerBet * 2;
        playerBet = 0;
    }

    public int returnPlayerMoney(){   //returns the amount of money the player currently has
        return (playerMoney);
    }

    public int returnPlayerBet(){     //returns the amount of money the player bet
        return (playerBet);
    }
}
