

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class nore extends JPanel{
	
	private ImageIcon img;
	private JLabel button;
	
	nore(){
		setLayout(new FlowLayout());
		
		img= new ImageIcon(getClass().getResource("darth-vader.jpg"));
		button = new JLabel(img);
		add(button);
	}
}
