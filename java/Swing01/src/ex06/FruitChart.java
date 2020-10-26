package ex06;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class FruitChart extends JFrame implements ActionListener{
	
	MyPanel panel = new MyPanel();
	String[] fruits = {"Grape", "Peach", "Kiwi", "Banana"};
	JTextField[] txtFruits = new JTextField[fruits.length];
	Color[] colors = {new Color(153, 102, 204), new Color(255, 102, 102), 
			new Color(0, 153, 102), new Color(255, 204, 0)};
	int[] countFruits = new int[fruits.length];
	double[] percentageFruits = new double[fruits.length];
//	int countSum = 0; 
	int[] perAngle = new int[fruits.length];
	int startAngle = 0;

	public FruitChart() {
		setTitle("Fruit Chart");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setListener();
		setSize(150*fruits.length, 400);
		setVisible(true);
	}

	private void setUI() {
		Container c = getContentPane();
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.cyan);
		for (int i=0; i<fruits.length; i++) {
			JLabel[] labels = new JLabel[fruits.length];
			labels[i] = new JLabel(fruits[i]);
			txtFruits[i] = new JTextField("0", 5);
			txtFruits[i].setHorizontalAlignment(SwingConstants.RIGHT);
			pnlNorth.add(labels[i]);
			pnlNorth.add(txtFruits[i]);
		}
		c.add(pnlNorth, new BorderLayout().NORTH);
		c.add(panel, new BorderLayout().CENTER);
	}

	private void setListener() {
		for (int i=0; i<fruits.length; i++) {
			txtFruits[i].addActionListener(this);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int countSum = 0; //문제!!!!1 문제!!!!!!!!!!!!
		
		for (int i=0; i<fruits.length; i++) {
			countFruits[i] = Integer.parseInt(txtFruits[i].getText());
//			System.out.println(fruits[i] +" : "+ countFruits[i]);
			countSum += countFruits[i];
		}
//		System.out.println("sum : "+countSum);
		
		for (int i=0; i<fruits.length; i++) {
			percentageFruits[i] = (countFruits[i] / (double)countSum)*100;
			percentageFruits[i] = Math.round(percentageFruits[i]*100)/100.0;
			perAngle[i] = (int)(360 * (percentageFruits[i]/100));
//			System.out.println("% : "+percentageFruits[i]);
//			System.out.println(perAngle[i]);
		}
		panel.repaint();
	}//actionPerformed
	
	class MyPanel extends JPanel {
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int pw = panel.getWidth();
			int ph = panel.getHeight();
			int gWidth = panel.getWidth()/3;
			int wHeight = panel.getWidth()/3;
			int x = pw/2 - gWidth/2;
			int y = ph/2 - wHeight/2;
		
			for (int i=0; i<fruits.length; i++) {
				g.setColor(colors[i]);
				
				g.fillArc(x, y, gWidth, wHeight, startAngle, perAngle[i]);
//				System.out.println(startAngle+"시|각"+perAngle[i]);
				startAngle += perAngle[i];
				
				g.setFont(new Font("돋음", Font.BOLD, 17));
				g.drawString(fruits[i] + " : " + percentageFruits[i] + "%", 10 + (pw/fruits.length)*i, 25);
			}
		}//paintComponent
	}//MyPanel

	public static void main(String[] args) {
		new FruitChart();
	}

}//class
