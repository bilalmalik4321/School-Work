import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class PaintPanel extends JFrame {
    private DrawSwitchTest Dpanel = new DrawSwitchTest();
    private DrawSwitchTestFrame fr = new DrawSwitchTestFrame();
    
    private JPanel BPanel = new JPanel();//background panel
    //private JFrame frame = new JFrame();//Initializing a Jframe
    PaintPanel(){
    //Container contentPane = getContentPane();
    	
    	JLayeredPane layeredPane = getLayeredPane();
    	//frame.setVisible(true);
    	//layeredPane.setPreferredSize(new Dimension(1000,1000));
    	Dpanel.setPreferredSize(new Dimension(800,800));
    	fr.setPreferredSize(new Dimension(450,450));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adding it to the frame
     layeredPane.add(Dpanel, new Integer(2));
     layeredPane.add(fr, new Integer(1));
        //frame.setLayout(null);
     //frame.setLayout(null);
        //contentPane.add(Dpanel);
       
       // frame.add(Dpanel);
       
        Dpanel.add(fr);
     //layeredPane.add(Dpanel, new Integer(1));
     Dpanel.setVisible(true);
     //layeredPane.add(fr, new Integer(2));
     fr.setVisible(true);
       // LayeredPane lp = new LayeredPane();
        
     //frame.setVisible(true);
       // frame.setSize(1000, 1000);
        
        setVisible(true);
        setSize(1000, 1000);
    }
}
