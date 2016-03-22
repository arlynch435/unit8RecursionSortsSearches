//********************************************************************
//  KochSnowflakeViewer.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of recursion.
//  @gcschmit (19 July 2014): converted from an applet to an application
//********************************************************************

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TreeViewer implements ActionListener, ChangeListener
{
    private final int WIDTH = 900;
    private final int HEIGHT = 1000;

    private final int MIN = 1, MAX = 18;

    private JButton increase, decrease;
    private JLabel titleLabel, orderLabel,angleLabel,trunkLabel;
    private TreePanel drawing;
    private JPanel panel, tools;
    private JFrame frame;
    private JSlider angle;
    private JSlider trunkLength;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }

    public TreeViewer()
    {
        tools = new JPanel ();
        tools.setLayout (new BoxLayout(tools, BoxLayout.X_AXIS));
        tools.setBackground (Color.yellow);
        tools.setOpaque (true);

        titleLabel = new JLabel ("The Fractal Tree");
        titleLabel.setForeground (Color.black);

        increase = new JButton (new ImageIcon ("increase.gif"));
        increase.setPressedIcon (new ImageIcon ("increasePressed.gif"));
        increase.setMargin (new Insets (0, 0, 0, 0));
        increase.addActionListener (this);
        decrease = new JButton (new ImageIcon ("decrease.gif"));
        decrease.setPressedIcon (new ImageIcon ("decreasePressed.gif"));
        decrease.setMargin (new Insets (0, 0, 0, 0));
        decrease.addActionListener (this);
        angle = new JSlider (0,90,30);
        angle.addChangeListener (this);
        trunkLength = new JSlider (0,250,50);
        trunkLength.addChangeListener (this);

        orderLabel = new JLabel ("Order: 1");
        orderLabel.setForeground (Color.black);
        angleLabel = new JLabel ("Angle: 30");
        angleLabel.setForeground (Color.black);
        trunkLabel = new JLabel ("Trunk Length: 50");
        trunkLabel.setForeground (Color.black);

        tools.add (titleLabel);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (decrease);
        tools.add (increase);
        tools.add (Box.createHorizontalStrut (20));
        tools.add (orderLabel);
        tools.add(angle);
        tools.add (angleLabel);
        tools.add(trunkLength);
        tools.add (trunkLabel);

        drawing = new TreePanel (1);

        panel = new JPanel();
        panel.add (tools);
        panel.add (drawing);

        frame = new JFrame();
        frame.setTitle("Fractal Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

    //-----------------------------------------------------------------
    //  Determines which button was pushed, and sets the new order
    //  if it is in range.
    //-----------------------------------------------------------------
    public void stateChanged(ChangeEvent event)
    {
        JSlider slider=(JSlider) event.getSource();
        double value=(double) slider.getValue();
        if (slider==angle)
        {
            angleLabel.setText ("Angle: " + value);
            drawing.setTheta (value);
            frame.repaint();
        }
        else if (slider==trunkLength)
        {
            trunkLabel.setText ("Trunk Length: " + value);
            drawing.setLInitial (value);
            frame.repaint();
        }
    }
    public void actionPerformed (ActionEvent event)
    {
        int order = drawing.getOrder();

        if (event.getSource() == increase)
            order++;
        else
            order--;

        if (order >= MIN && order <= MAX)
        {
            orderLabel.setText ("Order: " + order);
            drawing.setOrder (order);
            frame.repaint();
        }
    }
}
