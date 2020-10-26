package ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class MouseListenerEx extends JFrame {
	
	Container c = getContentPane();
	MouseListener lis = new MyMouseListener(); //���콺 ������
	JButton btnTarget = new JButton("��ư");
	
	public MouseListenerEx() {
		//�������� �⺻ â�ݱ� ������ â �����
		//�������� â�ݱ� ������ ���α׷� ����� ����
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("���콺 ������ ����"); //�������� Ÿ��Ʋ ����
		
		//�������� �⺻ ��ġ �����ڴ� ���� ���̾ƿ�
		//��ġ�����ڸ� �÷ο� ���̾ƿ����� ����
		setLayout(new FlowLayout());
		btnTarget.addMouseListener(lis); //��ư�� ������ ���̱�
		c.add(btnTarget); //����Ʈ�ҿ� ��ư �ޱ�
		
		setSize(500, 500); //�������� ũ��
		setVisible(true); //�������� ȭ�鿡 ���̱�
	}
	
	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			System.out.println("Ŭ��");
			//Ŭ�� = ���� + ���� , so ����+���� �ϸ� �ٷ� Ŭ�� 1�� ����
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			System.out.println("����");
//			c.setBackground(Color.green);
			c.setBackground(Color.cyan);
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			System.out.println("����");
			c.setBackground(Color.yellow);
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			System.out.println("����");
//			c.setBackground(Color.red);
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			System.out.println("����");
//			c.setBackground(Color.black);
			c.setBackground(Color.green);
		}
		
	}
	
	
	public static void main(String[] args) {
		new MouseListenerEx();
	}

}//class
