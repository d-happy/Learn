package student.ex01;

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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener {
	
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
		setTitle("�л� ���� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		setUI();
		setVisible(true);
		setListener();
	}

	private void setUI() {
		//North
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(Color.LIGHT_GRAY);
		pnlNorth.add(btnInput);
		pnlNorth.add(btnUpdate);
		pnlNorth.add(btnDelete);
		pnlNorth.add(new JLabel("�˻�"));
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		//Center
		c.add(new JScrollPane(txtResult), BorderLayout.CENTER);
		
		//South
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(5, 2));
		pnlSouth.add(new JLabel("�й�"));
		pnlSouth.add(txtSno);
		pnlSouth.add(new JLabel("�̸�"));
		pnlSouth.add(txtSname);
		pnlSouth.add(new JLabel("����"));
		pnlSouth.add(txtSmajor);
		pnlSouth.add(new JLabel("����"));
		pnlSouth.add(txtScore);
		pnlSouth.add(new JLabel("������ȣ"));
		pnlSouth.add(txtPno);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setListener() {
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		txtSearch.addActionListener(this);
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
		} else if (obj == btnSearch || obj == txtSearch) {
			search();
		}
		
	}//actionPerformed
	
	private void search() {
		String keyword = txtSearch.getText();
		//trim() : �¿� ���� ����
		/*
		if (keyword == null || keyword.trim().equals("")) { //searchAll
			List<StudentVO> list = dao.searchStudent();
			StringBuffer buffer = new StringBuffer(); 
			//buffer �������� ��Ʈ�� ����ȯ ������, append ���Ѵ� //buffer ��ü�� .~~ ����
			for (StudentVO vo : list) {
				buffer.append(vo.getSno());    buffer.append(" | ");
				buffer.append(vo.getSname());  buffer.append(" | ");
				buffer.append(vo.getSmajor()); buffer.append(" | ");
				buffer.append(vo.getScore());  buffer.append(" | ");
				buffer.append(vo.getPno());    buffer.append(" \n");
				//list �ȿ� ���� vo {~}�� ������ �ϳ��ϳ� Stiring���� ����ȯ�ϰ� " | " �߰��� �Է��ؼ�,
				//vo -> ~ | ~ | ������ ����Ǵ� ������� ����
			}
			txtResult.setText(buffer.toString()); //toString()���� String ����ȯ?
		} else {
		*/
		//searchNotAll
		List<StudentVO> list = dao.searchStudent(keyword);
		StringBuffer buffer = new StringBuffer(); 
		for (StudentVO vo : list) {
			buffer.append(vo.getSno());    buffer.append(" | ");
			buffer.append(vo.getSname());  buffer.append(" | ");
			buffer.append(vo.getSmajor()); buffer.append(" | ");
			buffer.append(vo.getScore());  buffer.append(" | ");
			buffer.append(vo.getPname());  buffer.append(" \n");
		}
		txtResult.setText(buffer.toString());
	}//search()
	
	private void delete() {
		String sno = txtSno.getText();
		int count = dao.deleteStudent(sno);
		txtResult.setText(count + "���� �л��� ���� �Ǿ����ϴ�.\n");
		txtResult.append(sno + "�й��� �л��� ���� �Ǿ����ϴ�.");
	}

	private void update() {
		StudentVO vo =getStudentData();
		int count = dao.updateStudent(vo);
		txtResult.setText(count + "���� �л� ������ ���� �Ǿ����ϴ�.\n");
		txtResult.append(txtSname.getText() + " �л� ������ ���� �Ǿ����ϴ�.");
	}

	private void input() {
		StudentVO vo = getStudentData();
		int count = dao.inputStudent(vo);
		txtResult.setText(count + "���� �л��� ��� �Ǿ����ϴ�.\n");
		txtResult.append(txtSname.getText() + " �л� ������ ��� �Ǿ����ϴ�.");
	}
	
	//�ؽ�Ʈ �ʵ忡�� ������ �б�
	private StudentVO getStudentData() {
		String sno = txtSno.getText();
		String sname = txtSname.getText();
		String smajor = txtSmajor.getText();
		int score = Integer.parseInt(txtScore.getText());
		String pno = txtPno.getText();
		StudentVO vo = new StudentVO(sno, sname, smajor, score, pno, null);
		return vo;
	}
	
	public static void main(String[] args) {
		new StudentFrame();
	}

}//class
