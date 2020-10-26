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
	
	JButton bntOk = new JButton("Ȯ��");
	JButton bntNew = new JButton("������");
	
	JTextField txtInput = new JTextField(10);
	JTextField txtScore = new JTextField(10);
	JTextField txtChance = new JTextField(10);
	
	JTextArea txtResult = new JTextArea();
	
	JLabel lblInput = new JLabel("�Է� : ");
	JLabel lblScore = new JLabel("��� : ");
	JLabel lblChance = new JLabel("����Ƚ�� : ");
	
	long startTime = 0; //Ŭ���� ���ư� �� , ���� �ð� ĸ��
	
	int Chance = 0;
	int Number = 0; //�ϴ� 0���� ����
	
	
	public NumberPuzzle() {
		setTitle("������~ ���� ���� ���߱�~ !!!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		startTime = System.currentTimeMillis(); //���� ������ �� , ���� �ð� ĸ��
		
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
		
		Number = (int)(Math.random()*100)+1; //���� ���� ����
		
//		pnlCenter.setLayout(new BorderLayout()); //�ؽ�Ʈ�Ʒ��� �ٷ� �ᵵ ��� ����
//		pnlCenter.add(txtResult);
		c.add(txtResult, BorderLayout.CENTER);
		
		String welcome1 = "1���� 100������ ���ڸ� ���纸����. \n";
		String welcome2 = "------------------------------ \n";
		
		txtResult.append(welcome1);
		txtResult.append(welcome2);
		
		pnlSouth.add(lblChance);
		pnlSouth.add(txtChance);
		pnlSouth.setBackground(Color.cyan);
		c.add(pnlSouth, BorderLayout.SOUTH);
		
		txtChance.setText("����������");
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
			
			Chance++; //����, Ŭ�� �׼� Ƚ�� ����
			
//			System.out.println("---"+Chance+"|"+Number+"---");
//			System.out.println("���� : "+startTime);
			
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
			
		
	}//actionPerformed

}//class
