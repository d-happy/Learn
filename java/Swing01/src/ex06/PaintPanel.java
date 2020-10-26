package ex06;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintPanel extends JFrame {
	
	MyPanel panel = new MyPanel();

	public PaintPanel() {
		setTitle("그리기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(10, 10, 100, 100);
			g.setColor(Color.blue);
			g.drawRect(10, 110, 100, 100);
			g.setColor(Color.red);
			g.drawOval(10, 220, 100, 80);
			g.setColor(Color.green);
			g.fillRect(120, 110, 100, 100);
			g.setColor(Color.red);
			g.drawArc(120, 220, 100, 100, 0, 90);
			g.fillArc(230, 220, 100, 100, 30, 30);
		}
	}

	public static void main(String[] args) {
		new PaintPanel();
	}

}//class
