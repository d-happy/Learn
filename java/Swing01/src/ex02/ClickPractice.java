package ex02;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class ClickPractice extends JFrame{
	
	Container c = getContentPane();
	JButton btnTarget = new JButton("ü��");
	
	int i=0; //Action Ƚ�� ���� ���� index //�׼� ���� �ƴ϶� �ۿ��� Ȯ���� �� ����
	
	ActionListener lis = new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(e);

			i ++; //Action 1������ Ƚ�� +1
			System.out.println("Ŭ�� Ƚ�� : " + i);
			
			Object obj = e.getSource();
			JButton button = (JButton)obj; //�׼� �Ͼ�� ����� -> JButton, �ٿ�ĳ����
//			System.out.println(button);
			
			//��ġ ���� ���� ��, c-button ���� int ���ؼ� -> for �г� Ŀ���� �� �ȿ��� ���� ��ġ
			int num3 = (int) ((Math.random()*400)+1);
			int num4 = (int) ((Math.random()*400)+1);
			button.setLocation(num3, num4); //�׼� ������ 500*500 ������ �гο��� ��ġ ����
			
			int w = button.getWidth();
			int h = button.getHeight();
			
			//�ۿ��� i=10 �� final ������ ����, 10 �Ǹ� i=0 ����
			//������ ������ 10 ���� ++;
			//�ۿ��� int index = 0; �ʿ��� �� �����, index�� ���ǹ� ���� -> �ڵ� �����ϱ� ����
			
			if (i%10 == 0) { //�׼� n0�� °���� ������, ������ ���
				System.out.printf("������!!! - %d�ܰ�\n", (i/10)+1);
				button.setSize(w-10, h-10);
				
				if ((i/10)+1 == 11) {
					System.out.println("��ư�� �Ҹ�Ǿ����ϴ�.");
					return;
				}
			}//if
		}
			
	}; //ActionListener

	
	public ClickPractice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ClickPractice");
		setLayout(null);
		
		//private void setUI(){} �ϳ� �����ؼ�  �� �ȿ��� ��ư ����� �׼� Ȯ��
		//private void ������ ���, ���� ��ġ, ... 
		//-> �ܰ踶�� �޼ҵ�(�����ϱ� ���� �̸�) �����ؼ� �ٸ� �޼ҵ�, ������, �ʵ忡�� Ȱ��
		//-> for ���߿� �� ��, �ٸ� ����� ���� �����ϱ� ����  
		//�ܰ踶�� �ֿܼ��� Ȯ���ϰ� ���� �ܰ� //ū �������� ���ư��� ���� ���� Ȯ��
		
		//�ڵ� ���� ����ġ��, ���� �� �� //�ڵ� �� ����ϰ� ~�ص� �ϴ� ���� �����ϴ°� �߿�
		//���߿� �˾Ƽ� ��
		
		btnTarget.setSize(100, 100);
		
		int num1 = (int) ((Math.random()*400)+1);
		int num2 = (int) ((Math.random()*400)+1);
		btnTarget.setLocation(num1, num2);
		
		btnTarget.setBackground(Color.cyan);
		
		btnTarget.addActionListener(lis);

		c.add(btnTarget);
		
		
		setSize(500, 500);
		setVisible(true);
		
	} //ClickPractice();
	
	
	public static void main(String[] args) {
		new ClickPractice();
	}
	
	
}//class
