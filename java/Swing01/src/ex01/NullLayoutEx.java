package ex01;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NullLayoutEx extends JFrame {
	
	public NullLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("배치 관리자 없는 예제");
		setSize(500, 500);
		setLayout(null); //배치 관리자를 없애고
		JButton button1 = new JButton("버튼1");
		button1.setSize(200, 100); //버튼의 크기
		button1.setLocation(100, 150); //버튼의 위치
		Container c = getContentPane();
		c.add(button1);
		
		for (int i=0; i<=10; i++) {
			JButton button = new JButton("버튼" + i);
			button.setSize(100, 50);
			button.setLocation(i * 10, i * 10);
			c.add(button);
		}
		
		setVisible(true);
	}

	public static void main(String[] args) {
		new NullLayoutEx();
	}

}//class
