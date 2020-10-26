package ex01;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class BorderLayoutEx extends JFrame {

	public BorderLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("보더 레이아운 예제");
		setSize(500, 500);
		
		Container c = getContentPane();
		
		setLayout(new BorderLayout(50, 50));
		c.add(new JButton("NORTH"), BorderLayout.NORTH);
		c.add(new JButton("SOUTH"), BorderLayout.SOUTH);
		c.add(new JButton("WEST"), BorderLayout.WEST);
		c.add(new JButton("EAST"), BorderLayout.EAST);
		c.add(new JButton("CENTER")/*, BorderLayout.CENTER*/);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new BorderLayoutEx();
	}

}
