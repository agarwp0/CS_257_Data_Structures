/* Pravesh Agarwal
 * HW3 - agarwp0
 * Pg 369, Question 10
 * File: Permutations.java
 * -----------------------
 * This file generates all permutations of an input string. Taking program
 * from pg 351, figure 9-2 and implementing it using the new strategy
 * described in question 10, pg 369
 */

import java.util.TreeSet;
import java.util.Scanner;

public class Permutations_Client {

  /* Main program */

  public static void main(String[] args){
    Scanner scan = new Scanner(System.in);
    System.out.printf("\nEnter a string: \n");
    String str = scan.nextLine();
    System.out.printf("The permutations of %s  are:\n", str);
    for (String s : generatePermutations(str)) {
      System.out.printf(" %s\n",s);
    }
  }

/*
 * Returns a set consisting of all permutations of the specified string.
 * This implementation uses the recursive insight that you remove the
 * first character and generate set containing all permutations of the
 * rest of the string. Finally, adding the first char in every possible
 * position in the set.
 */
   private static TreeSet<String> generatePermutations(String str) {
      TreeSet<String> result = new TreeSet<String>();
      if (str.equals("")) {
        result.add("");
      } 
      else {
        char ch = str.charAt(0);
        String rest = str.substring(1);
        for (String s : generatePermutations(rest)) {
  	  result.add(ch + s);
	  for(int i= 0; i< s.length(); i++){
	    result.add( s.substring(0,i+1) + ch + s.substring(i+1) );
	  }
        }
        
      }
      return result;
   }
}
