package ex05;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CheckBoxEx extends JFrame{

	public CheckBoxEx() {
		setTitle("Check Box");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		JCheckBox chkApple = new JCheckBox("Apple");
		JCheckBox chkPear = new JCheckBox("Pear", true); //체크된 상태로 시작
		JCheckBox chkDice = new JCheckBox(new ImageIcon("images/5.png"), true);
		chkDice.setSelectedIcon(new ImageIcon("images/1.png")); 
		//chkDice.setSelected(true); 상태
		add(chkApple);
		add(chkPear);
		add(chkDice);
		
		chkApple.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("apple");
			}
		});
		
		chkPear.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				Object obj = e.getItem(); //e.getSource();
				JCheckBox chkBox = (JCheckBox) obj;
				if (chkBox == chkPear) {
					String text = chkBox.getText(); 
					System.out.println(text+"|");
				}
//				System.out.println(e);
				int state = e.getStateChange();
//				System.out.println(state);
				switch (state) {
				case ItemEvent.SELECTED :
					System.out.println("checked");
					chkDice.setSelected(true);
					break;
				case ItemEvent.DESELECTED :
					System.out.println("check X");
					chkDice.setSelected(false);
					break;
				}
			}
		});
		
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckBoxEx();
	}

}//class
