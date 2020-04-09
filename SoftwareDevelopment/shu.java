// Fig. 26.35: Painter.java
// Testing PaintPanel.
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shu
{
   public static void main(String[] args)
   { 
      // create JFrame
      JFrame application = new JFrame("Assignment 2");
      
     // conpan.setLayout(new GridLayout(1,3));
      
      main paintPanel = new main(); 
      
      
      
      
      
      application.add(paintPanel, BorderLayout.CENTER); 

      
      // create a label and place it in SOUTH of BorderLayout
      //application.add(new JLabel("Drag the mouse to draw"), 
        // BorderLayout.SOUTH);

      application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      application.setSize(500, 400); 
      application.setVisible(true); 
   } 
} // end class Painter
