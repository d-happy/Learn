package puzzle_2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class NumberPuzzle extends JFrame {
	
	
	private Container c = getContentPane();
	private JPanel pnlNorth = new JPanel();
	private JPanel pnlSouth = new JPanel();
	private JButton bntOk = new JButton("Ȯ��");
	private JButton bntNew = new JButton("������");
	private JTextField txtInput = new JTextField(10);
	private JTextField txtScore = new JTextField(10);
	private JTextField txtLifeCount = new JTextField(10);
	private JTextArea txtResult = new JTextArea();
	private JLabel lblInput = new JLabel("�Է� : ");
	private JLabel lblScore = new JLabel("��� : ");
	private JLabel lblChance = new JLabel("����Ƚ�� : ");
	
	
	public NumberPuzzle() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		
		
		GameManager manager = GameManager.getInstance(); //main �ȿ��� �ҷ��� main ������ �� ������
		
		NumberPuzzle puzzle = new NumberPuzzle(); //�г�â ����, �ȿ��� UI �� ��
		
		puzzle.makePuzzle();
		
//		puzzle.welcome();
		
//		manager.setListener();
		
		manager.ingGame();
		
		manager.newGame();
		
		
	}//main
	
	
	public void makePuzzle() {
		setTitle("������~ ���� ���� ���߱�~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(500, 500);
		setVisible(true);
	}//makePuzzle()
	
	
	public void setUI() {
		pnlNorth.add(lblInput);
		pnlNorth.add(txtInput);
		pnlNorth.add(bntOk);
		pnlNorth.add(lblScore);
		pnlNorth.add(txtScore);
		txtScore.setText("1000000");
		pnlNorth.add(bntNew);
		pnlNorth.setBackground(Color.yellow);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		c.add(txtResult, BorderLayout.CENTER);
		
		pnlSouth.add(lblChance);
		pnlSouth.add(txtLifeCount);
		pnlSouth.setBackground(Color.cyan);
		c.add(pnlSouth, BorderLayout.SOUTH);
		
//		heart();
	}//setUI()
	/*
	public void heart(int lifeCount) {
		
		switch (lifeCount) {
		case 0 : 
			txtChance.setText("����������");
			break;
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
		
	}
		
	
	public void welcome() {
		String welcome1 = "1���� 100������ ���ڸ� ���纸����. \n";
		String welcome2 = "--------------------------------------------------- \n";
		
		txtResult.append(welcome1);
		txtResult.append(welcome2);
	}
	*/

	
	
}//class
