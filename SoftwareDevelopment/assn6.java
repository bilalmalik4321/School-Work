import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.IndexColorModel;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class assn6 extends JPanel{

	BufferedImage img;
	IndexColorModel TYPE_3BYTE_BGR;
	Graphics2D g2;
	int k=12;
	assn6(){
		repaint();
		
		ImageIcon pic = new ImageIcon(new ImageIcon("C:\\\\Users\\\\bilal\\\\eclipse-workspace\\\\lab3swdev\\\\src\\\\turt.png").getImage().getScaledInstance(120, 100, Image.SCALE_DEFAULT));
		img = new BufferedImage(300,200,BufferedImage.TYPE_3BYTE_BGR);
		g2=(Graphics2D) img.getGraphics();
	}
	
	public void draw() {
		g2.setBackground(Color.BLACK);
		g2.fillRect(0, 0, 300, 200);
	}
	
	
	public void paintComponent(Graphics g){
		g.drawImage(img, 0, 0, null);
	}
}
