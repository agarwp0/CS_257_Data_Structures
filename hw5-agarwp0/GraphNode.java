/* Pravesh Agarwal
 * HW5; Thu, April 23, 2020; Program 1: GraphNode.java
 * A class file that constructs a node of a graph 
 * with object - oriented approach and one generic variable
 *
 */


import java.util.HashMap;

public class GraphNode<C>{

  public String label;
  public HashMap<GraphNode, C> nodes = new HashMap<GraphNode, C>();

  public GraphNode( String label ){
  this.label = label;
  }

  public void link(GraphNode lk, C cost){
    nodes.put(lk, cost);
  }



}
