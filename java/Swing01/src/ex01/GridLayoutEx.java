package ex01;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GridLayoutEx extends JFrame {
	
	public GridLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("그리그 레이아웃 예제");
		setSize(500, 500);
		setLayout(new GridLayout(3, 4, 10, 20)); //(rows, cols, hgap, vgap)
		
		Container c = getContentPane();
		c.setBackground(Color.GREEN);
		
		for (int i=0; i<=10; i++) {
			add(new JButton("버튼"+i));
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutEx();
	}

}
