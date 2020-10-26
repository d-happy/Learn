package ex02;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class SampleListenerEx extends JFrame {
	
	Container c = getContentPane(); //프레임(윈도우)에 컨텐트 패널 얻기
	ActionListener lis = new MyActionListener(); //감시자
	JButton btnClick = new JButton("클릭");
	
	
	public SampleListenerEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("리스너 예제");
		btnClick.addActionListener(lis); //버튼에 감시자 붙임
		c.add(btnClick);
		setSize(500, 500);
		setVisible(true);
	}
	
	
	class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println("클릭됨");
//			String text = btnClick.getText(); //버튼의 글자 가져오기
//			System.out.println(text);
			
//			btnClick.setText("Click"); //버튼의 글자 설정하기 
			//if 할 때는 하면 안 됨
			//왜냐면 이건 "Click" 으로 고정해서 수정하는 거임
			
			//클릭할 때 마다 한글/영문 교대로 설정
			String text = btnClick.getText();
			
			if (text.equals("Click")) {
				btnClick.setText("클릭");
			} else if (text.equals("클릭")) {
				btnClick.setText("Click");
			}
		}
	}
	
	
	public static void main(String[] args) {
		new SampleListenerEx();
	}

}//class
