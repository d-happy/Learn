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
			String str = JOptionPane.showInputDialog("�̸��� �Է��ϼ���");
			System.out.println(str);
			if (str != null) {
				txt.setText(str);
			}
		} else if (obj == btnConfirm) {
			//confirm()
//			int result = JOptionPane.showConfirmDialog(null, "��� �ҷ���?");
			int result = JOptionPane.showConfirmDialog(null, "��� �ҷ���", "���࿩��", JOptionPane.YES_NO_OPTION);
//			System.out.println(result);
			switch (result) {
			case JOptionPane.OK_OPTION :
				System.out.println("��� �Ѵ��");
				break;
			case JOptionPane.NO_OPTION :
				System.out.println("��� �� �Ѵ��");
				break;
			case JOptionPane.CANCEL_OPTION :
				System.out.println("��� �߾��");
				break;
			case JOptionPane.CLOSED_OPTION :
				System.out.println("�׳� �ݾ� ���Ⱦ��");
				break;
			}
		} else if (obj == btnMessage) {
			//alert()
			JOptionPane.showMessageDialog(null, "�����ƾ��", "����", JOptionPane.WARNING_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		new OptionPaneEx();
	}

}//class
