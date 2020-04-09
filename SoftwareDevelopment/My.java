import java.lang.reflect.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.*;
public class My {
    public static void main(String args[]) {
      MyF frame = new MyF();
      frame.setSize(500,500);
      frame.setVisible(true);
    }
}
class MyF extends JFrame {
    JLabel name;
    JTextField nameField;
    JFrame jfKennedy;
    JButton refresh;
    JPanel kenPan;
    ArrayList List = new ArrayList();
    JTextField tf=new JTextField();
    
    
    public MyF() {
    	jfKennedy = new JFrame("Refresh panel");
    	jfKennedy.setSize(500,600);
    	jfKennedy.setVisible(true);
    	jfKennedy.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	refresh=new JButton("Refresh");
    	setLayout(new FlowLayout());
    	kenPan=new JPanel();
    	kenPan.add(refresh);
    	jfKennedy.add(kenPan);
    	tf.setSize(20, 100);
    	kenPan.add(tf);
    	
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
                        
                        Field[] Fields=cls.getFields();
                        
                        for(int i =0;i<Fields.length;i++) {
                        	
                        	//Fields[i].get(l);
                        	JTextField[] jtf ;
                        	System.out.println(Fields[i]);
                        	
                        	if(Fields[i].getName().contains("container")) {
                        		
                        		Object l = Fields[i].get(cls);
                        	
                        		System.out.println(l+" ***");
                        		//tf.setText(l.toString());
                        	}
                        }

                        displayPanel.setBounds(50,50,350,400);
                        pane.add(displayPanel,new Integer(2));
                        
                        int classModifier = cls.getModifiers();
                        if(Modifier.isPublic(classModifier)) {
                        	Method[] classMethods = cls.getMethods();
                        	
                        	for(Method method : classMethods) {
                        		System.out.println("Method Name: "+method.getName()+"\n");
                        		
                        		if(method.getName().startsWith("get")) {
                        			System.out.println("Getter Method");
                        			Class<?> dobe = method.getReturnType();
                        			Object l=method.getDefaultValue();
                        			
                        			
                        			//tf.setText((String) l);
                        			
                        		}
                        		else if(method.getName().startsWith("set")) {
                        			System.out.println("Setter Method");
                        		}
                        		System.out.println("Return type: "+ method.getReturnType());
                        		
                        		
                        		Class[] parameterType = method.getParameterTypes();
                        		System.out.println("Parameter: ");
                        		
                        		for(Class parameter : parameterType) {
                        			
                        			System.out.println(parameter.getName());
                        			
                        		}
                        		System.out.println();
                        	}
                        	
                        	
                        }
                        else {
                        	System.out.println("Class can't be accessed");
                        }
                        
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