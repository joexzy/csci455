// Name:Ziyi Xu
// USC NetID:3421876889
// CS 455 PA1
// Fall 2018

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.lang.Math;
import java.util.Scanner;
import java.awt.Color;


/**
    This component draws three bars and their labels to show the percent of the trials.
*/

public class CoinSimComponent extends JComponent{ 
   
   private int numTwoHeads;
   private int numTwoTails;
   private int numHeadTails;
   private int numTrials;
   private static final int BAR_WIDTH = 80;    // BAR_WIDTH means bar width.
   private static final int VER_BUF = 40;    // VER_BUF means vertical buffer.
   
   /**
       Creates a component. You give the number of two heads sitution, two tails sitution, head and tail sitution and the number of the whole trials.
       
       @param numOfTwoHeads number of two heads sitution in the simulator
       @param numOfTwoTails number of two tails sitution in the simulator
       @param numOfHeadTails number of a head and a tail sitution in the simulator
       @param numOfTrials number of the whole trials in the simulator
   */
   public CoinSimComponent (int numOfTwoHeads, int numOfTwoTails, int numOfHeadTails, int numOfTrials){
      numTwoHeads = numOfTwoHeads;
      numTwoTails = numOfTwoTails;
      numHeadTails = numOfHeadTails;
      numTrials = numOfTrials;
   }
   
   public void paintComponent (Graphics g){
      Graphics2D g2 = (Graphics2D) g;    
      
      //Compute the percent of each situation in total trials and round it to one percent.
      int twoHeadsPer = (int) Math.round((numTwoHeads * 1.0 / numTrials) * 100);
      int twoTailsPer = (int) Math.round((numTwoTails * 1.0 / numTrials) * 100);
      int headTailsPer = (int) Math.round((numHeadTails * 1.0 /numTrials) * 100);
      
      // The height of a bar equals barhight multiply scale. One scale shows the piexls one percent occupied. So barheight equals the percent of the trial here.
      int barHeightTwoHeads = twoHeadsPer;
      int barHeightTwoTails = twoTailsPer;
      int barHeightHeadTails = headTailsPer;
      
      String labelTwoHeads = "Two Heads:" + numTwoHeads + "(" + twoHeadsPer + "%)";
      
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(labelTwoHeads, context);
      int widthOfLabelTwoHeads = (int) labelBounds.getWidth();       //Get the width of the label.
      int heightOfLabelTwoHeads = (int) labelBounds.getHeight();     //Get the height of the label.
      
      String labelTwoTails = "Two Tails:" + numTwoTails + "(" + twoTailsPer + "%)";
      String labelHeadTails = "A Head and a Tail:" + numHeadTails + "(" + headTailsPer + "%)";
      
      double scale = (getHeight() - 2* VER_BUF - heightOfLabelTwoHeads) / 100.0;   //Compute the scale.
      
      int w = (getWidth() - 3 * BAR_WIDTH) / 4 ;            // w means the width between each bar, and the end bars and each side of the window.
      int bottom = getHeight() - VER_BUF ;
      
      Bar bar1 = new Bar(bottom, w, BAR_WIDTH, barHeightTwoHeads, scale, Color.RED, labelTwoHeads);
      Bar bar2 = new Bar(bottom, (BAR_WIDTH + 2 * w), BAR_WIDTH, barHeightHeadTails, scale, Color.GREEN, labelHeadTails);
      Bar bar3 = new Bar(bottom, (2 * BAR_WIDTH + 3 * w), BAR_WIDTH, barHeightTwoTails, scale, Color.BLUE, labelTwoTails);
      
      bar1.draw(g2);
      bar2.draw(g2);
      bar3.draw(g2);
      
   }
}
    