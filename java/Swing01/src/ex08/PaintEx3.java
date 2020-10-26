package ex08;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PaintEx3 extends JFrame implements ActionListener {
	
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
	
	final int LINE = 1;
	final int RECT = 4;
	final int OVAL = 0;
	final int RED = 10;
	final int GREEN = 20;
	final int BLUE = 30;
	
	int indexFigure = LINE;
	int indexColor = RED;
	
	Figure figure = new Figure(startX, startY, stopX, stopY, indexFigure, indexColor);
	ArrayList<Figure> figureList = new ArrayList<Figure>();

	public PaintEx3() {
		setTitle("PaintEx2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().add(pnlPanel);
		
		pnlPanel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				startX = e.getX();
				startY = e.getY();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) { //마우스 뗄 때 값 저장
				pnlPanel.repaint();
				
				figure = new Figure(startX, startY, stopX, stopY, indexFigure, indexColor);
				figureList.add(figure);
			}
		});
		
		pnlPanel.addMouseMotionListener(new MouseAdapter() { //드래그 하면서 끝나는 좌표 저장
			@Override
			public void mouseDragged(MouseEvent e) {
				stopX = e.getX();
				stopY = e.getY();
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
			
			for (Figure figure : figureList) {
				//Color
				if (figure.indexColor == RED) {
					g.setColor(Color.red);
				} else if (figure.indexColor == GREEN) {
					g.setColor(Color.green);
				} else if (figure.indexColor == BLUE) {
					g.setColor(Color.blue);
				}
				
				//Figure
				if (figure.indexFigure == LINE) {
					g.drawLine(figure.startX, figure.startY, figure.stopX, figure.stopY);
				} else if (figure.indexFigure == RECT) {
					g.drawRect(figure.startX, figure.startY, 
							figure.stopX-figure.startX, figure.stopY-figure.startY);
				} else if (figure.indexFigure == OVAL) {
					g.drawOval(figure.startX, figure.startY, 
							figure.stopX-figure.startX, figure.stopY-figure.startY);
				}
			}//for
		}
	}//PaintPanel
	
	class Figure {
		
		int startX = 0;
		int startY = 0;
		int stopX = 0;
		int stopY = 0;
		
		int indexFigure = 1;
		int indexColor = 10;
		
		public Figure(int startX, int startY, int stopX, int stopY, int indexFigure, int indexColor) {
			this.startX = startX;
			this.startY = startY;
			this.stopX = stopX;
			this.stopY = stopY;
			this.indexFigure = indexFigure;
			this.indexColor = indexColor;
		}

		@Override
		public String toString() {
			return "Figure [startX=" + startX + ", startY=" + startY + ", "
					+ "stopX=" + stopX + ", stopY=" + stopY
					+ ", indexFigure=" + indexFigure + ", indexColor=" + indexColor + "]";
		}
		
	}//Figure

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == miLine) {
			indexFigure = LINE;
		} else if (obj == miRect) {
			indexFigure = RECT;
		} else if (obj == miOval) {
			indexFigure = OVAL;
		} else if (obj == miRed) {
			indexColor = RED;
		} else if (obj == miGreen) {
			indexColor = GREEN;
		} else if (obj == miBlue) {
			indexColor = BLUE;
		}
	}//actionPerformed
	
	public static void main(String[] args) {
		new PaintEx3();
	}

}//class
