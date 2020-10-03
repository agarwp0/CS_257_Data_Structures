/* Pravesh Agarwal
 * HW5; Thu, April 23, 2020; Program 7: PuzzleNode.java
 * A class file that constructs a node of a graph 
 * with object - oriented approach to store the four letter words
 */


import java.util.ArrayList;

public class PuzzleNode{

  public String label, color;
  public ArrayList<PuzzleNode> links = new ArrayList<PuzzleNode>();

  public PuzzleNode( String label ){
  this.label = label;
  }

  public void link(PuzzleNode lk){
    links.add(lk);
  }
  
}
