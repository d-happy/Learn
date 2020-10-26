package ex05;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonEx extends JFrame{

	public ButtonEx() {
		setTitle("��ư ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton button1 = new JButton(new ImageIcon("images/smile_small.png"));
		JButton button2 = new JButton("Button", new ImageIcon("images/smile_middle.png"));
		JButton button3 = new JButton("Button", new ImageIcon("images/4.png"));
//		ImageIcon imgRollOver = new ImageIcon("images/5.png");
		button3.setRolloverIcon(new ImageIcon("images/5.png")); //���콺 Ŀ���� �÷�����
		button3.setPressedIcon(new ImageIcon("images/6.png")); //���콺 ��ư�� �������� 
		
		add(button1);
		add(button2);
		add(button3);
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonEx();
	}

}//class
