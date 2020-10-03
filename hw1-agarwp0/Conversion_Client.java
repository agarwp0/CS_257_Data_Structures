/* Pravesh Agarwal
 * 257: HW1
 * January 31, 2020
 * Client that reads values from a file, and stores it in an ArrayList
 * and Stack. The values are then printed in two files in decimal, hexadecimal
 * , octal and binary.
 *
 */


import java.io.File;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;


public class Conversion_Client{

  public static void main(String[] args) throws FileNotFoundException{
    // Setting up command line scanner and file scanner
    Scanner scan = new Scanner(System.in);
    Scanner fileScan = null;
    System.out.printf("\nEnter the file name with Integer values:\n");
    try{
      fileScan = new Scanner(new File(scan.next() )  );

    }
    catch(FileNotFoundException ea){
      System.out.printf("\nFile not found, using default file num.txt\n");
      try{
        fileScan = new Scanner(new File("num.txt")  );
      }
      catch(FileNotFoundException f){
        System.exit(-1);
      }
    
    }

    // Creating an ArrayList and inserting values from a file
    
    ArrayList<Integer> numAL = new ArrayList<Integer>(3);
    Stack<Integer> numStk = new Stack<Integer>();
    while(fileScan.hasNext()){
      int num =fileScan.nextInt(); 
      numAL.add(num);
      numStk.push(num);
    }
    // Calling method to write values to a file in 4 fundamental bases
    writeToFile("outAL.txt", numAL); 
    writeToFile("outStk.txt", numStk); 
  }



  public static void writeToFile(String s, ArrayList<Integer> i){
    
    // Setting up print stream to a file
    try{
      File outputFile = new File(s);
      FileOutputStream fout = new FileOutputStream(outputFile);
      PrintStream out = new PrintStream(fout);
    
      // Printing to the file
      out.printf(" Decimal   Hexadecimal   Octal   Binary \n\n");
    
      for(Integer n: i){
        out.printf(" %7s   %11s   %5s   %6s \n",Integer.toString(n, 10 )
  		                               ,Integer.toString(n, 16 )
		                               ,Integer.toString(n, 8  )
		                               ,Integer.toString(n, 2  )
	                                       ); 
      }
    }
    catch(IOException eb){
      System.out.printf("\n\n Problem encountered creating/writing the file");
    }
  }

  public static void writeToFile(String s, Stack<Integer> i){
    
    // Setting up print stream to a file
    try{
      File outputFile = new File(s);
      FileOutputStream fout = new FileOutputStream(outputFile);
      PrintStream out = new PrintStream(fout);
    
      // Printing to the file
      out.printf(" Decimal   Hexadecimal   Octal   Binary \n\n");
    
      while(!i.isEmpty()){
	int n = i.pop();
        out.printf(" %7s   %11s   %5s   %6s \n",Integer.toString(n, 10 )
  		                               ,Integer.toString(n, 16 )
		                               ,Integer.toString(n, 8  )
		                               ,Integer.toString(n, 2  )
	                                       ); 
      }
    }
    catch(IOException eb){
      System.out.printf("\n\n Problem encountered creating/writing the file");
    }
  }


}
