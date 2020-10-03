/* Pravesh Agarwal
 * Program : GradeCalculator_Client.java
 * Lack of Time; Cannot implement reading and writing to files and making a database
 * improvising
 * Calculates 
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;


public class GradeCalculator_Client{

  // All the nodes in the client where each node contains data
  // a student's scores in a class
  ArrayList<GradeNode> allNodes = new ArrayList<GradeNode>();


  public static void main(String[] node){

  // Load all the existing data into nodes
  // load("Id.txt");

  //Scanner input = new Scanner(System.in);

  GradeNode tom = new GradeNode("Tom Anderson");
  tom.addHW(90);
  tom.addHW(80);
  tom.addHW(85);
  tom.addHW(95);

  tom.addQuiz(95);
  tom.addQuiz(80);
  tom.addQuiz(75);
  tom.addQuiz(85);

  tom.partScore = 89;
  tom.fExam = 92;
  tom.mExam = 91;

  instructions();
  System.out.printf("\nYour total score = %f", avgTotal(tom) );
  System.out.printf("\n\n");

  }

  // Method to calculate the avegare score
  public static double avgTotal(GradeNode node){
    double hwTotal   = 0;
    double quizTotal = 0;
    double T         = 0;
    for( Double n : node.hWork ){
      hwTotal+=n;
    }
    for( Double n : node.quiz ){
      quizTotal+=n;
    }

    T = hwTotal/node.hWork.size()   +
	quizTotal/ node.quiz.size() +
        node.fExam +
	node.mExam +
	node.partScore;

    return T/5;
  }

  // Instructions
  public static void instructions(){
    System.out.printf("\n--------------------------------------------------\n"
                     +"\n4.0      A       100–93 (Exceptional work)          "
                     +"\n3.7      A-      92–90                              "
                     +"\n3.3      B+      89–87 (More than adequate work)    "
                     +"\n3.0      B       86–83                              "
                     +"\n2.7      B-      82–80                              "
                     +"\n2.3      C+      79–77 (Adequate work)              "
                     +"\n2.0      C       76–73 (Less than adequate)         "
                     +"\n1.7      C-      72–70                              "
                     +"\n1.3      D+      69–67 (Deficient work)             "
                     +"\n1.0      D       66–63                              "
                     +"\n0.7      D-      62–60                              "
                     +"\n0.0      F       59–00 (Failure to accomplish task) " 
                     +"\n----------------------------------------------------");
    System.out.printf("\n\n");
  }


  /*
  // Method to load and save nodes from txt files of the same name
  public static void load(String file){
    try{
      Scanner scan = new Scanner( new File(file) );
      while ( scan.hasNextLine() ){
        save( scan.nextLine() );
      }
      scan.close();
    }
    catch(FileNotFoundException e){
      System.out.printf("\nFile Id.txt not found!"
                       +" Please locate the file and try again");
      System.out.printf("\n\n");
    }
    
  }
  */
  
  /*
  public static void saveNodes(String id){
    try{
      Scanner scan = new Scanner( new File( (id+".txt") ) );
      while (scan.hasNextLine()){
        allNodes.add( new GradeNode( scan.nextLine() ) );

      }
    }
    catch(FileNotFoundException e){
    }
  }
  */


  // Method to construct nodes and save it to a new file
  
  // Format of data in File:
  // ID
  // HW/Assignments scores separated by a space
  // Quiz Scores separated by a space
  // Participation score
  // Midterm Exam Score
  // Final Exam Score
  // 
  public static void writeToFile(){
  
  }


  // Methods to compare the calculated data to give grade
  // Using data from GradingScale.txt file
  // Use nextLine and split(String regex, int limit) method 
  // in string class to parse the data

  public static String Grade(){
  return null; 
  }

}


