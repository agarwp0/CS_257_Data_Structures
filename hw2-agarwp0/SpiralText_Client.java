/* Pravesh Agarwal
 * hw2 Feb 17, 2020
 * Using constructed class GString to make the string go in spiral using
 * recursion but that didn't work so just submitting in iteration
 * But I have also submitted the recursive file which is this file 
 * please help me look what went wrong. Thank you!
 */

import java.awt.Color;
import java.util.Scanner;

public class SpiralText_Client extends WC{


  private GFilledOval theOval;
  private GString theString;
  private String s="this is a string"; 
  private int n;

  public void begin(){
    // theOval = new GFilledOval(250,250,50,50,canvas);
    // theOval.setColor(Color.RED);
    n =  s.length(); 
    spiralText( s , 0, 300, 300,5, 20 );
  }
  
  public static void main (String[]args) {
    Scanner scan = new Scanner(System.in);
    System.out.printf("\nEnter 'A' sentence.\n");
  
    String s = scan.nextLine();

    SpiralText_Client object = new SpiralText_Client();

    object.s = s;

    new SpiralText_Client().startController(1000,1000);
  }

  public void spiralText(String s, int i, int x, int y,int diff, int size){
    if (i < n){
      new GString(s, x, y, size, canvas);
    }
    else{
      if(i<n/4)
        spiralText( Character.toString( s.charAt(i) ), i+1
		    , x+diff+size, y+diff+size, diff+1, size);
      else if(i<n/2)
        spiralText( Character.toString( s.charAt(i) ), i+1
		    , x-diff-size, y+diff+size, diff+1, size);
      else if(i<3*n/4)
        spiralText( Character.toString( s.charAt(i) ),i+1
		    , x-diff-size, y-diff-size, diff+1, size);
      else
        spiralText( Character.toString( s.charAt(i) ),i+1
		    , x+diff+size, y+diff+size, diff+1, size);
    
    }

  }

/*
  public void onMousePress(Location p){
    int r = (int)(255*Math.random());
    int g = (int)(255*Math.random());
    int b = (int)(255*Math.random());
    theOval.setColor(  new Color(r,g,b) );
  }
*/
}
