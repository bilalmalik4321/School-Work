package lab1swdev;

import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest {
	
	private JFrame f;
	private JPanel p;
	private JButton b1;
	private JLabel lab;
	private JFrame f1;
	private JPanel p1;
	private JButton b2;
	private JLabel lab1;
	
	public ButtonTest() {
		
		gui();
	}
	
	public void gui() {
		f = new JFrame("Lab 1");
		f.setVisible(true);
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		p = new JPanel();
		p.setBackground(Color.gray);
		
		b1 = new JButton("Press button to make child");
	
		p.add(b1);
		
		f.add(p);
		
		b1.addActionListener(new k());
		
	}
	
	public void colorgui() {
		f1 = new JFrame("Lab 1 child");
		f1.setVisible(true);
		f1.setSize(600,400);
		
		p1 = new JPanel();
		p1.setBackground(Color.gray);
		
		b2 = new JButton("Press button to change color");
	
		p1.add(b2);
		
		f1.add(p1);
		
		b2.addActionListener(new s());
		
	}
	
	public static void main(String[] args) {
	
		new ButtonTest();
		
	}
	
	public class k implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			colorgui();
		}
	}
	
	public class s implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Color c = new Color ((int) (Math.random()*256), (int) (Math.random()*256), (int) (Math.random()*256));
			p.setBackground(c);
			
		}
	}
}	

