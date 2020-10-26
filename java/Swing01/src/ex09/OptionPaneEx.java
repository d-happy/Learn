package ex09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class OptionPaneEx extends JFrame implements ActionListener {

	Container c = getContentPane();
	JButton btnInput = new JButton("input");
	JButton btnConfirm = new JButton("confirm");
	JButton btnMessage = new JButton("message");
	JTextField txt = new JTextField(10);
	
	public OptionPaneEx() {
		setTitle("OptionPaneEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnInput.addActionListener(this);
		btnConfirm.addActionListener(this);
		btnMessage.addActionListener(this);
		c.setLayout(new FlowLayout());
		c.add(btnInput);
		c.add(btnConfirm);
		c.add(btnMessage);
		c.add(txt);
		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnInput) {
			//prompt()
			String str = JOptionPane.showInputDialog("이름을 입력하세요");
			System.out.println(str);
			if (str != null) {
				txt.setText(str);
			}
		} else if (obj == btnConfirm) {
			//confirm()
//			int result = JOptionPane.showConfirmDialog(null, "계속 할래요?");
			int result = JOptionPane.showConfirmDialog(null, "계속 할래요", "진행여부", JOptionPane.YES_NO_OPTION);
//			System.out.println(result);
			switch (result) {
			case JOptionPane.OK_OPTION :
				System.out.println("계속 한대요");
				break;
			case JOptionPane.NO_OPTION :
				System.out.println("계속 안 한대요");
				break;
			case JOptionPane.CANCEL_OPTION :
				System.out.println("취소 했어요");
				break;
			case JOptionPane.CLOSED_OPTION :
				System.out.println("그냥 닫아 버렸어요");
				break;
			}
		} else if (obj == btnMessage) {
			//alert()
			JOptionPane.showMessageDialog(null, "삭제됐어요", "삭제", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new OptionPaneEx();
	}

}//class
