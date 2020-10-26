package ex04;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ButtonEnableEx extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JButton btn1 = new JButton("�����/���̱�");
	JButton btn2 = new JButton("��� ����");
	JButton btn3 = new JButton("��Ȱ��ȭ");
	JButton btn4 = new JButton("��ġ/ũ�� ����");
	
	public ButtonEnableEx() {
		setTitle("Ȱ��ȭ ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300, 300);
		setVisible(true);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		c.setLayout(new FlowLayout());
		c.add(btn1);
		c.add(btn2);
		c.add(btn3);
		c.add(btn4);
		
		btn2.setBackground(Color.yellow);
		btn2.setForeground(Color.cyan);
		btn2.setFont(new Font("���� ���", Font.BOLD, 50));
		
		btn3.setEnabled(false);
	}
	
	public static void main(String[] args) {
		new ButtonEnableEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("�̺�Ʈ �߻�");
		Object obj = e.getSource();
		
		if (obj == btn1) {
			if (btn3.isVisible() == true) {
				btn3.setVisible(false);
			} else {
				btn3.setVisible(true);
			}
		} else if(obj == btn2) {
			System.out.println(btn2.getBackground());
			System.out.println(btn2.getForeground());
			System.out.println(btn2.getFont());
		} else if(obj == btn4) {
			System.out.println("x: "+btn4.getX());
			System.out.println("y: "+btn4.getY());
			System.out.println("width: "+btn4.getWidth());
			System.out.println("height: "+btn4.getHeight());
		}
	}
	
}//class
