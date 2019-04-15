// Name:Ziyi Xu
// USC NetID:3421876889
// CS 455 PA1
// Fall 2018

/**
    This class tests the CoinTossSimulator class.
*/
public class CoinTossSimulatorTester{
   public static void main (String[] args){
      CoinTossSimulator coinSim = new CoinTossSimulator();
      
      boolean result = true;
      
      coinSim.run (0);
      System.out.println("After constructor:");
      System.out.println("Number of trials [exp:0]: " + (coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()));
      System.out.println("Two-head tosses: " + coinSim.getTwoHeads());
      System.out.println("Two-tail tosses: " + coinSim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + coinSim.getHeadTails());
      System.out.print("Tosses add up correctly? ");
      if ( coinSim.getNumTrials() != coinSim.getTwoHeads() + coinSim.getTwoTails() + coinSim.getHeadTails()){
         result = false;
      }
      System.out.println(result);
      System.out.println();

      coinSim.run (1);
      System.out.println("After run:");
      System.out.println("Number of trials [exp:1]: " + (coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()));
      System.out.println("Two-head tosses: " + coinSim.getTwoHeads());
      System.out.println("Two-tail tosses: " + coinSim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + coinSim.getHeadTails());
      System.out.print("Tosses add up correctly? ");
      if ( coinSim.getNumTrials() != coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()){
         result = false;
      }
      System.out.println(result);
      System.out.println();
      
      coinSim.run (10);
      System.out.println("After run:");
      // Number of trials shows all the trials done before reset.
      System.out.println("Number of trials [exp:11]: " + (coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()));  
      System.out.println("Two-head tosses: " + coinSim.getTwoHeads());
      System.out.println("Two-tail tosses: " + coinSim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + coinSim.getHeadTails());
      System.out.print("Tosses add up correctly? ");
      if ( coinSim.getNumTrials() != coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()){
         result = false;
      }
      System.out.println(result);
      System.out.println();
      
      coinSim.run (100);
      System.out.println("After run:");
      System.out.println("Number of trials [exp:111]: " + (coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()));
      System.out.println("Two-head tosses: " + coinSim.getTwoHeads());
      System.out.println("Two-tail tosses: " + coinSim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + coinSim.getHeadTails());
      System.out.print("Tosses add up correctly? ");
      if ( coinSim.getNumTrials() != coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()){
         result = false;
      }
      System.out.println(result);
      System.out.println();
       
      //Reset the cointosssimulator.
      coinSim.reset();
      
      coinSim.run (0);
      System.out.println("After reset:");
      System.out.println("Number of trials [exp:0]: " + (coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()));
      System.out.println("Two-head tosses: " + coinSim.getTwoHeads());
      System.out.println("Two-tail tosses: " + coinSim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + coinSim.getHeadTails());
      System.out.print("Tosses add up correctly? ");
      if ( coinSim.getNumTrials() != coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()){
         result = false;
      }
      System.out.println(result);
      System.out.println();
      
      coinSim.run (1000);
      System.out.println("After run:");
      System.out.println("Number of trials [exp:1000]: " + (coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()));
      System.out.println("Two-head tosses: " + coinSim.getTwoHeads());
      System.out.println("Two-tail tosses: " + coinSim.getTwoTails());
      System.out.println("One-head one-tail tosses: " + coinSim.getHeadTails());
      System.out.print("Tosses add up correctly? ");
      if ( coinSim.getNumTrials() != coinSim.getTwoHeads()+coinSim.getTwoTails()+coinSim.getHeadTails()){
         result = false;
      }
      System.out.println(result);
      System.out.println();
      
   }
}
