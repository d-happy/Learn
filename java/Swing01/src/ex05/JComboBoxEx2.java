package ex05;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class JComboBoxEx2 extends JFrame implements ActionListener {
	
	Container c = getContentPane();
	String[] str1 = {"1", "2", "3", "4", "5", "6"};
	ImageIcon[] images = new ImageIcon[str1.length];
	JComboBox<String> combo1 = new JComboBox<>(str1);
	JLabel lblImage = new JLabel();
	
	public JComboBoxEx2() {
		setTitle("콤보박스 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setImages(); //images[]에 이미지 하나하나 넣어주고
		setUI(); //세팅
		setSize(500, 500);
		setVisible(true); //위로 올라가면 안 보임?? 와이??
	}

	private void setImages() {
		for (int i=0; i<images.length; i++) {
			images[i] = new ImageIcon("images/"+str1[i]+".png");
		}
	}

	private void setUI() {
		c.setLayout(new FlowLayout());
		c.add(combo1);
		lblImage.setIcon(images[0]);
		c.add(lblImage);
		combo1.addActionListener(this);
	}
	
	public static void main(String[] args) {
		new JComboBoxEx2();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int index = combo1.getSelectedIndex(); //JComboBox의 인덱스 0,1,2~ int로 구해줌
		lblImage.setIcon(images[index]);
	}

}//class
