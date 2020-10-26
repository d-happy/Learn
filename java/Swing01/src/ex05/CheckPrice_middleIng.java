package ex05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class CheckPrice_middleIng extends JFrame implements ItemListener {
	
	String[] fruits = new String[] {"Apple", "Pear", "Cherry", "Banana"};
	int[] prices = new int[] {200, 500, 700, 1000};
	JCheckBox[] boxes = new JCheckBox[fruits.length];
	
	JTextField txtMoney = new JTextField(7);
	private int money = 0;
	
	
	public CheckPrice_middleIng() {
		setTitle("CheckPrice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setListener();
		setSize(100*fruits.length, 150);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getItem();
		
		int state = ((ItemEvent)obj).getStateChange();
		
		for (int i=0; i<fruits.length; i++) {
			if (obj == boxes[i]) {
				
				stateSelected();
			}
		}
			
		}
		/*
		} else if (obj == chkPear) {
			switch (state) {
			case ItemEvent.SELECTED :
				money =+ pear;
				break;
			case ItemEvent.DESELECTED : 
				money =+ (-pear);
				break;
			}
		} else if (obj == chkCherry) {
			switch (state) {
			case ItemEvent.SELECTED :
				money =+ cherry;
				break;
			case ItemEvent.DESELECTED : 
				money =+ (-cherry);
				break;
			}
		}
		*/
		
		DecimalFormat df = new DecimalFormat("###,##0"); 
		txtMoney.setText(df.format(money));
	}//itemStateChanged
	
	private void stateSelected() {
		
		if (ItemEvent.SELECTED = true) {
			money =+ prices[0];
			break;
		}
		case ItemEvent.DESELECTED : 
			money =+ (-prices[0]);
			break;
		}
	}

	private void setListener() {
		chkApple.addItemListener(this);
		chkPear.addItemListener(this);
		chkCherry.addItemListener(this);
	}//setListener

	private void setUI() {
		Container c= getContentPane();
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.yellow);
		JPanel pnlCenter = new JPanel();
		pnlCenter.setBackground(Color.white);
		
		JLabel[] labels = new JLabel[fruits.length];
		for (int i=0; i<fruits.length; i++) {
			String labelStr = fruits[i] + ":" + prices[i] + "원";
			if (i != fruits.length-1) {
				labelStr = labelStr + ", "; 
			}
			labels[i] =new JLabel(labelStr);
			pnlNorth.add(labels[i]);
		}
		c.add(pnlNorth, BorderLayout.NORTH);
		
		for (int i=0; i<fruits.length; i++) {
			boxes[i] = new JCheckBox(fruits[i]);
			boxes[i].setBackground(Color.white);
			pnlCenter.add(boxes[i]);
		}
		c.add(pnlCenter, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.cyan);
		pnlSouth.add(new JLabel("현재금액: "));
		pnlSouth.add(txtMoney);
		txtMoney.setText(String.valueOf(money));
		pnlSouth.add(new JLabel("원"));
		c.add(pnlSouth, BorderLayout.SOUTH);		
	}//setUI

	public static void main(String[] args) {
		new CheckPrice_middleIng();
	}


}//class
