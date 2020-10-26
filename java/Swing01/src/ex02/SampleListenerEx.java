package ex02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SampleListenerEx extends JFrame {
	
	Container c = getContentPane(); //������(������)�� ����Ʈ �г� ���
	ActionListener lis = new MyActionListener(); //������
	JButton btnClick = new JButton("Ŭ��");
	
	
	public SampleListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("������ ����");
		btnClick.addActionListener(lis); //��ư�� ������ ����
		c.add(btnClick);
		setSize(500, 500);
		setVisible(true);
	}
	
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println("Ŭ����");
//			String text = btnClick.getText(); //��ư�� ���� ��������
//			System.out.println(text);
			
//			btnClick.setText("Click"); //��ư�� ���� �����ϱ� 
			//if �� ���� �ϸ� �� ��
			//�ֳĸ� �̰� "Click" ���� �����ؼ� �����ϴ� ����
			
			//Ŭ���� �� ���� �ѱ�/���� ����� ����
			String text = btnClick.getText();
			
			if (text.equals("Click")) {
				btnClick.setText("Ŭ��");
			} else if (text.equals("Ŭ��")) {
				btnClick.setText("Click");
			}
		}
	}
	
	
	public static void main(String[] args) {
		new SampleListenerEx();
	}

}//class
