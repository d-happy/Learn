package student.ex02_addcolumn;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//패키지 문제라면, import 부분 확인하기

@SuppressWarnings("serial")
public class StudentFrame extends JFrame implements ActionListener{
	
	Container c = getContentPane();
	JButton btnInput = new JButton("입력");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	String[] strSearch = {"학생명", "전공"};
	JComboBox<String> cbSearch = new JComboBox<>(strSearch);
	JTextField txtSearch = new JTextField(10);
	JTextField txtSno = new JTextField();
	JTextField txtSname = new JTextField();
	JTextField txtSmajor = new JTextField();
	JTextField txtScore = new JTextField();
	JTextField txtPno = new JTextField();
	JRadioButton rdoSgenF = new JRadioButton("여자", true);
	JRadioButton rdoSgenM = new JRadioButton("남자");
	JTextArea txtResult = new JTextArea();
	
	StudentDao dao = StudentDao.getInstance();
	
	public StudentFrame() {
		setTitle("학생 정보 관리 패널_addcolumn");
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
		pnlNorth.add(cbSearch);
		pnlNorth.add(new JLabel(" : "));
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch);
		pnlNorth.setBackground(Color.lightGray);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		c.add(txtResult, BorderLayout.CENTER);
		
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(6,2));
		pnlSouth.add(new JLabel("학번"));
		pnlSouth.add(txtSno);
		pnlSouth.add(new JLabel("이름"));
		pnlSouth.add(txtSname);
		pnlSouth.add(new JLabel("전공"));
		pnlSouth.add(txtSmajor);
		pnlSouth.add(new JLabel("점수"));
		pnlSouth.add(txtScore);
		pnlSouth.add(new JLabel("교수 번호"));
		pnlSouth.add(txtPno);
		pnlSouth.add(new JLabel("성별"));
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdoSgenF);
		bg.add(rdoSgenM);
		JPanel pnlButton = new JPanel();
		pnlButton.add(rdoSgenF);
		pnlButton.add(rdoSgenM);
		pnlSouth.add(pnlButton);
		c.add(pnlSouth, BorderLayout.SOUTH);
	}

	private void setListener() {
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSearch.addActionListener(this);
		cbSearch.addActionListener(this);
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

	private void input() throws NumberFormatException {
		StudentVO vo = getStudent();
		int count = dao.input(vo);
		txtResult.setText(count + "명의 학생 정보 -> 입력\n");
		txtResult.append(txtSname.getText() + " 학생 정보 -> 입력");
	}
	
	private void update() throws NumberFormatException {
		StudentVO vo = getStudent();
		int count = dao.update(vo);
		txtResult.setText(count + "명의 학생 정보 -> 수정\n");
		txtResult.append(txtSname.getText() + " 학생 정보 -> 수정");
	}
	
	private void delete() {
		String s_no = txtSno.getText();
		int count = dao.delete(s_no);
		txtResult.setText(count + "명의 학생 정보 -> 삭제\n");
		txtResult.append(txtSname.getText() + " 학생 정보 -> 삭제");
	}
	
	private void search() {
		int cbIndex = cbSearch.getSelectedIndex();
		if (cbSearch.getSelectedIndex() == 0) { //strSearch[0]="학생"
//			System.out.println("학생");
		} else if (cbSearch.getSelectedIndex() == 1) {
//			System.out.println("전공");
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
	
	private StudentVO getStudent() throws NumberFormatException {
		StudentVO vo = new StudentVO();
		
		String s_no     = txtSno.getText();
		String s_name   = txtSname.getText();
		String s_major  = txtSmajor.getText();
		
		int s_score     = Integer.parseInt(txtScore.getText());
		txtResult.setText("score에 숫자로 점수 입력");
		
		String p_no     = txtPno.getText();
		String s_gender=null;
		if (rdoSgenF.isSelected()) {
			s_gender = rdoSgenF.getText();
		} else if (rdoSgenM.isSelected()) {
			s_gender = rdoSgenM.getText();
		}
		vo = new StudentVO(s_no, s_name, s_major, s_score, p_no, null, s_gender);
		return vo;
	}
	
	public static void main(String[] args) { 
		new StudentFrame();
	}
	//main 창 띄워야 Ctrl+F11 해야 됨
	//아니면 다른 main 있는 창 걸로 구현됨 (main이 우선이니까?!)
	
	
}//clsaa
