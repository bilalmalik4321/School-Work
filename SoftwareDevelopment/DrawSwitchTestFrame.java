import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class DrawSwitchTestFrame extends JPanel {
    int mx,sx,my,sy;//variables for mouse
    int opt = 1;//variable for options
    public DrawSwitchTestFrame(){
        setBackground(Color.YELLOW);//background color
        setBounds(100, 100,300,300);//setting bounds
        addMouseListener(new MouseAdapter() {//Mouse listener
            public void mousePressed(MouseEvent m){//mouse pressed
                mx = m.getX();
                my = m.getY();
                repaint();
            }
            public void mouseReleased(MouseEvent m) {//mouse released
                sx = m.getX();
                sy = m.getY();
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {//mouse motion listener
            public void mouseDragged(MouseEvent m) {//mouse dragged
                sx = m.getX();
                sy = m.getY();
                repaint();
            }
        });
    }
   
    public void paint(Graphics g) {
    		super.paint(g);
            g.drawOval(Math.min(mx, sx), Math.min(my, sy), Math.abs(mx - sx), Math.abs(my- sy));

    }
}