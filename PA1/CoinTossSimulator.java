// Name:Ziyi Xu
// USC NetID:3421876889
// CS 455 PA1
// Fall 2018

import java.util.Random;

/**
 * class CoinTossSimulator
 * 
 * Simulates trials of repeatedly tossing two coins and allows the user to access the
 * cumulative results.
 * 
 * NOTE: we have provided the public interface for this class.  Do not change
 * the public interface.  You can add private instance variables, constants, 
 * and private methods to the class.  You will also be completing the 
 * implementation of the methods given. 
 * 
 * Invariant: getNumTrials() = getTwoHeads() + getTwoTails() + getHeadTails()
 * 
 */
public class CoinTossSimulator {
   private int twoHeadsNum;
   private int twoTailsNum;
   private int headTailsNum;
   private int trialsNum;

   /**
      Creates a coin toss simulator with no trials done yet.
   */
   public CoinTossSimulator() {
      twoHeadsNum = 0;
      twoTailsNum = 0;
      headTailsNum = 0;
      trialsNum = 0;
      }

   /**
      Runs the simulation for numTrials more trials. Multiple calls to this method
      without a reset() between them *add* these trials to the current simulation.
      
      @param numTrials  number of trials to for simulation; must be >= 1
    */
   public void run(int numTrials) {
      trialsNum = trialsNum + numTrials;
      Random rand = new Random();
      for (int i = 1; i <= numTrials; i++){
         int toss1 = rand.nextInt(2);     //Get a random number of 1 or 0.
         int toss2 = rand.nextInt(2); 
         
         // Suppose 1 represents the head of a coin and 0 represents the tail of a coin.
         if (toss1 == 1 && toss2 == 1){     
            twoHeadsNum ++;  
      }
         else if (toss1 == 0 && toss2 == 0){
            twoTailsNum ++;
         }
         else {
            headTailsNum ++;
         }
      }
   }


   /**
      Get number of trials performed since last reset.
   */
   public int getNumTrials() {
       return trialsNum; 
   }


   /**
      Get number of trials that came up two heads since last reset.
   */
   public int getTwoHeads() {
       return twoHeadsNum; 
   }


   /**
     Get number of trials that came up two tails since last reset.
   */  
   public int getTwoTails() {
       return twoTailsNum; 
   }


   /**
     Get number of trials that came up one head and one tail since last reset.
   */
   public int getHeadTails() {
       return headTailsNum; 
   }


   /**
      Resets the simulation, so that subsequent runs start from 0 trials done.
    */
   public void reset() {
      twoHeadsNum = 0;
      twoTailsNum = 0;
      headTailsNum = 0;
      trialsNum = 0;
   }

}
