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
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class CheckPrice extends JFrame implements ItemListener {
	
	String[] fruits = new String[] {"Apple", "Pear", "Cherry", "Banana", "Kiwi"};
	int[] prices = new int[] {200, 500, 700, 1000, 800};
	JCheckBox[] boxes = new JCheckBox[fruits.length]; //공통된 거 배열로 만들어 코드 중복 제거
	
	JTextField txtMoney = new JTextField(7);
	private int money = 0;
	
	public CheckPrice() {
		setTitle("CheckPrice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(100*fruits.length, 150);
		setVisible(true);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getItem();
		int state = e.getStateChange();
		int price = 0;
		for (int i=0; i<fruits.length; i++) {
			if (obj == boxes[i]) {
				price = prices[i];
			}
		}
		if (state == ItemEvent.DESELECTED) {
			price *= -1;
		}
		money += price;
		DecimalFormat df = new DecimalFormat("###,##0"); 
		txtMoney.setText(df.format(money));
	}//itemStateChanged

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
				labelStr += ", "; 
			}
			labels[i] =new JLabel(labelStr);
			pnlNorth.add(labels[i]);
		}
		c.add(pnlNorth, BorderLayout.NORTH);
		
		for (int i=0; i<fruits.length; i++) {
			boxes[i] = new JCheckBox(fruits[i]);
			boxes[i].addItemListener(this);
			boxes[i].setBackground(Color.white);
			pnlCenter.add(boxes[i]);
		}
		c.add(pnlCenter, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(Color.cyan);
		pnlSouth.add(new JLabel("현재금액: "));
		pnlSouth.add(txtMoney);
		txtMoney.setHorizontalAlignment(SwingConstants.RIGHT); //money 오른쪽 정렬
		txtMoney.setText(String.valueOf(money));
		pnlSouth.add(new JLabel("원"));
		c.add(pnlSouth, BorderLayout.SOUTH);		
	}//setUI

	public static void main(String[] args) {
		new CheckPrice();
	}


}//class
