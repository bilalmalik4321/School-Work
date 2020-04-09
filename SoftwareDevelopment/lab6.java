import java.lang.reflect.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class lab6 {
    public static void main(String args[]) {
      MyF frame = new MyF();
      frame.setSize(500,500);
      frame.setVisible(true);
    }
}
class MyF extends JFrame {
    JLabel name;
    JTextField nameField;
    public MyF() {
        JLayeredPane pane = getLayeredPane();
        JPanel centerPanel = new JPanel();
        centerPanel.setSize(400,400);
        name = new JLabel("Enter the name of the class :");
        nameField = new JTextField(20);
        centerPanel.add(name);
        centerPanel.add(nameField);
        pane.add(centerPanel,new Integer(1));
        nameField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent event) {
                if (event.getKeyCode() == KeyEvent.VK_ENTER) {
                    System.out.println(name);
                    try {
                        Class<?> cls = Class.forName(nameField.getText());
                        System.out.println(cls.getName());
                        JPanel displayPanel = (JPanel)cls.newInstance();
                        displayPanel.setBounds(50,50,350,400);
                        pane.add(displayPanel,new Integer(2));
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}