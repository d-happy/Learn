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

	private long startTime = System.currentTimeMillis(); //Ŭ���� ���ư� �� , ���� �ð� ĸ��
	
	private int lifeCount = 0;
	private int targetNum = 0; //�ϴ� 0���� ����
	
	
	public void setListener() {
//		txtInput.addActionListener(this);
//		bntOk.addActionListener(this);
//		bntNew.addActionListener(this);
	}
	
	public void ingGame() {
		
		
		
	}
	
	public void newGame() {
		
	}
	
	
	
	
	
 // ------------------------------------���� ����
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
// ------------------------------------���� ����

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if ((obj == txtInput) || (obj == bntOk)) {
			
			Chance++; //����, Ŭ�� �׼� Ƚ�� ����
			
			System.out.println("---"+Chance+"|"+Number+"---");
			System.out.println("���� : "+startTime);
			
			int numUser = Integer.parseInt(txtInput.getText());
			txtInput.setText("");
			
			if (Chance <= 5) {
				
				if (numUser > Number) {
					txtResult.append(numUser + "���� �۽��ϴ�. \n");
				} else if (numUser < Number) {
					txtResult.append(numUser + "���� Ů�ϴ�. \n");
				} else if (numUser == Number) {
					
					txtResult.append(Number + " : �����Դϴ�!!!!! \n");
					
					long endTime = System.currentTimeMillis();
					
					System.out.println("���� : "+endTime);
					
					long resultTime1 = endTime-startTime; //���� ���� ���� �ð� ĸ�Ķ� ��
					txtResult.append("�ɸ� �ð� : "+(resultTime1)+"\n"); //�ɸ� �ð� ���
					
					String timeScore1 = txtScore.getText();
					long timeScore2 = Long.parseLong(timeScore1);
					
					if (resultTime1 < timeScore2) {
						txtResult.append("< ��� �ֽ�!!!!!!! >");
						
						String resultTime2 = (""+resultTime1);
						txtScore.setText(resultTime2);
					}
				//numUser == Number
				}
			//Chance <= 5	
			} else {
				
				txtResult.append("----------------------------------\n");
				txtResult.append("��������\n");
				
				return;
			//Chance 5 �ʰ�
			}
			
			switch (Chance) {
			case 1 :
				txtChance.setText("��������");
				break;
			case 2 :
				txtChance.setText("������");
				break;
			case 3 :
				txtChance.setText("����");
				break;
			case 4 :
				txtChance.setText("��");
				break;
			case 5 :
				txtChance.setText("");
				break;
			}
			
		//obj==txtInput
			
		} else if (obj == bntNew) {
			Chance = 0; //����, �׼� Ƚ�� ���� ����
			Number = (int)(Math.random()*100)+1; //������, ���� ���� re
			startTime = System.currentTimeMillis(); //������, �ð� ĸ�� re
			
			txtChance.setText("����������");
			txtResult.setText("1���� 100������ ���ڸ� ���纸����. \n");
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
