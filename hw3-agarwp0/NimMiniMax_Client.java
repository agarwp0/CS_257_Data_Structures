/*
 * File: NimMiniMax_Client.java
 * --------------
 * This program simulates a simple variant of the game of Nim using 
 * minimax algorithm.
 * In this version, the game starts with a pile of 13 coins on a table.
 * Players then take turns removing 1, 2, or 3 coins from the pile.
 * The player who takes the last coin loses.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class NimMiniMax_Client extends TwoPlayerGame {

  /* Main program */

  public static void main(String[] args) {
     new NimMiniMax_Client().run();
  }
  
  /* Private constants */

  private static final int MAX_MOVE = 3;
  private static final int STARTING_COINS = 13;
  private static final Player STARTING_PLAYER = Player.HUMAN;

  /* Private instance variables */

  private Scanner scan;
  private int nCoins;              /* Number of coins left on the table */
  private Player currentPlayer;    /* Indicates whose turn it is        */
  

  public void run() {
    scan = new Scanner(System.in);
    printInstructions();
    nCoins = STARTING_COINS;
    currentPlayer = STARTING_PLAYER;
    while (nCoins > 1) {
      System.out.printf("\nThere are %d coins in the pile.", nCoins);
      if (currentPlayer == Player.HUMAN) {
        nCoins -= getUserMove().getMove();
      } else {
        int nTaken = getComputerMove().getMove();
        System.out.printf("\nI'll take %d.", nTaken);
        nCoins -= nTaken;
      }
      switchPlayer();
    }
    announceResult();
  }
  
  /* Abstract methods in TwoPlayerGame */

  public void initGame(){}

  public void displayGame(){}
 
  public void displayMove(Move move){}
 
  // Let's the computer know what are the legal moves
  public ArrayList<Move> generateLegalMoves(){
    ArrayList<Move> moves = new ArrayList<Move>();
    for (int i = 1; i<4; i++){
      Move m = new Move();
      m.setMove(i);
      moves.add( m ); 
    } 
      
    return moves;
  }

  // Subtracts the total coins in the pile with one choice
  // to look through that choice scenario in minimax algorithm
  public void makeMove(Move move){
    nCoins = nCoins - move.getMove();
  }

  // Adds back the subtracted choice to the total coins in the
  // pile after looking through that choice scenario in minimax
  // algorithm
  public void retractMove(Move move){
    nCoins = nCoins + move.getMove();
  }

  // Lets the minimax algorithm know when to stop checking deeper
  // that is, it has reached the end
  public boolean gameIsOver(){return nCoins<2;}

  // Base case for victory for the computer
  // as long as there are less than 4 coins, it can leave one 
  // coin and win
  public int evaluateStaticPosition(){
    if (nCoins>1 && nCoins<4){
      return 1;
    }
    else{
      return -1;
    }
  }

  /**
   * Asks the user to enter a move and returns the number of coins taken.
   * If the move is not legal, the user is asked to reenter a valid move.
   */

  public Move getUserMove() {
    int limit = (nCoins < MAX_MOVE) ? nCoins : MAX_MOVE;
    while (true) {
      System.out.printf("\nHow many would you like? ");
      int nTaken = scan.nextInt();
      if (nTaken > 0 && nTaken <= limit){
	Move userMove = new Move();
        userMove.setMove(nTaken);
	return userMove;
      }
      System.out.printf("\nThat's cheating!  Please choose " +
                         "between 1 and %d.", limit );
      System.out.printf("\nThere are %d coins in the pile.", nCoins);
    }
  }

  /**
   * Figures out what move is best for the computer player and returns
   * the number of coins taken.  The method first calls findGoodMove
   * to see if a winning move exists.  If none does, the program takes
   * only one coin to give the human player more chances to make a mistake.
   */

  public Move getComputerMove() {
    return findBestMove(0);
  }


  /**
   * Switches between the human and computer player.
   */

  public void switchPlayer() {
    currentPlayer = (currentPlayer == Player.HUMAN) ? Player.COMPUTER
                                                    : Player.HUMAN;
  }

  /**
   * Explains the rules of the game to the user.
   */

  public void printInstructions() {
    System.out.printf("\nWelcome to the game of Nim!                   "
                     +"\nIn this game, we will start with a pile of"
                     +" %d coins on the table.                        " 
                     +"\nOn each turn, you and I will alternately take"
                     +" between 1 and %d  coins from the table.       "
                     +"\nThe player who takes the"
                     +" last coin loses.\n",STARTING_COINS, MAX_MOVE);
  }

  /**
   * Announces the final result of the game.
   */

  public void announceResult() {
    if (nCoins == 0) {
       System.out.printf("\nYou took the last coin.  You lose.");
    } else {
       System.out.printf("\nThere is only one coin left.");
       if (currentPlayer == Player.HUMAN) {
          System.out.printf("\nI win.\n");
       } else {
          System.out.printf("\nI lose.\n");
       }
    }
  }


}
