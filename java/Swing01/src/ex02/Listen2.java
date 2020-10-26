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
	JButton btnLeft = new JButton("좌");
	JButton btnRight = new JButton("우");
	
	
	ActionListener lis = new ActionListener() { //interface <ActionListene>
//대표 이벤트 클릭
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(e); // 이벤트 정보 확인
			/*
			String cmd = e.getActionCommand(); //이벤트 정보 중에서 cmd 얻기
			if (cmd.equals("좌")) {
				System.out.println("왼쪽 버튼 클릭");
			} else if (cmd.equals("우")) {
				System.out.println("오른쪽 버튼 클릭");
			}
			*/
			/*
			Object obj = e.getSource(); 
			//이벤트가 발생된 놈, 누군지 e(이벤트 정도 다 있음)한테 물어보니 <버튼>이라고 알려줌
			if (obj == btnLeft) {
				System.out.println("왼쪽 버튼 클릭");
			} else if (obj == btnRight) {
				System.out.println("오른쪽 버튼 클릭");
			}
			*/
			Object obj = e.getSource();
			JButton button = (JButton)obj; 
			//Object는 최상위 클래스라서 글씨 O,X -> 글자 있는 JButton으도 DownCasting
			String text = button.getText();
			System.out.println(text + "버튼 클릭됨");
		}
	}; //ActionListener
	
	
	public Listen2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("컴포넌트 2개 감시하기");
		setLayout(new GridLayout(1, 2));
		c.add(btnLeft);
		c.add(btnRight);
		//감시자 1놈이 버튼 2개 감시
		btnLeft.addActionListener(lis);
		btnRight.addActionListener(lis);
		setSize(500, 500);
		setVisible(true);
	}

	
	public static void main(String[] args) {
		new Listen2();
	}

	
} //class
