// Fig. 26.34: PaintPanel.java
// Adapter class used to implement event handlers.
import java.awt.Point;
import java.awt.Shape;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import javafx.scene.shape.Line;

public class main extends JPanel 
{

   // list Point references
   private final ArrayList<Point> points = new ArrayList<Point>(); 
   private final ArrayList<Line> arrows = new ArrayList<Line>(); 
   JPopupMenu pmenu =new JPopupMenu();
   JMenuItem clear = new JMenuItem("Clear"); 
   	JButton jm = new JButton("delete node");
   	JButton a = new JButton("add edge");
   	JButton b = new JButton("add node");
   	JButton c = new JButton("delete edge");
   	JPanel conpan = new JPanel();
   	
   	static int k = 0;
   // set up GUI and register mouse event handler
   public main()
   {
	   conpan.setLayout(new GridLayout(1,3));
	   conpan.add(a);
	   conpan.add(b);
	   conpan.add(c);
	   conpan.add(jm);
	   add(conpan);
      // handle frame mouse motion event
      
	   
	   a.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			k = 1;
			
		}
		   
	   });
	   
	   b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k = 0;
				
			}
			   
		   });
	   
	   
	   c.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k = 2;
				
			}
			   
		   });
	   
	   jm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				k = 3;
				
			}
			   
		   });
	   
	   
	   
	   
	   
	   
	   
	   addMouseListener(
         new MouseAdapter() // anonymous inner class
         {  
            // store drag coordinates and repaint
            @Override
            public void mousePressed(MouseEvent event)
            {
               
               if(event.getButton() == MouseEvent.BUTTON1)  {
            	   if(k==0) {
            	   points.add(event.getPoint());
            	   }
            	   if(k==1) {
            		   Line line = new Line();
            		   line.setStartX(event.getX());
            		   line.setStartX(event.getY());
            		   line.setEndX(event.getX()+10);
            		   line.setEndY(event.getY()+10);
            		   
            		  arrows.add(10,line);
            	   }
               }
               // repaint JFrame
               repaint();
            } 
            
            public void mouseReleased(MouseEvent e)
            {
               for(Point point : points) {
            	if(e.getButton() == MouseEvent.BUTTON3 && (e.getX()==point.x || e.getX()<(point.x+20) || e.getY()<(point.y+20) || e.getY()==point.y))            		
            		   pmenu.show(e.getComponent(), e.getX(),e.getY());
               }
            } 
         } 
      ); 
   
   pmenu.add(clear);
   clear.addActionListener(
		   new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   
						   points.clear();
						   repaint();
					   }

				   
				   
			   }
		   
		   
		   );
   
   }

   // draw ovals in a 4-by-4 bounding box at specified locations on window
   @Override
   public void paintComponent(Graphics g)
   {
	  super.paintComponent(g); // clears drawing area 
	   
	   Graphics2D g2 = (Graphics2D) g;
	   

      // draw all 
      for (Point point : points)
    	  g2.fill(new Ellipse2D.Double(point.x,point.y,20,20));
      

      for (Line line : arrows)
    	  g.drawLine((int)line.getStartX(),(int)line.getStartY(), (int)line.getEndX(), (int)line.getEndY());
      
   } 
} // end class PaintPanel

