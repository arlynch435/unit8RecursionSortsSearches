//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Line2D;

public class TreePanel extends JPanel
{
   private final int PANEL_WIDTH = 400;
   private final int PANEL_HEIGHT = 800;

   private final double FL=1/1.2;
   private double THETA=30;
   private Line2D.Double trunk;
   private double LINITIAL=50;

   private int current; //current order

   //-----------------------------------------------------------------
   //  Sets the initial fractal order to the value specified.
   //-----------------------------------------------------------------
   public TreePanel (int currentOrder)
   {
      current = currentOrder;
      setBackground (Color.black);
      setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
      trunk=new Line2D.Double(PANEL_WIDTH/2,PANEL_HEIGHT,PANEL_WIDTH/2,PANEL_HEIGHT-LINITIAL);
   }
   public void setTheta(double newTheta)
   {
       THETA=newTheta;
    }
    public void setLInitial(double newLInitial)
   {
       LINITIAL=newLInitial;
    }

   //-----------------------------------------------------------------
   //  Draws the fractal recursively. Base case is an order of 1 for
   //  which a simple straight line is drawn. Otherwise three
   //  intermediate points are computed, and each line segment is
   //  drawn as a fractal.
   //-----------------------------------------------------------------
   public void drawFractal (int order, double x1, double y1, double lastTheta, double lastLength,
                            Graphics page)
   {
       Graphics2D page2= (Graphics2D) page;
       double newThetaLeft= lastTheta+THETA;
       double newThetaRight= lastTheta-THETA;
       double newLength=lastLength*FL;
       double xL2=x1-newLength*Math.sin(Math.toRadians(newThetaLeft));
       double yL2=y1-newLength*Math.cos(Math.toRadians(newThetaLeft));
       double xR2=x1-newLength*Math.sin(Math.toRadians(newThetaRight));
       double yR2=y1-newLength*Math.cos(Math.toRadians(newThetaRight));
       Line2D.Double left,right;
       if (order==1)
       {
           left=new Line2D.Double(x1,y1,xL2,yL2);
           right = new Line2D.Double(x1,y1,xR2,yR2);
           page.setColor(Color.green);
           page2.draw(left);
           page.setColor(Color.blue);
           page2.draw(right);
        }
        else
        {
           drawFractal(order-1,xL2,yL2,newThetaLeft,newLength,page);
           drawFractal(order-1,xR2,yR2,newThetaRight,newLength,page);
           left=new Line2D.Double(x1,y1,xL2,yL2);
           right = new Line2D.Double(x1,y1,xR2,yR2);
           page.setColor(Color.green);
           page2.draw(left);
           page.setColor(Color.blue);
           page2.draw(right);
        }
   }

   //-----------------------------------------------------------------
   //  Performs the initial calls to the drawFractal method.
   //-----------------------------------------------------------------
   public void paintComponent (Graphics page)
   {
       Graphics2D page2= (Graphics2D) page;
       super.paintComponent (page);

      page.setColor (Color.green);
      trunk=new Line2D.Double(PANEL_WIDTH/2,PANEL_HEIGHT,PANEL_WIDTH/2,PANEL_HEIGHT-LINITIAL);
      page2.draw(trunk);
      drawFractal (current, PANEL_WIDTH/2, PANEL_HEIGHT-LINITIAL, 0, LINITIAL, page);
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
