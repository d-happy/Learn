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
		setTitle("�޺��ڽ� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setImages(); //images[]�� �̹��� �ϳ��ϳ� �־��ְ�
		setUI(); //����
		setSize(500, 500);
		setVisible(true); //���� �ö󰡸� �� ����?? ����??
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
		int index = combo1.getSelectedIndex(); //JComboBox�� �ε��� 0,1,2~ int�� ������
		lblImage.setIcon(images[index]);
	}

}//class
