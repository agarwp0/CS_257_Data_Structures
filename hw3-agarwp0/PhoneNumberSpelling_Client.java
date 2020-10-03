/* Pravesh Agarwal
 * 257 HW3 - agarwp0
 * Feb 22, Sat, 2020
 * Pg 371 Q12
 * File: PhoneNumberSpelling_Client
 * Generates all the posible letter combinations to a given number,
 * represented as a string of digits.
 */


import java.util.Scanner;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;

public class PhoneNumberSpelling_Client{

  public static void main(String[] args){
   
    // Getting mnemonics from text file and storing it in mnemonics, a TreeMap 
    Scanner fileScan = null;
    try{
      fileScan = new Scanner(  new File("mnemonics.txt")  );
    }
    catch(FileNotFoundException e){
      System.out.printf("File not found!! Please locate and try again.");
    }

    TreeMap<String, String> mnemonics = new TreeMap<String, String>();
    while( fileScan.hasNext() ){
      mnemonics.put( fileScan.next(), fileScan.next() );
    }

    fileScan.close();


    // Giving instructions
    System.out.printf("\n-------Phone Number Spelling Program------------"+
                      "\nGenerates all possible letter combinations to a "+
		      "\ngiven number represented as a string of digits  "+
		      "\nPuts a . in place of 0 and 1 since they don't   "+
		      "\nhave any characters.                            "+
		      "\n----------------------------------------------\n");
    System.out.printf("\nEnter a phone number: \n"); 

    // setting up scanner to get input from user.
    Scanner scan = new Scanner(System.in);
    String phoneNo = scan.nextLine();

    // Getting equivalent mnemonic from the user input
    // to pass as parameter to method listMnomonics
    ArrayList<String> digitAlphabets = new ArrayList<String>();
    for(int i = 0; i < phoneNo.length(); i++){
        digitAlphabets.add(  mnemonics.get(  
			     Character.toString( phoneNo.charAt(i) )  )
			  );
    }

    // Calling to recursive method listMnemonics and printing the result
    System.out.printf("\nPossible letter combination of that prefix: \n");
    for(  String s : listMnemonics(digitAlphabets)  ){
      System.out.printf("%s\n",s);
    }

  }



  // Recursive method that generates the mnemonics from a list of strings
  // in the same prefex and to the same number of combinations as the 
  // number of strings
  // Eg: ABC DEF would give AD AE Af BD BE BF CD CE CF

  public static TreeSet<String> listMnemonics(ArrayList<String> strings){
    TreeSet<String> result = new TreeSet<String>();

    if( strings.isEmpty() ){
      result.add("");
    }
    else{
      String str = strings.get(0);
      ArrayList<String> rest = new ArrayList<String>();

      for ( String s: strings){
	rest.add(s);
      }
      rest.remove(0);
      
      for(int i = 0; i < str.length(); i++){
        char ch = str.charAt(i);
        for ( String s : listMnemonics(rest) ){
          result.add(ch + s);
	  System.out.printf("adding %s + %s = %s\n",ch, s, ch+s);
	}
      }
    }
    return result;
  }
  
}
