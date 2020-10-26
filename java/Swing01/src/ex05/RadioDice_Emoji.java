package ex05;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@SuppressWarnings("serial")
public class RadioDice_Emoji extends JFrame implements ItemListener {
	
	JRadioButton rdoHappy = new JRadioButton("Emoji_Happy", true);
	JRadioButton rdoBeam = new JRadioButton("Emoji_Beam");
	JRadioButton rdoBlush = new JRadioButton("Emoji_Blush");
	JLabel lblSmile = new JLabel();
	
	public RadioDice_Emoji() {
		setTitle("Emoji_¢¾");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(450, 450);
		setVisible(true);
	}
	
	private void setUI() {
		Container c= getContentPane();
		JPanel pnlNorth = new JPanel();
		setLayout(new FlowLayout());
		Color c1 = new Color(102, 204, 102);
		Color c2 = new Color(102, 204, 204);
		rdoHappy.setBackground(c1);
		rdoBeam.setBackground(c2);
		rdoBlush.setBackground(Color.pink);
		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(rdoHappy);
		bGroup.add(rdoBeam);
		bGroup.add(rdoBlush);
		pnlNorth.add(rdoHappy);
		pnlNorth.add(rdoBeam);
		pnlNorth.add(rdoBlush);
		rdoHappy.addItemListener(this);
		rdoBeam.addItemListener(this);
		rdoBlush.addItemListener(this);
		Color c3 = new Color(255, 255, 240);
		c.setBackground(c3);
		pnlNorth.setBackground(c3);
		c.add(pnlNorth);
		c.add(lblSmile);
		lblSmile.setIcon(new ImageIcon("images/emoji_shy_small.png"));
	}//setUI
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		if (rdoHappy.isSelected()) {
			System.out.println("happy");
			lblSmile.setIcon(new ImageIcon("images/emoji_happy_small.png"));
		} else if (rdoBeam.isSelected()) {
			System.out.println("beam");
			lblSmile.setIcon(new ImageIcon("images/emoji_beam_small.png"));
		} else if (rdoBlush.isSelected()) {
			System.out.println("blush");
			lblSmile.setIcon(new ImageIcon("images/emoji_blush_small.png"));
		}
	}//itemStateChanged

	public static void main(String[] args) {
		new RadioDice_Emoji();
	}

}//class
