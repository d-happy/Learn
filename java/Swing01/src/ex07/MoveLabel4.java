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
public class MoveLabel4 extends JFrame {
	
	final int move = 5;
	int index = 1;
	int[] count = new int[index];
	int second = 0;

	Container c = getContentPane();
	JPanel pnlNorth = new JPanel();
	JPanel pnlCenter = new JPanel();
	JPanel pnlSouth = new JPanel();
	JLabel lblLavel = new JLabel();
	
	MyPanel panel = new MyPanel();
	TimeLabel timelbl = new TimeLabel(String.valueOf(second));
	MyLabel[] label = new MyLabel[index];
	JLabel myBeam = new JLabel(new ImageIcon("images/emoji_beam_small!!!.png"));

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
		}//keyPressed
	};//KeyListener

	public MoveLabel4() {

		pnlNorth.setBackground(Color.white);
		pnlNorth.setLayout(new GridLayout(1, 2));
		
		lblLavel.setVerticalAlignment(SwingConstants.CENTER);
		lblLavel.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30));
		pnlNorth.add(lblLavel);
		
		pnlNorth.add(panel);
		
		c.add(pnlNorth, BorderLayout.NORTH);

		setTitle("Move Label");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnlCenter.setLayout(null);
		c.add(pnlCenter, BorderLayout.CENTER);

		myBeam.setSize(30, 30);
		myBeam.setLocation(250, 250);
		
		plusLabel();

		setSize(500, 500);
		setVisible(true);
		c.requestFocus(); // ´«¿¡ º¸ÀÌ°í Focus °£ µÚ¿¡ KeyListener °¡´É

		pnlSouth.setBackground(Color.white);
		
		timelbl.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30));
		pnlSouth.add(timelbl);
		
		c.add(pnlSouth, BorderLayout.SOUTH);
		
		c.addKeyListener(lis);
		
		Thread thlbl = new Thread(timelbl);
		thlbl.start();
	}

	public void plusLabel() {
		
		int random = (int) (Math.random() * 300) + 1;
		
		for (int num : count) {		
			label[num] = new MyLabel(new ImageIcon("images/smile_middle.png"));
			label[num].setSize(30, 30);
			label[num].setLocation(random, random);
			Thread[] th = new Thread[index];
			th[num]	= new Thread(label[num]);
			th[num].start();
			pnlCenter.add(label[num]);
		}

//		myBeam.setSize(30, 30);
//		myBeam.setLocation(250, 250);
		pnlCenter.add(myBeam);
		
		second = 0;
		
//		Thread thlbl = new Thread(timelbl);
//		thlbl.start();
//		
		Thread thPanel = new Thread(panel);
		thPanel.start();
		
		lblLavel.setText("Lv." + index);

	}//plusLabel
	
	class TimeLabel extends JLabel implements Runnable {
		
		TimeLabel(String second) {
			super(String.valueOf(second));
		}

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
					if (second < 10) {
						this.setText(String.valueOf(++second));
						System.out.println(";;; "+second);
					} else if (second == 10) {
						System.out.println("--"+second);
						this.setText("gg");
						break;
					} else if (second == 15) {
						System.out.println(second);
						this.setText("gg");
						break;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//run
	}//timeLabel

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
					int myXRight = myX + myBeam.getWidth();
					int myY = myBeam.getY();
					int myYLow = myY + myBeam.getHeight();

					Point p = this.getLocation();
					int x = p.x;
					int xRight = p.x + 30;
					int y = p.y;
					int yLow = p.y + 30;

					Thread.sleep(1000);
					
					if (myXRight < x && second < 10) {
						if (myY > yLow) {
							this.setLocation(x - movelbl, y + movelbl);
						} else if (myYLow < y) {
							this.setLocation(x - movelbl, y - movelbl);
						} else if (myY == y) {
							this.setLocation(x - movelbl, y);
						}
					} else if (myX > xRight && second < 10) {
						if (myY > yLow) {
							this.setLocation(x + movelbl, y + movelbl);
						} else if (myYLow < y) {
							this.setLocation(x + movelbl, y - movelbl);
						} else if (myY == y) {
							this.setLocation(x + movelbl, y);
						}
					} else if ((myX < x && myXRight > x)
							&&(myY < yLow || myYLow > y)&& second < 10) {
						lblStop();
						break;
					} else if ((myX < xRight && myXRight > xRight)
							&&(myY < yLow || myYLow > y)&& second < 10) {
						lblStop();
						break;
					} else if (second == 10) {
						lblPlus();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} //while
		}//run
		
		public void lblPlus() {
			System.out.println("Level Up!!!");
			timelbl.setText("Level Up!!!");
			index++;
			myBeam.setLocation(myBeam.getX(), myBeam.getY());
			plusLabel();
		}
		
		public void lblStop() {
			System.out.println("Stop¤Ð¤Ð¤Ð¤Ð");
			second = 15;
		}
	}//MyLabel

	class MyPanel extends JPanel implements Runnable {

		int width;
		int w;
		int wStr;

		@Override
		public void run() {
			while (true) {
				try {
					if (second < 10) {
						width = second * 20;
						w = 200 - width;
						wStr = 210 - width;
						panel.repaint();
					} else if (second == 10) {
						System.out.println("======================");
						break;
					} else if (second == 15) {
						System.out.println("======================stop");
						break;
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
			if (second < 10) { 
				g.setColor(Color.green); 
				g.drawString(String.valueOf(w), wStr, 25); 
			} else if (second == 10 || second == 15) { 
				g.setColor(Color.red);
				g.drawString(String.valueOf(w), wStr, 25); 
			}
		}
	}//MyPanel
	
	public static void main(String[] args) {
		new MoveLabel4();
	}

}// class
