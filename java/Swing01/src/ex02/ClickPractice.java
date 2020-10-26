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
	JButton btnTarget = new JButton("체리");
	
	int i=0; //Action 횟수 세기 위한 index //액션 안이 아니라 밖에서 확인할 수 있음
	
	ActionListener lis = new ActionListener() {
	
		@Override
		public void actionPerformed(ActionEvent e) {
//			System.out.println(e);

			i ++; //Action 1번마다 횟수 +1
			System.out.println("클릭 횟수 : " + i);
			
			Object obj = e.getSource();
			JButton button = (JButton)obj; //액션 일어나는 당사자 -> JButton, 다운캐스팅
//			System.out.println(button);
			
			//위치 랜덤 구할 때, c-button 으로 int 구해서 -> for 패널 커져도 그 안에서 랜덤 위치
			int num3 = (int) ((Math.random()*400)+1);
			int num4 = (int) ((Math.random()*400)+1);
			button.setLocation(num3, num4); //액션 때마다 500*500 사이즈 패널에서 위치 랜덤
			
			int w = button.getWidth();
			int h = button.getHeight();
			
			//밖에서 i=10 를 final 변수로 지정, 10 되면 i=0 으로
			//레벨업 변수는 10 마다 ++;
			//밖에서 int index = 0; 필요한 거 만들고, index로 조건문 생성 -> 코드 이해하기 쉽게
			
			if (i%10 == 0) { //액션 n0번 째마다 레벨업, 사이즈 축소
				System.out.printf("레벨업!!! - %d단계\n", (i/10)+1);
				button.setSize(w-10, h-10);
				
				if ((i/10)+1 == 11) {
					System.out.println("버튼이 소멸되었습니다.");
					return;
				}
			}//if
		}
			
	}; //ActionListener

	
	public ClickPractice() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("ClickPractice");
		setLayout(null);
		
		//private void setUI(){} 하나 생성해서  그 안에서 버튼 만들고 액션 확인
		//private void 사이즈 축소, 랜덤 위치, ... 
		//-> 단계마다 메소드(이해하기 쉬운 이름) 생성해서 다른 메소드, 생성자, 필드에서 활용
		//-> for 나중에 볼 때, 다른 사람이 봐도 이해하기 쉽게  
		//단계마다 콘솔에서 확인하고 다음 단계 //큰 구조에서 돌아가는 관계 먼저 확인
		
		//코드 보고 따라치기, 도움 안 됨 //코드 덜 깔끔하고 ~해도 일단 동작 구현하는게 중요
		//나중에 알아서 됨
		
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
