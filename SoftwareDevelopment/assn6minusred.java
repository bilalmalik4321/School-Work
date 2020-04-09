import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class assn6minusred extends JPanel {
	
	BufferedImage imgb;
	BufferedImage imgr;
	BufferedImage imgg;
	Graphics2D g2;
	BufferedImage imersion;
	
	
	assn6minusred(String[] args){
		//super("Assn 6");
		File image = new File("C:\\Users\\bilal\\eclipse-workspace\\Assn6swdev\\src\\pink.jpg");
		
		imersion=null;
		
		setSize(120,200);
		
		//setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setVisible(true);
		
		
		try {
			imersion=ImageIO.read(image);
			imgb= new BufferedImage(imersion.getWidth(),imersion.getHeight(),BufferedImage.TYPE_INT_ARGB);
			imgr= new BufferedImage(imersion.getWidth(),imersion.getHeight(),BufferedImage.TYPE_INT_ARGB);
			imgg= new BufferedImage(imersion.getWidth(),imersion.getHeight(),BufferedImage.TYPE_INT_ARGB);
			
			
			for(int i=0;i<imersion.getWidth();i++) {
				for(int j=0;j<imersion.getHeight();j++) {
					
					Color c = new Color(imersion.getRGB(i, j));
					int r = c.getRed();
					int b = c.getBlue();
					int g = c.getGreen();
					int a = c.getAlpha();
					
					Color bColor= new Color(r,g,0,a);
					imgb.setRGB(i, j, bColor.getRGB());
	

					Color rColor= new Color(0,g,b,a);
					imgr.setRGB(i, j, rColor.getRGB());

					Color gColor= new Color(r,0,b,a);
					imgg.setRGB(i, j, gColor.getRGB());
				}
			}
			System.out.println("He");
			//JLabel picLabel = new JLabel(new ImageIcon(img));
			//add(picLabel);
			ImageIO.write(imgb, "jpg",new File("C:\\\\Users\\\\bilal\\\\eclipse-workspace\\\\Assn6swdev\\\\src\\\\pink-blue.jpg") );
			ImageIO.write(imgr, "jpg",new File("C:\\\\Users\\\\bilal\\\\eclipse-workspace\\\\Assn6swdev\\\\src\\\\pink-red.jpg") );
			ImageIO.write(imgg, "jpg",new File("C:\\\\Users\\\\bilal\\\\eclipse-workspace\\\\Assn6swdev\\\\src\\\\pink-green.jpg") );
			
			
			
			}
		
		catch(IOException e){
			e.printStackTrace();
		}
		
		
		//g2= (Graphics2D) imgb.getGraphics();
		setBounds(150,50,imgb.getWidth(),imgb.getHeight());
		//setBounds(50,50,imgb.getWidth(),imgb.getHeight());
		
		
		//img= new BufferedImage(300,200,BufferedImage.TYPE_INT_RGB);
		
		//g2.drawImage(img, null, defaultCloseOperation, defaultCloseOperation);
	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.drawImage(imgr, 0,0,this);
		
	}
	
	
	public void start() {
		draw();
	}
	
	public void draw() {
		
	}
	
	
	public static void main(String[] args) {
		new assn6minusred(args);
	}

}
