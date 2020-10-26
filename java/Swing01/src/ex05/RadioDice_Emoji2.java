package ex05;

import java.awt.BorderLayout;
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
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class RadioDice_Emoji2 extends JFrame implements ItemListener {
	
	JRadioButton[] rdo = new JRadioButton[3];
	String[] names = {"Emoji_Happy", "Emoji_Beam", "Emojo_Blush"};
	ImageIcon[] img = new ImageIcon[rdo.length]; 
	JLabel lblSmile = new JLabel();
	
	public RadioDice_Emoji2() {
		setTitle("Emoji_��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(450, 450);
		setVisible(true);
	}
	
	private void setUI() {
		Container c= getContentPane();
		JPanel pnlNorth = new JPanel();
//		setLayout(new FlowLayout());
		Color c1 = new Color(102, 204, 102);
		Color c2 = new Color(102, 204, 204);
		ButtonGroup bGroup = new ButtonGroup();
		for (int i=0; i<rdo.length; i++) {
			if (i == 0) {
				rdo[i] = new JRadioButton(names[i], true);
			} else {
				rdo[i] = new JRadioButton(names[i]);
			} //������ �迭 ����� �ȿ� ���빰 �ϳ��� �����ؾ�, rdo[i]���� �� �� �� ����
			bGroup.add(rdo[i]);
			pnlNorth.add(rdo[i]);
			rdo[i].addItemListener(this);
		}
		rdo[0].setBackground(c1);
		rdo[1].setBackground(c2);
		rdo[2].setBackground(Color.pink);
		img[0] = new ImageIcon("images/emoji_happy_small.png");
		img[1] = new ImageIcon("images/emoji_beam_small.png");
		img[2] = new ImageIcon("images/emoji_blush_small.png");
		Color c3 = new Color(255, 255, 240);
		c.setBackground(c3);
		pnlNorth.setBackground(c3);
		c.add(pnlNorth, BorderLayout.NORTH);
		c.add(lblSmile, BorderLayout.CENTER);
		lblSmile.setIcon(new ImageIcon("images/emoji_shy_small.png"));
	}//setUI
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getItem();
		JRadioButton radio = (JRadioButton)obj;
		String str = radio.getText(); 
		//ItemListener�Ǵ� ��ü e�� ??�� ���� obj ����� JRadioButton���� �ٿ�ĳ�����ؼ� getText(); ����
		//if�� radio == ItemEvent.DESELECTED �̸� return; �ؼ� �ߺ� üũ ����
		for (int i=0; i<rdo.length; i++) {
			if (rdo[i].isSelected()) { //rdo[i]�� checked
				lblSmile.setIcon(img[i]);
				System.out.println(str);
				break;
			}
		}
	}//itemStateChanged

	public static void main(String[] args) {
		new RadioDice_Emoji2();
	}

}//class
