//Bilal Malik 104435995
//Software Dev Assignment 5

import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.*;

public class a5 extends JPanel implements Serializable
{

	static JRadioButton add;  
	static JRadioButton delete;  
	static JRadioButton move;  
	static JComboBox option;
	static String modeChoice = "Node";
	static String choice = "add"; 
	static Point head = null; 
	static Point tail = null; 
	static String[] optis = {"Node","Edge"};
	
	boolean pointt1 = false;
	int index;					
	Point move1 = new Point();	
	Point move2 = new Point();
	
	static ArrayList<Line2D> edges = null;
	static ArrayList<Point> nodes = null;
	ArrayList<Integer> eindex = new ArrayList<Integer>();
	ArrayList<Integer> plindex = new ArrayList<Integer>();
	
	int pointIndex;
	Point tempPoint = new Point(-15,15);
	static Color black = Color.BLACK;		
	
	public a5() 
	{
		head = new Point();
		tail = new Point();
		nodes = new ArrayList<Point>();
		edges = new ArrayList<Line2D>();
		theList listener = new theList();
        addMouseListener(listener);
        addMouseMotionListener(listener);
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		JFrame frame = new JFrame("Assignment 5 Software Development"); 
		a5 starter = new a5(); 
		JPanel opts = new JPanel();	
		JLayeredPane panel = new JLayeredPane(); 
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.setSize(1200, 800); 
        frame.setLayout(new BorderLayout());			
        frame.getContentPane().add(panel, BorderLayout.CENTER);	
        
        panel.setBounds(0,0,1200,800); 
        starter.setBackground(Color.white);
        starter.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
        opts.setBounds(0,0,1200,100); 
        starter.setBounds(10,100,1160,600);
		panel.add(starter,0,0);
		panel.add(opts,1,0);
		
		add = new JRadioButton("Add"); 
		add.setActionCommand("add");
		add.setSelected(true);
		delete = new JRadioButton("Delete");
		delete.setActionCommand("del");
		move = new JRadioButton("Move");
		move.setActionCommand("mov");
		
		ButtonGroup buttongroup = new ButtonGroup();
		buttongroup.add(add);
		buttongroup.add(delete);
		buttongroup.add(move);
		JButton saveGraph = new JButton("Save");
		JButton loadGraph = new JButton("Load");
		option = new JComboBox(optis);
		
		option.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox comb = (JComboBox)e.getSource();
				modeChoice = (String) comb.getSelectedItem();
				
				if(modeChoice.equals("Edge")) {
					move.setVisible(false);
				}
				else {
					move.setVisible(true);
				}
				
			}
		});
		
		
		opts.add(add,BorderLayout.SOUTH);
		opts.add(delete,BorderLayout.SOUTH);
		opts.add(move);
		opts.add(option);
		
		opts.add(loadGraph);
		opts.add(saveGraph);
		
		saveGraph.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
		        {    

		            FileOutputStream file = new FileOutputStream("directedGraph.ser"); 
		            ObjectOutputStream out = new ObjectOutputStream(file); 
		            out.writeObject(edges);
		            out.writeObject(nodes); 
		            out.close(); 
		            file.close(); 
		            JPanel in = new JPanel();
	    			JOptionPane.showMessageDialog(in,"Graph has been saved! Press the load button to view your work.");
	    			
		        } 
		        catch(IOException ex) 
		        { 
		        	JPanel out = new JPanel();
	    			JOptionPane.showMessageDialog(out,"Graph could not be saved"); 
		        }
				
			}
		});
		
		
		
		loadGraph.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try
		        {    
		            edges.clear();
		            nodes.clear();
		            black = Color.white;
		            starter.repaint();
					
		            FileInputStream file = new FileInputStream("directedGraph.ser"); 
		            ObjectInputStream input = new ObjectInputStream(file); 
		              
		            
		            edges = (ArrayList<Line2D>)input.readObject();            
		            nodes = (ArrayList<Point>)input.readObject();
		            input.close(); 
		            file.close(); 
		            JPanel in = new JPanel();
		            JOptionPane.showMessageDialog(in,"Graph has been loaded!");
		            black = Color.BLACK;
		            starter.repaint();  
		        }  
				
		        catch(Exception ex) 
		        { 
		        	JPanel in = new JPanel();
	    			JOptionPane.showMessageDialog(in,"Could not Load the save file.");
		        }
			}	
		});
		
		add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice = e.getActionCommand();
				
			}
		});
		
		move.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice = e.getActionCommand();
			}
		});
		
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				choice = e.getActionCommand();
			}
		});
		
		frame.setSize(1200,800);
		frame.setResizable(false);
		frame.setVisible(true);	
	}
	
	class theList extends MouseAdapter{
		popup pu; 
		
		public theList() {
			pu = new popup(); 
		}
		
	    public void mousePressed(MouseEvent e) { 
	    	if(modeChoice.equals("Edge")) {
		    	if(choice.equals("add")) {
		    		if(nodes.size()>0) {
			    		for(Point p: nodes) {
			    			if(p.distance(e.getPoint()) <= 30){
			    				head.setLocation(p.x,p.y);
			    			}
			    		}
		    		}
		    		else {
		    			JPanel p = new JPanel();
		    			JOptionPane.showMessageDialog(p,"Please add a node before adding a edge.");
		    		}
		    	}
		    	else if(choice.equals("mov")){
		    		if(edges.size() == 0) { 
		    			JPanel p = new JPanel();
		    			JOptionPane.showMessageDialog(p,"Please create an edge before attempting to move an edge.");
		    		}
		    		else {
		    			for(Line2D l: edges) {
		    				if(l.ptLineDist(e.getPoint())<= 15) {
		    					index = edges.indexOf(l);
		    					if(l.getP1().distance(e.getPoint()) <= l.getP2().distance(e.getPoint())) {
		    						pointt1 = true;
		    						move1.setLocation(e.getPoint());
		    						move2.setLocation(l.getP2());
		    						head.setLocation(move2);;
		    					}
		    					else {
		    						pointt1 = false;
		    						move1.setLocation(l.getP1());
		    						move2.setLocation(e.getPoint());
		    						head.setLocation(move1);;
		    					}
		    					break;
		    				}
		    			}
		    			repaint();
		    		}
		    	}
	    	}
	    	else {
	    		if(choice.equals("add")) {
	    			tempPoint.setLocation(e.getX(), e.getY());
	    			repaint();
	    		}
	    		else if(choice.equals("mov")) {
	    			if(nodes.size() >= 1) {
		    			for(Point p: nodes) {
		    				if(p.distance(e.getPoint()) <= 10) {
		    					pointIndex = nodes.indexOf(p);
		    					for(Line2D l : edges) {
		    						if(l.ptLineDist(p) <= 10) {
		    							eindex.add(edges.indexOf(l));
		    							if(l.getP1().distance(p)<l.getP2().distance(p)) {
		    								plindex.add(1);
		    							}
		    							else {
		    								plindex.add(2);
		    							}
		    						}
		    					}
		    					break;
		    				}
		    			}
	    			}
	    			else {
	    				JPanel in = new JPanel();
		    			JOptionPane.showMessageDialog(in,"Please add a node before attempting to move.");    				
	    			}
	    		}
	    	}
	    }

	    public void mouseDragged(MouseEvent e) {
	    	if(modeChoice.equals("Edge")) {
		    	if(choice.equals("add")) { 
			    	tail.setLocation(e.getX(),e.getY());
			    	for(Point p: nodes) {
			    		if(p.distance(e.getPoint())<= 30) {
			    			tail.setLocation(p);
			    		}
			    	}
			        repaint();
		    	}
	    	}
	    	else {
	    		if(choice.equals("add")) 
	    		{
	    			tempPoint.setLocation(e.getX(), e.getY());
	    			repaint();
	    		}
	    		else if(choice.equals("mov")) {
	    			nodes.get(pointIndex).setLocation(e.getPoint());
	    			for(Integer i: eindex) {
	    				int dex = eindex.indexOf(i);
	    				if(plindex.get(dex) == 1) {
	    					edges.get(i).setLine(nodes.get(pointIndex), edges.get(i).getP2());
	    					repaint();
	    				}
	    				else if(plindex.get(dex) == 2) {
	    					edges.get(i).setLine(edges.get(i).getP1(), nodes.get(pointIndex));
	    					repaint();
	    				}
	    			}
	    			repaint();
	    		}
	    	}
	    }
	    
	    public void mouseReleased(MouseEvent e) {
	    	if(e.isPopupTrigger()) { 
	    		pu.show(e.getComponent(), e.getX(), e.getY());
	    	}
	    	if(modeChoice.equals("Edge")) {		    	
			    	if(choice.equals("add")) {
			    		for(Point p: nodes) {
				    			if(p.distance(e.getPoint()) <= 30) {
				    				repaint();
				    				edges.add(new Line2D.Double(head,p));
				    			}
				    		}
					        repaint();			    		
			    	}
			    	else if(choice.equals("del")){ 
			    		if(edges.size() == 0) { 
			    			JPanel p = new JPanel();
			    			JOptionPane.showMessageDialog(p,"Create an edge before attempting to delete one.");
			    		}
			    		else {
				    		for(Line2D l: edges) { 
				    			if(l.ptLineDist(e.getPoint()) <= 15) {
				    				edges.remove(l); 
				    				repaint();
				    				break;
				    			}
				    		}
			    		}
			    	}		    	
	    	}
	    	
	    	else {
	    		
	    		if(choice.equals("add")) {
	    			nodes.add(new Point(e.getX(),e.getY()));
	    			tempPoint.setLocation(-50, -50);
	    			repaint();
	    		}
	    		
	    		else if(choice.equals("del")) {
	    			
	    			if(nodes.size()>= 1) {
		    			for(Point p: nodes) {
		    				
		    				if(p.distance(e.getPoint()) <= 15) {
		    					nodes.remove(p);
		    					break;
		    				}
		    			}
		    			ArrayList<Line2D> temp = new ArrayList<Line2D>();
		    			for(Line2D l: edges) {
		    				
	    					if(l.getP1().distance(e.getPoint()) <= 15 || l.getP2().distance(e.getPoint()) <= 15) {
	    						temp.add(l);
	    						
	    					}
		    			}
		    			for(Line2D t: temp) {
		    				edges.remove(t);
		    			}
		    			repaint();
	    			}
	    			
	    			else {
	    				
	    				JPanel p = new JPanel();
		    			JOptionPane.showMessageDialog(p,"There are no nodes at the moment. Please add one first to delete a node.");
	    			}
	    		}
	    		
	    		else {
	    			
	    			eindex.clear();
	    			plindex.clear();
	    		}
	    	}
	    }
	    
	    public void clear(){ 
	    	black = Color.white; 
	    	repaint(); 
	    	nodes.clear();
	    	edges.clear(); 
	    }
	    
	    class popup extends JPopupMenu
	    { 
			popup(){
				JMenuItem clear = new JMenuItem("Clear");
				add(clear);
				clear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) { 
						clear();
					}
				});
			}	
		}
	}
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g; 
		g2d.setColor(black); 
		//if add is selected as well as node
		if(choice.equals("add")&& modeChoice.equals("Node"))
		{
			g2d.fillOval(tempPoint.x -5, tempPoint.y-5, 10, 10);
		}
		//if add is selected as well as edges
		else if(choice.equals("add")&& modeChoice.equals("Edge")) 
		{
			drawArrowLine(g2d,head.x,head.y,tail.x,tail.y,10,5);			
		}
		
		for(Point point: nodes)
		{
			//draw oval to draw all nodes in the nodes array list
			g2d.fillOval(point.x -5, point.y -5, 10, 10);
		}
		
		for(Line2D line: edges) 
		{ 
			//call drawArrowLine to draw all arrows in the egdes array list
			drawArrowLine(g2d,(int)line.getX1(),(int)line.getY1(),(int)line.getX2(),(int)line.getY2(),10,5);
		}
		
		black = Color.BLACK;	
	}
	
	private void drawArrowLine(Graphics g, int x1, int y1, int x2, int y2, int distance, int height) {
	    
		int deltax = x2 - x1, deltay = y2 - y1;
	    double Delta = Math.sqrt(deltax*deltax + deltay*deltay);
	    double xm = Delta - distance, xn = xm, ym = height, yn = -height, x;
	    double sin = deltay / Delta, cos = deltax / Delta;
	    
	    x = xm*cos - ym*sin + x1;
	    ym = xm*sin + ym*cos + y1;
	    xm = x;
	    x = xn*cos - yn*sin + x1;
	    yn = xn*sin + yn*cos + y1;
	    xn = x;
	    //drawing the lines at the head of the arrow
	    int[] xpoints = {x2, (int) xm, (int) xn};
	    int[] ypoints = {y2, (int) ym, (int) yn};
	    //drawing the stem of the arrow
	    g.drawLine(x1, y1, x2, y2);
	    g.fillPolygon(xpoints, ypoints, 3);
	    
	}
}