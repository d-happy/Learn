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
	JButton btnInput = new JButton("입력");
	JButton btnUpdate = new JButton("수정");
	JButton btnDelete = new JButton("삭제");
	JButton btnSearch = new JButton("검색");
	JTextField txtSearch = new JTextField(10);
	JTextField txtSno = new JTextField();
	JTextField txtSname = new JTextField();
	JTextField txtSmajor = new JTextField();
	JTextField txtScore = new JTextField();
	JTextField txtPno = new JTextField();
	JTextArea txtResult = new JTextArea();
	StudentDao dao = StudentDao.getInstance();
	
	public StudentFrame() {
		setTitle("학생 정보 관리");
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
		pnlNorth.add(new JLabel("검색"));
		pnlNorth.add(txtSearch);
		pnlNorth.add(btnSearch);
		c.add(pnlNorth, BorderLayout.NORTH);
		
		//Center
		c.add(new JScrollPane(txtResult), BorderLayout.CENTER);
		
		//South
		JPanel pnlSouth = new JPanel();
		pnlSouth.setLayout(new GridLayout(5, 2));
		pnlSouth.add(new JLabel("학번"));
		pnlSouth.add(txtSno);
		pnlSouth.add(new JLabel("이름"));
		pnlSouth.add(txtSname);
		pnlSouth.add(new JLabel("전공"));
		pnlSouth.add(txtSmajor);
		pnlSouth.add(new JLabel("점수"));
		pnlSouth.add(txtScore);
		pnlSouth.add(new JLabel("교수번호"));
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
		//trim() : 좌우 공백 제거
		/*
		if (keyword == null || keyword.trim().equals("")) { //searchAll
			List<StudentVO> list = dao.searchStudent();
			StringBuffer buffer = new StringBuffer(); 
			//buffer 개념으로 스트링 형변환 빠르게, append 더한다 //buffer 객체로 .~~ 가능
			for (StudentVO vo : list) {
				buffer.append(vo.getSno());    buffer.append(" | ");
				buffer.append(vo.getSname());  buffer.append(" | ");
				buffer.append(vo.getSmajor()); buffer.append(" | ");
				buffer.append(vo.getScore());  buffer.append(" | ");
				buffer.append(vo.getPno());    buffer.append(" \n");
				//list 안에 넣은 vo {~}의 값들을 하나하나 Stiring으로 형변환하고 " | " 추가로 입력해서,
				//vo -> ~ | ~ | 식으로 인출되는 모양으로 변경
			}
			txtResult.setText(buffer.toString()); //toString()값을 String 형변환?
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
		txtResult.setText(count + "명의 학생이 삭제 되었습니다.\n");
		txtResult.append(sno + "학번의 학생이 삭제 되었습니다.");
	}

	private void update() {
		StudentVO vo =getStudentData();
		int count = dao.updateStudent(vo);
		txtResult.setText(count + "명의 학생 정보가 수정 되었습니다.\n");
		txtResult.append(txtSname.getText() + " 학생 정보가 수정 되었습니다.");
	}

	private void input() {
		StudentVO vo = getStudentData();
		int count = dao.inputStudent(vo);
		txtResult.setText(count + "명의 학생이 등록 되었습니다.\n");
		txtResult.append(txtSname.getText() + " 학생 정보가 등록 되었습니다.");
	}
	
	//텍스트 필드에서 데이터 읽기
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
