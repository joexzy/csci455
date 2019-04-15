// Name:Ziyi Xu
// USC NetID:3421876889
// CS 455 PA1
// Fall 2018

import javax.swing.JFrame;
import java.util.Scanner;

/**
    Construct a frame, add the component and make the frame visible to the users.
*/
public class CoinSimViewer{
   public static void main(String[] args){
      JFrame frame = new JFrame(); 

      frame.setSize(800, 500);
      frame.setTitle("CoinSim");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      Scanner in = new Scanner (System.in);
      System.out.print("Enter number of trials: ");
      int trialsNum = in.nextInt();
      // Check whether the input is positive.
      while (trialsNum <= 0){ 
         System.out.println("ERROR: Number entered must be greater than 0.");
         in = new Scanner(System.in);
         System.out.print("Enter number of trials: ");
         trialsNum = in.nextInt();
      }

      CoinTossSimulator coinSim = new CoinTossSimulator();
      coinSim.run(trialsNum);
      
      CoinSimComponent component = new CoinSimComponent((coinSim.getTwoHeads()), (coinSim.getTwoTails()), (coinSim.getHeadTails()), (coinSim.getNumTrials()));
      frame.add(component);

      frame.setVisible(true);
   }
}