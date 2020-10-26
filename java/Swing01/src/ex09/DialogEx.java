package ex09;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DialogEx extends JFrame {
	
	Container c = getContentPane();
	JButton btnshow = new JButton("���̾�α� ����");
	MyDialog dialog = new MyDialog(this, "Dialog");

	public DialogEx() {
		setTitle("DialogEx");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnshow.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true); //���̾�α׿� ��Ŀ��? ��
				//��� ������ ���̾�αװ� ������ �� �Ʒ� ���� �����
				System.out.println("close");
				String text = dialog.txtSay.getText();
				btnshow.setText(text);
			}
		});
		c.add(btnshow);
		setSize(500, 500);
		setVisible(true);
	}
	
	//���̾�α��� �⺻ ��ġ �����ڴ� BoderLayout
	class MyDialog extends JDialog {
		
		JTextField txtSay = new JTextField(10);
		JButton btnOk = new JButton("OK");
		
		private MyDialog(Frame owner, String title) {
			super(owner, title, true); //��� �⺻���� false
			setLayout(new FlowLayout());
			btnOk.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					setVisible(false); //this. ����?
				}
			});
			add(txtSay);
			add(btnOk);
			setSize(300, 300);
		}
		
		
		
	}//MyDialog

	public static void main(String[] args) {
		new DialogEx();
	}

}//class
