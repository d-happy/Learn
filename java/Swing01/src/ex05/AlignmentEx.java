package ex05;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class AlignmentEx extends JFrame{

	public AlignmentEx() {
		// 여유 공간을 확인
		setTitle("정렬 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setLayout(new FlowLayout()); //여유 공간을 확인하고
		JButton button = new JButton(new ImageIcon("images/smile_middle.png"));
		button.setHorizontalAlignment(SwingConstants.RIGHT); //가로
		button.setVerticalAlignment(SwingConstants.BOTTOM); //세로
		add(button);
		setSize(500, 500);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AlignmentEx();
	}

}//class
