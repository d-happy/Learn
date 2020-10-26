package ex05;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class RadioDice_Smile extends JFrame implements ActionListener{
	
	JRadioButton rdoYellow = new JRadioButton("Smile_Yellow", true);
	JRadioButton rdoWhite = new JRadioButton("Smile_White");
	JRadioButton rdoBlack = new JRadioButton("Smile_Black");
	JLabel lblSmile = new JLabel();
	
	public RadioDice_Smile() {
		setTitle("Smile_Color");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(500, 510);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == rdoYellow) {
			System.out.println("-y");
			lblSmile.setIcon(new ImageIcon("images/smile_yellow.jpg"));
		} else if (obj == rdoWhite) {
			System.out.println("w");
			lblSmile.setIcon(new ImageIcon("images/smile_white.jpg"));
		} else if (obj == rdoBlack) {
			System.out.println("-b");
			lblSmile.setIcon(new ImageIcon("images/smile_black.jpg"));
		}
	}
	
	private void setUI() {
		Container c= getContentPane();
		JPanel pnlNorth = new JPanel();
		setLayout(new FlowLayout());
		
		rdoYellow.setBackground(Color.yellow);
		rdoWhite.setBackground(Color.white);
		rdoBlack.setBackground(Color.gray);
		rdoYellow.addActionListener(this);
		rdoWhite.addActionListener(this);
		rdoBlack.addActionListener(this);
		
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdoYellow);
		bGroup.add(rdoWhite);
		bGroup.add(rdoBlack);
		
		pnlNorth.add(rdoYellow);
		pnlNorth.add(rdoWhite);
		pnlNorth.add(rdoBlack);
		
		c.add(pnlNorth);
		c.add(lblSmile);
		
	}//setUI

	public static void main(String[] args) {
		new RadioDice_Smile();
	}


}//class
