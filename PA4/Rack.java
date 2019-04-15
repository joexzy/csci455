// Name: Ziyi Xu
// USC NetID: ziyix
// CS 455 PA4
// Fall 2018

import java.util.ArrayList;
import java.util.Arrays;

/**
   A Rack of Scrabble tiles
   In this class, you could find all the subsets of a string of letters.
   To do it, you need to transfer the word you get to a unique word(no letter appear more than once) and 
   record the number of the multiplicity of each letter from unique word.
 */

public class Rack {
   /**
      Representation invariant:
      the string the rack refers to must only contains letters(no white-space or any other characters)
   */
   private String rack;//to store the input string 
   private ArrayList<String> subset; //a arrayList to store all the subsets from rack
   private int[] multiplicity;//to store the number of multiplicity of the letters in the unique wor
   private static final int ORI_NUM = 1;//the multiplicity of a letter is at least 1.
   
   /**
      create a rack with given string.
      @param rack the string from input(after removing the characters aren't letters)
      PRE: the string rack refers to must be a word without any white-spaces
   */
   public Rack(String rack){
      this.rack = rack;  
   }
  
   /**
      Firstly, use the method uniqueString() to remove the multi-letters in the rack.
      And then use the method allSubsets to produce all subsets from rack.
      @return a ArrayList that contains all the subsets of rack
   */
   public ArrayList<String> getAllSubsets(){
      uniqueString();
      subset = new ArrayList<String>(allSubsets(rack, multiplicity, 0));
      return subset;
   }
   
   /**
      remove the letters appear more than once and record the number of the multiplicity of each letter from unique word.
      store the number of multiplicity in the array int[] multiplicity.
      the number of ith letter in the rack will be stored in the multiplicity[i].
      PRE: multiplicity.length >= rack.length() >=0
   */
   private void uniqueString(){
      multiplicity = new int[rack.length()];
      for(int i = 0; i < rack.length(); i++){
         multiplicity[i] = ORI_NUM;
         for(int j = i+1; j < rack.length(); j++){
            if(rack.charAt(i) == rack.charAt(j)){
               multiplicity[i] += 1;
               rack = rack.substring(0, j) + rack.substring(j+1);//remove this letter in the rack
               j -= 1;//If you remove the jth letter, the order of next letter will become j. So j= j-1.
            }
         }
      }
   }
               
   /**
      Finds all subsets of the multiset starting at position k in unique and mult.
      unique and mult describe a multiset such that mult[i] is the multiplicity of the char
           unique.charAt(i).
      PRE: mult.length must be at least as big as unique.length()
           0 <= k <= unique.length()
      @param unique a string of unique letters
      @param mult the multiplicity of each letter from unique.  
      @param k the smallest index of unique and mult to consider.
      @return all subsets of the indicated multiset
      @author Claire Bono
    */
   private static ArrayList<String> allSubsets(String unique, int[] mult, int k) {
      ArrayList<String> allCombos = new ArrayList<>();
      
      if (k == unique.length()) {  // multiset is empty
         allCombos.add("");
         return allCombos;
      }
      
      // get all subsets of the multiset without the first unique char
      ArrayList<String> restCombos = allSubsets(unique, mult, k+1);
      
      // prepend all possible numbers of the first char (i.e., the one at position k) 
      // to the front of each string in restCombos.  Suppose that char is 'a'...
      
      String firstPart = "";          // in outer loop firstPart takes on the values: "", "a", "aa", ...
      for (int n = 0; n <= mult[k]; n++) {   
         for (int i = 0; i < restCombos.size(); i++) {  // for each of the subsets 
                                                        // we found in the recursive call
            // create and add a new string with n 'a's in front of that subset
            allCombos.add(firstPart + restCombos.get(i));  
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }

   
}
