/* Pravesh Agarwal
 * HW4 Question 3, Sunday, April 12, 2020
 * There are 3 ways to run program. 1) with no command line argument
 * 2) with one command line argument 3) with two argument. TIAS
 * The argument should be less than 3 non -ve integer. 
 */

public class PrintClient{

  public static void main(String[]args){
    int n, last;
    try{

		  // With no command line argument 
		  if (args.length<1){
		    System.out.printf("\n %10s   %10s   %10s   %10s"
				    , "base10", "binary", "hex(a)", "hex(b)" );
		    for(int i=0; i<12;i++){ 
		      n = i;

		      System.out.printf("\n %10d   %10s   %10x   %10s"
		                      , n
		                      , Integer.toBinaryString(n)
		                      , n
		                      , Integer.toHexString(n).toUpperCase()
		                     );
		    }
		    System.out.printf("\n\n");
		  }

		  // With one command line argument 
		  else if(args.length ==1 & Integer.parseInt(args[0])>=0){
		    n = Integer.parseInt(args[0]);    
		    System.out.printf("\n %10s   %10s   %10s   %10s"
			  	      , "base10", "binary", "hex(a)", "hex(b)" );
		    
		    for(int i=0; i < n+1; i++){ 
		      System.out.printf("\n %10d   %10s   %10x   %10s"
		                        , i
		                        , Integer.toBinaryString(i)
		                        , i
		                        , Integer.toHexString(i).toUpperCase()
		                       );
		    }
		    System.out.printf("\n\n");

		  }

		  // With two command line argument 
		  else if (args.length == 2 &  Integer.parseInt(args[0])>=0
			               & Integer.parseInt(args[1])>=0){
		    
		    n = Integer.parseInt(args[0]);    
		    last = Integer.parseInt(args[1]);    
		    if (n>last){
			int swap = n;
		      n = last;
		last = swap;
		    }

		    System.out.printf("\n %10s   %10s   %10s   %10s"
	 		      , "base10","binary","hex(a)","hex(b)" );

		    for (int i = n; i<last+1; i++){
		      System.out.printf("\n %10d   %10s   %10x   %10s"
		                        , i
		                        , Integer.toBinaryString(i)
		                        , i
		                        , Integer.toHexString(i).toUpperCase()
		                       );
		    }
		    System.out.printf("\n\n");
		  }

		  // Pre-condition
		  else{
		    System.out.printf("\n\tRun with less than 3 non -ve integer argument"
				     + " on command line, pls\n\n");
		  }
    }
		// Skipping around expected exceptions
    catch(ArrayIndexOutOfBoundsException | NumberFormatException e){
      System.out.printf("\n\tRun with less than 3 non -ve integer argument"
		       + " on command line, pls\n\n");
    
    }

  }


}

