package ex05;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class JComboBoxEx extends JFrame{
	
	Container c = getContentPane();
	String[] str1 = {"A", "B", "C", "D"};
	String[] str2 = {"가", "나", "다", "라"};

	JComboBox<String> combo1 = new JComboBox<>(str1);
	JComboBox<String> combo2 = new JComboBox<>();
	
	public JComboBoxEx() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setVisible(true);
		setUI();
	}

	private void setUI() {
		c.setLayout(new FlowLayout());
		c.add(combo1);
		
		for (int i=0; i<str2.length; i++) {
			combo2.addItem(str2[i]);
		}
		c.add(combo2);
	}
	
	public static void main(String[] args) {
		new JComboBoxEx();
	}

}//class
