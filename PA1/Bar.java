// Name:Ziyi Xu
// USC NetID:3421876889
// CS 455 PA1
// Fall 2018

// we included the import statements for you
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;


/**
 * Bar class
 * A labeled bar that can serve as a single bar in a bar graph.
 * The text for the label is centered under the bar.
 * 
 * NOTE: we have provided the public interface for this class. Do not change
 * the public interface. You can add private instance variables, constants,
 * and private methods to the class. You will also be completing the
 * implementation of the methods given.
 * 
 */
public class Bar {
   private int xLeft;
   private int labBot;
   private int yTop;                    //The y coordinate of the top left corner
   private int height;
   private int barWidth;
   private double colScale;
   private Color colColor;
   private String colLabel;
   private static final int VER_BUF = 40;      // VER_BUF means vertical buffer.
   private static final int BAR_WIDTH = 80;    // BAR_WIDTH means bar width.
   
   


   /**
      Creates a labeled bar.  You give the height of the bar in application
      units (e.g., population of a particular state), and then a scale for how
      tall to display it on the screen (parameter scale). 
  
      @param bottom  location of the bottom of the label
      @param left  location of the left side of the bar
      @param width  width of the bar (in pixels)
      @param barHeight  height of the bar in application units
      @param scale  how many pixels per application unit
      @param color  the color of the bar
      @param label  the label at the bottom of the bar
   */
   public Bar(int bottom, int left, int width, int barHeight,
              double scale, Color color, String label) {
      xLeft = left;
      labBot = bottom;
      barWidth = width;
      colScale = scale;
      colColor = color;
      colLabel = label;
      
      height = (int) (barHeight * colScale);               // To compute the actual height of the bar.
      yTop = VER_BUF + (int) ((100 - barHeight) * colScale);    // To compute the the y coordinate of the top left corner of a bar.
   }
   
   /**
      Draw the labeled bar. 
      @param g2  the graphics context
   */
   public void draw(Graphics2D g2) {
      Rectangle body = new Rectangle( xLeft, yTop, barWidth, height);      
      g2.draw(body);
      
      String labelWidHi = colLabel;
      Font font = g2.getFont();
      FontRenderContext context = g2.getFontRenderContext();
      Rectangle2D labelBounds = font.getStringBounds(labelWidHi, context);
      int widthOfLabel = (int) labelBounds.getWidth();       // To get the width of the label.
      int heightOfLabel = (int) labelBounds.getHeight();     // To get the height of the label.
      
      int labLeft = xLeft + (BAR_WIDTH / 2) - ( widthOfLabel / 2);     // To make the label centered of with the label.
      
      g2.drawString(colLabel, labLeft, labBot);
      g2.setColor(colColor);
      g2.fill(body);  
      g2.setColor(Color.BLACK);                            // Reset the color to make the label be black.
      
      
      

   }
}
