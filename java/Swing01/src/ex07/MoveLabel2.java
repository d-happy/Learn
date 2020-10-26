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
public class MoveLabel2 extends JFrame {
	
	Container c = getContentPane();
	MyPanel panel = new MyPanel();
	JPanel pnlCenter = new JPanel();
	MyLabel label = new MyLabel(new ImageIcon("images/smile_middle.png"));
	TimeLabel labelTime = new TimeLabel();
	JLabel myLabel = new JLabel(new ImageIcon("images/emoji_beam_small!!!.png"));
	
	int move = 5;
	int index=0;
	
	KeyListener lis = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) { }
		
		@Override
		public void keyReleased(KeyEvent e) { }
		
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			int myX = myLabel.getX();
			int myY = myLabel.getY();
			
			int mw = myLabel.getWidth();
			int mh = myLabel.getHeight();
			int cw = c.getWidth();
			int ch = c.getHeight();
			int maxW = cw - mw;
			int maxH = ch - mh;
			
			if ((0 <= myX && myX <= maxW ) && (0 <= myY && myY <= maxH)) {
				switch (keyCode) {
				case KeyEvent.VK_LEFT : 
					myLabel.setLocation(myX - move, myY);
					break;
				case KeyEvent.VK_RIGHT : 
					myLabel.setLocation(myX + move, myY);
					break;
				case KeyEvent.VK_UP : 
					myLabel.setLocation(myX, myY - move);
					break;
				case KeyEvent.VK_DOWN : 
					myLabel.setLocation(myX, myY + move);
					break;
				}
			} else if (myX < 0 || myY < 0) {
				myLabel.setLocation(myX + move, myY + move);
			}
		}//keyPressed
	};//KeyListener
	
	public MoveLabel2() {
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.white);
		pnlNorth.setLayout(new GridLayout(1,2));
		JLabel lblLavel = new JLabel();
		lblLavel.setVerticalAlignment(SwingConstants.CENTER);
		lblLavel.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30));
		lblLavel.setText("Lv."+index);
		pnlNorth.add(lblLavel);
//		pnlNorth.add(labelTime);
		pnlNorth.add(panel);
		Thread thPanel = new Thread(panel);
		thPanel.start();
		panel.repaint();
		
		c.add(pnlNorth, BorderLayout.NORTH);
		
		setTitle("MoveLabel2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pnlCenter.setLayout(null);
		c.add(pnlCenter, BorderLayout.CENTER);
		
		plusLabel();
		
		setSize(500, 500);
		setVisible(true);
		c.requestFocus(); //´«¿¡ º¸ÀÌ°í Focus °£ µÚ¿¡ KeyListener °¡´É
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.white);
		JLabel lblover = new JLabel("00000");
		pnlSouth.add(lblover);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}
	
	public void plusLabel() {
//		Thread thTime = new Thread(labelTime);
//		thTime.start();
		
		int random = (int)(Math.random()*(c.getWidth()/6))+1;
		label.setSize(30, 30);
		label.setLocation(random*5, random*5);
		Thread th = new Thread(label);
		th.start();
		pnlCenter.add(label);
		
		myLabel.setSize(30, 30);
		myLabel.setLocation(250, 250);
		pnlCenter.add(myLabel);
		
		c.addKeyListener(lis);
	}//plusLabel
	
	class MyLabel extends JLabel implements Runnable {

		public MyLabel(ImageIcon imageIcon) {
			super(imageIcon); //class MyLabel ÇØ´ç
		}

		@Override
		public void run() {
			index++;
			move = move * index;
			while (true) {
				try {
					int myX = myLabel.getX();
					int myY = myLabel.getY();
					
					Thread.sleep(1000);
					Point p = this.getLocation();
					int x = p.x;
					int y = p.y;
					
					if (myX < x) {
						if (myY < y) {
							this.setLocation(x - move, y - move);
						} else if (myY > y) {
							this.setLocation(x - move, y + move);
						} else if (myY == y) {
							this.setLocation(x - move, y);
						}
					} else if (myX > x) {
						if (myY < y) {
							this.setLocation(x + move, y - move);
						} else if (myY > y) {
							this.setLocation(x + move, y + move);
						} else if (myY == y) {
							this.setLocation(x + move, y);
						}
					} else if (myX == x) {
						if (myY < y) {
							this.setLocation(x, y - move);
						} else if (myY > y) {
							this.setLocation(x, y + move);
						} else if (myY == y) {
							System.out.println("!!!");
							this.setLocation(x, y);
							plusLabel();
							break;
						}
					}//if
				} catch (Exception e) {
					e.printStackTrace();
				}
			}//try
		}//run
	}//MyLabel
	
	class MyPanel extends JPanel implements Runnable{
		
		int numTime = 1;
		int width;
		
		@Override
		public void run() {
			while (true) {
				try {
					if (numTime <= 5) {
						Thread.sleep(1000);
						++numTime;
						width = numTime*20;
					} else {
						numTime = 1;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				System.out.println(width);
			}
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.fillRect(10, 10, 200-width, 20);
		}
		
	}//MyPanel
	
	/*
	class TimeLabel extends JLabel implements Runnable {
		@Override
		public void run() {
//			int i;
			while (true) { 
				try {
					this.setFont(new Font("¸¼Àº°íµñ", Font.BOLD, 30));
					this.setText(String.valueOf(10));
					Thread.sleep(1000);
					int i = Integer.parseInt(this.getText());
					System.out.println(i);
					this.setText(String.valueOf(100));
//					System.out.println(--i);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//run
	}//TimeLabel
	*/
	
	public static void main(String[] args) {
		new MoveLabel2();
	}

}//class
