package puzzle_2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameManager implements ActionListener {
	
	private GameManager() {
	}
	private static GameManager instance;
	public static GameManager getInstance() {
		if (instance==null) {
			instance=new GameManager();
		}
		return instance;
	}

	private long startTime = System.currentTimeMillis(); //클래스 돌아갈 때 , 지금 시간 캡쳐
	
	private int lifeCount = 0;
	private int targetNum = 0; //일단 0으로 지정
	
	
	public void setListener() {
//		txtInput.addActionListener(this);
//		bntOk.addActionListener(this);
//		bntNew.addActionListener(this);
	}
	
	public void ingGame() {
		
		
		
	}
	
	public void newGame() {
		
	}
	
	
	
	
	
 // ------------------------------------게터 세터
	public int getlifeCount() {
		return lifeCount;
	}

	public void setlifeCount(int chance) {
		lifeCount = chance;
	}

	public int getNumber() {
		return targetNum;
	}

	public void settargetNum(int number) {
		targetNum = number;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
// ------------------------------------게터 세터

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if ((obj == txtInput) || (obj == bntOk)) {
			
			Chance++; //엔터, 클릭 액션 횟수 세기
			
			System.out.println("---"+Chance+"|"+Number+"---");
			System.out.println("시작 : "+startTime);
			
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
			
		
	}//actionPerformed(ActionEvent)

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	*/
	

}//class
