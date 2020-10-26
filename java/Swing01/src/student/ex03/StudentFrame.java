package student.ex03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//��Ű�� �������, import �κ� Ȯ���ϱ�

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener{
	
	Container c = getContentPane();
	JButton btnInput1 = new JButton("�Է�");
	JButton btnInput2 = new JButton("�Է�");
	JButton btnUpdate1 = new JButton("����");
	JButton btnUpdate2 = new JButton("����");
	JButton btnDelete1 = new JButton("����");
	JButton btnDelete2 = new JButton("����");
	JButton btnSearch1 = new JButton("�˻�");
	JButton btnSearch2 = new JButton("�˻�");
	String[] strSearch = {"�л���", "����"};
	JComboBox<String> cbSearch = new JComboBox<>(strSearch);
	JTextField txtSearch = new JTextField(10);
	JTextArea txtResult = new JTextArea();
	
	MyDialog dialogIn = new MyDialog(this, "�Է�", 1);
	MyDialog dialogUp1 = new MyDialog(this, "����", 1);
	MyDialog dialogUp2 = new MyDialog(this, "����", 2);
	MyDialog dialogDel = new MyDialog(this, "����", 1);
	
	StudentDao dao = StudentDao.getInstance();
	
	public StudentFrame() {
		setTitle("�л� ���� ���� �г�_addcolumn");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setUI();
		setListener();
		setVisible(true);
	}
	
	private void setUI() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(btnInput1);
		pnlNorth.add(btnUpdate1);
		pnlNorth.add(btnDelete1);
		pnlNorth.add(cbSearch);
		pnlNorth.add(new JLabel(" : "));
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch1);
		pnlNorth.setBackground(Color.lightGray);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		c.add(txtResult, BorderLayout.CENTER);
		
		btnInput1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogIn.setVisible(true);
			}
		});
		
		btnUpdate1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogUp1.setVisible(true);
			}
		});
		
		btnDelete1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialogDel.setVisible(true);
			}
		});
	
	}//setUI
	
	class MyDialog extends JDialog {
		
		JTextField txtSno = new JTextField();
		JTextField txtSname = new JTextField();
		JTextField txtSmajor = new JTextField();
		JTextField txtScore = new JTextField();
		JTextField txtPno = new JTextField();
		JRadioButton rdoSgenF = new JRadioButton("����", true);
		JRadioButton rdoSgenM = new JRadioButton("����");
		
		private MyDialog(Frame owner, String title, int num) {
			super(owner, title, true);
			
			if (title.equals("�Է�")) {
				setSize(400, 400);
				this.setLayout(new GridLayout(7,2));
				this.add(new JLabel("�й�"));
				this.add(txtSno);
				this.add(new JLabel("�̸�"));
				this.add(txtSname);
				this.add(new JLabel("����"));
				this.add(txtSmajor);
				this.add(new JLabel("����"));
				this.add(txtScore);
				this.add(new JLabel("���� ��ȣ"));
				this.add(txtPno);
				this.add(new JLabel("����"));
				ButtonGroup bg = new ButtonGroup();
				bg.add(rdoSgenF);
				bg.add(rdoSgenM);
				JPanel pnlButton = new JPanel();
				pnlButton.add(rdoSgenF);
				pnlButton.add(rdoSgenM);
				this.add(pnlButton);
				this.add(btnInput2);
				btnInput2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			} else if (title.equals("����") && num == 1) {
				setSize(400, 80);
				this.setLayout(new GridLayout(1,3));
				this.add(new JLabel("�й�"));
				this.add(txtSno);
				this.add(btnSearch2);
				btnSearch2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialogUp1.setVisible(false);
						dialogUp2.setVisible(true);
					}
				});
			} else if (title.equals("����") && num == 2) {
				setSize(400, 400);
				setLayout(new GridLayout(7,2));
				add(new JLabel("�й�"));
				add(txtSno);
				add(new JLabel("�̸�"));
				add(txtSname);
				add(new JLabel("����"));
				add(txtSmajor);
				add(new JLabel("����"));
				add(txtScore);
				add(new JLabel("���� ��ȣ"));
				add(txtPno);
				add(new JLabel("����"));
				ButtonGroup bg = new ButtonGroup();
				bg.add(rdoSgenF);
				bg.add(rdoSgenM);
				JPanel pnlButton = new JPanel();
				pnlButton.add(rdoSgenF);
				pnlButton.add(rdoSgenM);
				add(pnlButton);
				add(btnUpdate2);
				btnUpdate2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			} else if (title.equals("����")) {
				setSize(400, 80);
				this.setLayout(new GridLayout(1,3));
				this.add(new JLabel("�й�"));
				this.add(txtSno);
				this.add(btnDelete2);
				btnDelete2.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
			}
		}//MyDialog
		
		private StudentVO getStudent() throws NumberFormatException {
			StudentVO vo = new StudentVO();
			
			String s_no     = txtSno.getText();
			String s_name   = txtSname.getText();
			String s_major  = txtSmajor.getText();
			
			int s_score     = Integer.parseInt(txtScore.getText());
			txtResult.setText("score�� ���ڷ� ���� �Է�");
			
			String p_no     = txtPno.getText();
			String s_gender=null;
			if (rdoSgenF.isSelected()) {
				s_gender = rdoSgenF.getText();
			} else if (rdoSgenM.isSelected()) {
				s_gender = rdoSgenM.getText();
			}
			vo = new StudentVO(s_no, s_name, s_major, s_score, p_no, null, s_gender);
			return vo;
		}//StudentVO
		
	}//MyDialog

	private void setListener() {
		btnInput2.addActionListener(this);
		btnUpdate2.addActionListener(this);
		btnDelete2.addActionListener(this);
		btnSearch1.addActionListener(this);
		btnSearch2.addActionListener(this);
		cbSearch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == btnInput2) {
			input();
		} else if (obj == btnSearch2) {
			updateRead();
		} else if (obj == btnUpdate2) {
			update();
		} else if (obj == btnDelete2) {
			delete();
		} else if (obj == btnSearch1) {
			search();
		}
	}//actionPerformed

	private void input() throws NumberFormatException {
		StudentVO vo = dialogIn.getStudent();
		int count = dao.input(vo);
		txtResult.setText(count + "���� �л� ���� -> �Է�\n");
		txtResult.append(dialogIn.txtSname.getText() + " �л� ���� -> �Է�");
	}
	
	private void updateRead() {
		int s_no2 = Integer.parseInt(dialogUp1.txtSno.getText());
		List<StudentVO> list = dao.searchUp(s_no2);
		for (StudentVO vo : list) {
			System.out.println("uu");
			dialogUp2.txtSno.setText(vo.getS_no());
			dialogUp2.txtSname.setText(vo.getS_name());
			dialogUp2.txtSmajor.setText(vo.getS_major());
			dialogUp2.txtScore.setText(String.valueOf(vo.getS_score()));
			dialogUp2.txtPno.setText(vo.getP_no());
			if (vo.getS_gender().equals("����")) {
				dialogUp2.rdoSgenF.setSelected(true);
			} else {
				dialogUp2.rdoSgenM.setSelected(true);
			}
		}
	}
	
	private void update() throws NumberFormatException {
		System.out.println("up");
		StudentVO vo = dialogUp2.getStudent();
		int count = dao.update(vo);
		txtResult.setText(count + "���� �л� ���� -> ����\n");
		txtResult.append(dialogUp2.txtSname.getText() + " �л� ���� -> ����");
	}
	
	private void delete() {
		String s_no = dialogDel.txtSno.getText();
		int count = dao.delete(s_no);
		txtResult.setText(count + "���� �л� ���� -> ����\n");
		txtResult.append(dialogDel.txtSname.getText() + " �л� ���� -> ����");
	}
	
	private void search() {
		int cbIndex = cbSearch.getSelectedIndex();
		if (cbSearch.getSelectedIndex() == 0) { //strSearch[0]="�л�"
//			System.out.println("�л�");
		} else if (cbSearch.getSelectedIndex() == 1) {
//			System.out.println("����");
		}
		String keyword = txtSearch.getText();
		List<StudentVO> list = dao.search(keyword, cbIndex);
		StringBuffer buffer =new StringBuffer();
		for (StudentVO vo : list) {
			buffer.append(vo.getS_no());      buffer.append(" | ");
			buffer.append(vo.getS_name());    buffer.append(" | ");
			buffer.append(vo.getS_major());   buffer.append(" | ");
			buffer.append(vo.getS_score());   buffer.append(" | ");
			buffer.append(vo.getP_name());    buffer.append(" | ");
			buffer.append(vo.getS_gender());  buffer.append(" \n");
		}
		txtResult.setText(buffer.toString());
	}
	
	public static void main(String[] args) { 
		new StudentFrame();
	}
	//main â ����� Ctrl+F11 �ؾ� ��
	//�ƴϸ� �ٸ� main �ִ� â �ɷ� ������ (main�� �켱�̴ϱ�?!)
	
	
}//clsaa
