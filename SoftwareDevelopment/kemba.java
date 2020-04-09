import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.*;

public class kemba extends JFrame{
		
	public JTextField jtf;
	public JLabel text;
	
	public kemba() {
		
		super("Lab 6");
		setLayout(new FlowLayout());
		
		text=new JLabel("Input class here:");
		jtf = new JTextField();
		
		add(text,BorderLayout.NORTH);
		add(jtf,BorderLayout.NORTH);
		
	}
	
	public static void main(String args) {
		new kemba();
	}
	
}
