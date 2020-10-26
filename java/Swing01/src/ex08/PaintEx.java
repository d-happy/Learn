package ex08;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ex06.PaintPanel;

@SuppressWarnings("serial")
public class PaintEx extends JFrame {
	
	PaintPanel pnlPaint = new PaintPanel();
	int startX = 0;
	int startY = 0;
	int stopX = 0;
	int stopY = 0;

	public PaintEx() {
		setTitle("PaintEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(pnlPaint);
		
		pnlPaint.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
		});
		
		pnlPaint.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
//				startX = stopX;
//				startY = stopY;
				stopX = e.getX();
				stopY = e.getY();
				pnlPaint.repaint();
			}
		});
		
		setSize(500, 500);
		setVisible(true);
	}
	
	class PaintPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawLine(startX, startY, stopX, stopY);
		}
	}//PaintPanel

	public static void main(String[] args) {
		new PaintEx();
	}

}//class
