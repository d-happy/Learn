package ex01;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame; //array �� ����, swing ���

@SuppressWarnings("serial") //���� ������ X, ���� 1+���⿡���� �����ؼ� ����x
public class MyFrame extends JFrame { // JFrame ���
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [X] ������ ���α׷� ����
		setSize(500, 500);
		setTitle("���� ������");
		
		//��ġ ������ - �⺻ ��ġ ������(BorderLayout)
		//FloeLayout : ��->�� ��ġ, ������ ������ �Ʒ��� ��ġ
//		setLayout(new FlowLayout()); //�⺻ ����-��� ����
		setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20)); //(����, ���ΰ���, ���ΰ���)
		for (int i=0; i<10; i++) {
			JButton button = new JButton("��ư" + i);
			add(button);
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args)  {
		new MyFrame();
	}

}
