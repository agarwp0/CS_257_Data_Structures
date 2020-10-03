/*
 * File: Move.java
 * ---------------
 * This class represents the class for all moves in two-player games.
 */

/**
 * This class represents the class for moves in a two-player
 * game.  At this level, the class exports getters and setters for the
 * rating of the move.  Clients should extend this class to include
 * whatever fields are necessary to define a move in a particular game.
 */

public class Move {

  /* Private instance variables */

  private int rating, coins;

  // Sets a move with the no of coins user takes from the pile
  public void setMove(int coins){
    this.coins = coins;
  }

  // gets the move with the no of coins user takes from the pile
  public int getMove(){
    return coins;
  }

  /**
   * Sets the rating for this move.
   *
   * @param rating The rating for this move
   */

  public void setRating(int rating) {
    this.rating = rating;
  }


  /**
   * Gets the rating for this move, as previously set by setRating.
   *
   * @return The rating for this move
   */

  public int getRating() {
    return rating;
  }



}
