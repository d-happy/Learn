package ex07;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class MoveLabel3 extends JFrame {
	
	final int move = 5;
	int index = 1;
	int[] count = new int[index];
	int result = 0;

	Container c = getContentPane();
	MyPanel panel = new MyPanel();
	JPanel pnlCenter = new JPanel();
	MyLabel[] label = new MyLabel[index];
	GameLabel gamelbl = new GameLabel();
	JLabel myBeam = new JLabel(new ImageIcon("images/emoji_beam_small!!!.png"));

	/*
	 * final int move = 5; int index = 1; int[] count = new int[index]; int result =
	 * 0;
	 */

	KeyListener lis = new KeyListener() {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();

			int myX = myBeam.getX();
			int myY = myBeam.getY();

			int mw = myBeam.getWidth();
			int mh = myBeam.getHeight();
			int cw = c.getWidth();
			int ch = c.getHeight();
			int maxW = cw - mw;
			int maxH = ch - mh;

			if ((0 <= myX && myX <= maxW) && (0 <= myY && myY <= maxH)) {
				switch (keyCode) {
				case KeyEvent.VK_LEFT:
					myBeam.setLocation(myX - move, myY);
					break;
				case KeyEvent.VK_RIGHT:
					myBeam.setLocation(myX + move, myY);
					break;
				case KeyEvent.VK_UP:
					myBeam.setLocation(myX, myY - move);
					break;
				case KeyEvent.VK_DOWN:
					myBeam.setLocation(myX, myY + move);
					break;
				}
			} else if (myX < 0 || myY < 0) {
				myBeam.setLocation(myX + move, myY + move);
			}
		}// keyPressed
	};// KeyListener

	public MoveLabel3() {

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.white);
		pnlNorth.setLayout(new GridLayout(1, 2));
		JLabel lblLavel = new JLabel();
		lblLavel.setVerticalAlignment(SwingConstants.CENTER);
		lblLavel.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30));
		lblLavel.setText("Lv." + index);
		pnlNorth.add(lblLavel);
		pnlNorth.add(panel);
		Thread thPanel = new Thread(panel);
		thPanel.start();

		c.add(pnlNorth, BorderLayout.NORTH);

		setTitle("MoveLabel2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnlCenter.setLayout(null);
		c.add(pnlCenter, BorderLayout.CENTER);

		plusLabel();

		setSize(500, 500);
		setVisible(true);
		c.requestFocus(); // ´«¿¡ º¸ÀÌ°í Focus °£ µÚ¿¡ KeyListener °¡´É

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.white);
		gamelbl.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30));
		pnlSouth.add(gamelbl);
		Thread thlbl = new Thread(gamelbl);
		thlbl.start();
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	public void plusLabel() {
//		int random = (int) (Math.random() * 100) + 1;
//		label.setSize(30, 30);
//		label.setLocation(random * 5, random * 5);
//		Thread th = new Thread(label);
//		th.start();
//		pnlCenter.add(label);
		
		for (int num : count) {		
			label[num] = new MyLabel(new ImageIcon("images/smile_middle.png"));
			label[num].setSize(30, 30);
			int random = (int) (Math.random() * 99) + 1;
			label[num].setLocation(random*5, random*5);
			Thread[] th = new Thread[index];
			th[num]	= new Thread(label[num]);
			th[num].start();
			pnlCenter.add(label[num]);
		}

		myBeam.setSize(30, 30);
		myBeam.setLocation(250, 250);
		pnlCenter.add(myBeam);

		c.addKeyListener(lis);
		
		result = 0;
		
		Thread thlbl = new Thread(gamelbl);
		thlbl.start();
		
		Thread thPanel = new Thread(panel);
		thPanel.start();
		
	}// plusLabel

	class MyLabel extends JLabel implements Runnable {

		public MyLabel(ImageIcon imageIcon) {
			super(imageIcon); // class MyLabel ÇØ´ç
		}

		@Override
		public void run() {
			int movelbl = move * index;
			while (true) {
				try {
					int myX = myBeam.getX();
					int myY = myBeam.getY();

					Thread.sleep(1000);
					Point p = this.getLocation();
					int x = p.x;
					int y = p.y;

					if (myX < x) {
						if (myY < y) {
							this.setLocation(x - movelbl, y - movelbl);
						} else if (myY > y) {
							this.setLocation(x - movelbl, y + movelbl);
						} else if (myY == y) {
							this.setLocation(x - movelbl, y);
						}
						result = 0;
					} else if (myX > x) {
						if (myY < y) {
							this.setLocation(x + movelbl, y - movelbl);
						} else if (myY > y) {
							this.setLocation(x + movelbl, y + movelbl);
						} else if (myY == y) {
							this.setLocation(x + movelbl, y);
						}
						result = 0;
					} else if (myX == x) {
						if (myY < y) {
							this.setLocation(x, y - movelbl);
						} else if (myY > y) {
							this.setLocation(x, y + movelbl);
						} else if (myY == y) {
							System.out.println("!!!");
//							this.setLocation(x, y);
							plusLabel();
							index++;
							result = 1;
							System.out.println("---"+result);
//							break;
						}
					} // if
				} catch (Exception e) {
					e.printStackTrace();
				}
			} // try
		}// run
	}// MyLabel

	class MyPanel extends JPanel implements Runnable {

		int numTime = 0;
		int width;
		int w;
		int w2;

		@Override
		public void run() {
			while (true) {
				try {
					if (numTime < 21 && result == 0) {
						width = numTime * 10;
						w = 200 - width;
						w2 = 210 - width;
						System.out.println("numTime : " + numTime + " | width : " + width);
						System.out.println("w : " + w);
						panel.repaint();
						Thread.sleep(1000);
						++numTime;
					} else if (numTime == 21 && result == 0) {
						numTime = 0;
					} else if (numTime < 21 && result == 1) {
						numTime = 0;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}// run

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.green);
			g.fillRect(10, 10, w, 20);
			g.setFont(new Font("¸íÁ¶Ã¼", Font.BOLD, 12));
			g.drawString(String.valueOf(w), w2, 25);
		}
	}// MyPanel
	
	class GameLabel extends JLabel implements Runnable {

		public GameLabel() {
			super();
//			this.setText("Game ing");
		}
		
		@Override
		public void run() {
			try {
				if (result == 0) {
					this.setText("Game ing");
				} else if (result == 1) {
					this.setText("GameOver");
				}
				System.out.println(result);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}//GameLabel

	public static void main(String[] args) {
		new MoveLabel3();
	}

}// class
