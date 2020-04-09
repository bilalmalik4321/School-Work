import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Ellipse2D.Float;
import java.util.concurrent.locks.*;
import javax.swing.*;

public class pan extends JPanel implements ActionListener{
	
	JCheckBox b1,b2,b3;
	JPanel pan2 ;
	float y1 = 0,y2 = 150,y3 = 294;
	boolean yf1,yf2,yf3;
	Thread t1,t2,t3;
	Lock lock = new ReentrantLock();
	Condition cond1 = lock.newCondition(); 
	Condition cond2 = lock.newCondition();
	Condition cond3 = lock.newCondition();
	
	
	public pan() {
		
		setBackground(Color.white);
		setLayout(new BorderLayout());
		
		
		buttonCreator();
		
		pan2 = new JPanel();
		pan2.setLayout(new GridLayout(1,3));
		pan2.add(b1);
		pan2.add(b2);
		pan2.add(b3);
		
		add(pan2,BorderLayout.SOUTH);
		
		
		t1 = new Thread(new Runnable() {
			public void run(){
				while(true) {
					lock.lock();
					if(b1.isSelected())
						try { cond1.await(); } catch (InterruptedException e) {}
					
					yf1 = (y1==0) ? false : (y1 >= 294) ? true : yf1;
					y1 = yf1 ? y1-1: y1+1; 
					
					repaint();
					lock.unlock();
					try { Thread.sleep(10); } catch (InterruptedException e) {}
					
				}
			}
		});
		
		t2 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					lock.lock();
					if(b2.isSelected()) 
						try { cond2.await(); } catch (InterruptedException e) {}
					
					yf2 = (y2==0) ? false : (y2 >= 294) ? true : yf2;
					y2 = yf2 ? y2-1: y2+1; 
					
					
					repaint();
					lock.unlock();
					try { Thread.sleep(10); } catch(InterruptedException e) {}
				}
			}
		});
		
		t3 = new Thread(new Runnable() {
			public void run() {
				while(true) {
					lock.lock();
					if(b3.isSelected()) 
						try { cond3.await(); } catch (InterruptedException e) {}
					
					yf3 = (y3==0) ? false : (y3 >= 294) ? true : yf3;
					y3 = yf3 ? y3-1: y3+1; 
					
					
					repaint();
					lock.unlock();
					try { Thread.sleep(10); } catch(InterruptedException e) {}
				}
			}
		});
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.draw(new Ellipse2D.Float(10.0f , y1 , 60.0f, 60.0f));
		g2d.draw(new Ellipse2D.Float(105.0f , y2, 60.0f, 60.0f));
		g2d.draw(new Ellipse2D.Float(200.0f , y3, 60.0f, 60.0f));
		
		repaint();

		
	}
	
	
	public void actionPerformed(ActionEvent e) {
		
		if(!b1.isSelected()) {
			lock.lock();
			cond1.signal();
			lock.unlock();
		}
		
		
		if(!b2.isSelected()) {
			lock.lock();
			cond2.signal();
			lock.unlock();
		}
		
		if(!b3.isSelected()) {
			lock.lock();
			cond3.signal();
			lock.unlock();
			
		}
		
	}
	
	private void buttonCreator() {
		
		b1 = new JCheckBox("Suspended");
		b2 = new JCheckBox("Suspended");
		b3 = new JCheckBox("Suspended");
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		
		
	}
	
}
