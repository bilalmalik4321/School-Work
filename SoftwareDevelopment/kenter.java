import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.event.*;

public class kenter extends JPanel{
	
	static int k=0;
	static int h=0;
	static int l=0;
	
	JSlider slider1;
	JSlider slider2;
	JSlider slider3;
	
	public kenter() {
		slider1 = new JSlider(JSlider.HORIZONTAL,0,255,0);
		slider2 = new JSlider(JSlider.HORIZONTAL,0,255,0);
		slider3 = new JSlider(JSlider.HORIZONTAL,0,255,0);
		
		slider1.setMajorTickSpacing(30);
		slider2.setMajorTickSpacing(30);
		slider3.setMajorTickSpacing(30);
		
		slider1.setPaintTicks(true);
		slider2.setPaintTicks(true);
		slider3.setPaintTicks(true);
		
		add(slider1);
		add(slider2);
		add(slider3);
		event e = new event();
		slider1.addChangeListener(e);
		slider2.addChangeListener(e);
		slider3.addChangeListener(e);
		
		
	}
	
	public class event implements ChangeListener{
		public void stateChanged(ChangeEvent e) {
			Color c=new Color (k, h, l);
			if(e.getSource()==slider1) {
				k = slider1.getValue();
				setBackground(c);
			}
			
			else if(e.getSource()==slider2) {
				h = slider2.getValue();
				setBackground(c);
			}
			
			else if (e.getSource()==slider3){
				l = slider2.getValue();
				setBackground(c);
			}
		}
	}
}
