package ex02;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JTextFieldEx extends JFrame{
	
	Container c= getContentPane();
	JTextField txtInput = new JTextField(10);
	JButton btnOk = new JButton("Ȯ��");
	JTextField txtOutput = new JTextField(10);
	
	
	ActionListener lis = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String text = txtInput.getText();
//			System.out.println(text);
			txtOutput.setText(text);
			txtInput.setText(""); 
			//txtInput�� �Է��� ����=text, txtOutput�� ������
		}
	}; //ActionListener
	
	
	public JTextFieldEx() {
		setTitle("Ŭ�� ������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setListener();
		setSize(500, 500);
		setVisible(true);
	}
	
	private void setListener() {
		btnOk.addActionListener(lis); //���⼭, Ŭ���� �� ����
		txtInput.addActionListener(lis); //���⼭, ������ �� ����
	}

	private void setUI() {
		c.setLayout(new FlowLayout());
		c.add(txtInput);
		c.add(btnOk);
		c.add(txtOutput);
	}
	
	public static void main(String[] args) {
		new JTextFieldEx();
	}

}//class
