//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 400;

   private final double FL=1/3;
   private final double THETA=30;

   private final int TOPX = 200, TOPY = 20;

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
   }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (int order, int x1, int y1, double lastTheta, double lastLength,
                            Graphics page)
   {
       double newThetaLeft= lastTheta+THETA;
       double newThetaRight= lastTheta-THETA;
       double newLength=lastLength*FL;
       double xL2=newLength*Math.sin(newThetaLeft);
       double yL2=newLength*Math.cos(newThetaLeft);
       double xR2=newLength*Math.sin(newThetaRight);
       double yR2=newLength*Math.cos(newThetaRight);
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
      super.paintComponent (page);
// 
//       page.setColor (Color.green);
// 
//       drawFractal (current, TOPX, TOPY, LEFTX, LEFTY, page);
//       drawFractal (current, LEFTX, LEFTY, RIGHTX, RIGHTY, page);
//       drawFractal (current, RIGHTX, RIGHTY, TOPX, TOPY, page);
   }

   //-----------------------------------------------------------------
   //  Sets the fractal order to the value specified.
   //-----------------------------------------------------------------
   public void setOrder (int order)
   {
      current = order;
   }

   //-----------------------------------------------------------------
   //  Returns the current order.
   //-----------------------------------------------------------------
   public int getOrder ()
   {
      return current;
   }
}
