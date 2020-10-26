package ex03;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class KeyListenerEx extends JFrame {
	
	Container c = getContentPane();
	JLabel[] labels = new JLabel[3];
	KeyListener lis = new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			
		}
		
		@Override
		public void keyReleased(KeyEvent e) { 
//			System.out.println(e); //e : 이벤트 값이 저장
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			String keyText = KeyEvent.getKeyText(keyCode);
			
			labels[0].setText(String.valueOf(keyCode));
			labels[1].setText(String.valueOf(keyChar));
			labels[2].setText(keyText);
			if (keyCode == KeyEvent.VK_F5) { //입력된 키(키보드의 위치값)이 F5면
				c.setBackground(Color.yellow);
			} else if (keyCode == KeyEvent.VK_CONTROL) {
				c.setBackground(Color.green);
			}
		}
		
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
		
	}; //KeyListener()
	
	public KeyListenerEx() {
		setTitle("키 리스너 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(500, 500);
		setVisible(true);
		c.requestFocus(); //포커스를 가지는 콤포넌트만 키이벤트 받을 수 있음!!!
	}
	
	private void setUI() {
		c.setLayout(new FlowLayout()); //상단 정리?
		for (int i=0; i<labels.length; i++) {
			labels[i] = new JLabel(String.valueOf(i+1));
			labels[i].setOpaque(true); //레이블 기본상태가 투명을 불투명하게
			labels[i].setBackground(Color.cyan);
			c.add(labels[i]);
		}
		c.addKeyListener(lis);
	}

	public static void main(String[] args) {
		new KeyListenerEx();
	}

}//class
