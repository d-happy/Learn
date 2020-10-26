package ex05;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class JSliderEx extends JFrame{
	
	Container c = getContentPane();
	JSlider hSlider = new JSlider(); //0~100
	JSlider vSlider = new JSlider(JSlider.VERTICAL, 0, 200, 50);
	JTextField txt = new JTextField(5);

	public JSliderEx() {
		setTitle("슬라이더 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		hSlider.setPaintLabels(true);
		hSlider.setPaintTicks(true);
		hSlider.setPaintTrack(true);
		hSlider.setMajorTickSpacing(20); //눈금
		hSlider.setMinorTickSpacing(5);
		
		hSlider.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				int value = hSlider.getValue();
//				System.out.println(value);
				txt.setText(String.valueOf(value));
				vSlider.setValue(value*2);
			}
		});
		
		vSlider.setPaintTrack(false);
		
		c.add(hSlider);
		c.add(vSlider);
		c.add(txt);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JSliderEx();
	}

}//class
