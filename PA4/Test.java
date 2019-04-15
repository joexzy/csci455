import java.util.ArrayList;

public class Test{
   public static void main(String[] args){
      
      String test;
      String b;
      test = "aab";
      int size = test.length();
      int[] a = new int[size];
      for(int i = 0; i < size; i++){
         a[i] = 1;
         for(int j = i + 1; j < size; j++){
            if(test.charAt(i) == test.charAt(j)){
               a[i] +=1;
               test = test.substring(0,j) + test.substring(j+1);
               j -= 1;
               size -= 1;
            }
         }
      }
      /**
      System.out.println(test);
      System.out.println(size);
      for(int i = 0; i < size; i++){
         System.out.println(a[i]);
      }
      */
      b = allSubsets(test, a, 0).toString();
      System.out.println(b);
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
            //System.out.println(firstPart + restCombos.get(i));
         }
         firstPart += unique.charAt(k);  // append another instance of 'a' to the first part
      }
      
      return allCombos;
   }
}
