package ex04;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class ImageLabelEx extends JFrame{
	
	public ImageLabelEx() {
		setTitle("�̹��� ���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		ImageIcon image = new ImageIcon("images/smile.png");
		JLabel label = new JLabel(image);
		add(label);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new ImageLabelEx();
	}

}//class
