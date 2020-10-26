package ex07;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ThreadEx extends JFrame {
	
	Container c = getContentPane();
	JLabel lblTimer = new JLabel("0");

	public ThreadEx() {
		setTitle("Thread Ex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		lblTimer.setFont(new Font("���� ���", Font.BOLD, 50));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(lblTimer);
		TimerThread th = new TimerThread(lblTimer);
		th.start(); //run() ȣ���ϴ� ���� �ƴԿ� ���� //��ŸƮ�� ���� ����� �� �ȿ� �� �ø�
		setSize(500, 500);
		setVisible(true);
	}
	
	class TimerThread extends Thread {
		JLabel label;
		TimerThread(JLabel label) {
			this.label = label;
		}
		
		@Override
		public void run() {//�������� ����(main)
			super.run();
			System.out.println("������ ����");
			while (true) {
				//1�ʸ��� 1���� 1����
				try {
					Thread.sleep(1000); //1000 �и��� ���� ���
					int num = Integer.parseInt(label.getText());
					label.setText(String.valueOf(++num));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//run
	}//TimerThread
	
	public static void main(String[] args) {
		new ThreadEx();
	}

}//class
