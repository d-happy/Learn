package ex05;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class JRadioButtonEx extends JFrame{
	
	// <input type = "radio" name = "radio">

	public JRadioButtonEx() {
		setTitle("라디오 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JRadioButton rdoMale = new JRadioButton("Male", true); //checked
		JRadioButton rdoFemale = new JRadioButton("Female");
		
		//라디오버튼을 하나의 그룹으로 묶기
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdoMale);
		bGroup.add(rdoFemale);
		
		add(rdoMale);
		add(rdoFemale);
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JRadioButtonEx();
	}

}//class
