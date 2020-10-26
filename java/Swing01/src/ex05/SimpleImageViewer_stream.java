package ex05;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

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
public class SimpleImageViewer_stream extends JFrame implements ActionListener, ChangeListener {
	
	int index = 0;
	int indexImage = 0;
	ImageIcon[] imgIcon = null;
	JSlider slider = new JSlider(1, 4, 1);
	JLabel lblImage = new JLabel();
	JButton btnLeft = new JButton();
	JButton btnRight = new JButton();
	

	public SimpleImageViewer_stream() {
		setTitle("Simple Image Viewer_Stream");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setImage();
//		setUI();
		setSize(500, 500);
//		setVisible(true);
	}

	private void setImage() {
		
		String[] fileImages = null;
		
		int g = 0;
		
		File file = new File("D:\\images");
		String[] fileList = file.list();
		
		for (int i=0; i<fileList.length; i++) {
			int periodIndex = fileList[i].lastIndexOf(".");
			int fileLength = fileList[i].length();
			System.out.println(periodIndex + "|" + fileLength);
			
			int interval = fileLength - periodIndex; //4
			
			int startPeriod = fileLength - interval; //~.ccc 에서 .의 인덱스
			
			String str = fileList[i].substring(startPeriod);
			System.out.println(str);
			
			switch (str) {
			case ".png" : 
				System.out.println("----------png");
				
//				fileImages[i] = fileList[i];
				indexImage ++;
				
//				fileImage = fileList[i];
				System.out.println("======="+fileList[i]);
				
				break;
			case ".jpg" : 
				System.out.println("----------jpg");
				
				indexImage ++;
				
				System.out.println("======="+fileList[i]);
				
				break;
			case ".gif" : 
				System.out.println("----------gif");
				
				indexImage ++;
				
				System.out.println("======="+fileList[i]);
				
				break;
				
			default : 
				fileList[i] = null;
				break;
			}
			
			System.out.println("number : " + indexImage);
			
			System.out.println("파일 : " +fileList[i]);
			
		}//for
		System.out.println("sum : " + indexImage); //24
		
		fileImages = new String[indexImage];
		
		for (int i=0; i<fileImages.length; i++) {
			
			for (int j=i; j<fileList.length; i++) {
			
				if (fileList[i] != null) {
					fileImages[i] = fileList[i];
				}
			}
			
			System.out.println("------------------ 이미지 파일 : "+fileImages[i]);
		}
		
		
	}
	/*
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
	*/

	public static void main(String[] args) {
		new SimpleImageViewer_stream();
	}

}//class
