package ex05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class JSliderColorEx extends JFrame implements ChangeListener {
	
	Container c = getContentPane();
	JSlider[] sliders = new JSlider[3];
	Color[] colors = {Color.red, Color.green, Color.blue};
	JLabel label = new JLabel("색상변경");

	public JSliderColorEx() {
		setTitle("슬라이더 색상 변경");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUI();
		setSize(700, 300);
		setVisible(true);
	}

	private void setUI() {
		//North
		JPanel pnlNorth = new JPanel();
		for (int i=0; i<sliders.length; i++) {
			sliders[i] = new JSlider(0, 255, 128); //(최소, 최대, 시작)
			sliders[i].setForeground(colors[i]); // 텍스트 색상
			sliders[i].setPaintLabels(true); //라벨 보임
			sliders[i].setPaintTicks(true); //눈금 보임
			sliders[i].setMajorTickSpacing(50);
			sliders[i].setMinorTickSpacing(10);
			sliders[i].addChangeListener(this);
			pnlNorth.add(sliders[i]);
		}
		c.add(pnlNorth, BorderLayout.NORTH);
		
		//Center
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setVerticalAlignment(SwingConstants.CENTER);
		c.add(label);
	}

	public static void main(String[] args) {
		new JSliderColorEx();
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int red = sliders[0].getValue();
		int green = sliders[1].getValue();
		int blue = sliders[2].getValue();
		
		Color color = new Color(red, green, blue);
		label.setBackground(color);
	}

}//class
