/* Pravesh Agarwal
 * HW5 Program : CarrollPuzzle.java
 * Finds a minimal word ladder between two words
 */


import java.util.Scanner;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

public class CarrollPuzzle_Client{

  // All the nodes created in the graph
  public static ArrayList<PuzzleNode> wordNodes = new ArrayList<PuzzleNode>(500);

  public static void main(String[] args){
    load("FourLetterWords.txt");  
    
    createLinks();

    /*----------Testing if the graph is constructed-------
    for(int i =0; i<wordNodes.get(0).links.size(); i++){
      System.out.printf("\n/%s/ - /%s/", wordNodes.get(0).label
		                 , wordNodes.get(0).links.get(i).label );
    }
    System.out.printf("\n\n");
    -----------------------------------------------------*/

    instructions();

    // Getting input from the user
    Scanner scan = new Scanner( System.in );
    
    String fWord = "co";
    String sWord = "da";
    while (fWord.length() != 4 || sWord.length() !=4 || !contains(fWord) || !contains(sWord)){
      System.out.printf("\nEnter First Word: CODE\n");
      fWord = scan.next().toUpperCase();
      System.out.printf("\nEnter Second Word: DATA\n");
      sWord = scan.next().toUpperCase();
      System.out.printf("\n\n");

      if( !contains(fWord) || !contains(sWord) ){
        System.out.printf("\nPlease try again! Must be four letter valid English word!!\n");
        System.out.printf("\n");
      }

    }

    scan.close();


    // Calling minPath to search for the shortest/ minimum path 
    minPath(fWord, sWord );

  }


  // Method to scan data from the file
  public static void load(String file){
    try{
      Scanner scan = new Scanner( new File(file) );
      while (scan.hasNext()){
        constructNode( scan.next() );
      }
      scan.close();
    }
    catch(FileNotFoundException e){
      System.out.printf("\nFile FourLetterWord.txt not found!"
		       +" Please locate the file and try again");
      System.out.printf("\n\n");
    }
  }


  // Method to construct the graph
  public static void constructNode(String s){
    wordNodes.add( new PuzzleNode(s) );
  }

  // Method to compare the words with one difference in character and link them
  public static void createLinks(){
    int index = 1;
    for (PuzzleNode node : wordNodes){
      for (int i = index; i<wordNodes.size(); i++){
       
	// comparing first char 
	if(node.label.charAt(0) != wordNodes.get(i).label.charAt(0) 
	  && node.label.substring(1).equals( wordNodes.get(i).label.substring(1) ) ){
	  node.link( wordNodes.get(i) );
	  wordNodes.get(i).link(node);
	}

	// comparing second char
	if(node.label.charAt(0) == wordNodes.get(i).label.charAt(0) 
	   && node.label.charAt(1) != wordNodes.get(i).label.charAt(1) 
	   && node.label.substring(2).equals( wordNodes.get(i).label.substring(2) ) ){
	  node.link( wordNodes.get(i) );
	  wordNodes.get(i).link(node);
	}

	// comparing third char
	if(node.label.substring(0, 2).equals( wordNodes.get(i).label.substring(0, 2) )
	   && node.label.charAt(2) != wordNodes.get(i).label.charAt(2) 
	   && node.label.charAt(3) == wordNodes.get(i).label.charAt(3) ){
	  node.link(wordNodes.get(i));
	  wordNodes.get(i).link(node);
	}

	// comparing fourth char
	if(node.label.substring(0, 3).equals( wordNodes.get(i).label.substring(0, 3) )
	   && node.label.charAt(3) != wordNodes.get(i).label.charAt(3) ){
	  node.link( wordNodes.get(i) );
	  wordNodes.get(i).link(node);
	}

      }
      index++;
    }
  }


  // Method to give instructions
  public static void instructions(){
    System.out.printf("\n----------------------------------------------------------"
		     +"\n Welcome to Word Ladder based on Lewis Carroll's Puzzle.  "
		     +"\n Enter any two Four Letter Words to find the shorest      "
		     +"\n distance to convert first word to the second by changing "
		     +"\n one letter at a time with the additional constraints that"
		     +"\n at each step, the sequence of letter must still form a   "
		     +"\n valid word                                               " );
    System.out.printf("\n");
  }


  // Method to find the smallest word ladder using BFS
  public static void minPath(String s, String e){
  
    PuzzleNode start = wordNodes.get( containsAt(s) );
    PuzzleNode end = wordNodes.get( containsAt(e) );

    for(PuzzleNode node : wordNodes){
      node.color="WHITE";
    }  

    BFS(start, end);
  
  }

  public static void BFS(PuzzleNode start, PuzzleNode end){
    ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
    Queue<PuzzleNode> visitor = new ArrayDeque<PuzzleNode>();
    visitor.add(start);
    ArrayList<Integer> path = new ArrayList<Integer>();
    path.add(containsAt(start.label));
    paths.add(path);

    while( !visitor.isEmpty() ) {
      PuzzleNode visit = visitor.remove();
      if (visit != end){
        for(PuzzleNode node : visit.links){
	  if( node.color.equals("WHITE") || node.color.equals("GRAY") ){
	    node.color="GRAY";
	    visitor.add(node);

	    boolean exists = false;
	    ArrayList<Integer> existsAt = new ArrayList<Integer>();
	    
	    if(paths.size()>0){
              for(ArrayList<Integer> p : paths){
	        exists = (p.get(p.size()-1) == containsAt(visit.label) );
	        if(exists){
	          existsAt.add( paths.indexOf(p) );
	        }
	      }
	    }
	    if (visit.links.size() > 1) {
              for (int i = 0; i < visit.links.size()-1; i++) {
                ArrayList<Integer> path1 = new ArrayList<Integer>();
                for (Integer j : paths.get(existsAt.get(0))) {
                  path1.add(j);
                }
                paths.add(path1);
              }
            }

	    paths.get( existsAt.get(0) ).add( containsAt(node.label) );
	  }
	  else{
	    ArrayList<Integer> path2 = new ArrayList<Integer>();
            path2.add(containsAt(node.label));
            paths.add(path2);
	  }
	}
      }
    visit.color="BLACK";
    }
    

    // Removing paths that don't reach End node
    for(int i = 0; i < paths.size(); i++){
      if(paths.get(i).get(paths.get(i).size()-1) != containsAt(end.label)){
        paths.remove( paths.indexOf( paths.get(i) ) );
      }
    } 

    // Find the shorest path among all the paths
    ArrayList<Integer> shortestPath = paths.get(0);
    for(ArrayList<Integer> p : paths){
      if(shortestPath != p){
	if(shortestPath.size() > p.size()){
	  shortestPath = p;
	}
      }
    }
    for (int j = 0; j < paths.get(0).size(); j++) {
      System.out.printf("%s,", wordNodes.get(paths.get(0).get(j)).label);
    }
    System.out.printf("\n\n");
    /*// Output to the users
    for(Integer i : shortestPath){
      System.out.printf("\n %s",wordNodes.get(i).label );
      System.out.printf("\n\n Found me");
    }
    System.out.printf("\n\n %d", paths.size());
    */
  }

  

  // Method to ckeck if a node with the same label already exists
  public static boolean contains(String s){
    for(PuzzleNode node : wordNodes){
      if( node.label.equals(s) )
        return true;
    }
    return false;
  }


  // Method to ckeck if a node with the same label already exists
  public static int containsAt(String s){
    for(int i = 0; i< wordNodes.size(); i++){
      if( wordNodes.get(i).label.equals(s) )
        return i;
    }
    return -1;
  }



}
