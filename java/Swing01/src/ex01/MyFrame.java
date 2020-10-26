package ex01;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame; //array 안 쓰고, swing 사용

@SuppressWarnings("serial") //서버 여러개 X, 서버 1+여기에서만 관리해서 오류x
public class MyFrame extends JFrame { // JFrame 상속
	
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // [X] 누르면 프로그램 종료
		setSize(500, 500);
		setTitle("샘플 프레임");
		
		//배치 관리자 - 기본 배치 관리자(BorderLayout)
		//FloeLayout : 좌->우 배치, 공간이 없으면 아래로 배치
//		setLayout(new FlowLayout()); //기본 정렬-가운데 정렬
		setLayout(new FlowLayout(FlowLayout.LEFT, 30, 20)); //(정렬, 가로간격, 세로간격)
		for (int i=0; i<10; i++) {
			JButton button = new JButton("버튼" + i);
			add(button);
		}
		
		setVisible(true);
	}
	
	public static void main(String[] args)  {
		new MyFrame();
	}

}
