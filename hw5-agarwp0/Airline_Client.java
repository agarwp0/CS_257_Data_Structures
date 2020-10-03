/* Pravesh Agarwal
 * HW5; Thu, April 23, 2020; Program 1: Airline_Client.java
 * A Client file that constructs a graph using GraphNode class
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;
import java.util.HashSet;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;

public class Airline_Client{

  protected static ArrayList<GraphNode<Integer>> allNodes = new ArrayList<GraphNode<Integer>>();

  public static void main(String args[]){
    // Calling load method with the file AirlineGraph.txt
    load("AirlineGraph.txt");

    // Displaying the graph
    // Problem occurs when the below loop is changed to enhanced loop. WHY??
    for (int j =0; j<allNodes.size();j++){
      for(GraphNode<Integer> i : allNodes.get(j).nodes.keySet()){
        System.out.printf("\n%s  -  %s  (%d)", allNodes.get(j).label
                          , i.label, allNodes.get(j).nodes.get(i));
      }
    }
    System.out.printf("\n\n");
  }



  //----------------------------- Exercise 1----------------------------

  public static void load(String file){
    try{
      Scanner scan = new Scanner( new File(file) );
      while (scan.hasNextLine()){
        save(parseString(scan.nextLine()));
      }
      scan.close();
    }
    catch(FileNotFoundException e){
      System.out.printf("\nFile AirlineGraph.txt not found!"
		       +" Please locate the file and try again");
      System.out.printf("\n\n");
    }
  }

  public static String[] parseString(String s){
    
    if (s.indexOf("-") == -1){
      String[] data= {s};
      data[0] = data[0].trim();
      return data;
    }

    else if (s.indexOf("(") == -1){
      String[] data = s.split("-");
      data[0] = data[0].trim();
      data[1] = data[1].trim();
      return data;
    } 
  
    else{
      String[] data = s.split("[-()]");
      data[0] = data[0].trim();
      data[1] = data[1].trim();
      data[2] = data[2].trim();
      return data;
    }
  
  
  }

  public static void save(String[] data){
    
    // First Format of data in file
    if(data.length == 1  && !contains(data[0])){
      allNodes.add( new GraphNode<Integer>(data[0]) );
    }

    // Second Format of data in file
    if(data.length == 2){
      GraphNode<Integer> node1 = null;
      GraphNode<Integer> node2 = null;
      
      if(!contains(data[0])){
        node1 = new GraphNode<Integer>(data[0]) ;
        allNodes.add( node1 );
      }
      else{
        node1 = allNodes.get( containsAt(data[0]) ); 
      }
      
      if (data[1].charAt(0)=='>' ){
        data[1] = data[1].substring(1);
        data[1] = data[1].trim();

	if( !contains(data[1]) ){
          node2 = new GraphNode<Integer>(data[1]) ;
          allNodes.add( node2 );
        }
        else{
          node2 = allNodes.get( containsAt(data[1]) ); 
        }
        node1.link(node2, 0);
      }
      else{
	if( !contains(data[1]) ){
          data[1] = data[1].trim();
          node2 = new GraphNode<Integer>(data[1]) ;
          allNodes.add( node2 );
        }
        else{
          node2 = allNodes.get( containsAt(data[1]) ); 
        }
        node1.link(node2, 0);
        node2.link(node1, 0);
         
      }
    
    }


    // Third Format of data in file
    if(data.length == 3){
      GraphNode<Integer> node1 = null;
      GraphNode<Integer> node2 = null;
      
      if(!contains(data[0])){
        node1 = new GraphNode<Integer>(data[0]) ;
        allNodes.add( node1 );
      }
      else{
        node1 = allNodes.get( containsAt(data[0]) ); 
      }
      
      if (data[1].charAt(0)=='>' ){
        data[1] = data[1].substring(1);
        //data[1] = data[1].trim();

	if( !contains(data[1]) ){
          node2 = new GraphNode<Integer>(data[1].trim()) ;
          allNodes.add( node2 );
        }
        else{
          node2 = allNodes.get( containsAt(data[1]) ); 
        }
        node1.link( node2, Integer.parseInt( data[2] )  );
      }
      else{
	if( !contains(data[1]) ){
          //data[1] = data[1].trim();
          node2 = new GraphNode<Integer>(data[1].trim()) ;
          allNodes.add( node2 );
        }
        else{
          node2 = allNodes.get( containsAt(data[1]) ); 
        }
        node1.link( node2, Integer.parseInt( data[2] )  );
        node2.link( node1, Integer.parseInt( data[2] )  );
    
    }

  }

  }
 
  // Method to ckeck if a node with the same label already exists
  public static boolean contains(String s){
    for(GraphNode<Integer> node : allNodes){
      if( node.label.equals(s) )
        return true;
    }
    return false;
  }


  // Method to ckeck if a node with the same label already exists
  public static int containsAt(String s){
    for(int i = 0; i< allNodes.size(); i++){
      if( allNodes.get(i).label.equals(s) )
        return i;
    }
    return -1;
  }


  //---------------------------- Exercise 2----------------------------

public static void DFS(GraphNode<Integer> visit) {
    Stack<GraphNode<Integer>> visited = new Stack<GraphNode<Integer>>();
    Set<GraphNode<Integer>> visitedSet = new HashSet<GraphNode<Integer>>();
    GraphNode<Integer> visitor = visit;
    visited.push(visitor);
    while (!visited.isEmpty()) {
      visitor = visited.pop();
      if (!visitedSet.contains(visitor)) {
        for (GraphNode<Integer> node : visitor.nodes.keySet()) {
          if (!visitedSet.contains(node)) {
            visited.push(node);
          }
        }
      }
      visitedSet.add(visitor);
    }
  }
}
