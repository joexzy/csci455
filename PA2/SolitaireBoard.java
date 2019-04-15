// Name: Ziyi Xu
// USC NetID: ziyix
// CSCI455 PA2
// Fall 2018

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/*
  class SolitaireBoard
  The board for Bulgarian Solitaire.  You can change what the total number of cards is for the game
  by changing NUM_FINAL_PILES, below.  Don't change CARD_TOTAL directly, because there are only some values
  for CARD_TOTAL that result in a game that terminates.
  (See comments below next to named constant declarations for more details on this.)
*/


public class SolitaireBoard {
   
   public static final int NUM_FINAL_PILES = 9;
   // number of piles in a final configuration
   // (note: if NUM_FINAL_PILES is 9, then CARD_TOTAL below will be 45)
   
   public static final int CARD_TOTAL = NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2;
   // bulgarian solitaire only terminates if CARD_TOTAL is a triangular number.
   // see: http://en.wikipedia.org/wiki/Bulgarian_solitaire for more details
   // the above formula is the closed form for 1 + 2 + 3 + . . . + NUM_FINAL_PILES
   
   private static final int SIGNAL = 1;
   // a signal to suggest that a certain number of piles has appeared.

   // Note to students: you may not use an ArrayList -- see assgt description for details.
   
   
   /**
      Representation invariant:
      Sum of all cards should equals to CARD_TOTAL(NUM_FINAL_PILES * (NUM_FINAL_PILES + 1) / 2).
      The number of cards each pile contains must be between 0(exclusive) and CARD_TOTAL(inclusive). It must be a integer as well.
      If the currentSize > 0, you can find the piles of cards in the location [0, currentSize - 1] in the array. And you can find the nth 
      piles of cards in the position of (n-1) in the array.
   */
   
   // <add instance variables here>
   
   /**
     Create the array to store the number of each piles. Each element in the array means a pile. Through the precodition, each element should be 
     a positive integer, so the largest number of elements is equal to CARD_TOTAL.
   */
   private int[] piles = new int[CARD_TOTAL];   
   private int currentSize = 0;    // Initial a variable to record the size of the partially filled array.
  
 
   /**
      Creates a solitaire board with the configuration specified in piles.
      piles has the number of cards in the first pile, then the number of cards in the second pile, etc.
      PRE: piles contains a sequence of positive numbers that sum to SolitaireBoard.CARD_TOTAL
   */
   public SolitaireBoard(ArrayList<Integer> piles) {
      
      // To copy the elements in the ArrayList piles to the partially filled array piles.
      for (int i = 0; i < piles.size(); i++) {
         this.piles[i] = piles.get(i);
         currentSize++;  // Update the size of partially filled array piles. 
      }

      assert isValidSolitaireBoard();   // sample assert statement (you will be adding more of these calls)
   }
 
   
   /**
      Creates a solitaire board with a random initial configuration.
   */
   public SolitaireBoard() {
      
      int tester = 0; // A tester to test whether the creation of the solitaire board is finished. When tester = CARD_TOTAL, it is finished.
      Random generator = new Random();
      int i = 0;     // Use i to record the order of elements in the array.
      while (tester < CARD_TOTAL) {
         int creator = 1 + generator.nextInt(CARD_TOTAL - tester);   // Creator stores the integer from one to the remaining of the CARD_TOTAL. 
         piles[i] = creator;
         tester = tester + creator;       // Update the tester.
         currentSize++;              //Update the size of partially filled array piles.
         i++;
      }  
      assert isValidSolitaireBoard();   //Assert statement
   }
  
   
   /**
      Plays one round of Bulgarian solitaire.  Updates the configuration according to the rules
      of Bulgarian solitaire: Takes one card from each pile, and puts them all together in a new pile.
      The old piles that are left will be in the same relative order as before, 
      and the new pile will be at the end.
   */
   public void playRound() {
      
      /**
         Because of the rule of the Bulgarian Solitaire above, the size of the partially filled array before one turn equals to the
         number of new pile.
      */
      int newPile = currentSize;  
      
      for (int i = 0; i < currentSize; i++) {
         piles[i] = piles[i] - 1;  // Update the number of old piles. Take one card from each pile.
      }
      
      /**
         After one turn, use the loop below to remove the zero piles. Use the i to find all the positive piles after one turn.
         And then use j to record the positive elements into the array.
      */
      int j = 0;
      for (int i = 0; i < currentSize; i++) {
         if (piles[i] != 0) {
            piles[j] = piles [i];
            j = j + 1;
         }
      }
      currentSize = j + 1;   // Update the size of partially filled array piles.
      
      piles[currentSize - 1] = newPile;  // Add the new pile number into the array.
      
      assert isValidSolitaireBoard();   //Assert statement


   }
   
   /**
      Returns true iff the current board is at the end of the game.  That is, there are NUM_FINAL_PILES
      piles that are of sizes 1, 2, 3, . . . , NUM_FINAL_PILES, in any order.
   */
   
   public boolean isDone() {
      
      /**
         Because this is a boolean method and it will return true or flase, so I add the assert statement at the beginning
         of isDone() method. This method won't modify the array piles.
      */
      assert isValidSolitaireBoard(); 
      
      /**
         Create a new array pilesNum to test whether the process of Bulgarian Solitaire is done. When there is a element x in 
         the array piles, update the element in the order of x-1 to SIGNAL in the array pilesNum. If all the elements in pilesNum from
         0 to （Num_FINAL_PILES - 1） are 1, it means the process is finished. 
      */
      int[] pilesNum = new int[CARD_TOTAL];
      
      for (int i = 0; i < currentSize; i++) {
         pilesNum[piles[i]-1] = SIGNAL;
      }
      
      for (int i = 0; i < NUM_FINAL_PILES; i++) {
         if (pilesNum[i] != SIGNAL) {
            return false;
         }
      }
      return true;
   }           
   
   
   /**
      Returns current board configuration as a string with the format of
      a space-separated list of numbers with no leading or trailing spaces.
      The numbers represent the number of cards in each non-empty pile.
   */
   public String configString() {
      
      String pilesString = piles[0] + "";  //Transfer the integer into a string.
      
      for (int i = 1; i < currentSize; i++) {
         String pilesAdd = piles[i] + "";
         pilesString = pilesString + " " + pilesAdd;
      }
      
      assert isValidSolitaireBoard();     //Assert statement

      return pilesString;  
   }
   
   
   /**
      Returns true iff the solitaire board data is in a valid state
      (See representation invariant comment for more details.)
   */
   private boolean isValidSolitaireBoard() {
      
      boolean pilesSum = false;
      boolean eachPiles = false;
      
      // Compute the sum of the number of piles.
      int sum = 0;
      for (int i = 0; i < currentSize; i++) {
         sum = sum + piles[i];
      }
      
      if (sum == CARD_TOTAL) {
         pilesSum = true;
      }
      
      for (int i = 0; i < currentSize; i++) {
         if ( piles[i] <= 0 || piles[i] > CARD_TOTAL) {
            return false;
         }
      }
      
      eachPiles = true;
      
      return (pilesSum && eachPiles);  

   }
   
}
