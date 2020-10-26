package ex07;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ThreadEx2 extends JFrame {

	Container c = getContentPane();
	/*JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();*/
	JLabel[] labels = new JLabel[4];
	
//	TimeThread2 th2 = new TimeThread2(lblNumber2);
//	th2.start();
	
	class TimeThread extends Thread {
		JLabel label;
		int interval;
		int num2;
		int numStat;
		TimeThread(JLabel label, int num1, int num2, int numStat) { 
			//증가 간격, 증가 단위 를 int로 넣어서 변경 가능 //유연한 소스
			this.label = label;
			this.interval = num1;
			this.num2 = num2;
			this.numStat = numStat;
		}
		
		@Override
		public void run() {
			super.run();
//			int num;
//			int random = (int)(Math.random()*256);
			while (true) {
				try {
//					num = Integer.parseInt(label.getText());
					if (numStat % 3 == 0) {
						TimeThread.sleep(interval);
					} else { 
						TimeThread.sleep(interval);
					}
					label.setText(String.valueOf(numStat +=num2));
					label.setBackground(new Color(
							(int)(Math.random()*256),
							(int)(Math.random()*256), 
							(int)(Math.random()*256)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}//run
	}//TimeThread
	
	public ThreadEx2() {
		setTitle("ThreadEx2");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/*label1.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		c.add(label1);
		label2.setFont(new Font("궁서체", Font.BOLD, 50));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setOpaque(true);
		c.add(label2);*/
		c.setLayout(new GridLayout(2, 2));
		for (int i = 0; i < labels.length; i++) {
			labels[i] =new JLabel();
			labels[i].setFont(new Font("궁서체", Font.BOLD, 50));
			labels[i].setHorizontalAlignment(SwingConstants.CENTER);
			labels[i].setOpaque(true);
			c.add(labels[i]);
			TimeThread[] th = new TimeThread[labels.length];
			th[i] = new TimeThread(labels[i], 1000*i, i, i);
			th[i].start();
		}
		setSize(400, 400);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ThreadEx2();
		System.out.println("main close");
	}

}//class
