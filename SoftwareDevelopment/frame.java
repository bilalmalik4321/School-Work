import javax.swing.*;

public class frame extends JFrame{

	public frame() {
		kickStarter ks =new kickStarter();
	}

	private void kickStarter() {

		setTitle("A9 part B");
		setSize(350,350);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		pan peter = new pan();
		add(peter);

	}

	public static void main(String[] args) {

		frame f1=new frame();


	}



}
