package ex01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelEx extends JFrame{
	
	Container c = getContentPane();
	JPanel pnlNorth = new JPanel(); //JPanel �� �⺻ ��ġ�����ڴ�  FlowLayout
	JPanel pnlCenter = new JPanel(); //<div>
	
	JButton btnNewGame = new JButton("������"); //<button>, <input type="button">
	JButton btnOpen = new JButton("����");
	JButton btnExit = new JButton("����");
	
	JLabel lblBanana = new JLabel("�ٳ���"); //<label>
	JLabel lblApple = new JLabel("���");

	public PanelEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("�г� ����");
		setSize(500, 500);
		
		setUI(); //�޼ҵ� ����� ��ü �ȿ��� ����
		
		setVisible(true);
	}
	
	private void setUI() {
		pnlNorth.add(btnNewGame);
		pnlNorth.add(btnOpen);
		pnlNorth.add(btnExit);
		pnlNorth.setBackground(Color.GREEN);
		
		pnlCenter.setLayout(null);
		lblBanana.setSize(100, 50);
		lblBanana.setLocation(100, 100);
		lblApple.setSize(100, 50);
		lblApple.setLocation(300, 300);
		pnlCenter.add(lblBanana);
		pnlCenter.add(lblApple);
		pnlCenter.setBackground(Color.YELLOW);
		
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(pnlCenter, BorderLayout.CENTER);
	}
	
	public static void main(String[] args) {
		new PanelEx();
	}

}//class
