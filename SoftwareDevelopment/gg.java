import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.awt.*;
import javax.sound.sampled.*;

public class gg extends JFrame implements ActionListener,MouseListener
{
	Timer timer;
	JPanel picPlace;
	JLabel thepic;
	ImageIcon pic,pic2;
    String status; 
    AudioInputStream audioIn;
    Clip clip;
    String bip = "C:\\Users\\bilal\\eclipse-workspace\\lab4swdev\\I am your father.wav";
	boolean stop=false;
	gg()
	{
		super( "Lab 4 (Try to catch the Cartman)");
		picPlace=new JPanel();
		picPlace.setSize(120,100);
		picPlace.setVisible(true);
		try {
			
			
			audioIn = AudioSystem.getAudioInputStream(new File(bip).getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			
		}
		catch(Exception ex)
		{
			System.out.println("file not found.");
		}
		pic = new ImageIcon(new ImageIcon("C:\\Users\\bilal\\eclipse-workspace\\lab3swdev\\src\\darth-vader.jpg").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		pic2 = new ImageIcon(new ImageIcon("C:\\Users\\bilal\\eclipse-workspace\\lab3swdev\\src\\anakin.jpg").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		thepic=new JLabel(pic);
		thepic.setLocation(0, 0);
		 picPlace.add(thepic);
		add(picPlace);
		timer=new Timer(1000, this);
		setSize( 800, 800 );
		setVisible(true);
		setResizable(false);
		timer.start();
		picPlace.addMouseListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(stop==false) {
		thepic.setLocation(( int ) ( Math.random() * 700 ), ( int ) ( Math.random() * 600 ));
		}
		
	}
	public static void main(String[] args)
	{
		gg o1=new gg();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int x= e.getX();
		int y=e.getY();
		
       
		if(x>=thepic.getX()&&x<=thepic.getX()+120)
		{
			if(y>=thepic.getY()&&y<=thepic.getY()+100)
			{
				clip.loop(Clip.LOOP_CONTINUOUSLY); 
				stop=true;
				thepic.setIcon(pic2);
			}
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		stop=false;
		thepic.setIcon(pic);
		clip.stop();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}