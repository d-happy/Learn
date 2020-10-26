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
public class SimpleImageViewer extends JFrame {
	
	ImageIcon[] imgIcon = new ImageIcon[4];
	JLabel lblImage = new JLabel();
	int index = 0;

	public SimpleImageViewer() {
		setTitle("Simple Image Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setImage();
		setUI();
		setSize(500, 500);
		setVisible(true);
	}

	private void setImage() {
		for (int i=0; i<imgIcon.length; i++) {
			imgIcon[i] = new ImageIcon("images/image"+i+".jpg");
		}
	}

	private void setUI() {
		Container c = getContentPane();
		
		JPanel pnlNorth = new JPanel();
		c.add(pnlNorth, BorderLayout.NORTH);
		pnlNorth.setBackground(Color.white);
		JSlider slider = new JSlider(1, 4, 1);
		slider.setBackground(Color.white);
		slider.setPaintLabels(true); 
		slider.setPaintTicks(true); 
		slider.setMajorTickSpacing(1);
		pnlNorth.add(slider);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				index = slider.getValue() -1;
				imgIcon[index] = new ImageIcon("images/image"+index+".jpg");
				lblImage.setIcon(imgIcon[index]);
				lblImage.setVerticalAlignment(SwingConstants.CENTER);
			}
		});//slider.addChangeListener
		
		c.add(lblImage, BorderLayout.CENTER);
		lblImage.setIcon(imgIcon[0]);
		lblImage.setOpaque(true);
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setVerticalAlignment(SwingConstants.CENTER);
		
		JPanel pnlSouth = new JPanel();
		c.add(pnlSouth, BorderLayout.SOUTH);
		pnlSouth.setBackground(Color.white);
		JButton btnLeft = new JButton();
		JButton btnRight = new JButton();
		btnLeft.setIcon(new ImageIcon("images/left.png"));
		btnRight.setIcon(new ImageIcon("images/right.png"));
		pnlSouth.add(btnLeft);
		pnlSouth.add(btnRight);
		btnRight.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index ++;
				if (0 <= index && index < imgIcon.length) {
					System.out.println("->" + index);
					imgIcon[index] = new ImageIcon("images/image"+index+".jpg");
					lblImage.setIcon(imgIcon[index]);
				} else {
					index = 0;
					System.out.println("->" + index);
					imgIcon[index] = new ImageIcon("images/image"+index+".jpg");
					lblImage.setIcon(imgIcon[index]);
				}
				lblImage.setVerticalAlignment(SwingConstants.CENTER);
				slider.setValue(index+1);
			} 
		});//btnRight.addActionListener
		btnLeft.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				index --;
				if (0 <= index && index < imgIcon.length) {
					System.out.println("<-" + index);
					imgIcon[index] = new ImageIcon("images/image"+index+".jpg");
					lblImage.setIcon(imgIcon[index]);
				} else { 
					index = imgIcon.length-1;
					System.out.println("<-" + index);
					imgIcon[index] = new ImageIcon("images/image"+index+".jpg");
					lblImage.setIcon(imgIcon[index]);
				}
				lblImage.setVerticalAlignment(SwingConstants.CENTER);
				slider.setValue(index+1);
			}
		});//btnLeft.addActionListener
	}

	public static void main(String[] args) {
		new SimpleImageViewer();
	}

}//class
