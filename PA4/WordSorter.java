// Name: Ziyi Xu
// USC NetID: ziyix
// CS 455 PA4
// Fall 2018

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Collections;

/**
   create a wordsorter to find all the results in the given dictionary 
   of a input in the game and sort the results by their scores. If the scores 
   of two words are the same. they will be sorted by alphabetical order.
   In this class, you can use method get all the words in the given dictionary
   from the input of a rack. And you can also use a method to sort them.
*/
public class WordSorter{
   /**
      representaion invariant:
      the string rack refers to must only contain letters（no white-spaces or any other characters)
   */
   private Rack rack;// the input rack(after removing non-letter characters)
   private AnagramDictionary dictionary;//the dictionary need to be preprocessed
   private ArrayList<String> word = new ArrayList<>(); //a arraylist to store results with a order in the rule
   private static final int WORD_LENGTH = 2;// the length of a word in dictionary must be at least 2
   
   /**
      create a wordsorter by a Rack and a AnagramDictionary.
      PRE: the string rack refers to must only contain letters（no white-spaces or any other characters)
   */
   public WordSorter(Rack rack, AnagramDictionary dictionary){     
      this.rack = rack;
      this.dictionary = dictionary;            
   }
   
   /**  
      get all the words from rack
      and then sort the words by score first and then with alphabetical order
      return@ a ArrayList contains all the words derive from rack in the rule 
      of Scrabble sorted.
   */
   public ArrayList<String> wordSort(){
      getWords();
      Collections.sort(word, new WordComparator());
      return word;
   }
      
   
   /**
      get all the words from rack by  the rule of Scrabble
      Firstly, find all the subsets of rack.
      Next, to each subset, find its whole anagrams in the dictionary given.
      Finally, put them into the ArrayList word.
   */
   private void getWords(){
      ArrayList<String> subsets = new ArrayList<String>(rack.getAllSubsets());
      
      for(int i = 0; i < subsets.size(); i++){
         if(subsets.get(i).length() >= WORD_LENGTH){ //the length of a word in dictionary must be at least 2
            ArrayList<String> anagram = new ArrayList<String>(dictionary.getAnagramsOf(subsets.get(i)));
            if(anagram.size() > 0){
               for(int j = 0; j <anagram.size(); j++){
                  word.add(anagram.get(j));
               }
            }
         }
      }
   }

}

/**
   create a new comparator implents Comparator.
   With this, you can compare the words by their scores.
   And the word with a higher score will be in the front.
   If two words have the same score, they will be sorted
   by alphabetical order.
*/
class WordComparator implements Comparator<String>{
   
   /**
      compare a and b with their scores.the word with a higher score 
      will be in the front. If a and b have the same score, 
      they will be sorted by alphabetical order.
      @param a a string compared with b
      @param b a string compared with a
      @return a negative number when score of b > score of a; a positive number 
      when score of a > score of b
      when score of a = score of b
      return a negative number when a is in front of b in alphabet, otherwise a positive number
      PRE: a.equals(b) = false
   */
   public int compare (String a, String b){
      ScoreTable tableOfA= new ScoreTable(a);
      ScoreTable tableOfB= new ScoreTable(b);
      int scoreOfA = tableOfA.getScore();
      int scoreOfB = tableOfB.getScore();
      
      if(scoreOfA != scoreOfB){
         return scoreOfB - scoreOfA;
      }
      else{
         return a.compareTo(b);
      }
   }
}
      
      
      
   
   
   