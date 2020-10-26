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
		lblTimer.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblTimer.setHorizontalAlignment(SwingConstants.CENTER);
		c.add(lblTimer);
		TimerThread th = new TimerThread(lblTimer);
		th.start(); //run() 호출하는 것이 아님에 주의 //스타트가 스택 만들고 그 안에 런 올림
		setSize(500, 500);
		setVisible(true);
	}
	
	class TimerThread extends Thread {
		JLabel label;
		TimerThread(JLabel label) {
			this.label = label;
		}
		
		@Override
		public void run() {//스레드의 메인(main)
			super.run();
			System.out.println("스레드 실행");
			while (true) {
				//1초마다 1번씩 1증가
				try {
					Thread.sleep(1000); //1000 밀리초 동안 대기
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
