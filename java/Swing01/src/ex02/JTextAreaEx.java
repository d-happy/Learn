package ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class JTextAreaEx extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	JPanel pnlNorth = new JPanel();
	JTextField txtInput = new JTextField(10);
	JButton btnOk = new JButton("Click");
	JTextArea txtResult = new JTextArea();
	
	public JTextAreaEx() {
		setTitle("텍스트 에어리어 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		
		setUI();
		setListener();
	}
	
	private void setListener() {
		txtInput.addActionListener(this);
		btnOk.addActionListener(this);
		//ActionListener 인터페이스를 class에 implements 했으니까
		//this로 class 스스로 지칭함
	}

	private void setUI() {
		pnlNorth.add(txtInput);
		pnlNorth.add(btnOk);
		pnlNorth.setBackground(Color.cyan);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		txtResult.setBackground(Color.yellow);
		JScrollPane scroll = new JScrollPane(txtResult);
		c.add(scroll, BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		new JTextAreaEx();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String text = txtInput.getText();
		if (!text.equals("")) {
			txtResult.append(text + "\n");
			txtInput.setText("");
		}
	}

}//class
