package ex02;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Listen2 extends JFrame{
	
	Container c = getContentPane();
	JButton btnLeft = new JButton("��");
	JButton btnRight = new JButton("��");
	
	
	ActionListener lis = new ActionListener() { //interface <ActionListene>
//��ǥ �̺�Ʈ Ŭ��
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(e); // �̺�Ʈ ���� Ȯ��
			/*
			String cmd = e.getActionCommand(); //�̺�Ʈ ���� �߿��� cmd ���
			if (cmd.equals("��")) {
				System.out.println("���� ��ư Ŭ��");
			} else if (cmd.equals("��")) {
				System.out.println("������ ��ư Ŭ��");
			}
			*/
			/*
			Object obj = e.getSource(); 
			//�̺�Ʈ�� �߻��� ��, ������ e(�̺�Ʈ ���� �� ����)���� ����� <��ư>�̶�� �˷���
			if (obj == btnLeft) {
				System.out.println("���� ��ư Ŭ��");
			} else if (obj == btnRight) {
				System.out.println("������ ��ư Ŭ��");
			}
			*/
			Object obj = e.getSource();
			JButton button = (JButton)obj; 
			//Object�� �ֻ��� Ŭ������ �۾� O,X -> ���� �ִ� JButton���� DownCasting
			String text = button.getText();
			System.out.println(text + "��ư Ŭ����");
		}
	}; //ActionListener
	
	
	public Listen2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("������Ʈ 2�� �����ϱ�");
		setLayout(new GridLayout(1, 2));
		c.add(btnLeft);
		c.add(btnRight);
		//������ 1���� ��ư 2�� ����
		btnLeft.addActionListener(lis);
		btnRight.addActionListener(lis);
		setSize(500, 500);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new Listen2();
	}

	
} //class
