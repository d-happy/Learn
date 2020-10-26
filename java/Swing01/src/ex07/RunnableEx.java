package ex07;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RunnableEx extends JFrame {
	
	Container c = getContentPane();
//	TimerLabel label = new TimerLabel("0");
	
	public RunnableEx() {
		setTitle("RunnableEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		c.setLayout(new GridLayout(2, 5));
		for (int i=0; i<4; i++) {
			TimerLabel label = new TimerLabel(String.valueOf(i));
			label.setFont(new Font("�������", Font.BOLD, 50));
			label.setHorizontalAlignment(SwingConstants.CENTER);
			c.add(label);
			Thread th = new Thread(label);
			th.start();
		}
		setSize(500, 500);
		setVisible(true);
	}
	
	class TimerLabel extends JLabel implements Runnable {
		
		TimerLabel(String text) {
			super(text); //new JLabel(text)
		}

		@Override
		public void run() {
			System.out.println("act");
			while (true) {
				//1�ʸ��� 1���� 1����
				try {
					Thread.sleep(1000); //1000 �и��� ���� ���
					int num = Integer.parseInt(this.getText());
					setText(String.valueOf(++num));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
	}//TimerLabel

	public static void main(String[] args) {
		new RunnableEx();
	}

}//class
