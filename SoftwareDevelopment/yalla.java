// Fig. 26.34: PaintPanel.java
// Adapter class used to implement event handlers.
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.security.SecureRandom;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.Timer;



class task extends TimerTask{
	public void run() {
		
	}
	
}


public class yalla extends JPanel 
{
	int xs[] = {55,67,109,73,83,55,27,37,1,43};
	int ys[] = {0,36,36,54,96,72,96,54,36,36};
	
	int secondsPassed = 0;
public static int speed;
	int delay = 5000;
	Timer time;
	
	
	yalla(){
		//time = new Timer(speed, new ActionListener() {
			//public void actionPerformed(ActionEvent e) {
				//repaint();
		//	}
		//});
		//time.start();
	}
	



        //
   // draw ovals in a 4-by-4 bounding box at specified locations on window
   @Override
   public void paintComponent(Graphics g)
   {
      
	   SecureRandom random = new SecureRandom();
	   
	   super.paintComponent(g); // clears drawing area
      g.setColor(Color.blue);
      	Polygon p = new Polygon(xs,ys,10);
      	
      	
        Graphics2D g2d = (Graphics2D) g;
        g2d.fill(p);
       
        
        g2d.translate(150,150);
        g2d.rotate(Math.PI/18);
        g2d.setColor(new Color(random.nextInt(256),random.nextInt(256),random.nextInt(256)));
        g2d.fill(p);
        
        g2d.rotate(Math.PI/18);
        g2d.translate(100,200);
        g2d.setColor(Color.green);
        g2d.fill(p);
        
        g2d.rotate(Math.PI/18);
        g2d.translate(60,60);
        g2d.setColor(Color.yellow);
        g2d.fill(p);
       
        
   } 
} // end class PaintPanel
