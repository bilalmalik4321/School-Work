package lab1swdev;

import javax.swing.*;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ButtonFrame extends JFrame{

	private final JLabel label1;
	private final JLabel label2;
	private final JLabel label3;
	
	public ButtonFrame(){
		
		super("Testing JLabel");
		setLayout(new FlowLayout());
		
		label1 = new JLabel("Label with text");
		label1.setToolTipText("This is label1");
		add(label1);
		
		Icon sum = new ImageIcon(getClass().getResource("summer.jpeg"));
		label2 = new JLabel("Label with text and icon",sum,SwingConstants.LEFT);
		label2.setToolTipText("This is label2");
		add(label2);
		
		label3 = new JLabel();
		label3.setText("Label with icon and text at bottom");
		label3.setIcon(sum);
		label3.setHorizontalTextPosition(SwingConstants.CENTER);
		label3.setVerticalTextPosition(SwingConstants.BOTTOM);
		label3.setToolTipText("This is label3");
		add(label3);
		
	}
	
	/*private class ButtonHandler implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(ButtonFrame.this, String.format(
					"You pressed: %s", event.getActionCommand()));
		}
		
	}*/
	
	
}
