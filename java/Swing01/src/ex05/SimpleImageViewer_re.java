package ex05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

@SuppressWarnings("serial")
public class SimpleImageViewer_re extends JFrame implements ActionListener, ChangeListener {
	
	ImageIcon[] imgIcon = new ImageIcon[4];
	JSlider slider = new JSlider(1, 4, 1);
	JLabel lblImage = new JLabel();
	JButton btnLeft = new JButton(new ImageIcon("images/left.png"));
	JButton btnRight = new JButton(new ImageIcon("images/right.png"));
	int index = 0;

	public SimpleImageViewer_re() {
		setTitle("Simple Image Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setImage();
		setUI();
		setSize(500, 500);
		setVisible(true);
	}

	private void setImage() {
		for (int i=0; i<imgIcon.length; i++) {
			imgIcon[i] = new ImageIcon("images/image" + i + ".jpg");
		}
	}

	private void setUI() {
		Container c = getContentPane();
		
		JPanel pnlNorth = new JPanel();
		c.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setBackground(Color.white);
		slider.setBackground(Color.white);
		slider.setPaintLabels(true); 
		slider.setPaintTicks(true); 
		slider.setMajorTickSpacing(1);
		pnlNorth.add(slider);
		slider.addChangeListener(this);
		
		c.add(lblImage, BorderLayout.CENTER);
		setIcon();
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setVerticalAlignment(SwingConstants.CENTER);
		
		JPanel pnlSouth = new JPanel();
		c.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setBackground(Color.white);
		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);
		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);
	}//setUI

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		++index;
		if (obj == btnRight) {
			if (0 <= index && index < imgIcon.length) { } 
			else { index = 0; }
		} else if (obj == btnLeft) {
			index +=-2;
			if (0 <= index && index < imgIcon.length) { } 
			else { index = imgIcon.length-1; }
		}
		setIcon();
	}//actionPerformed

	@Override
	public void stateChanged(ChangeEvent e) {
		index = slider.getValue() -1;
		setIcon();
	}//stateChanged
	
	private void setIcon() {
		imgIcon[index] = new ImageIcon("images/image"+index+".jpg");
		lblImage.setIcon(imgIcon[index]);
		slider.setValue(index+1);
	}

	public static void main(String[] args) {
		new SimpleImageViewer_re();
	}

}//class
