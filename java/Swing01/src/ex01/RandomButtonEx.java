package ex01;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class RandomButtonEx extends JFrame {

	public RandomButtonEx() {
		
		Container c = getContentPane();
//		Color col = new Color(33CCCC, true);
//		c.setBackground(Color.#6BEBD6);
		
		setDefaultCloseOperation(RandomButtonEx.EXIT_ON_CLOSE);
		setTitle("��ư 10�� ���� ��ġ");
		setSize(500, 500);
		setLayout(null);
		
		for (int i=1; i<=10; i++) {
			JButton button = new JButton("����" + i);
			button.setSize(75, 75);
			
			int num1 = (int) ((Math.random()*400)+1);
			int num2 = (int) ((Math.random()*400)+1);
			
			button.setLocation(num1, num2);
			
			c.add(button);
		}
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new RandomButtonEx();
	}

	
	/*
	//	Container c = getContentPane();
	//	JPanel pnlCenter = new JPanel(); 
 	
	private void setUI() {
		
		//	JButton btn1 = new JButton("����");
//	JButton btn2 = new JButton("���");
//	JButton btn3 = new JButton("��");
//	JButton btn4 = new JButton("ü��");
//	JButton btn5 = new JButton("Ű��");
		
		JButton btn=null;
		
		for (int i=1; i<-10; i++) {
			btn = new JButton("����"+i);
		}
		
		pnlCenter.add(btn);
//		pnlCenter.add(btn2);
//		pnlCenter.add(btn3);
//		pnlCenter.add(btn4);
//		pnlCenter.add(btn5);
		
		btn.setSize(30, 30);
//		btn2.setSize(30, 30);
//		btn3.setSize(30, 30);
//		btn4.setSize(30, 30);
//		btn5.setSize(30, 30);
		
		c.add(pnlCenter, BorderLayout.CENTER);
	}
	*/
	

}//class
