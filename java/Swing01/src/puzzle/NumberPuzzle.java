package puzzle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NumberPuzzle extends JFrame implements ActionListener {

	Container c = getContentPane();
	
	JPanel pnlNorth = new JPanel();
//	JPanel pnlCenter = new JPanel();
	JPanel pnlSouth = new JPanel();
	
	JButton bntOk = new JButton("확인");
	JButton bntNew = new JButton("새게임");
	
	JTextField txtInput = new JTextField(10);
	JTextField txtScore = new JTextField(10);
	JTextField txtChance = new JTextField(10);
	
	JTextArea txtResult = new JTextArea();
	
	JLabel lblInput = new JLabel("입력 : ");
	JLabel lblScore = new JLabel("기록 : ");
	JLabel lblChance = new JLabel("남은횟수 : ");
	
	long startTime = 0; //클래스 돌아갈 때 , 지금 시간 캡쳐
	
	int Chance = 0;
	int Number = 0; //일단 0으로 지정
	
	
	public NumberPuzzle() {
		setTitle("돌려라~ 랜덤 숫자 맞추기~ !!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startTime = System.currentTimeMillis(); //게임 시작할 때 , 지금 시간 캡쳐
		
		setUI();
		setListener();
		
		setSize(500, 300);
		setVisible(true);
	}
	
	private void setUI() {
		pnlNorth.add(lblInput);
		pnlNorth.add(txtInput);
		pnlNorth.add(bntOk);
		pnlNorth.add(lblScore);
		pnlNorth.add(txtScore);
		pnlNorth.add(bntNew);
		pnlNorth.setBackground(Color.yellow);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		txtScore.setText("1000000");
		
		Number = (int)(Math.random()*100)+1; //숫자 랜덤 생성
		
//		pnlCenter.setLayout(new BorderLayout()); //텍스트아레아 바로 써도 상관 없음
//		pnlCenter.add(txtResult);
		c.add(txtResult, BorderLayout.CENTER);
		
		String welcome1 = "1부터 100사이의 숫자를 맞춰보세요. \n";
		String welcome2 = "------------------------------ \n";
		
		txtResult.append(welcome1);
		txtResult.append(welcome2);
		
		pnlSouth.add(lblChance);
		pnlSouth.add(txtChance);
		pnlSouth.setBackground(Color.cyan);
		c.add(pnlSouth, BorderLayout.SOUTH);
		
		txtChance.setText("♥♥♥♥♥");
	}

	private void setListener() {
		txtInput.addActionListener(this);
		bntOk.addActionListener(this);
		bntNew.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new NumberPuzzle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if ((obj == txtInput) || (obj == bntOk)) {
			
			Chance++; //엔터, 클릭 액션 횟수 세기
			
//			System.out.println("---"+Chance+"|"+Number+"---");
//			System.out.println("시작 : "+startTime);
			
			int numUser = Integer.parseInt(txtInput.getText());
			txtInput.setText("");
			
			if (Chance <= 5) {
				
				if (numUser > Number) {
					txtResult.append(numUser + "보다 작습니다. \n");
				} else if (numUser < Number) {
					txtResult.append(numUser + "보다 큽니다. \n");
				} else if (numUser == Number) {
					
					txtResult.append(Number + " : 정답입니다!!!!! \n");
					
					long endTime = System.currentTimeMillis();
					
					System.out.println("엔드 : "+endTime);
					
					long resultTime1 = endTime-startTime; //지금 전에 찍은 시간 캡쳐랑 비교
					txtResult.append("걸린 시간 : "+(resultTime1)+"\n"); //걸린 시간 출력
					
					String timeScore1 = txtScore.getText();
					long timeScore2 = Long.parseLong(timeScore1);
					
					if (resultTime1 < timeScore2) {
						txtResult.append("< 기록 更신!!!!!!! >");
						
						String resultTime2 = (""+resultTime1);
						txtScore.setText(resultTime2);
					}
				//numUser == Number
				}
			//Chance <= 5	
			} else {
				
				txtResult.append("----------------------------------\n");
				txtResult.append("게임종료\n");
				
				return;
			//Chance 5 초과
			}
			
			switch (Chance) {
			case 1 :
				txtChance.setText("♥♥♥♥");
				break;
			case 2 :
				txtChance.setText("♥♥♥");
				break;
			case 3 :
				txtChance.setText("♥♥");
				break;
			case 4 :
				txtChance.setText("♥");
				break;
			case 5 :
				txtChance.setText("");
				break;
			}
			
		//obj==txtInput
			
		} else if (obj == bntNew) {
			Chance = 0; //찬스, 액션 횟수 새로 센다
			Number = (int)(Math.random()*100)+1; //새게임, 숫자 랜덤 re
			startTime = System.currentTimeMillis(); //새게임, 시간 캡쳐 re
			
			txtChance.setText("♥♥♥♥♥");
			txtResult.setText("1부터 100사이의 숫자를 맞춰보세요. \n");
			txtResult.append("------------------------------ \n");
		//obj == bntNew	
		}
			
		
	}//actionPerformed

}//class
