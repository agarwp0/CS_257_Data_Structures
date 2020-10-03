/* Pravesh Agarwal
 * Program : GradeNode.java
 * A class that constructs nodes containing the data of a individual's 
 * scores in a course 
 *
 *
 *
 */

import java.util.ArrayList;


public class GradeNode{


  // Global Variables
  // Assignments scores, Quizes scores
  ArrayList<Double> hWork = new ArrayList<Double>();	
  ArrayList<Double> quiz = new ArrayList<Double>();
  
  // Scores for Class Participation/ Preparedness, final exam, Midterm, Exam
  double partScore = 0;
  double fExam  = 0;
  double mExam  = 0;
  
  // id of the node associating with the biography of the student
  String id;

  // Constructors
  public GradeNode(String id){
    this.id = id;
  }


  // Methods to Add data in the Node
  public void addHW(double n){
    hWork.add(n);
  }

  public void addQuiz(double n){
    quiz.add(n);
  }


  // Methods to edit data
  public void editHW(int i, double n){
    hWork.remove(i);
    hWork.add(i,n);
  }

  public void editQuiz(int i, double n){
    quiz.remove(i);
    quiz.add(i,n);
  }


  //Methods to delete data
  public void deleteHW( double i){
    hWork.remove(i);
  }

  public void deleteQuiz(double i){
    quiz.remove(i);
  }


}

