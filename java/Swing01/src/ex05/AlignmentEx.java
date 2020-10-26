package ex05;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AlignmentEx extends JFrame{

	public AlignmentEx() {
		// ���� ������ Ȯ��
		setTitle("���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new FlowLayout()); //���� ������ Ȯ���ϰ�
		JButton button = new JButton(new ImageIcon("images/smile_middle.png"));
		button.setHorizontalAlignment(SwingConstants.RIGHT); //����
		button.setVerticalAlignment(SwingConstants.BOTTOM); //����
		add(button);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AlignmentEx();
	}

}//class
