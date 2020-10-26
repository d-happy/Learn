package ex06;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintColor extends JFrame {
	
	Mypanel panel = new Mypanel(); //Container 1/2 can

	public PaintColor() {
		setTitle("PaintColor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setSize(500, 500);
		setVisible(true);
	}

	class Mypanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int widthG = 200;
			int heightG = 200;
			
			int x = (panel.getWidth()/2) - (widthG/2);
			int y = (panel.getHeight()/2) - (heightG/2);
			//paintComponent() 안에서 해야 크기가 변해도 변한 크기의 가운데를 찾음
			
			g.setColor(Color.green);
			g.fillArc(x, y, widthG, heightG, -30, 120);
			g.setColor(Color.red);
			g.fillArc(x, y, widthG, heightG, 90, 120);
			g.setColor(Color.blue);
			g.fillArc(x, y, widthG, heightG, 210, 120);
			
			int c = panel.getWidth();
			int d = panel.getHeight();
			System.out.println(c + "|" + d);
		}
	}
	
	public static void main(String[] args) {
		new PaintColor();
	}

}//class
