package puzzle_3_alone;

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

	GameManager manager = GameManager.getinstance();
	
	Container c = getContentPane();
	JPanel pnlNorth = new JPanel();
	JPanel pnlSouth = new JPanel();
	JLabel lblInput = new JLabel("�Է� : ");
	JLabel lblScore = new JLabel("��� : ");
	JLabel lbllifeCount = new JLabel("����Ƚ�� : ");
	JTextField txtInput = new JTextField(10);
	JTextField txtScore = new JTextField(10);
	JTextField txtLifeCount = new JTextField(10);
	JButton bntOk = new JButton("Ȯ��");
	JButton bntNew = new JButton("������");
	JTextArea txtMessage = new JTextArea();
	
	final String heart = "��";
	final String message = "1���� 100������ ���ڸ� ���纸����. \n";
	final String line = "------------------------------ \n";
	
	long startTime = 0;
	
	int numberUser = 0;
	int count = 0;
	
	
	public static void main(String[] args) {
		new NumberPuzzle();
	}
	
	public NumberPuzzle() {
		setTitle("���� ���� ���� ���� ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setUI();
		setListener();
		manager.gameStart();
		printHeart();
		
		startTime = System.currentTimeMillis();
		
		setSize(500, 500);
		setVisible(true);
	}
	
	public void setUI() {
		pnlNorth.add(lblInput);
		pnlNorth.add(txtInput);
		pnlNorth.add(bntOk);
		pnlNorth.add(lblScore);
		pnlNorth.add(txtScore);
		pnlNorth.add(bntNew);
		pnlNorth.setBackground(Color.yellow);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		txtScore.setText("1000000");

		c.add(txtMessage, BorderLayout.CENTER);
		welcomeMessage();
		
		pnlSouth.add(txtLifeCount);
		pnlSouth.add(txtLifeCount);
		pnlSouth.setBackground(Color.cyan);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void welcomeMessage() {
		txtMessage.setText(message);
		txtMessage.append(line);
	}
	
	private void countMinusMessage() {
		txtMessage.append(line);
		txtMessage.append("<������>�� �����ϼ���.");
		txtInput.setEnabled(false);
		bntOk.setEnabled(false);
	}

	public void printHeart() {
		count = manager.getLifeCount();
		String blank = "";
		
		for (int i=0; i<count; i++) {
			blank += heart;
		}
		txtLifeCount.setText(blank);
	}

	public void setListener() {
		txtInput.addActionListener(this);
		bntOk.addActionListener(this);
		bntNew.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object obj = e.getSource();
		
		if (obj == txtInput || obj == bntOk) {
			
			System.out.println("�� : " + manager.getNumberRandom());
			
			count = manager.getLifeCount()-1;
			manager.setLifeCount(count);
			printHeart();
			
			numberUser = Integer.parseInt(txtInput.getText());
			txtInput.setText("");
			
			if (0 < numberUser && numberUser <= 100) {
		
				int resultPuzzle = manager.numResult(numberUser);
				
				switch (resultPuzzle) {
					case 1 : //BIG
						txtMessage.append(numberUser + "���� �۽��ϴ�. \n");
						break;
					case 2 : //SMALL
						txtMessage.append(numberUser + "���� Ů�ϴ�. \n");
						break;
					case 3 : //SAME
						txtMessage.append("< " + numberUser + " : �����Դϴ�!!!!! >\n");
						
						long endTime = System.currentTimeMillis();
						long resultTime = endTime-startTime; 
						txtMessage.append(line);
						txtMessage.append("�ɸ� �ð� : "+(resultTime)+"\n"); 
						
						String timeScoreStr = txtScore.getText();
						long timeScore = Long.parseLong(timeScoreStr);
						
						if (resultTime < timeScore) {
							txtMessage.append("< ��� �ֽ�!!!!!!! >\n");
							
							String resultTimeStr = (""+resultTime);
							txtScore.setText(resultTimeStr);
						}
						countMinusMessage();
						break;
					case 4 : //COUNT_MINUS
						countMinusMessage();
						break;
				}//switch
			
			} else {
				count = manager.getLifeCount()+1;
				manager.setLifeCount(count);
				printHeart();
				txtMessage.append(line);
				txtMessage.append("<1~100 ������ ����>�� �Է��� �ּ���\n");
				txtMessage.append(line);
			}
		//obj == txtInput || bntOk
			
		} else if (obj == bntNew) {
			manager.gameNew();
			startTime = System.currentTimeMillis(); //������, �ð� ĸ�� re
			
			welcomeMessage();
			
			txtInput.setEnabled(true);
			bntOk.setEnabled(true);
		//obj == bntNew	
		}
	}//actionPerformed


}//class
