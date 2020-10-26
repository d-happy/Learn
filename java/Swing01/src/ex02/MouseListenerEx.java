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
	MouseListener lis = new MyMouseListener(); //마우스 감시자
	JButton btnTarget = new JButton("버튼");
	
	public MouseListenerEx() {
		//프레임의 기본 창닫기 동작은 창 숨기기
		//프레임의 창닫기 동작을 프로그램 종료로 설정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("마우스 리스너 예제"); //프레임의 타이틀 설정
		
		//프레임의 기본 배치 관리자는 보더 레이아웃
		//배치관리자를 플로우 레이아웃으로 설정
		setLayout(new FlowLayout());
		btnTarget.addMouseListener(lis); //버튼에 감시자 붙이기
		c.add(btnTarget); //컨텐트팬에 버튼 달기
		
		setSize(500, 500); //프레임의 크기
		setVisible(true); //프레임을 화면에 보이기
	}
	
	class MyMouseListener implements MouseListener {

		@Override
		public void mouseClicked(java.awt.event.MouseEvent e) {
			System.out.println("클릭");
			//클릭 = 눌림 + 떼짐 , so 눌림+떼짐 하면 바로 클릭 1번 나옴
		}

		@Override
		public void mousePressed(java.awt.event.MouseEvent e) {
			System.out.println("눌림");
//			c.setBackground(Color.green);
			c.setBackground(Color.cyan);
		}

		@Override
		public void mouseReleased(java.awt.event.MouseEvent e) {
			System.out.println("떼짐");
			c.setBackground(Color.yellow);
		}

		@Override
		public void mouseEntered(java.awt.event.MouseEvent e) {
			System.out.println("들어옴");
//			c.setBackground(Color.red);
		}

		@Override
		public void mouseExited(java.awt.event.MouseEvent e) {
			System.out.println("나감");
//			c.setBackground(Color.black);
			c.setBackground(Color.green);
		}
		
	}
	
	
	public static void main(String[] args) {
		new MouseListenerEx();
	}

}//class
