// Name: Ziyi Xu
// USC NetID: ziyix
// CS 455 PA4
// Fall 2018

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileNotFoundException;

/**
   A class to find and print out the results from
   input racks with the rule of Scrabble.
   NOTE: this program don't think about a input with a white-space
   E.g. If your input is "abc def", only the "abc" will be used.
   this program is case-sensitive
   this program will ignore any other characters like "@" in the input
*/
public class WordFinder{
   public static void main(String[] args){
      Rack rack;
      String fileName;
      AnagramDictionary dictionary;
      
      //an optional command-line input to choose the dictionary
      //If you don't type anything,we will use the sowpods.txt 
      if(args.length > 0){
         fileName = args[0];
      }
      else{
         fileName = "sowpods.txt";
      }
      
      try{
         dictionary = new AnagramDictionary(fileName);
         System.out.println("Type . to quit.");
         Scanner in = new Scanner(System.in);
         System.out.print("Rack? "); 
         
         while(in.hasNext()){
            String str = in.next();
            if(str.equals(".")){
               break;
            }
            else{
               rack = new Rack(leaveLetter(str));
               WordSorter sorter = new WordSorter(rack, dictionary);
               ArrayList<String> sortedArr = new ArrayList<String>(sorter.wordSort());
               System.out.println("We can make " + sortedArr.size() + " words from \"" + str + "\"");
               if(sortedArr.size() > 0){
                  printScrabble(sortedArr);
               }
            }
         System.out.print("Rack? ");
         }
      }
      catch(FileNotFoundException exception){
         System.out.println("File not found: " + fileName);
      }
     
      
   }
   /**
      process the string given to remove all the 
      non-letter characters.
      @param str a string need to be preprocessed
      @return a string after processing the str
   */
   private static String leaveLetter(String str){
      String strReturn = "";
      for(int i = 0; i < str.length(); i++){
         if(Character.isLetter(str.charAt(i))){
            strReturn = strReturn + str.charAt(i);
         }
      }
      return strReturn;
   }
   
   /**
      get the score of a string
      @param s a string need to give its score
      @return the score of s
      PRE: s only contains letters
   */
   private static int getScore(String s){
      ScoreTable scoreTable = new ScoreTable(s);
      int score = scoreTable.getScore();
      return score;
   }
   
   /**
      A helper function to print out the words in the arraylist
      @param arr a arraylist contains the words need to be printed out
   */
   private static void printScrabble(ArrayList<String> arr){
      System.out.println("All of the words with their scores (sorted by score):");
      for(int i = 0; i < arr.size(); i++){
         int score = getScore(arr.get(i));
         System.out.println(score + ": " + arr.get(i));
      }
   }
      
   
}
           
            
      
      
      