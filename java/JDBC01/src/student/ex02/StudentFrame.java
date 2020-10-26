package student.ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//��Ű�� �������, import �κ� Ȯ���ϱ�

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener{
	
	Container c = getContentPane();
	JButton btnInput = new JButton("�Է�");
	JButton btnUpdate = new JButton("����");
	JButton btnDelete = new JButton("����");
	JButton btnSearch = new JButton("�˻�");
	JTextField txtSearch = new JTextField(10);
	JTextField txtSno = new JTextField();
	JTextField txtSname = new JTextField();
	JTextField txtSmajor = new JTextField();
	JTextField txtScore = new JTextField();
	JTextField txtPno = new JTextField();
	JTextArea txtResult = new JTextArea();
	
	StudentDao dao = StudentDao.getInstance();
	
	public StudentFrame() {
		setTitle("�л� ���� ���� �г�_ȥ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setUI();
		setListener();
		setVisible(true);
	}
	
	private void setUI() {
		JPanel pnlNorth = new JPanel();
		pnlNorth.add(btnInput);
		pnlNorth.add(btnUpdate);
		pnlNorth.add(btnDelete);
		pnlNorth.add(new JLabel("�˻�"));
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch);
		pnlNorth.setBackground(Color.lightGray);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		c.add(txtResult, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(5,2));
		pnlSouth.add(new JLabel("�й�"));
		pnlSouth.add(txtSno);
		pnlSouth.add(new JLabel("�̸�"));
		pnlSouth.add(txtSname);
		pnlSouth.add(new JLabel("����"));
		pnlSouth.add(txtSmajor);
		pnlSouth.add(new JLabel("����"));
		pnlSouth.add(txtScore);
		pnlSouth.add(new JLabel("���� ��ȣ"));
		pnlSouth.add(txtPno);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setListener() {
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		
		if (obj == btnInput) {
			input();
		} else if (obj == btnUpdate) {
			update();
		} else if (obj == btnDelete) {
			delete();
		} else if (obj == btnSearch) {
			search();
		}
	}//actionPerformed

	private void input() {
		StudentVO vo = getStudent();
		int count = dao.input(vo);
		txtResult.setText(count + "���� �л� ���� -> �Է�\n");
		txtResult.append(txtSname.getText() + " �л� ���� -> �Է�");
	}
	
	private void update() {
		StudentVO vo = getStudent();
		int count = dao.update(vo);
		txtResult.setText(count + "���� �л� ���� -> ����\n");
		txtResult.append(txtSname.getText() + " �л� ���� -> ����");
	}
	
	private void delete() {
		String s_no = txtSno.getText();
		int count = dao.delete(s_no);
		txtResult.setText(count + "���� �л� ���� -> ����\n");
		txtResult.append(txtSname.getText() + " �л� ���� -> ����");
	}
	
	private void search() {
		String keyword = txtSearch.getText();
		List<StudentVO> list = dao.search(keyword);
		StringBuffer buffer =new StringBuffer();
		for (StudentVO vo : list) {
			buffer.append(vo.getS_no());    buffer.append(" | ");
			buffer.append(vo.getS_name());  buffer.append(" | ");
			buffer.append(vo.getS_major()); buffer.append(" | ");
			buffer.append(vo.getS_score()); buffer.append(" | ");
			buffer.append(vo.getP_name());  buffer.append(" \n");
		}
		txtResult.setText(buffer.toString());
	}
	
	private StudentVO getStudent() {
		String s_no    = txtSno.getText();
		String s_name  = txtSname.getText();
		String s_major = txtSmajor.getText();
		int s_score    = Integer.parseInt(txtScore.getText());
		String p_no    = txtPno.getText();
		StudentVO vo = new StudentVO(s_no, s_name, s_major, s_score, p_no, null);
		return vo;
	}
	
	public static void main(String[] args) {
		new StudentFrame();
	}
	
}//clsaa
