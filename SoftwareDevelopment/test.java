import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


public class test extends JFrame{

	public JButton b= new JButton("Khalas");
	public JButton c;
	public JButton d;
	public JButton e;
	public Panel p;
	public Panel p1;
	public JRadioButton jg;
	public JRadioButton jg2;
	public JRadioButton jg3;
	public ButtonGroup gb;
	public JLabel lb;
	public JComboBox jcomb;
	
	public Timer tt;
	int count=0;
	
	test(){
		
		super("the");
		
		tt= new Timer(100,new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				count++;
				lb.setText("ya"+count);
			}
			
		}
		);
		
		//setLayout(new FlowLayout());
		setVisible(true);
		setSize(600,700);
		p = new Panel();
		p.setBackground(Color.black);
		//p.setBounds(100,100,100,100);
		p1 = new Panel();
		p1.setBackground(Color.green);
		gb= new ButtonGroup();
		lb=new JLabel("Bilafanels");
		jg= new JRadioButton();
		jg2= new JRadioButton();
		jg3= new JRadioButton();
		
		String[] message = {"Message 1","Message 2","Message 3"};
		//jcomb = new JComboBox(message);
		//p.add(jcomb);
		//p1.setBounds(50,50,100,100);
		gb.add(jg);
		gb.add(jg2);
		gb.add(jg3);
		c = new JButton("hayawan");
		d = new JButton("bil");
		e = new JButton("tobes");
		add(p);
		p1.add(jg);
		p1.add(lb);
		p1.add(jg2);
		p1.add(jg3);
		p.setLayout(new GridLayout(1,4,20,20));
		p.add(b);
		p.add(c);
		p.add(d);
		p.add(e);
		add(p1,BorderLayout.LINE_END);
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p.setBackground(Color.white);
			}
			
			}
			
		);
		
		jg.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tt.start();
				
			}
			
		});
		
		jg2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				tt.stop();
				
			}
			
		});
		
	}
	
	
	
	
	public static void main(String[] args) {
		new test();
	}
}
