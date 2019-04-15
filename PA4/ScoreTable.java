// Name: Ziyi Xu
// USC NetID: ziyix
// CS 455 PA4
// Fall 2018
import java.util.Arrays;

/**
   A scoretable that stores the score of each letter. You can use it to 
   get the score of a word.
   Note: In this program, a and A has the same score. So all the letters will
   be transferred to lower case first and then to find its score.
*/
public class ScoreTable{
   
   /**
      representation invariant:
      the string word refers to must only contain letters（no white-spaces or any other characters)
      the size of SCORE must be 26
   */
   private String word;//the word to get its score
   //it stores the scores of 26 letter and the elements are sorted by the letter it refers to with alphabetical order
   private static final int[] SCORE = {1, 3, 3, 2, 1, 4, 2, 4, 1, 8, 5, 1, 3, 1, 1, 3, 10, 1, 1, 1, 1, 4, 4, 8, 4, 10} ;
   
   /**
      creat a scoretable with the string word. 
      All the letter with upper case in the string will be transferredto lower case.
      @param word the string which is waiting for being given a score
   */
   public ScoreTable(String word){
      this.word = word.toLowerCase();
   }
   
   /**
      get the score of the string(word) given
      @return the score of word
   */
   public int getScore(){
      int sum = 0;
      for(int i = 0; i < word.length(); i++){
         sum += letterScore(word.charAt(i));
      }
      return sum;
      
   }
   
   /**
      to give score for a single letter
      @param c the single character(letter) waiting for being given a score
      @return the score of c
   */
   private static int letterScore(char c){
      int letterNum = c - 'a';  //use it to find the position of this letter in the array int[]SCORE
      return SCORE[letterNum];
      
   }
}
   
   
   
   