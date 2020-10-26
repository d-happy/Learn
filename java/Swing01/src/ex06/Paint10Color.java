package ex06;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Paint10Color extends JFrame{
	
	MyPanel panel = new MyPanel();
	Color[] colors = new Color[10];
	final int perAngle = 360 / colors.length;
	int startAngle = 90;

	public Paint10Color() {
		setTitle("Paint10Color");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(panel);
		setSize(500, 500);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int panelWidth = panel.getWidth();
			int panelHeigth = panel.getHeight();
			int gWidth = 200;
			int gHeigth = 200;
			
			int x = panelWidth/2 - gWidth/2;
			int y = panelHeigth/2 - gHeigth/2;
			
			for (int i=0; i<colors.length; i++) {
				int red = (int)(Math.random()*256); //0~255
				int green = (int)(Math.random()*256);
				int blue = (int)(Math.random()*256);
				
				colors[i] = new Color(red, green, blue);
				
				g.setColor(colors[i]);
				g.fillArc(x, y, gWidth, gHeigth, startAngle, perAngle);
				startAngle += perAngle;
			}
		}
	}//MyPanel

	public static void main(String[] args) {
		new Paint10Color();
	}

}//class
