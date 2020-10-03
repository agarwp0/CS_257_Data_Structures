/* Pravesh Agarwal
 * HW2
 * Q1 Parameterized class of Date class in Date.java
 *
 */

import java.util.Stack;

public class DateStack extends Stack<Date>{

  public DateStack(Date...dt){
    for(Date d : dt) 
      push(d);
  }

  // Don't understand how this exactly works?
  public String toString(){
    String str = "";
    for(Date k:this){
      if ( !str.isEmpty() ) str += ", ";
      str +=k;
    } 
    return "[" + str + "]";
  }


}
