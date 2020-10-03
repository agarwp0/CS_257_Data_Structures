/*
 * Pravesh Agarwal
 * 257: HW1
 * January 31, 2020
 * File taken from package edu.stanford.cs/javacs2/ch6
 * My edit: Replaced BufferedReader & FileReader with Scanner
 * Replaced other print with Sopf
 *
 * File: ReverseFile.java
 * ----------------------
 * This program displays the lines of an input file in reverse order.
 */


import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReverseFile {

   public void run() {
      Scanner sysin = new Scanner(System.in);
      System.out.printf("\nInput File Name\n");
      try {
         Scanner fileScan = new Scanner(new File(sysin.next() ) );
         ArrayList<String> lines = readEntireFile(fileScan);
         fileScan.close();
         for (int i = lines.size() - 1; i >= 0; i--) {
            System.out.printf("\n%s\n",lines.get(i));
         }
      } 
      catch (FileNotFoundException x) {
        System.out.printf("File not found, please locate and try again");
      }
   }

/* Reads the entire contents of a file from a reader into an ArrayList */

   private ArrayList<String> readEntireFile(Scanner fileScan) {
     ArrayList<String> lines = new ArrayList<String>();
       while (fileScan.hasNext()) {
         String line = fileScan.nextLine();
         lines.add(line);
       }
       return lines;
   }


/* Main program */

   public static void main(String[] args) {
      new ReverseFile().run();
   }

}
