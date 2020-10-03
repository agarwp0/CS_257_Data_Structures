/* Pravesh Agarwal
 * HW4 Program 4: BTNode_Client.java
 * Constructs a tree and tests methods in BTNode.java class file
 */


import java.util.ArrayList;

public class BTNode_Client {

  static ArrayList<BTNode> list = new ArrayList<BTNode>();

  public static void main(String[] args) {

    // Constructing a Tree inorder traversal : rpvaesh
    // Unbalanced and doesn't have BST Property
    // BTNode h = new BTNode("h");
    BTNode s = new BTNode("s", null, null/*h*/);
    BTNode e = new BTNode("e", null, s);
    // BTNode v = new BTNode("v");
    BTNode a = new BTNode("a", null/*v*/, e);
    BTNode r = new BTNode("r");
    BTNode p = new BTNode("p", r,a);

    

    // Testing the methods in BTNode    

    System.out.printf("\nInOrder Traversal      = %s", p.inOrder());
    System.out.printf("\nTree is balanced       = %b", p.isBalanced());
    System.out.printf("\nTree has BST Property  = %b", p.hasBSTProperty());
    System.out.printf("\nCommon Ancestor        = %s", findCommonAncestor(s, r, p).key);
    System.out.printf("\n\n");

    if ( ! p.isBalanced() ){
    rebalance(p);
    BTNode newRoot = list.get( list.size()/2 );
    System.out.printf("\nRebalance : ");
    System.out.printf("\nInOrder Traversal      = %s", newRoot.inOrder());
    
    System.out.printf("\n\t newRoot: %s left: %s right: %s "
		          , p.key   , p.left.key, p.right.key ); 
    // System.out.printf("\n\t  %s %s %s ", e.key, e.left.key, e.right.key ); 
    System.out.printf("\n\t leaf   : %s ", a.key); 
    System.out.printf("\n\t parent : %s leaf: %s ", e.key, e.left.key); 
    
    
    System.out.printf("\n\n");
    }
  }

  // Finds the common ancestor of two nodes
  public static BTNode findCommonAncestor(BTNode a, BTNode b, BTNode root) {
    if (root == null) {
      return null;
    }
    if (root == a || root == b)
      return root;
    BTNode left = findCommonAncestor(a, b, root.left);
    BTNode right = findCommonAncestor(a, b, root.right);
    if (left != null && right != null)
      return root;
    return left != null ? left : right;
  }

  // Exercise : 9; Rebalances the unbalanced tree
  public static BTNode rebalance(BTNode root) {
    constructArray(root);
    cleanse();

    BTNode ROOT = constructBalancedTree(list);
    fixHeight(list.get(list.size()/2) );
    return ROOT;
  }

  // Recursively constructs the balanced tree from sorted arraylist : list
  private static BTNode constructBalancedTree(ArrayList<BTNode> list) {
    BTNode ROOT = null;
    if (list.size()!=0) {ROOT = list.get(list.size() / 2);}
    if (list.size() <= 1) {
      return ROOT;
    } 
    else {
     
      // recursively passes the left portion of the array from the middle index
      ArrayList<BTNode> leftMiniList = new ArrayList<BTNode>();
      for (int i = 0; i < list.size() / 2; i++) {
        leftMiniList.add(list.get(i));
      }
      ROOT.left = constructBalancedTree(leftMiniList);

      // recursively passes the right portion of the array from the middle index
      int rightSize = (list.size() / 2 + 1);
      ArrayList<BTNode> rightMiniList = new ArrayList<BTNode>();
      for (int i = rightSize; i < list.size(); i++) {
        rightMiniList.add(list.get(i));
      }
      ROOT.right = constructBalancedTree(rightMiniList);
      
      return ROOT;
    }
  }

  // Add all the elements of the tree in the ArrayList: list
  private static void constructArray(BTNode root) {
    list.add(root);
    if (root.left != null)
      constructArray(root.left);
    if (root.right != null)
      constructArray(root.right);
    sortArray();
  }

  // Sorts the nodes added in constructArray in list ArrayList
  private static void sortArray() {
    BTNode swap;
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < list.size(); j++) {
        int cmp = list.get(i).key.compareTo(list.get(j).key);
        if (cmp < 0) {
          swap = list.get(i);
          list.set(i, list.get(j));
          list.set(j, swap);
        }
      }
    }
  }

  // Cleans the left and right association of the nodes 
  // in the tree before rebalance.
  private static void cleanse() {
    for (BTNode node : list) {
      node.left  = null;
      node.right = null;
    }
  }

  // Fix the height of the nodes in the rebalanced tree
  private static void fixHeight(BTNode root) {
    if (root.left == null && root.right == null) {
      root.height = 0;
    } 

    if (root.left != null) {
      fixHeight(root.left);
      root.height = root.left.height + 1;
    } 

    if (root.right != null) {
      fixHeight(root.right);
      root.height = root.right.height + 1;
    }
  }

}

