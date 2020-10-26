package ex02;

import java.awt.Color;
//import java.awt.*;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JTextFieldEx2 extends JFrame{

	Container c = getContentPane();
	JTextField txtInput = new JTextField(10);
	JTextField txtOutput = new JTextField(10);
	JButton btnCheck = new JButton("Check");
	
	ActionListener lis = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
//			String text = txtInput.getText();
//			txtOutput.setText(text);
//			txtInput.setText("");
			
			Object obj = e.getSource(); //액션 당사자가 어디냐? 3가지 나눠서 작동
			
			if (obj == txtInput) {
				String text1 = txtInput.getText();
				txtOutput.setText(text1);
				txtInput.setText("");
				c.setBackground(Color.darkGray);
			} else if (obj == txtOutput) {
				String text2 = txtOutput.getText();
				txtOutput.setText("");
				txtInput.setText(text2);
				c.setBackground(Color.lightGray);
			} else if (obj == btnCheck) {
				String text1 = txtInput.getText();
				String text2 = txtOutput.getText();
				txtOutput.setText(text1);
				txtInput.setText(text2);
				c.setBackground(Color.pink);
				/*if (!text1.equals("")) {
					txtOutput.setText(text1);
					txtInput.setText("");
				} else if (!text2 .equals("")) {
					txtInput.setText(text2);
					txtOutput.setText("");
				} else if (!text1.equals("") && !text2 .equals("")) {*/
			}
			
		}//actionPerformed
		
	}; //ActionListener
	
	public JTextFieldEx2() {
		setTitle("패널 입력 출력 바꾸기 확인");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setListener();
		setSize(500, 500);
		setVisible(true);
	}
	
	private void setListener() {
		btnCheck.addActionListener(lis);
		txtInput.addActionListener(lis);
		txtOutput.addActionListener(lis);
//		txtOutput.addActionListener(lis); //서로 바꾸기 할 때
	}

	private void setUI() {
		setLayout(new FlowLayout());
		c.add(txtInput);
		c.add(btnCheck);
		c.add(txtOutput);
	}

	public static void main(String[] args) {
		new JTextFieldEx2();
	}
	
}//class
