// Name: Ziyi Xu
// USC NetID: ziyix
// CSCI455 PA2
// Fall 2018

import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

/**
   class BulgarianSolitaireSimulator
   It contains the main method to run the Bulgarian Solitaire game. In the each turn, it will take one card
   from each pile and then put them into the new pile.The old piles that are left will be in the same relative 
   order as before, and the new pile will be at the end.
   It can get the initial configuration by user input or a sequence of randomized numbers.
   It can give you the output immediately or by step after you press the 'Enter'.
*/

public class BulgarianSolitaireSimulator {

   public static void main(String[] args) {
     
      boolean singleStep = false;
      boolean userConfig = false;
      ArrayList<Integer> piles = new ArrayList <Integer>();
      Scanner in = new Scanner(System.in);
      
      SolitaireBoard SolitaireSim;
      
      
      for (int i = 0; i < args.length; i++) {
         if (args[i].equals("-u")) {
            userConfig = true;
         }
         else if (args[i].equals("-s")) {
            singleStep = true;
         }
      }
      
      // When user type -u, the program will get the initial configuration from user input.
      if(userConfig) {
         userMode(in, piles);
         SolitaireSim = new SolitaireBoard(piles);
      }
      else {
         SolitaireSim = new SolitaireBoard();
      }
      
      // Give the user the result of Bulfarian Solitaire. If user types -s, it will be put step by step.
      outputMode(SolitaireSim, in, singleStep);
         
      
   }
   
   /**
      After user types -u, turn into the usermode. The program will give the user a prompt and then
      get the input from user typing to create the object.
      @param userInput a the scanner to get the user input
      @param userPiles a ArrayList to store the initial piles of cards 
   */
   private static void userMode(Scanner userInput, ArrayList<Integer> userPiles) {
      
      System.out.println("Number of total cards is " + SolitaireBoard.CARD_TOTAL);
      System.out.println("You will be entering the initial configuration of the cards (i.e., how many in each pile).");
      System.out.println("Please enter a space-separated list of positive integers followed by newline:");
      
      Scanner input = new Scanner(userInput.nextLine());
      
      while (userPiles.size() == 0){
         errorCheck(input, userPiles);
         
         // If the size of userPiles is 0 after errorcheck, it means the input didn't pass the errorcheck.
         // It will tell user the error and type the input again.
         if (userPiles.size() == 0) {
            errorPrint();
            input = new Scanner(userInput.nextLine());
         }
      }
         
   }
   
   /**
      After get the initial data. This method will help give the output. It will give the result of each turn
      until the process is done. The boolean single could control the output mode. If it is true, the output will
      be made step by step.
      @param outputSim the object to use the isDone() method to see if the process is finished
      @param returnType the scanner to consume 'Enter', which help realize step output
      @param single a signal to determine whether the output shoulb be showed in step
   */
   private static void outputMode(SolitaireBoard outputSim, Scanner returnType, boolean single) {
      
      System.out.print("Initial configuration: ");
      String iniConfi = outputSim.configString();
      System.out.println(iniConfi);
      
      int step = 1;
      
      
      while (!outputSim.isDone()) {
         outputSim.playRound();
         System.out.print("[" + step + "] " + "Current configuration: ");
         String stepOutput = outputSim.configString();
         step++;
         
         if (single) {
            System.out.print(stepOutput);
            returnType.nextLine();   //Only if you press 'Enter', the process will continue.
         }
         else {
            System.out.println(stepOutput);
         }
      }
      
      System.out.println("Done!");
   }
         
         
   /**
      Help check whether your input is valid. If it isn't valid, the ArrayList checkPiles will be cleared
      @param inputTest a scanner to get the positive integer and check whether the input is valid
      @param checkPiles a ArrayList to store valid input as initial piles of cards
   */
   private static void errorCheck(Scanner inputTest, ArrayList<Integer> checkPiles) {
      
      int sum = 0;
      boolean signal = true;
      
      while (inputTest.hasNextInt()) {
         int temp = inputTest.nextInt();
         checkPiles.add(temp);
         sum = sum + temp;
         
         if (temp <= 0) {
            signal = false;
         }
      }
      
      if (inputTest.hasNext() || (sum != SolitaireBoard.CARD_TOTAL) || signal == false) {
         checkPiles.clear();
      }
      
   }
   
   /**
      If the input isn't valid, use this method to give the error information and tell user to give input again.
   */
   private static void errorPrint() {
      
      System.out.println("ERROR: Each pile must have at least one card and the total number of cards must be " + SolitaireBoard.CARD_TOTAL);
      System.out.println("Please enter a space-separated list of positive integers followed by newline:");
   }
      

   // <add private static methods here>

  
}
