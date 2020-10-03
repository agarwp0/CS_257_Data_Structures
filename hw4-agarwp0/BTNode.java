/* Pravesh Agarwal
 * HW4 - Program 4 : BTNode.java
 * Constructs a node and gives several methods to manipulate the tree
 *
 */

public class BTNode {
	
  String key;
  BTNode left, right;
  int height;

  public BTNode(String key, BTNode left, BTNode right) {
    this.key = key;
    this.left = left;
    this.right = right;
    setHeight();
  }

  public BTNode(String key) {
    this.key = key;
    left = right = null;
  }

  // inOrder traversal
  public String inOrder() {
    String result = "";
    if (left != null)
      result += left.inOrder();
    result += " " + key;
    if (right != null)
      result += right.inOrder();
    return result;
  }

  // sets the height of each node during construction of the nodes
  private void setHeight() {
    if (left == null && right == null) {
      height = 0;
    }
    if (left != null && right != null) {
      if (left.height > right.height) {
        height = left.height + 1;
      } else {
        height = right.height + 1;
      }
    } else if (left != null) {
      height = left.height + 1;
    } else if (right != null) {
      height = right.height + 1;
    }

  }



  // Ex. 6
  public int getHeight() {
    return isLeaf() ? 0 : height;
  }



  // Ex. 7
  boolean isBalanced() {
    if (getHeight() == 0 || getHeight() == 1) {
      return true;
    } else {
      boolean L = false;
      boolean R = false;
      if (left != null)  L = left.isBalanced();
      if (right != null) R = right.isBalanced();
      if (L == true && R == true || L == false && R == false) return true;
      else return false;
      
    }
  }



  // Ex. 8
  boolean hasBSTProperty() {
    if (height == 0) {
      return true;
    } 
    else {
      
      if (left != null)  left.hasBSTProperty();
      if (right != null) right.hasBSTProperty();
      int cmpL, cmpR;
      cmpL = cmpR = -1;
      if (left != null)  cmpL = left.key.compareTo(key);
      if (right != null) cmpR = key.compareTo(right.key);
      if (cmpL < 0 && cmpR < 0) {
        return true;
      }
      else {
        return false;
      }
    
    }
  }

  // checks if a node is leaf of the tree
  boolean isLeaf() {
    return (left == null && right == null);
  }


}
