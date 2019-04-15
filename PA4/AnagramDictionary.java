// Name: Ziyi Xu
// USC NetID: ziyix
// CS 455 PA4
// Fall 2018

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;


/**
   A dictionary of all anagram sets. 
   Note: the processing is case-sensitive; so if the dictionary has all lower
   case words, you will likely want any string you test to have all lower case
   letters too, and likewise if the dictionary words are all upper case.
 */

public class AnagramDictionary {
   //to store anagrams, the key is the canonical form(formde by alphabetical order) and the value is a ArratList 
   //which store the anagrams of the canonical form.
   private Map<String, ArrayList<String>> dictionary = new HashMap<>();
   /**
      Create an anagram dictionary from the list of words given in the file
      indicated by fileName.  
      PRE: The strings in the file are unique.
      @param fileName  the name of the file to read from
      @throws FileNotFoundException  if the file is not found
    */
   public AnagramDictionary(String fileName) throws FileNotFoundException {
      File inFile = new File(fileName);
      Scanner in = new Scanner(inFile);//read the file
      
      while(in.hasNext()){
         String str = in.next();
         String strForm = canonicalForm(str);//the canonical form of the input string
         ArrayList<String> arrList;
         if(dictionary.get(strForm) == null){
            arrList = new ArrayList<>();//If you cannot find the strForm, the hashmap will return a null. So we make arrList a empty ArrayList
         }
         else{
            arrList = new ArrayList<>(dictionary.get(strForm));
         }
         arrList.add(str);
         dictionary.put(strForm, arrList);//update the dictionary
      }
   }
   

   /**
      Get all anagrams of the given string. This method is case-sensitive.
      E.g. "CARE" and "race" would not be recognized as anagrams.
      @param s string to process
      @return a list of the anagrams of s
    */
   public ArrayList<String> getAnagramsOf(String s) {
      String strForm = canonicalForm(s);
      if(dictionary.get(strForm) == null){
         return new ArrayList<String>();
      }
      else{         
         return dictionary.get(strForm);
      }
   }
   
   /**
      to make a string become its canonical form with alphabetical order
      E.g. "cba" to "abc"
      @param str string to process
      @return the canonical form of str
   */
   private static String canonicalForm(String str){
      String[] s = new String[str.length()];
      for(int i = 0; i < s.length; i++){
         s[i] = "" + str.charAt(i);
      }
      
      Arrays.sort(s);
      
      String strReturn = "";
      
      for(int i = 0; i < s.length; i++){
         strReturn += s[i];
      }
      
      return strReturn;
   }
         
      
      
   
   
}
