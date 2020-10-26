package ex01;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NullLayoutEx extends JFrame {
	
	public NullLayoutEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("��ġ ������ ���� ����");
		setSize(500, 500);
		setLayout(null); //��ġ �����ڸ� ���ְ�
		JButton button1 = new JButton("��ư1");
		button1.setSize(200, 100); //��ư�� ũ��
		button1.setLocation(100, 150); //��ư�� ��ġ
		Container c = getContentPane();
		c.add(button1);
		
		for (int i=0; i<=10; i++) {
			JButton button = new JButton("��ư" + i);
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
