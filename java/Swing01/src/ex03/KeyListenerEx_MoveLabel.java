package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerEx_MoveLabel extends JFrame {
	
	Container c = getContentPane();
	JLabel label = new JLabel(new ImageIcon("images/smile_0.png"));
	JButton btnPlus = new JButton("[Ȯ��]");

	final int move = 10; //final �ʵ� ���� ����
	
	int numX = 300;
	int numY = 300;
	
	int clickBtn = 0;
	
	KeyListener lis = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) {
			
		}
		
		@Override
		public void keyPressed(KeyEvent e) { //Ű ���� �� �̺�Ʈ
			System.out.println("---");
			int keyCode = e.getKeyCode();
			
			int labelX = label.getX();
			int labelY = label.getY(); //�� ��ġ
			//int�� �����ϸ� �� �� �׳� label.getX() �� ��ü�� �ؾ� �� - �ʵ忡�� ����
			//KeyListener() �ȿ��� int �����ϸ� �� ��?!
			
			int labelWidth = label.getWidth();
			int labelHeigth = label.getHeight(); //�� ũ��
			
			int cWidth= c.getWidth();
			int cHeight = c.getHeight(); //�����̳� ũ��
			
			int maxWidth = cWidth-labelWidth;
			int maxHeight = cHeight-labelHeigth; //�ִ� ũ��
			
			if ((0 <= labelX && labelX < maxWidth) &&
					(0 <= labelY && labelY < maxHeight)) {
				//switch �˾ƺ��� ����
				if (keyCode == KeyEvent.VK_LEFT) {
					label.setLocation(labelX-move, labelY);
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					label.setLocation(labelX+move, labelY);
				} else if (keyCode == KeyEvent.VK_UP) {
					label.setLocation(labelX, labelY-move);
				} else if (keyCode == KeyEvent.VK_DOWN) {
					label.setLocation(labelX, labelY+move);
				}
				System.out.println(labelX + "|" + labelY);
				System.out.println(cWidth + "|" + cHeight);
				System.out.println("������ : "+getSize());

			} else if (label.getX() < 0 || label.getY() < 0) {
				label.setLocation(10, 10); //0,0 -�� ���� �ñ�� ����
			} else {
				label.setText("X"); //���߿� �г� Ű�� �ڿ� ���� ����� ����
				System.out.println("�� �̻� ������ �� �����ϴ�.");
			}
		}//keyPressed
	};
		
	ActionListener lisAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			clickBtn++;
			
			setSize(numX+(clickBtn*30), numY+(clickBtn*30));
			
//			c.setSize(numX+(clickBtn*30), numY+(clickBtn*30));
			
			System.out.println("Ȯ�� : "+getSize());
			
			c.addKeyListener(lis);
		}
	};//ActionListener

	public KeyListenerEx_MoveLabel() {
		setTitle("Move Label");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(numX, numY);
		setVisible(true);
		c.requestFocus(); //â�� �� �Ŀ� ��Ŀ�� �۵��ؾ� ��
	}
	
	private void setUI() {
		c.setLayout(null);
		
		label.setSize(30, 30);
		label.setOpaque(true); //�� �⺻ : ���� -> ������, ����
		label.setBackground(Color.cyan);
		c.add(label);
		
		c.addKeyListener(lis);
		
		btnPlus.setSize(70, 30);
//		btnPlus.setLocation(c.getWidth()/2, c.getHeight()/2);
		btnPlus.addActionListener(lisAction);
		c.add(btnPlus);
		
	}

	public static void main(String[] args) {
		new KeyListenerEx_MoveLabel();
	}
	
}//class
