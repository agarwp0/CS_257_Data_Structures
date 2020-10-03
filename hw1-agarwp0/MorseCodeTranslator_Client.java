/* Pravesh Agarwal
 * 257: HW1
 * January 31, 2020
 * Morse Code Translator that translates characters into morsecode and vise-versa.
 * Assuming:
 * Any characters other tahn A-Z will be ignored.
 * Each sequence of morse code will be separated by space
 * Lack of encoding for space
 * Ends the program when user enters a black line
 */



import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;


public class MorseCodeTranslator_Client{
  
  public static void main(String[] args){
    // Setting up command line  Scanner and file scanner
    Scanner scan = new Scanner(System.in);
    Scanner fileScan = null; 
    try{
      fileScan = new Scanner (new File("morsetable.txt"));
    }
    catch(FileNotFoundException e){
      System.out.printf("\nFile 'morsetable' not found, please locate and"
		        + "try again\n");
      System.exit(-1);
    }

    // Getting values from the file into a map collection
    Map<Character,String> codeEM = new HashMap<Character,String>();
    Map<String,Character> codeME = new HashMap<String,Character>();
    
    while(fileScan.hasNext() ){
      char eng = fileScan.next().charAt(0);
      String morse = fileScan.next();
      codeEM.put(eng, morse.trim());
      codeME.put(morse.trim(), eng);
    }

    // Instructions and getting user input
    System.out.printf("\nMorse Code Translator!"
		     +"\n======================"
                     +"\nAssuming:"
                     +"\n Any characters other tahn A-Z will be ignored."
                     +"\n Each sequence of morse code will be separated by"
		     +  " space"
                     +"\n Lack of encoding for space"
                     +"\n Ends the program when user enters a black line"
		     +"\n-----------------------------------------------\n");

    // Calling method to give the converted form
    while( true ){
      
      String s = scan.nextLine();
      
      if ( s.trim().isEmpty() ){
        break;
      }

      s = s.trim();
      s = s + " ";

      String result = ( Character.isLetter(s.charAt(0))  ) 
	              ? englishToMorse(codeEM, s.toUpperCase()) 
		      : morseToEnglish(codeME, s.toUpperCase());

      // Print out the final result 
      System.out.printf("\n%s\n", result);
    }  
  
  
  }
	
  // Method that translates characters to morse code
  public static String englishToMorse(Map<Character,String> eM, String s)  {
    String result = "";
    for(int i=0; i<s.length(); i++){
     char x = s.charAt(i);
      if (eM.containsKey(x)){
        result += eM.get(x);
	result += " ";
      }
    }
    return result;
  }

  // Method that translates morse code to characters
  public static String morseToEnglish(Map<String, Character> mE, String s)  {
    String result = "";
    int space1 = 0, space2 = 0;

    while(space2<s.length()-1 ){
      space2  = s.indexOf(" ", space1+1);
      String subS= s.substring(space1, space2);
      if ( mE.containsKey(subS.trim()) ){
        result += String.valueOf(  mE.get( subS.trim() )  );
      }
      space1 = space2 ;
    }

    return result;
  }


}
