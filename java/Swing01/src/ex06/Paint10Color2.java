package ex06;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Paint10Color2 extends JFrame{
	
	MyPanel panel = new MyPanel();
	Color[] colors = new Color[10];
	final int perAngle = 360 / colors.length;
	int startAngle = 90;

	public Paint10Color2() {
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
			
			int panel_Width = panel.getWidth();
			int panel_Heigth = panel.getHeight();
			int gWidth = 200;
			int gHeigth = 200;
			
			int x = panel_Width/2 - gWidth/2;
			int y = panel_Heigth/2 - gHeigth/2;
			
			for (int i=0; i<colors.length; i++) {
				colors[i] = new Color(
						(int)(Math.random()*256), 
						(int)(Math.random()*256), 
						(int)(Math.random()*256));
				g.setColor(colors[i]);
				g.fillArc(x, y, gWidth, gHeigth, startAngle, perAngle);
				startAngle += perAngle;
				
				g.drawLine((10*i), panel_Heigth/2, panel_Width/2, (10*i));
				g.drawLine(panel_Width/2, (10*i), panel_Width - (10*i), panel_Heigth/2);
				g.drawLine((10*i), panel_Heigth/2, panel_Width/2, panel_Heigth - (10*i));
				g.drawLine(panel_Width/2, panel_Heigth - (10*i), panel_Width - (10*i), panel_Heigth/2);
				
				g.setFont(new Font("µ¸À½", Font.BOLD, 30));
				g.drawString("hi", (int)(Math.random()*panel_Width), (int)(Math.random()*panel_Heigth));
			}
		}
	}//MyPanel

	public static void main(String[] args) {
		new Paint10Color2();
	}

}//class
