package ex08;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintEx2 extends JFrame implements ActionListener {
	
	JMenuItem miLine = new JMenuItem("Line");
	JMenuItem miRect = new JMenuItem("Rect");
	JMenuItem miOval = new JMenuItem("Oval");
	JMenuItem miRed = new JMenuItem("Red");
	JMenuItem miGreen = new JMenuItem("Green");
	JMenuItem miBlue = new JMenuItem("Blue");
	
	PaintPanel pnlPanel = new PaintPanel();
	int startX = 0;
	int startY = 0;
	int stopX = 0;
	int stopY = 0;
	
	int indexFigure = 1;
	int indexColor = 10;
	
	int line = 1;
	int rect = 4;
	int oval = 0;
	int red = 10;
	int green = 20;
	int blue = 30;

	public PaintEx2() {
		setTitle("PaintEx2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(pnlPanel);
		
		pnlPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
		});
		
		pnlPanel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				stopX = e.getX();
				stopY = e.getY();
				pnlPanel.repaint();
			}
		});
		
		setMenu();
		
		setSize(500, 500);
		setVisible(true);
	}

	private void setMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu mnnFigure = new JMenu("Figure");
		JMenu mnnColor = new JMenu("Color");
		
		mnnFigure.add(miLine);
		mnnFigure.add(miRect);
		mnnFigure.add(miOval);
		mnnColor.add(miRed);
		mnnColor.add(miGreen);
		mnnColor.add(miBlue);
		
		miLine.addActionListener(this);
		miRect.addActionListener(this);
		miOval.addActionListener(this);
		miRed.addActionListener(this);
		miGreen.addActionListener(this);
		miBlue.addActionListener(this);
		
		menuBar.add(mnnFigure);
		menuBar.add(mnnColor);
		setJMenuBar(menuBar);
	}

	class PaintPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			//Color
			if (indexColor == red) {
				g.setColor(Color.red);
			} else if (indexColor == green) {
				g.setColor(Color.green);
			} else if (indexColor == blue) {
				g.setColor(Color.blue);
			}
			
			//Figure
			if (indexFigure == line) {
				g.drawLine(startX, startY, stopX, stopY);
			} else if (indexFigure == rect) {
				g.drawRect(startX, startY, stopX-startX, stopY-startY);
			} else if (indexFigure == oval) {
				g.drawOval(startX, startY, stopX-startX, stopY-startY);
			}
		}
	}//PaintPanel

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == miLine) {
			indexFigure = line;
		} else if (obj == miRect) {
			indexFigure = rect;
		} else if (obj == miOval) {
			indexFigure = oval;
		} else if (obj == miRed) {
			indexColor = red;
		} else if (obj == miGreen) {
			indexColor = green;
		} else if (obj == miBlue) {
			indexColor = blue;
		}
	}//actionPerformed
	
	public static void main(String[] args) {
		new PaintEx2();
	}

}//class
