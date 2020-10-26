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
	JButton btnPlus = new JButton("[확대]");

	final int move = 10; //final 필드 변수 지정
	
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
		public void keyPressed(KeyEvent e) { //키 누를 때 이벤트
			System.out.println("---");
			int keyCode = e.getKeyCode();
			
			int labelX = label.getX();
			int labelY = label.getY(); //라벨 위치
			//int로 변수하면 안 됨 그냥 label.getX() 이 자체로 해야 함 - 필드에서 했음
			//KeyListener() 안에서 int 정의하면 잘 됨?!
			
			int labelWidth = label.getWidth();
			int labelHeigth = label.getHeight(); //라벨 크기
			
			int cWidth= c.getWidth();
			int cHeight = c.getHeight(); //컨테이너 크기
			
			int maxWidth = cWidth-labelWidth;
			int maxHeight = cHeight-labelHeigth; //최대 크기
			
			if ((0 <= labelX && labelX < maxWidth) &&
					(0 <= labelY && labelY < maxHeight)) {
				//switch 알아보기 쉬움
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
				System.out.println("사이즈 : "+getSize());

			} else if (label.getX() < 0 || label.getY() < 0) {
				label.setLocation(10, 10); //0,0 -로 가면 팅기게 만듬
			} else {
				label.setText("X"); //나중에 패널 키운 뒤에 보면 변경되 있음
				System.out.println("더 이상 움직일 수 없습니다.");
			}
		}//keyPressed
	};
		
	ActionListener lisAction = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			clickBtn++;
			
			setSize(numX+(clickBtn*30), numY+(clickBtn*30));
			
//			c.setSize(numX+(clickBtn*30), numY+(clickBtn*30));
			
			System.out.println("확대 : "+getSize());
			
			c.addKeyListener(lis);
		}
	};//ActionListener

	public KeyListenerEx_MoveLabel() {
		setTitle("Move Label");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(numX, numY);
		setVisible(true);
		c.requestFocus(); //창이 뜬 후에 포커스 작동해야 함
	}
	
	private void setUI() {
		c.setLayout(null);
		
		label.setSize(30, 30);
		label.setOpaque(true); //라벨 기본 : 투명 -> 불투명, 변경
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
